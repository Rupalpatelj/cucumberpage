package movecursur;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.bcel.generic.Visitor;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class IndexPage {
   public static WebDriver driver;
    @Test
    public void dropdownMenu()
    {
        //WebDriverManager.chromedriver().setup();
        //FirefoxProfile prof = new FirefoxProfile();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://www.argos.co.uk/");
        driver.manage().window().maximize();

        WebElement menu=driver.findElement(By.cssSelector(".uppercase.meganav__level-1-title"));

        Actions act= new Actions(driver);
        act.moveToElement(menu).build().perform();
        WebElement submenu=driver.findElement(By.cssSelector("a[href*='/browse/technology/televisions-and-accessories/c:29955/']"));
        submenu.click();
        WebElement popup= driver.findElement(By.cssSelector("a[href*='/browse/technology/televisions-and-accessories/hdmi-cables-and-optical-cables/c:30103/']"));
        popup.click();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        List<WebElement> filtermenu=driver.findElements(By.cssSelector(".ac-accordion__expand-button"));
        List<WebElement> selectitem=driver.findElements(By.cssSelector(".ac-facet__label.ac-facet__label--rating.radio__label"));
        String click = null;
        for (WebElement i:selectitem)
        {

            if (i.getText().contains("5only"))
            {

                    i.click();
                   click =i.getText();
                System.out.println(i.getText());
                    break;
            }
        }
       // WebElement actual = driver.findElement(By.cssSelector(".xs-stack.sm-row.xs-auto--none.sm-auto--none.md-auto--none.lg-auto--negative.product-list"));
      //  Assert.assertArrayEquals(new String[]{click},actual);
    }
}
