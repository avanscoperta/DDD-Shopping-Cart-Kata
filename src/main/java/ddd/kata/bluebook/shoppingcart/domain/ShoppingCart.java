package ddd.kata.bluebook.shoppingcart.domain;

import java.util.ArrayList;
import java.util.List;

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
        int count = 0;
        for (LineItem lineItem:lineItems)
              {
                  count = count + lineItem.getQty();

        }
        return count;
    }

    public void addItem(AddItems command) {
        LineItem lineItem = new LineItem(command.getArticleId(), command.getItemDescription(), command.getQty());
        lineItems.add(lineItem);
    }
}
