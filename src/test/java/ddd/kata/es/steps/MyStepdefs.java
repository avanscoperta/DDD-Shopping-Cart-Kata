package ddd.kata.es.steps;

import io.cucumber.java8.En;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyStepdefs implements En {
    public MyStepdefs() {

        Given("^item (.*) is available in the catalog$", (String itemDescription) -> {

        });
    }
}
