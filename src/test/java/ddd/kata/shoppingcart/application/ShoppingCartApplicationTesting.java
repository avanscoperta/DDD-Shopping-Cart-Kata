package ddd.kata.shoppingcart.application;

import ddd.kata.shoppingcart.domain.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ShoppingCartApplicationTesting {

    @Autowired
    ShoppingCartApi shoppingCartApi;

/*    @Test
    public void personalShoppingCartsAreCreated() {
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = shoppingCartApi.getCartForUser(userId);

        assertNotNull(shoppingCart);

    }*/
}
