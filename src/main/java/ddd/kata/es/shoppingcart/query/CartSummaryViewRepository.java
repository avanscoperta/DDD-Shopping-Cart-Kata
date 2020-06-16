package ddd.kata.es.shoppingcart.query;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartSummaryViewRepository extends MongoRepository<CartSummaryView, String> {

}
