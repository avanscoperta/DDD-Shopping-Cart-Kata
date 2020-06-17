package ddd.kata.es.shoppingcart.domain;

import ddd.kata.es.catalog.domain.ItemId;
import ddd.kata.es.catalog.domain.ItemPriceUpdated;
import ddd.kata.es.shoppingcart.domain.command.UpdateItemPriceInCart;
import ddd.kata.es.shoppingcart.domain.events.CartMarkedAsCheckedOut;
import ddd.kata.es.shoppingcart.domain.events.ItemsAddedToCart;
import org.axonframework.test.saga.FixtureConfiguration;
import org.axonframework.test.saga.SagaTestFixture;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class PriceUpdatePolicyTest {

    FixtureConfiguration fixture = new SagaTestFixture<PriceUpdatePolicy>(PriceUpdatePolicy.class);
    private CartId cartId;
    private ItemId itemId;
    private String description;
    private int qty;
    private Money originalPrice;
    private Money newPrice;
    private ItemsAddedToCart itemsAddedToCart;
    private ItemPriceUpdated itemPriceUpdated;

    @BeforeEach
    void setUp() {
        cartId = CartId.generate();
        itemId = ItemId.generate();
        description = "Whatever";
        qty = 5;
        originalPrice = Money.of(88, "EUR");
        newPrice = Money.of(108.50, "EUR");

        itemsAddedToCart = new ItemsAddedToCart(cartId, itemId, description, qty, originalPrice);
        itemPriceUpdated = new ItemPriceUpdated(itemId, newPrice);
    }

    @Test
    public void priceUpdatesArePropagatedToCarts() {


        itemPriceUpdated = new ItemPriceUpdated(itemId, newPrice);
        UpdateItemPriceInCart updatePricesInCart = new UpdateItemPriceInCart(cartId, itemId, newPrice);



        fixture.givenAPublished(itemsAddedToCart)
                .whenPublishingA(itemPriceUpdated)
                .expectDispatchedCommands(updatePricesInCart);
    }

    @Test
    public void checkedOutCartsAreNotReceivingTheCommand() {

        String userId = UUID.randomUUID().toString();
        Money totalCartAmount = Money.of(2351.87, "EUR");

        CartMarkedAsCheckedOut cartMarkedAsCheckedOut = new CartMarkedAsCheckedOut(cartId, userId, totalCartAmount);

        fixture.givenAPublished(itemsAddedToCart)
                .andThenAPublished(cartMarkedAsCheckedOut)
                .whenPublishingA(itemPriceUpdated)
                .expectNoDispatchedCommands();
    }

}
