package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.yahoo.YahooMainPage;
import utils.WebDriverFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class YahooTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(YahooTest.class);
    private String menuItem;
    private YahooMainPage yahooPage;

    public YahooTest(String value) {
        this.menuItem = value;
    }

    @Before
    public void clearCookie(){
        driver.manage().deleteAllCookies();
        yahooPage = new YahooMainPage(driver);
    }

    @Parameters(name = "{index}: Yahoo {0}")
    public static Iterable<Object[]> data() {
        driver = WebDriverFactory.getFirefoxDriver();
        YahooMainPage yahoo = new YahooMainPage(driver);
        yahoo.open();
        List<WebElement> menuItems = yahoo.getMainMenuItems();
        logger.info("Main menu items count is {}", menuItems.size());

        List<WebElement> seeMore = yahoo.getMoreMenuItems();
        logger.info("'See more' menu items count is {}", seeMore.size());
        menuItems.addAll(seeMore);

        assertTrue("Unable get Yahoo left-side menu items", menuItems.size() > 0);
        Collection<Object[]> result = new ArrayList<Object[]>();
        for (WebElement e: menuItems){
            String link = e.getText().isEmpty()?e.getAttribute("textContent"):e.getText();
            result.add(new Object[]{link});
        }
        driver.close();
        return  result;
    }

    @Test
    public void verifyTimeOfLoadingYahooSitesTest()  {
        long expLoadPageTime = 7;
        String message = "'Yahoo %s' loading over %s sec";
        yahooPage.open();
        yahooPage.clickNavigationMenuItem(menuItem);
        yahooPage.waitPageLoadingCompleted(expLoadPageTime);
        assertTrue(String.format(message, menuItem, expLoadPageTime) , yahooPage.isPageLoaded());
    }

}

