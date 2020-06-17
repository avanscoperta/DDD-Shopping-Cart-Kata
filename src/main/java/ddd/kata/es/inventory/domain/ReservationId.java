package ddd.kata.es.inventory.domain;

import java.util.UUID;

public class ReservationId {

    private final String id;

    public ReservationId(String id) {
        this.id = id;
    }

    public static ReservationId generate() {
        return new ReservationId(UUID.randomUUID().toString());
    }
}
