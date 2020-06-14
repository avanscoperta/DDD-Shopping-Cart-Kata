package ddd.kata.shoppingcart.domain;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class ShoppingCart {

    @Id
    private String cartId;
    private String userId;
    private double totalAmount;

    public ShoppingCart(String cartId, String userId) {
        this.cartId = cartId;
        this.userId = userId;
        this.totalAmount = 0.0;
    }

    public static ShoppingCart createEmpty(String userId) {
        return new ShoppingCart(
                UUID.randomUUID().toString(),
                userId);
    }

    /**
     * TODO: double sucks big time.
     * @return
     */
    public double getTotalAmount() {
        return totalAmount;
    }
}
