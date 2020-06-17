package ddd.kata.es.shoppingcart.domain;

import ddd.kata.es.catalog.domain.ItemPriceUpdated;
import ddd.kata.es.shoppingcart.domain.command.UpdateItemPriceInCart;
import ddd.kata.es.shoppingcart.domain.events.CartMarkedAsCheckedOut;
import ddd.kata.es.shoppingcart.domain.events.ItemsAddedToCart;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Saga
public class PriceUpdatePolicy {

    @Autowired
    private transient CommandGateway commandGateway;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<CartId> activeCarts = new ArrayList<>();



    @StartSaga
    @SagaEventHandler(associationProperty = "itemId")
    public void on(ItemsAddedToCart event) {
        activeCarts.add(event.getCartId());
        SagaLifecycle.associateWith("cartId", event.getCartId().toString());
    }

    @SagaEventHandler(associationProperty = "itemId")
    public void on(ItemPriceUpdated event) {
        activeCarts.forEach(cartId -> {
                    UpdateItemPriceInCart command = new UpdateItemPriceInCart(
                            cartId, event.getItemId(), event.getNewPrice()
                    );
                    commandGateway.send(command);
                });
    }


    // TODO remove activeCarts

    @SagaEventHandler(associationProperty = "cartId")
    public void on(CartMarkedAsCheckedOut event) {
        activeCarts.remove(event.getCartId());
        logger.info("Removed cart from active carts");

    }
}
