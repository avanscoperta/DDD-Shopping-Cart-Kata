package ddd.kata.es.shoppingcart.query;

import ddd.kata.es.catalog.domain.ItemId;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

/**
 * We are embracing CQRS separation here: this class structure has
 * - no behavioural logic, this belongs tp the Aggregate and Policies
 * - can have display specific logic, to display data ina way which is more effective to the reader
 */
public class CartSummaryView {

    @Id
    private String cartId;
    private String userId;
    private Map<ItemId, LineItemView> lineItems;


    public CartSummaryView(String cartId, String userId) {
        this.cartId = cartId;
        this.userId = userId;
        lineItems = new HashMap<>();
    }
}
