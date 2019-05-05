package tasks;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductsToShoppingCart implements Task {
    private final List<String> productNames;

    @Override
    @Step("{0} adds products called: #products")
    public <T extends Actor> void performAs(T actor)
    {
        productNames.forEach(
                productName -> actor.attemptsTo(AddProductToShoppingCart.named(productName))
        );
    }

    public static AddProductsToShoppingCart named(String... items)
    {
        return instrumented(AddProductsToShoppingCart.class, asList(items));
    }

    public static AddProductsToShoppingCart named(Collection<String> items)
    {
        return instrumented(AddProductsToShoppingCart.class, items);
    }

    public AddProductsToShoppingCart(List<String> items) {
        this.productNames = ImmutableList.copyOf(items);
    }
}