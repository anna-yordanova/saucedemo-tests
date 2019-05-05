package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import tasks.ProductsList;

import java.util.List;

public class ShoppingCart
{
    public static Question<List<String>> productsList()
    {
        return actor -> TextContent.of(ProductsList.ITEM_NAMES).viewedBy(actor).asList();
    }
}
