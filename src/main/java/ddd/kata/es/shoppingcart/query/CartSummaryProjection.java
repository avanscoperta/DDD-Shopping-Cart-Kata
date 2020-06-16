package ddd.kata.es.shoppingcart.query;

import ddd.kata.es.shoppingcart.domain.events.CartCreated;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Turns a flow of Events into a specialized view
 */
@Component
public class CartSummaryProjection {

    private final CartSummaryViewRepository repository;

    public CartSummaryProjection(CartSummaryViewRepository repository) {
        this.repository = repository;
    }

    /**
     * Seeds the summary with the content of the first event.
     * @param cartCreated
     */
    public void on(CartCreated cartCreated) {
        CartSummaryView summaryView = new CartSummaryView(
                cartCreated.getCartId().toString(),    // <-- Should we keep the original type or flatten it?
                cartCreated.getUserId()
        );
        repository.save(summaryView);
    }

    @QueryHandler
    public Optional<CartSummaryView> find(String cartId) {
        return repository.findById(cartId);
    }
}
