package step_definitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

import net.serenitybdd.screenplay.actors.Stage;
import org.hamcrest.Matchers;
import questions.ShoppingCart;
import tasks.AddProductToShoppingCart;
import tasks.AddProductsToShoppingCart;
import tasks.LogIntoTheApplication;
import tasks.NavigateTo;

import java.util.List;

public class AddToShoppingCart {

    private Stage scenarioStage;

    @Before
    public void setTheStage() {
        scenarioStage = OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is logged in")
    public void on_the_home_page(User user) {
        theActorCalled(user.toString()).wasAbleTo(NavigateTo.theLoginPage());
        theActorInTheSpotlight().attemptsTo(LogIntoTheApplication.withCredentials(user.getUserName(), user.getUserPassword()));
    }

//    @Given("she/he has added {string} product to shopping cart")
//    public void add_product_to_shopping_cart(String productName) {
//        theActorInTheSpotlight().wasAbleTo(AddProductToShoppingCart.named(productName));
//    }

    @Given("has added the following product in the shopping cart: (.*)$")
    public void add_products_to_shopping_cart(String productName) {
        theActorInTheSpotlight().wasAbleTo(AddProductsToShoppingCart.named(productName));
    }

//    @Given("she/he has added the following product(s) in her/his shopping cart")
//    public void add_products_to_shopping_cart(List<String> productNames) {
//        theActorInTheSpotlight().wasAbleTo(AddProductsToShoppingCart.named(productNames));
//    }

    @When("she/he opens the shopping cart")
    public void open_shopping_cart() {
        theActorInTheSpotlight().attemptsTo(NavigateTo.theShoppingCart());
    }

    @Then("in the shopping cart is listed: (.*)$")
    public void products_should_be_in_shopping_cart(String productName)
    {
        theActorInTheSpotlight().should(seeThat(ShoppingCart.productsList(), contains(productName)));
    }

//    @Then("in her/his shopping cart is/are listed")
//    public void products_should_be_in_shopping_cart(List<String> productNames){
//
//        theActorInTheSpotlight().should(seeThat(ShoppingCart.productsList(), contains(productNames)));
//    }
}
