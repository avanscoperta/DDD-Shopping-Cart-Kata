package ddd.es.kata.catalog.domain;

import java.util.Objects;
import java.util.UUID;

public class ItemId {
    private final String id;

    public ItemId(String id) {
        this.id = id;
    }

    public static ItemId generate() {
        return new ItemId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemId)) return false;
        ItemId itemId = (ItemId) o;
        return Objects.equals(id, itemId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
