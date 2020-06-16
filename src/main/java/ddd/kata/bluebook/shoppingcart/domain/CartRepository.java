package ddd.kata.bluebook.shoppingcart.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartRepository extends MongoRepository<ShoppingCart, String> {
    ShoppingCart findByUserId(String userId);
}
