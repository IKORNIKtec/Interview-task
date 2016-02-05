package pages.nascar;

import config.ConfigProperties;
import model.nascar.UserNascar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class NascarMainPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(NascarMainPage.class);
    private NascarRegistrationForm registerForm;
    private NascarLoginForm loginForm;

    @FindBy(css="#registerOrLogin .gigyaRegisterDialog")
    WebElement registerButton;

    @FindBy(css="#registerOrLogin .gigyaLoginDialog")
    WebElement loginButton;


    public NascarMainPage(WebDriver driver) {
        super(driver);
        registerForm = new NascarRegistrationForm(driver);
        loginForm = new NascarLoginForm(driver);
    }

    @Override
    public String getBaseUrl() {
        return ConfigProperties.NASCAR_BASE_URL;
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void registerUser(UserNascar user) {
        logger.info("Register user {}", user.toString());
        clickRegisterButton();
        registerForm.fillForm(user);
        registerForm.clickSubmit();
    }


    public void login(UserNascar user) {
        loginButton.click();
        loginForm.fillForm(user);
        loginForm.clickSubmit();
    }

    public void logout() {
    }

    public boolean isUserLoggedIn() {

        return false;
    }
}

