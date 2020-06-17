package ddd.kata.es.steps;

import ddd.kata.es.catalog.domain.ItemId;
import ddd.kata.es.inventory.query.ReservationViewRepository;
import ddd.kata.es.shoppingcart.domain.CartId;
import ddd.kata.es.shoppingcart.domain.command.AddItems;
import io.cucumber.java8.En;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@SpringBootTest
public class MyStepdefs implements En {
    ItemId itemId; // TODO: Context
    String userId;
    String description;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private ReservationViewRepository reservationViewRepository;

    public MyStepdefs() {

        Given("^item (.*) is available in the catalog$", (String itemDescription) -> {
            // for now we can just assume that there's a valid ItemId.
            itemId = ItemId.generate();
            description = itemDescription;
        });

        Given("I am a registered user", () -> {
            // Write code here that turns the phrase above into concrete actions
            userId = UUID.randomUUID().toString();
        });


        When("^I add the item to my shopping cart$", () -> {
            CartId cartId = CartId.generate();
            Money unitPrice = Money.of(0.50, "EUR");

            AddItems addItems = new AddItems(cartId, itemId, description, 1, unitPrice);
            commandGateway.send(addItems);
        });


        Then("the item should be reserved for me", () -> {
           await().atMost(5, TimeUnit.SECONDS).until(() -> reservationViewRepository.findByItemId(itemId).isPresent()
                    );
        });




    }
}
