package ddd.es.kata.shoppingcart.domain;


import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Test;

public class TestShoppingCartES {

    FixtureConfiguration<ShoppingCart> fixture = new AggregateTestFixture<>(ShoppingCart.class);

    @Test
    public void canCreateAnEmptyShoppingCart() {
       // fixture.
    }

}
