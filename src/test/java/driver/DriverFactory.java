package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
  public static WebDriver getChromeDriver() {
    String driverLocation;
    String currentPath = System.getProperty("user.dir");

    if( OS.isFamilyMac()) {
      driverLocation = currentPath + "/src/test/resources/drivers/chromedriver";
    } else {
      driverLocation = currentPath + "\\src\\test\\resources\\drivers\\chromedriver";
    }

    if(driverLocation == null) {
      throw new IllegalArgumentException("Can't detect OS");
    }

    System.setProperty("webdriver.chrome.driver", driverLocation);

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--incognito");

    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    return driver;
  }
}
