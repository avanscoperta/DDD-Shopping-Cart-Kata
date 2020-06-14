package ddd.kata.shoppingcart.application;

import ddd.kata.shoppingcart.domain.ShoppingCart;
import ddd.kata.shoppingcart.domain.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartApi {

@Autowired
ShoppingCartRepository repository;


    public ShoppingCart getCartForUser(String userId) {
        ShoppingCart shoppingCart = repository.findByUserId(userId);
        if(shoppingCart == null) {
            shoppingCart = ShoppingCart.createEmpty(userId);
            repository.save(shoppingCart);
        }
        return  shoppingCart;
    }




}
