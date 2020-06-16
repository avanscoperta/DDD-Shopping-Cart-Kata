package ddd.kata.es.catalog.domain;

import ddd.kata.es.catalog.domain.events.ItemAddedToCatalog;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class CatalogItemTest {


    FixtureConfiguration<CatalogItem> fixture = new AggregateTestFixture<>(CatalogItem.class);



    @Test
    public void canAddAnewOneToCatalog() {
        ItemId itemId = ItemId.generate();
        String description ="Amazing item description";
        Money unitPrice = Money.of(99.99, "EUR");
        String imageUrl = "http://somewhere.com/aiuabsi";

        AddItemToCatalog addItemToCatalog = new AddItemToCatalog(
                itemId, description, unitPrice, imageUrl
        );

        ItemAddedToCatalog itemAddedToCatalog = new ItemAddedToCatalog(itemId, description, unitPrice, imageUrl);

        fixture.givenNoPriorActivity()
                .when(addItemToCatalog)
                .expectSuccessfulHandlerExecution()
                .expectEvents(itemAddedToCatalog);
    }
}
