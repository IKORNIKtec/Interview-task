package pages;

import config.ConfigProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public static long WAIT_TIME_SECONDS = 70;

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementPresence(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitForElementPresence(By locator){
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitPageLoadingCompleted(){
        waitPageLoadingCompleted(WAIT_TIME_SECONDS);
    }

    public void waitPageLoadingCompleted(final long timeoutSeconds){
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);

            ExpectedCondition<Boolean> pageLoadCondition = new
                    ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                        }
                    };

            wait.until(pageLoadCondition);
        }catch (TimeoutException e){

        }
    }

    public boolean isPageLoaded(){
        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
    }
    public abstract String getBaseUrl();

    public void open() {
        driver.get(getBaseUrl());
    }
}

