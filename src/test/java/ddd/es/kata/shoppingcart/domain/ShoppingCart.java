package ddd.es.kata.shoppingcart.domain;

import ddd.es.kata.shoppingcart.domain.command.CreateEmpty;
import ddd.es.kata.shoppingcart.domain.events.CartCreated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class ShoppingCart {

    @AggregateIdentifier
    private String cartId;

    private ShoppingCart() {}

    // here we check whether we can execute commands.

    @CommandHandler
    public ShoppingCart(CreateEmpty command) {

        // Guard conditions

        apply(new CartCreated(
                command.getCartId(),
                command.getUserId()
        ));
    }

    // here we just update the local state


    @EventSourcingHandler
    public void on(CartCreated event) {
        cartId = event.getCartId();
    }



}
