package ddd.kata.es.shoppingcart.domain.command;

import ddd.kata.es.catalog.domain.ItemId;
import ddd.kata.es.shoppingcart.domain.CartId;
import org.javamoney.moneta.Money;

public class UpdateItemPriceInCart {
    private final CartId cartId;
    private final ItemId itemId;
    private final Money newPrice;

    public UpdateItemPriceInCart(CartId cartId, ItemId itemId, Money newPrice) {

        this.cartId = cartId;
        this.itemId = itemId;
        this.newPrice = newPrice;
    }

    public CartId getCartId() {
        return cartId;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public Money getNewPrice() {
        return newPrice;
    }
}
