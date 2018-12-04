package foodband;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public class TestBase {
    public FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("http://93.158.194.208:6005/login");
        login("test", "test");
        wd.findElement(By.id("selectKitchen")).click();
        new Select(wd.findElement(By.id("selectKitchen"))).selectByVisibleText("Новокузнецкий");
        wd.findElement(By.xpath(".//*[@class=\"btn btn-lg btn-default btn-block\"]")).click();
        wd.get("http://93.158.194.208:6005/operator/all");
    }

    private void login(String username, String password) {
        wd.findElement(By.id("inputLogin")).click();
        wd.findElement(By.id("inputLogin")).clear();
        wd.findElement(By.id("inputLogin")).sendKeys(username);
        wd.findElement(By.id("inputPassword")).click();
        wd.findElement(By.id("inputPassword")).click();
        wd.findElement(By.id("inputPassword")).clear();
        wd.findElement(By.id("inputPassword")).sendKeys(password);
        wd.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/button")).click();
    }


    protected void gotoHomePage() {
        wd.get("http://93.158.194.208:6005/operator/all");
    }



    protected void gotoNewOrder() {

//        wd.findElement(By.xpath(".//*[@class=\"navbar-brand nav-button\"]")).click();
//        wd.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[1]/div/div/div[1]/a")).click();
        wd.findElement(By.cssSelector("a.nav-button")).click();
    }

    protected void selectWOK() {

        wd.findElement(By.xpath(".//*[@class=\"item-header ng-binding\"]")).click();
    }

    protected void choiceUdonWithBeef_normal() {

        wd.findElement(By.cssSelector("div.panel-warning:nth-child(1) > div:nth-child(2) > button:nth-child(1)")).click();
    }

    protected void selectDrinks_NonAlcoholic() {

//        wd.findElement(By.xpath(".//*[@class=\"item-header ng-binding text-selected\"]")).click();
        wd.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/ui-view/div[1]/div[1]/div/div/div/ng-include/div/div/div/div[7]/div[2]/div[1]/div[1]/a")).click();
    }

    protected void choiceFruitJuice() {

        wd.findElement(By.cssSelector("div.col-md-3:nth-child(30) > div:nth-child(2) > button:nth-child(1)")).click();
    }

    protected void addItemFood() {

        wd.findElement(By.cssSelector(".tbody > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > button:nth-child(3)")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }


}

