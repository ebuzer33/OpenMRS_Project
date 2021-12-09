package testngPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriver;
import java.util.List;

public class ElementsPage extends Parent {

    public ElementsPage(){
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(id ="username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "loginButton")
    WebElement loginBtn;

    @FindBy(css = "ul#sessionLocation>li")
    List<WebElement> locationSession;

    @FindBy(css = "li[class='nav-item logout']")
    WebElement logout;

    @FindBy(css = "#content>div:nth-child(2)")
    WebElement loginSuccess;

    @FindBy(id = "error-message")
    WebElement errorMsg;

    @FindBy(id = "sessionLocationError")
    WebElement locationMsg;

    @FindBy(css = "li>i[class=\"icon-user small\"]")
    WebElement adminBtn;

    @FindBy(id="user-account-menu")
    WebElement myAccountBtn;

    @FindBy(css ="#breadcrumbs>li:last-child")
    WebElement myAccountText;

    @FindBy(id = "selected-location")
    WebElement locationBtn;

    @FindBy(css = "ul.select>li")
    List<WebElement> menuLocation;

    @FindBy(id = "selected-location")
    WebElement locationText;

    @FindBy(tagName = "legend")
    WebElement loginText;
}
