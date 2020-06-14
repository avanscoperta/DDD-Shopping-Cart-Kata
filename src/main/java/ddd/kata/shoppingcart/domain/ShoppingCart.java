package ddd.kata.shoppingcart.domain;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {

    @Id
    private String cartId;
    private String userId;
    private double totalAmount;
    private List<LineItem> lineItems;

    public ShoppingCart(String cartId, String userId) {
        this.cartId = cartId;
        this.userId = userId;
        this.totalAmount = 0.0;
        this.lineItems = new ArrayList<LineItem>();
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

    public void addItem(String itemId, String description, double unitPrice) {
        lineItems.add(new LineItem(itemId, description, unitPrice));
    }

    public int getItemsCount() {
        return lineItems.size(); // FIXME: This will explode with lineitem quantity. ;-)
    }
}
