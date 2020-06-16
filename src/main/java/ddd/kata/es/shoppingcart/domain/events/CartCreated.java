package ddd.kata.es.shoppingcart.domain.events;

import ddd.kata.es.shoppingcart.domain.CartId;

public class CartCreated {
    private final CartId cartId;
    private final String userId;

    public CartCreated(CartId cartId, String userId) {

        this.cartId = cartId;
        this.userId = userId;
    }

    public CartId getCartId() {
        return cartId;
    }

    public String getUserId() {
        return userId;
    }
}
