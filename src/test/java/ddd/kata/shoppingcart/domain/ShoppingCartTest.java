package ddd.kata.shoppingcart.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoppingCartTest {

    @Test
    public void canCreateAnEmptyCart() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        assertNotNull(shoppingCart);
    }

    @Test
    public void anEmptyCartSubTotalIsZero() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        assertEquals(0.0, shoppingCart.getTotalAmount());
    }

}
