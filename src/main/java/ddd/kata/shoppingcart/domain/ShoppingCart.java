package ddd.kata.shoppingcart.domain;

import ddd.kata.shoppingcart.domain.articles.ArticleId;
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
        int count = 0;
        for (LineItem lineItem:lineItems)
              {
                  count = count + lineItem.getQty();

        }
        return count;
    }

    public void addItem(ArticleId articleId, String itemDescription, int qty) {
        LineItem lineItem = new LineItem(articleId, itemDescription, qty);
        lineItems.add(lineItem);
    }
}
