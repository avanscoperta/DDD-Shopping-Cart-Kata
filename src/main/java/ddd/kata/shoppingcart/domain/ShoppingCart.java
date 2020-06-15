package ddd.kata.shoppingcart.domain;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {


    private final String cartId;
    private final String userId;
    private List<LineItem> lineItems;

    public ShoppingCart(String cartId, String userId) {
        this.cartId = cartId;
        this.userId = userId;
        this.lineItems = new ArrayList<LineItem>();
    }

    public double getTotalAmount() {
        return 0.0;
    }

    public int getItemsCount() {
        return lineItems.size();
    }
}
