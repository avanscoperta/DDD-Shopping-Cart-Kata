package ddd.es.kata.shoppingcart.domain;


import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class ShoppingCart {

    @AggregateIdentifier
    private String cartId;

    private List<LineItem> lineItems;

    private ShoppingCart() {
    }

    // here we check whether we can execute commands.

    @CommandHandler
    public ShoppingCart(CreateEmpty command) {

        // Guard conditions: not so much in this scenario

        apply(new CartCreated(
                command.getCartId(),
                command.getUserId()
        ));
    }

    @CommandHandler
    public void addItems(AddItems command) {
        // Guard --> Lista interna.

        apply(new ItemsAddedToCart(
                command.getCartId(),
                command.getItemId(),
                command.getDescription(),
                command.getQty(),
                command.getUnitPrice()
        ));
    }

    @CommandHandler
    public void removeItems(RemoveItems command) {
        // Rigetta se l'Id non c'è.
        if (lineItems.stream().filter((item) -> item.getItemId().equals(command.getItemId())).count() == 0) {
           throw new RuntimeException("Not found");
        }

        int presentItems = lineItems.stream().filter((item) -> item.getItemId().equals(command.getItemId())).findFirst().get().getQty();

        int remainingItems = presentItems - command.getQty();

        apply(new ItemsRemovedFromCart(
                command.getCartId(), command.getItemId(), command.getQty(), remainingItems
        ));

    }

    // here we just update the local state

    @EventSourcingHandler
    public void on(CartCreated event) {
        cartId = event.getCartId();
        this.lineItems = new ArrayList<LineItem>(); // <-- unico punto per creare.
    }

    @EventSourcingHandler
    public void on(ItemsAddedToCart event) {
        lineItems.add(new LineItem(
                event.getItemId(),
                event.getQty(),
                event.getDescription()
        ));
    }



}
