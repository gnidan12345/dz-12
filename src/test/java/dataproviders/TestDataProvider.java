package dataproviders;

import com.rd.person.Man;
import com.rd.person.Person;
import com.rd.person.Woman;
import org.testng.annotations.DataProvider;

public class TestDataProvider {


    @DataProvider(name = "womanIsRetireData")
    public static Object[][] womanIsRetireData() {
        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", false, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", false, false);
        Woman woman3 = new Woman("Mila", "Green", 61, null, "Max", false, false);

        return new Object[][]{
                {woman1, true}, {woman2, false}, {woman3, true}
        };
    }

    @DataProvider(name = "manIsRetireData")
    public static Object[][] manIsRetireData() {
        Man man1 = new Man("Olga", "KLart", 75, null, "Laxw", false, false);
        Man man2 = new Man("Dina", "Lol", 25, null, "Koa", false, false);
        Man man3 = new Man("Mila", "Green", 61, null, "Max", false, false);

        return new Object[][]{
                {man1, true}, {man2, false}, {man3, false}
        };
    }

    @DataProvider(name = "registerPartnershipWoman")
    public static Object[][] registerPartnershipDataWoman() {
        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", false, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", false, false);


        Man man1 = new Man("Andrew", "Base", 45, null, null, false, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, false, false);

        return new Object[][]{
                {woman1, man1, true}, {woman2, man2, true}
        };
    }

    @DataProvider(name = "registerPartnershipMan")
    public static Object[][] registerPartnershipDataMan() {

        Man man1 = new Man("Andrew", "Base", 45, null, null, false, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, false, false);

        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", false, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", false, false);


        return new Object[][]{
                {man1, woman1, true}, {man2, woman2, true}
        };
    }

    @DataProvider(name = "deRegisterPartnershipMan")
    public static Object[][] deRegisterPartnershipDataMan() {

        Man man1 = new Man("Andrew", "Base", 45, null, null, true, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, true, false);

        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", true, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", true, false);

        return new Object[][]{
                {man1, woman1, false}, {man2, woman2, false}
        };
    }

    @DataProvider(name = "deRegisterPartnershipWoman")
    public static Object[][] deRegisterPartnershipDataWoman() {

        Man man1 = new Man("Andrew", "Base", 45, null, null, true, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, true, false);

        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", true, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", true, false);

        return new Object[][]{
                {man1, woman1, false}, {man2, woman2, false}
        };
    }

    @DataProvider(name = "ManAge")
    public static Object[][] ManAge() {
        Man man1 = new Man("Andrew", "Base", 45, null, null, false, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, false, false);

        return new Object[][]{
                {man1, 45}, {man2, 55}

        };
    }

    @DataProvider(name = "ManLastName")
    public static Object[][] ManLastName() {
        Man man1 = new Man("Andrew", "Base", 45, null, null, false, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, false, false);

        return new Object[][]{
                {man1, "Base"}, {man2, "Last"}
        };
    }

    @DataProvider(name = "ManFirstName")
    public static Object[][] ManFirstName() {
        Man man1 = new Man("Andrew", "Base", 45, null, null, false, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, false, false);

        return new Object[][]{
                {man1, "Andrew"}, {man2, "Bill"}
        };
    }

    @DataProvider(name = "ManHasNoPartner")
    public static Object[][] ManHasNoPartner() {
        Man man1 = new Man("Andrew", "Base", 45, null, null, false, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, false, false);

        return new Object[][]{
                {man1, null}, {man2, null}
        };
    }

    @DataProvider(name = "ManHasPartner")
    public static Object[][] ManHasPartner() {
        Man man1 = new Man("Andrew", "Base", 45, null, null, false, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, false, false);

        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", false, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", false, false);

        return new Object[][]{
                {man1, woman1, woman1}, {man2, woman2, woman2}
        };
    }

    @DataProvider(name = "WomanAge")
    public static Object[][] WomanAge() {
        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", true, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", true, false);

        return new Object[][]{
                {woman1, 75}, {woman2, 25}
        };
    }

    @DataProvider(name = "WomanLastName")
    public static Object[][] WomanLastName() {
        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", true, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", true, false);

        return new Object[][]{
                {woman1, "KLart"}, {woman2, "Lol"}

        };
    }

    @DataProvider(name = "WomanFirstName")
    public static Object[][] WomanFirstName() {
        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", true, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", true, false);

        return new Object[][]{
                {woman1, "Olga"}, {woman2, "Dina"}

        };
    }


    @DataProvider(name = "WomanHasNoPartner")
    public static Object[][] WomanHasNoPartner() {
        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", true, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", true, false);

        return new Object[][]{
                {woman1, null}, {woman2, null}
        };
    }


    @DataProvider(name = "WomanHasPartner")
    public static Object[][] WomanHasPartner() {

        Woman woman1 = new Woman("Olga", "KLart", 75, null, "Laxw", false, false);
        Woman woman2 = new Woman("Dina", "Lol", 25, null, "Koa", false, false);

        Man man1 = new Man("Andrew", "Base", 45, null, null, false, false);
        Man man2 = new Man("Bill", "Last", 55, null, null, false, false);

        return new Object[][]{
                {woman1, man1, man1}, {woman2, man2, man2}
        };
    }
}


