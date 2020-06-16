package ddd.kata.es.catalog.domain;

import org.javamoney.moneta.Money;

public class ItemPriceUpdated {
    private final ItemId itemId;
    private final Money newPrice;

    public ItemPriceUpdated(ItemId itemId, Money newPrice) {
        this.itemId = itemId;
        this.newPrice = newPrice;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public Money getNewPrice() {
        return newPrice;
    }
}
