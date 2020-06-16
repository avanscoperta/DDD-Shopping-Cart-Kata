package ddd.es.kata.shoppingcart.domain;

import ddd.es.kata.catalog.domain.ItemId;
import org.javamoney.moneta.Money;

public class ItemsAddedToCart {
    private final String cartId;
    private final ItemId itemId;
    private final String description;
    private final int qty;
    private final Money unitPrice;

    public ItemsAddedToCart(String cartId, ItemId itemId, String description, int qty, Money unitPrice) {

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
