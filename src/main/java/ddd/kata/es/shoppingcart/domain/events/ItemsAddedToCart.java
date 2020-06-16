package ddd.kata.es.shoppingcart.domain.events;

import ddd.kata.es.catalog.domain.ItemId;
import ddd.kata.es.shoppingcart.domain.CartId;
import org.javamoney.moneta.Money;

public class ItemsAddedToCart {
    private CartId cartId;
    private final ItemId itemId;
    private final String description;
    private final int qty;
    private final Money unitPrice;

    public ItemsAddedToCart(CartId cartId, ItemId itemId, String description, int qty, Money unitPrice) {

        this.cartId = cartId;
        this.itemId = itemId;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public CartId getCartId() {
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
