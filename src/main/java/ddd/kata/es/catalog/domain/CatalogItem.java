package ddd.kata.es.catalog.domain;

import ddd.kata.es.catalog.domain.events.ItemAddedToCatalog;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class CatalogItem {

    @AggregateIdentifier
    private ItemId itemId;

    private CatalogItem() {}

    @CommandHandler
    public CatalogItem(AddItemToCatalog command) {
        apply(new ItemAddedToCatalog(
                command.getItemId(),
                command.getDescription(),
                command.getUnitPrice(),
                command.getImageUrl()
        ));
    }

    @EventSourcingHandler
    public void on(ItemAddedToCatalog event) {
        this.itemId = event.getItemId();
    }

}
