package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.LoginPage;

public class LogIntoTheApplication
{
    public static Performable withCredentials(String username, String password) {

        return Task.where("{0} logs into the application",
                Enter.theValue(username).into(LoginForm.USERNAME),
                Enter.theValue(password).into(LoginForm.PASSWORD),
                Click.on(LoginForm.LOGIN_BUTTON)
                );
    }
}
