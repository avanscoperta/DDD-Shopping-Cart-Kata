package ddd.es.kata.shoppingcart.domain.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateEmpty {

    @TargetAggregateIdentifier
    private final String cartId;
    private final String userId;

    public CreateEmpty(String cartId, String userId) {
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
