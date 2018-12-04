package foodband;

import org.testng.annotations.Test;

public class OrdersSearch extends TestBase {

    /*
    Тест проверяющий минимальную работоспособность формы "Поиск заказов"
    */

    @Test
    public void testOrdersSearch() {

        gotoOrdersSearch();
        fillOrdersSearch(new ParametrOrderSearch("MOW15285947"));
        initOrdersSearch();
        outSesion();
    }

}
