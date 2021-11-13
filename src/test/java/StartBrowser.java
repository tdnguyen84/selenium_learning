import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartBrowser implements Urls {

  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = DriverFactory.getChromeDriver();

    String loginUrl = demoUrl.concat(loginSlug);
    driver.get(loginUrl);

    try {
      String username = "tomsmith";
      String password = "SuperSecretPassword!";
      login(driver, username, password);
      Thread.sleep(20000);

    } catch (Exception ignored) {
    } finally{
      driver.quit();
    }
  }

  private static void login(WebDriver driver, String username, String password) {
    WebElement txtUsername = driver.findElement(By.cssSelector("#username"));
    WebElement txtPassword = driver.findElement(By.id("password"));
    WebElement btnSubmit = driver.findElement(By.xpath("//button[@type='submit']"));

    txtUsername.sendKeys(username);
    txtPassword.sendKeys(password);
    btnSubmit.click();
  }
}
