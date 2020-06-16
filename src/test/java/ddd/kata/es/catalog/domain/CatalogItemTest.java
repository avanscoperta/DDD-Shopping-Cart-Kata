package ddd.kata.es.catalog.domain;

import ddd.kata.es.catalog.domain.events.ItemAddedToCatalog;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatalogItemTest {


    FixtureConfiguration<CatalogItem> fixture = new AggregateTestFixture<>(CatalogItem.class);
    private ItemId itemId;
    private String description;
    private Money unitPrice;
    private String imageUrl;
    private AddItemToCatalog addItemToCatalog;
    private ItemAddedToCatalog itemAddedToCatalog;


    @BeforeEach
    void setUp() {
        itemId = ItemId.generate();
        description = "Amazing item description";
        unitPrice = Money.of(99.99, "EUR");
        imageUrl = "http://somewhere.com/aiuabsi";

        addItemToCatalog = new AddItemToCatalog(
                itemId, description, unitPrice, imageUrl
        );

        itemAddedToCatalog = new ItemAddedToCatalog(itemId, description, unitPrice, imageUrl);

    }

    @Test
    public void canAddANewOneToCatalog() {


        fixture.givenNoPriorActivity()
                .when(addItemToCatalog)
                .expectSuccessfulHandlerExecution()
                .expectEvents(itemAddedToCatalog);
    }

    @Test
    public void canUpdateItemPrice() {

        Money newPrice = Money.of(109.99, "EUR");

        UpdateItemPrice updateItemPrice = new UpdateItemPrice(itemId, newPrice);
        ItemPriceUpdated itemPriceUpdated = new ItemPriceUpdated(itemId, newPrice);

        fixture.given(itemAddedToCatalog)
                .when(updateItemPrice)
                .expectSuccessfulHandlerExecution()
                .expectEvents(itemPriceUpdated);
    }


}
