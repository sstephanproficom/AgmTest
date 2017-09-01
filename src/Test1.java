import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.proficom.de/";
    driver.manage().window().setSize(new Dimension(1024,768));
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void test() throws Exception {
    driver.get(baseUrl + "/");
    
    Actions action = new Actions(driver);
    WebElement we = driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[2]/a"));
    we.click();
    action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[2]/div/ul/li[2]/a"))).click();
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}