package ddd.kata.es.shoppingcart.domain.command;

import ddd.kata.es.catalog.domain.ItemId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.javamoney.moneta.Money;

public class AddItems {

    @TargetAggregateIdentifier
    private final String cartId;
    private final ItemId itemId;
    private final String description;
    private final int qty;
    private final Money unitPrice;

    public AddItems(String cartId, ItemId itemId, String description, int qty, Money unitPrice) {
        // Structural validation

        this.cartId = cartId;
        this.itemId = itemId;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getCartId() {
        return cartId;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public int getQty() {
        return qty;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }
}
