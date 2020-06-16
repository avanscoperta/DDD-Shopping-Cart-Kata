package ddd.kata.es.shoppingcart.domain;


import ddd.kata.es.catalog.domain.ItemId;
import ddd.kata.es.shoppingcart.domain.command.AddItems;
import ddd.kata.es.shoppingcart.domain.command.CreateEmpty;
import ddd.kata.es.shoppingcart.domain.command.RemoveItems;
import ddd.kata.es.shoppingcart.domain.events.CartCreated;
import ddd.kata.es.shoppingcart.domain.events.ItemsAddedToCart;
import ddd.kata.es.shoppingcart.domain.events.ItemsRemovedFromCart;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class TestShoppingCartES {

    FixtureConfiguration<ShoppingCart> fixture = new AggregateTestFixture<>(ShoppingCart.class);
    private String cartId;
    private String userId;
    private CreateEmpty createEmpty;
    private CartCreated cartCreatedEmpty;
    private ItemId itemId;
    private String description;
    private int qty;
    private Money unitPrice;
    private ItemsAddedToCart itemsAddedToCart;
    private int qtyToRemove;
    private int remainingItems;

    @BeforeEach
    void setUp() {
        cartId = UUID.randomUUID().toString();
        userId = UUID.randomUUID().toString();
        createEmpty = new CreateEmpty(cartId, userId);
        cartCreatedEmpty = new CartCreated(cartId, userId);
        itemId = ItemId.generate();
        description = "desc";
        qty = 3;
        unitPrice = Money.of(3, "EUR");
        itemsAddedToCart = new ItemsAddedToCart(cartId, itemId, description, qty, unitPrice);
        qtyToRemove = 1;
        remainingItems = 2;
    }

    @Test
    public void canCreateAnEmptyShoppingCart() {

        fixture.givenNoPriorActivity()
                .when(createEmpty)
                .expectEvents(cartCreatedEmpty);
    }

    @Test
    public void canAddItemsToCart() {

        AddItems addItems = new AddItems(cartId, itemId, description, qty, unitPrice);

        fixture.given(cartCreatedEmpty)
                .when(addItems)
                .expectEvents(itemsAddedToCart);
    }

    @Test
    public void canRemoveItems() {

        ItemsAddedToCart itemsAddedToCart = new ItemsAddedToCart(cartId, itemId, description, qty, unitPrice);
        RemoveItems removeItems = new RemoveItems(cartId, itemId, qtyToRemove);
        ItemsRemovedFromCart itemsRemoved = new ItemsRemovedFromCart(cartId, itemId, qtyToRemove, remainingItems);

        fixture.given(cartCreatedEmpty)
                .andGiven(itemsAddedToCart)
                .when(removeItems)
                .expectEvents(itemsRemoved);
    }

    @Test
    public void cantRemoveNonPresentItems() {
        ItemId otherItemId = ItemId.generate();
        RemoveItems removeOtherItems = new RemoveItems(cartId, otherItemId, qtyToRemove);

        fixture.given(cartCreatedEmpty)
                .andGiven(itemsAddedToCart)
                .when(removeOtherItems)
                .expectException(RuntimeException.class);
    }



}
