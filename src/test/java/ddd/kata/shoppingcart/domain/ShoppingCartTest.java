package ddd.kata.shoppingcart.domain;

import ddd.kata.shoppingcart.domain.articles.ArticleId;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoppingCartTest {

    @Test
    public void canCreateAnEmptyCart() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        assertNotNull(shoppingCart);
    }

    @Test
    public void anEmptyCartSubTotalIsZero() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        assertEquals(0.0, shoppingCart.getTotalAmount());
    }

    @Test
    public void thereAreNoItems() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        assertEquals(0, shoppingCart.getItemsCount());
    }

    @Test
    public void canAddItems() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        ArticleId articleId = ArticleId.generate();
        String itemDescription = "bellissimo oggetto";
        int qty = 4;
        double unitPrice = 0.99;

        AddItems addItems = new AddItems(cartId, articleId, itemDescription, qty, unitPrice);

        shoppingCart.addItem(addItems);

        assertEquals(qty, shoppingCart.getItemsCount());
    }




    /*
    @Test
    public void canAddItemsToCart() {
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = ShoppingCart.createEmpty(userId);
        String itemId = UUID.randomUUID().toString();
        String description = "Fabulous Item";
        double unitPrice = 23.99;

        shoppingCart.addItem(itemId, description, unitPrice);

        assertEquals(1, shoppingCart.getItemsCount());
    }*/



}
