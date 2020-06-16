package ddd.kata.es.shoppingcart.query;

import ddd.kata.es.shoppingcart.domain.CartId;
import ddd.kata.es.shoppingcart.domain.events.CartCreated;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ShoppingCartSummaryTest {

    @Autowired
    CartSummaryProjection projection;

    @Test
    public void createdCartsAreTracked() {
        CartId cartId = CartId.generate();
        String userId = UUID.randomUUID().toString();

        CartCreated cartCreated = new CartCreated(cartId, userId);

        projection.on(cartCreated);

        Optional<CartSummaryView> cartSummary = projection.find(cartId.toString());

        assertTrue(cartSummary.isPresent());
    }


}
