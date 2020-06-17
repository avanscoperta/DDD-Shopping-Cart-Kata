package ddd.kata.es.shoppingcart.domain.command;

import ddd.kata.es.shoppingcart.domain.CartId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateEmpty {
    @TargetAggregateIdentifier
    private final CartId cartId;
    private final String userId;

    public CreateEmpty(CartId cartId, String userId) {

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
