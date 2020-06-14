package ddd.kata.shoppingcart.domain;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class ShoppingCart {

    @Id
    private String cartId;
    private String userId;

    public ShoppingCart(String cartId, String userId) {
        this.cartId = cartId;
        this.userId = userId;
    }

    public static ShoppingCart createEmpty(String userId) {
        return new ShoppingCart(
                UUID.randomUUID().toString(),
                userId);
    }
}
