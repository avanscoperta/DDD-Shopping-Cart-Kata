package ddd.kata.shoppingcart.domain.articles;

import java.util.UUID;

public class ArticleId {
    private final String id;

    public ArticleId(String id) {
        this.id = id;
    }

    public static ArticleId generate() {
        return new ArticleId(UUID.randomUUID().toString());
    }
}
