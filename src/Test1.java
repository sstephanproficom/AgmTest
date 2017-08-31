import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\sstephan\\Downloads\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.proficom.de/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void test() throws Exception {
    driver.get(baseUrl + "/");
    By expression = By.xpath("/html/body/div[1]/header/div/div/div[4]/div/nav/ul/li[3]/ul/li[2]/a");
    WebElement link = driver.findElement(expression);
    link.click();
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}