package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import ui.Header;
import ui.LoginPage;

public class NavigateTo  {

    public static Performable theLoginPage() {

        return Task.where("{0} opens the Home page", Open.browserOn().the(LoginPage.class));
    }

    public static Performable theShoppingCart() {
        return Task.where("{0} opens the Shopping cart", Click.on(Header.SHOPPING_CART_ICON));
    }
}