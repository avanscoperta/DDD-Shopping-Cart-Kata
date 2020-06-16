package ddd.kata.es.shoppingcart.domain.events;

import ddd.kata.es.catalog.domain.ItemId;
import ddd.kata.es.shoppingcart.domain.CartId;

public class ItemsRemovedFromCart {
    private final CartId cartId;
    private final ItemId itemId;
    private final int qty;
    private final int remainingItems;

    public ItemsRemovedFromCart(CartId cartId, ItemId itemId, int qty, int remainingItems) {
        this.cartId = cartId;
        this.itemId = itemId;
        this.qty = qty;
        this.remainingItems = remainingItems;
    }

    public CartId getCartId() {
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
