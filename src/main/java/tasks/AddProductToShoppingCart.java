package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AddProductToShoppingCart
{
    public static Performable named(String productName) {

        return Task.where("{0} add product to shopping cart",
                Click.on(ProductsList.ADD_TO_CART_BUTTON.of(productName)));
    }
}