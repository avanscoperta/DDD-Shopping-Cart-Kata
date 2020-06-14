package ddd.kata.shoppingcart.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoppingCartTest {

    @Test
    public void canCreateAnEmptyCart() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        assertNotNull(shoppingCart);
    }

}
