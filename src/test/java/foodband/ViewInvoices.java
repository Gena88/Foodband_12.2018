package foodband;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ViewInvoices extends TestBase {

    /*
    Тест проверяющий минимальную работоспособность формы "Просмотр накладных"
    */

    @Test
    public void testViewInvoices() {
//        gotoViewInvoices();
//        wd.findElement(By.xpath("//input[@name='wblnum']")).click();
        wd.findElement(By.name("wblnum")).click();
//        wd.findElement(By.name("wblnum")).clear();
//        wd.findElement(By.name("wblnum")).sendKeys("18-1785-7206");
        wd.findElement(By.name("wblnum")).sendKeys("18-1785-7206");
//        try {
//
//            Thread.sleep(3000);     //1000-задержка  на 1000 миллисекунду = 1 секунда
//
//        } catch (InterruptedException e) {
//            System.err.println(e.getMessage());
//        }
        initViewInvoices();
        outSesion();
//        new Actions(wd).doubleClick(wd.findElement(By.id("pass"))).build().perform();
    }


}
