package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends BasePage {


    @FindBy (id = "search-input")
    private WebElement searchInput;

    @FindBy (className = "el-icon-search")
    private WebElement iconSearch;

    @FindBy (css = ".filters__body>.filters__base shadow.filter-itm>ul.open>li.flt-check>.el-checkbox__label>a")
    List<WebElement> categorySamsung;
    @FindBy (css = "button.el-dialog__headerbtn")
    WebElement marketingBaner;

    @FindBy (css = ".menu--desktop__drop-list>ul.menu-aim>li.menu-aim__item>a")
    List<WebElement> categories;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void printSamCategory () {
        for (WebElement element : categorySamsung) {
            System.out.println(element);
        }
    }


    public void setSearchText (String searchIn) {
        searchInput.sendKeys(searchIn);
        //searchInput.sendKeys(Keys.ENTER);

    }
    public void startSearch () {
        iconSearch.click();
    }

    // private WebElement categories;




//    public void clickOnSome (String setSearch) {
//        categories.click();
//        categories.sendKeys(setSearch);
//        categories.sendKeys(Keys.ENTER);
//    }
    public void clickOnsButton () {

    }
    public void closeMark () {
        marketingBaner.click();
    }

    public void printCategories () {
        for (WebElement category : categories) {
            System.out.println(category.getText());

        }
    }
    public void getGategories (String categoryName) {
        for (WebElement category : categories) {
            if (category.getText().equals(categoryName)) {
                category.click();
            }

        }
    }
}
