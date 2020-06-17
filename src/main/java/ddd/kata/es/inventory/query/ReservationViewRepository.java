package ddd.kata.es.inventory.query;

import ddd.kata.es.catalog.domain.ItemId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ReservationViewRepository extends MongoRepository<ReservationView, String> {
    Optional<ReservationView> findByItemId(ItemId itemId);
}
