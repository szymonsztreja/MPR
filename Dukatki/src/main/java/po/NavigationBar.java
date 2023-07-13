package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationBar extends BasePage{
    @FindBy(xpath = "//button[contains(text(), 'Szukaj')]")
    private WebElement searchBtn;

    @FindBy(partialLinkText = "Zaloguj")
    private WebElement loginBtn;

    @FindBy(partialLinkText = "Twoje konto")
    private WebElement userAccBtn;

    @FindBy(id = "menu_search_text")
    private WebElement searchInput;

    @FindBy(partialLinkText = "Wyloguj się")
    private WebElement logoutBtn;

    @FindBy()


    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
    }

    public LoginPage openLoginPage(){
        loginBtn.click();
        return new LoginPage(driver);
    }

    public UserAccountPage openUserAccountPage(){
        userAccBtn.click();
        return new UserAccountPage(driver);
    }

    public LoginPage logout(){
        logoutBtn.click();
        return new LoginPage(driver);
    }

    public String getCartStatus(){

    }

//    public SearchResultsPage serach(String searched){
//        searchInput.sendKeys(searched);
//        searchBtn.click();
//        return  new SearchResultsPage(driver);
//    }
}
