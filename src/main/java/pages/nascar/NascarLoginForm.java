package pages.nascar;

import model.nascar.UserNascar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class NascarLoginForm extends BasePage {

    @FindBy(css="#gigya-login-screen input[name='username']")
    WebElement loginField;

    @FindBy(css="#gigya-login-screen input[name='password']")
    WebElement passwordField;

    @FindBy(css="#gigya-login-screen .gigya-input-submit")
    WebElement submitButton;

    public NascarLoginForm(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getBaseUrl() {
        return null;
    }


    public void clickSubmit() {
        submitButton.click();
    }

    public void fillForm(UserNascar user) {
        loginField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
    }
}

