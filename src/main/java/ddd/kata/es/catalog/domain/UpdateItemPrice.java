package ddd.kata.es.catalog.domain;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.javamoney.moneta.Money;

public class UpdateItemPrice {

    @TargetAggregateIdentifier
    private final ItemId itemId;
    private final Money newPrice;

    public UpdateItemPrice(ItemId itemId, Money newPrice) {
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
