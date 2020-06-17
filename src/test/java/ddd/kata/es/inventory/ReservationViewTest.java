package ddd.kata.es.inventory;

import ddd.kata.es.catalog.domain.ItemId;
import ddd.kata.es.inventory.query.ReservationProjection;
import ddd.kata.es.shoppingcart.domain.CartId;
import ddd.kata.es.shoppingcart.domain.events.CartCreated;
import ddd.kata.es.shoppingcart.domain.events.ItemsAddedToCart;
import ddd.kata.es.shoppingcart.query.CartSummaryProjection;
import ddd.kata.es.shoppingcart.query.CartSummaryView;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReservationViewTest {


    @Autowired
    ReservationProjection projection;

    @Test
    public void itemAddedAreRegisteredAsReservations() {
        CartId cartId = CartId.generate();
        ItemId itemId = ItemId.generate();
        String description = "the item";
        int qty = 5;
        Money unitPrice = Money.of(0.99, "USD");

        ItemsAddedToCart itemsAddedToCart = new ItemsAddedToCart(cartId, itemId, description, qty, unitPrice);

        projection.on(itemsAddedToCart);

       // Optional<CartSummaryView> cartSummary = projection.find(cartId.toString());

       // assertTrue(cartSummary.isPresent());
    }
}
