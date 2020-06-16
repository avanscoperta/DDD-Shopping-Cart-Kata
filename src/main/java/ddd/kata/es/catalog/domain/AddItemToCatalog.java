package ddd.kata.es.catalog.domain;

import org.javamoney.moneta.Money;

public class AddItemToCatalog {
    private final ItemId itemId;
    private final String description;
    private final Money unitPrice;
    private final String imageUrl;

    public AddItemToCatalog(ItemId itemId, String description, Money unitPrice, String imageUrl) {
        this.itemId = itemId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
