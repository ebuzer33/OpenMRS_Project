package testngPages;

import org.testng.annotations.Test;
import utils.BaseDriver;

public class MenuPage extends BaseDriver {

    ElementsPage ep =new ElementsPage();

    @Test
    public void menu() {
        ep.sendKeysFunction(ep.userName, "Admin");
        ep.sendKeysFunction(ep.password, "Admin123");
        ep.randomClick(ep.locationSession);
        ep.clickFunction(ep.loginBtn);

        ep.hoverFunction(ep.adminBtn);
        ep.clickFunction(ep.myAccountBtn);
        ep.verifyContainsText(ep.myAccountText,"My Account");

        ep.chooseAndVerify(ep.menuLocation, ep.locationBtn,ep.locationText,
                ep.locationText.getText());

        ep.clickFunction(ep.logout);
        ep.verifyContainsText(ep.loginText,"LOGIN");

    }
}
