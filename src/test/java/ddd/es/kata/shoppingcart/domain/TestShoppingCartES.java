package ddd.es.kata.shoppingcart.domain;


import ddd.es.kata.shoppingcart.domain.events.CartCreated;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class TestShoppingCartES {

    FixtureConfiguration<ShoppingCart> fixture = new AggregateTestFixture<>(ShoppingCart.class);
    private String cartId;
    private String userId;

    @BeforeEach
    void setUp() {
        cartId = UUID.randomUUID().toString();
        userId = UUID.randomUUID().toString();
    }

    @Test
    public void canCreateAnEmptyShoppingCart() {

        CreateEmpty createEmpty = new CreateEmpty(cartId, userId);
        CartCreated cartCreatedEmpty = new CartCreated(cartId, userId);

        fixture.givenNoPriorActivity()
                .when(createEmpty)
                .expectEvents(cartCreatedEmpty);
    }

}
