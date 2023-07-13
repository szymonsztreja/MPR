import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaluclateFuelTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/fuel-cost-calculator.html");
    }

    @Test
    public void calculateFuelExpenses344KilometersWithOutClear(){
        String actualResult = calculateFuel("344", "5.5", "1.8");
        String expectedResult = "This trip will require 18.9 liters of fuel, which amounts to a fuel cost of $34.06.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateFuelExpenses344KilometersWithClear(){
        clear();
        String actualResult = calculateFuel("344", "5.5", "1.8");
        String expectedResult = "This trip will require 18.9 liters of fuel, which amounts to a fuel cost of $34.06.";
        Assert.assertEquals(expectedResult, actualResult);
    }
    private String calculateFuel(String tripDistance, String fuelEfficiency, String gasprice){
        driver.findElement(By.name("tripdistance")).sendKeys(tripDistance);
        driver.findElement(By.name("fuelefficiency")).sendKeys(fuelEfficiency);
        driver.findElement(By.name("gasprice")).sendKeys(gasprice);
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        return driver.findElement(By.className("verybigtext")).getText();
    }
    public void clear(){
        driver.findElement(By.className("clearbtn")).click();
    }

    @AfterClass
    public static void quitChrome(){
        driver.quit();
    }
}
