package ddd.es.kata.shoppingcart.domain;

import ddd.es.kata.catalog.domain.ItemId;

import java.util.Objects;

public class LineItem {

    private final ItemId itemId;
    private final String description;
    private final int qty;

    public LineItem(ItemId itemId, int qty, String description) {
        this.itemId = itemId;
        this.qty = qty;
        this.description = description;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineItem)) return false;
        LineItem lineItem = (LineItem) o;
        return qty == lineItem.qty &&
                itemId.equals(lineItem.itemId) &&
                description.equals(lineItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, description, qty);
    }
}
