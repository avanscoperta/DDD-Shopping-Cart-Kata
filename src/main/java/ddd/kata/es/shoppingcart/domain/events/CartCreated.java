package ddd.kata.es.shoppingcart.domain.events;

public class CartCreated {
    private final String cartId;
    private final String userId;

    public CartCreated(String cartId, String userId) {

        this.cartId = cartId;
        this.userId = userId;
    }

    public String getCartId() {
        return cartId;
    }

    public String getUserId() {
        return userId;
    }
}
