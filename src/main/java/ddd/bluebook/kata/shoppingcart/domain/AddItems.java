package ddd.bluebook.kata.shoppingcart.domain;

import ddd.bluebook.kata.shoppingcart.domain.articles.ArticleId;

public class AddItems {
    private final String cartId;
    private final ArticleId articleId;
    private final String itemDescription;
    private final int qty;
    private final double unitPrice;

    public AddItems(String cartId, ArticleId articleId, String itemDescription, int qty, double unitPrice) {
        rejectIfNegativeQty(qty);
        rejectIfNegativePrice(unitPrice);
        this.cartId = cartId;
        this.articleId = articleId;
        this.itemDescription = itemDescription;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    private void rejectIfNegativeQty(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Negative quantity, nice try!");
    }

    private void rejectIfNegativePrice(double unitPrice) {
        if (unitPrice < 0) throw new IllegalArgumentException("Negative price, even better!");
    }

    public String getCartId() {
        return cartId;
    }

    public ArticleId getArticleId() {
        return articleId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getQty() {
        return qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
