package tasks;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsList {
    public static final Target ADD_TO_CART_BUTTON = Target.the("the Add to cart button")
            .locatedBy("//*[@class='inventory_item_name' and text()='{0}']/ancestor::*[3]//*[contains(@class, 'btn_inventory')]");
    public static final Target ITEM_NAMES = Target.the("items names").locatedBy("[class=inventory_item_name]");
}
