package ddd.kata.es.inventory.query;

import ddd.kata.es.inventory.domain.ReservationId;
import ddd.kata.es.shoppingcart.domain.events.ItemsAddedToCart;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReservationProjection {

    @Autowired
    ReservationViewRepository repository;

    @EventHandler
    public void on(ItemsAddedToCart event) {
        ReservationId reservationId = ReservationId.generate();

        ReservationView reservation = new ReservationView(
                reservationId,
                event.getItemId(),
                event.getDescription(),
                LocalDate.now(),
                "Unknown user",
                event.getQty(),
                event.getCartId()
        );
        repository.save(reservation);
    }

}
