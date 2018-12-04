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
    }

    private void login(String username, String password) {
        wd.findElement(By.id("inputLogin")).click();
        wd.findElement(By.id("inputLogin")).clear();
        wd.findElement(By.id("inputLogin")).sendKeys(username);
        wd.findElement(By.id("inputPassword")).click();
        wd.findElement(By.id("inputPassword")).click();
        wd.findElement(By.id("inputPassword")).clear();
        wd.findElement(By.id("inputPassword")).sendKeys(password);
        wd.findElement(By.xpath(".//*[@class=\"btn btn-lg btn-default btn-block\"]")).click();
    }

    protected void outSesion() {
        wd.findElement(By.linkText("Выйти")).click();
    }

    protected void initOrdersSearch() {
        wd.findElement(By.xpath("//div[@class='text-container']/form/input[8]")).click();
    }

    protected void fillOrdersSearch(ParametrOrderSearch parametrOrderSearch) {
        wd.findElement(By.id("ord_num")).click();
        wd.findElement(By.id("ord_num")).clear();
        wd.findElement(By.id("ord_num")).sendKeys(parametrOrderSearch.getOrderNumber());
    }

    protected void gotoOrdersSearch() {
        wd.findElement(By.linkText("Поиск заказов")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    protected void initViewInvoices() {
        wd.findElement(By.name("sub")).click();
    }

    protected void gotoViewInvoices() {
        wd.findElement(By.linkText("Просмотр накладных")).click();
    }
}
