package ddd.kata.es.shoppingcart.domain.events;

import ddd.kata.es.shoppingcart.domain.CartId;
import org.javamoney.moneta.Money;

public class CartMarkedAsCheckedOut {
    private final CartId cartId;
    private final String userId;
    private final Money totalCartAmount;

    public CartMarkedAsCheckedOut(CartId cartId, String userId, Money totalCartAmount) {
        this.cartId = cartId;
        this.userId = userId;
        this.totalCartAmount = totalCartAmount;
    }

    public CartId getCartId() {
        return cartId;
    }

    public String getUserId() {
        return userId;
    }

    public Money getTotalCartAmount() {
        return totalCartAmount;
    }
}
