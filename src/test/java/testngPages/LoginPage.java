package testngPages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseDriver;

public class LoginPage extends BaseDriver {
    ElementsPage ep =new ElementsPage();

    @Test(dataProvider ="getData")
    public void login_1(String username,String password) {

        ep.sendKeysFunction(ep.userName, username);
        ep.sendKeysFunction(ep.password, password);
        ep.randomClick(ep.locationSession);
        ep.clickFunction(ep.loginBtn);

        if (username.equals("Admin") && password.equals("Admin123"))
        {
            ep.verifyContainsText(ep.loginSuccess, "Logged in as");
            ep.clickFunction(ep.logout);
        }
        else
        {
            ep.verifyContainsText(ep.errorMsg,"Invalid");
        }
    }

    @Test(dataProvider = "getData")
    public void login_2(String username,String password) {
        ep.sendKeysFunction(ep.userName, username);
        ep.sendKeysFunction(ep.password, password);
        ep.clickFunction(ep.loginBtn);
        ep.verifyContainsText(ep.locationMsg, "You must choose ");
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data=
        {
                {"Admin","Admin123"},
                {"Admin",""},
                {"",""},
                {"","Admin123"},
                {"admin","admin123"},
                {"xyz","1234"}
        };
        return data;
    }

}
