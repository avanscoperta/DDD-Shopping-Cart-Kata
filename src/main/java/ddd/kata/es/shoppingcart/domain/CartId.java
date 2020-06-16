package ddd.kata.es.shoppingcart.domain;

import java.util.Objects;
import java.util.UUID;

/**
 * This is a Value Object Too!
 * Strong typing. :-)
 * And a little verbose :-(
 */
public class CartId {
    private final String cartId;

    public CartId(String cartId) {
        this.cartId = cartId;
    }

    public static CartId generate() {
        return new CartId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartId)) return false;
        CartId cartId1 = (CartId) o;
        return cartId.equals(cartId1.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }

    @Override
    public String toString() {
        return cartId;
    }
}
