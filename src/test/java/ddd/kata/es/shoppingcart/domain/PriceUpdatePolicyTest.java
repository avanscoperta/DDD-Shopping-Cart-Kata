package ddd.kata.es.shoppingcart.domain;

import ddd.kata.es.catalog.domain.ItemId;
import ddd.kata.es.catalog.domain.ItemPriceUpdated;
import ddd.kata.es.shoppingcart.domain.command.UpdateItemPriceInCart;
import ddd.kata.es.shoppingcart.domain.events.ItemsAddedToCart;
import org.axonframework.test.saga.FixtureConfiguration;
import org.axonframework.test.saga.SagaTestFixture;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class PriceUpdatePolicyTest {

    FixtureConfiguration fixture = new SagaTestFixture<PriceUpdatePolicy>(PriceUpdatePolicy.class);

    @Test
    public void priceUpdatesArePropagatedToCarts() {

        CartId cartId = CartId.generate();
        ItemId itemId = ItemId.generate();
        String description = "Whatever";
        int qty = 5;
        Money originalPrice = Money.of(88, "EUR");
        Money newPrice = Money.of(108.50, "EUR");

        ItemsAddedToCart itemsAddedToCart = new ItemsAddedToCart(cartId, itemId, description, qty, originalPrice);
        ItemPriceUpdated itemPriceUpdated = new ItemPriceUpdated(itemId, newPrice);
        UpdateItemPriceInCart updatePricesInCart = new UpdateItemPriceInCart(cartId, itemId, newPrice);

        fixture.givenAPublished(itemsAddedToCart)
                .whenPublishingA(itemPriceUpdated)
                .expectDispatchedCommands(updatePricesInCart);
    }
}
