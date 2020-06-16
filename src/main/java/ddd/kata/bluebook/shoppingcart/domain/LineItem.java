package ddd.kata.bluebook.shoppingcart.domain;

import ddd.kata.bluebook.shoppingcart.domain.articles.ArticleId;

public class LineItem {
    private final ArticleId articleId;
    private final String itemDescription;
    private final int qty;

    public LineItem(ArticleId articleId, String itemDescription, int qty) {

        this.articleId = articleId;
        this.itemDescription = itemDescription;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }
}
