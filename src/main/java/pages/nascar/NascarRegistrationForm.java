package pages.nascar;

import model.nascar.UserNascar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class NascarRegistrationForm extends BasePage {

    @FindBy(css=".gigya-screen-dialog-inner .gigya-register-form input[data-gigya-name='email']")
    WebElement emailField;

    @FindBy(css=".gigya-screen-dialog-inner .gigya-register-form input[data-gigya-name='password']")
    WebElement passwordField;

    @FindBy(css=".gigya-screen-dialog-inner .gigya-register-form input[data-gigya-name='zip']")
    WebElement zipField;

    @FindBy(css=".gigya-screen-dialog-inner .gigya-register-form input[data-gigya-name='data.terms']")
    WebElement privacyCheckbox;

    @FindBy(css=".gigya-screen-dialog-inner .gigya-register-form .gigya-input-submit")
    WebElement submitButton;

    public NascarRegistrationForm(WebDriver driver) {
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
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        zipField.sendKeys(user.getZip());
        acceptPrivacy();
    }
    public void acceptPrivacy() {
        privacyCheckbox.click();
    }
}

