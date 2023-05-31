package dataproviders;

import com.rd.person.Man;
import com.rd.person.Person;
import com.rd.person.Woman;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "couple")
    public static Object[][] couple() {
        return new Object[][]{{new Man("Kol", "Jhy", 75, null, null, false, false),
                new Woman("Lida", "Fase", 45, null, "Mjk", false, false)},
        {new Man("Dase", "Koler", 45, null, null, false, false),
                new Woman("Lola", "Gare", 45, null, "Made", false, false)}};

    }

    @DataProvider(name = "women")
    public static Object[][] women(){
        return new Object[][]{{new Woman("Olga", "KLart", 75, null, "Laxw", false, false)},
                {new Woman("Dina", "Lol", 25, null, "Koa", false, false)}};

    }


    @DataProvider(name = "men")
    public static Object[][] men(){
        return new Object[][]{{new Man("Luke", "Perry", 35, null , null, false, false)},
                {new Man("Jerry", "Volt", 75, null, null, true, false)}};

    }


}