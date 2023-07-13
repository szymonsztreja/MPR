import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimesheetTests {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.miraclesalad.com/webtools/timesheet.php");
    }

    @Test
    public void timePassedTestShouldReturn1Hour36Minutes(){
        driver.findElement(By.name("start[0]")).sendKeys("12:37");
        driver.findElement(By.name("end[0]")).sendKeys("14:13");
        driver.findElement(By.xpath("//button[@id='calc-hours']")).click();
        String actucalResult = driver.findElement(By.name("calc-hours-total")).getText();
        String expectedResult = "1:36";
        Assert.assertEquals(expectedResult, actucalResult);
    }
    @AfterClass
    public static void quitChrome(){
        driver.quit();
    }
}
