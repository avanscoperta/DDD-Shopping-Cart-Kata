package ddd.kata.shoppingcart.domain;

/**
 * A single line in our shopping cart
 */
public class LineItem {

    private final String itemId;
    private final String description;
    private final double unitPrice;

    public LineItem(String itemId, String description, double unitPrice) {
        this.itemId = itemId;
        this.description = description;
        this.unitPrice = unitPrice;
    }
}
