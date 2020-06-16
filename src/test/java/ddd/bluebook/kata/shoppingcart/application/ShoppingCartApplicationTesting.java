package ddd.bluebook.kata.shoppingcart.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
