package ddd.kata.es.inventory.query;

import ddd.kata.es.catalog.domain.ItemId;
import ddd.kata.es.inventory.domain.ReservationId;
import ddd.kata.es.shoppingcart.domain.CartId;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class ReservationView {
    @Id
    private ReservationId reservationid;
    private ItemId itemId;
    private String description;
    private LocalDate placedOn;
    private String reservedTo;
    private int qty;
    private CartId cartId;

    public ReservationView(ReservationId reservationid, ItemId itemId, String description, LocalDate placedOn, String reservedTo, int qty, CartId cartId) {
        this.reservationid = reservationid;
        this.itemId = itemId;
        this.description = description;
        this.placedOn = placedOn;
        this.reservedTo = reservedTo;
        this.qty = qty;
        this.cartId = cartId;
    }
}
