package ddd.kata.es.catalog.domain.events;

import ddd.kata.es.catalog.domain.ItemId;
import org.javamoney.moneta.Money;

public class ItemAddedToCatalog {
    private final ItemId itemId;
    private final String description;
    private final Money unitPrice;
    private final String imageUrl;

    public ItemAddedToCatalog(ItemId itemId, String description, Money unitPrice, String imageUrl) {

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
