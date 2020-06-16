package ddd.kata.es.shoppingcart.domain.command;

import ddd.kata.es.catalog.domain.ItemId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class RemoveItems {

    @TargetAggregateIdentifier
    private final String cartId;
    private final ItemId itemId;
    private final int qty;

    public RemoveItems(String cartId, ItemId itemId, int qty) {
        this.cartId = cartId;
        this.itemId = itemId;
        this.qty = qty;
    }

    public String getCartId() {
        return cartId;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public int getQty() {
        return qty;
    }
}
