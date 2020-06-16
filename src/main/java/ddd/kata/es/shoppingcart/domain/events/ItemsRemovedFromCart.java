package ddd.kata.es.shoppingcart.domain.events;

import ddd.kata.es.catalog.domain.ItemId;

public class ItemsRemovedFromCart {
    private final String cartId;
    private final ItemId itemId;
    private final int qty;
    private final int remainingItems;

    public ItemsRemovedFromCart(String cartId, ItemId itemId, int qty, int remainingItems) {
        this.cartId = cartId;
        this.itemId = itemId;
        this.qty = qty;
        this.remainingItems = remainingItems;
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

    public int getRemainingItems() {
        return remainingItems;
    }
}
