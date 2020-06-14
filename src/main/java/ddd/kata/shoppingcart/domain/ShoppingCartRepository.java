package ddd.kata.shoppingcart.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

    ShoppingCart findByUserId(String userId);

}
