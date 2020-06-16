package ddd.kata.bluebook.shoppingcart.application;

import ddd.kata.bluebook.shoppingcart.domain.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartApi {

@Autowired
CartRepository repository;


 /*   public ShoppingCart getCartForUser(String userId) {
        ShoppingCart shoppingCart = repository.findByUserId(userId);
        if(shoppingCart == null) {
            shoppingCart = ShoppingCart.createEmpty(userId);
            repository.save(shoppingCart);
        }
        return  shoppingCart;
    }*/




}
