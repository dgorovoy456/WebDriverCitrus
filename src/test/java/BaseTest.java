import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public String searchtext = "samsung";
    private WebDriver driver;
    //@BeforeSuite
    //@BeforeTest
    @BeforeClass
            public void beforeClass () {
        System.setProperty("webdriver.chrome.driver", "/home/dhorovyi/Downloads/chromedriver_linux64/chromedriver");
    }
    @BeforeMethod
    public void beforeMethod () {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--whitelist-ip *");
        chromeOptions.addArguments("--proxy-server='direct://'");
        chromeOptions.addArguments("--proxy-bypass-list=*");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
//        chromeOptions.addArguments("--headless"); //!!!should be enabled for Jenkins
//        chromeOptions.addArguments("--disable-dev-shm-usage"); //!!!should be enabled for Jenkins
//        chromeOptions.addArguments("--window-size=1920x1080"); //!!!should be enabled for Jenkins
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.citrus.ua/");
    }

    @Test
    public void openPage () throws InterruptedException {

        MainPage page = new MainPage(driver);
        Thread.sleep(20000);
        page.closeMark();
        page.printCategories();
        page.getGategories("Смартфоны");
         // page.clickOnSome("test");

    }

//    @Test
//    public void openPage1 () throws InterruptedException {
//        MainPage page1 = new MainPage(driver);
//        page1.setSearchText(searchtext);
//        page1.startSearch();
//        Thread.sleep(5000);
//        page1.printSamCategory();

//    }
    @AfterMethod
    public void afterMethod () throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }
    @AfterClass
    public void afterClass () {

    }

    //@AfterTest
    //@AfterSuite
}
