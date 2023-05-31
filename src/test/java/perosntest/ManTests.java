package perosntest;

import com.rd.person.Man;
import com.rd.person.Person;
import com.rd.person.Woman;
import dataproviders.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManTests {
    SoftAssert softAssert = new SoftAssert();
    private Man man;
    private Woman woman;

    @BeforeMethod(alwaysRun = true)
    public void createMan() {
        man = new Man("Klark", "Huge", 66, null, null, false, false);

    }

    @BeforeMethod(alwaysRun = true)
    public void createWoman() {

        woman = new Woman("Kate", "Dase", 42);
    }


    @Test(dataProvider = "men", dataProviderClass = TestDataProvider.class)
    public void testisRetired(Man man) {

        Assert.assertTrue(man.isRetired(), "You are not of retirement age");
    }

    @Test(dataProvider = "couple", dataProviderClass = TestDataProvider.class)
    public void testRegisterPartnership(Man man, Woman woman) {
        man.registerPartnership(woman);
        softAssert.assertTrue(man.isPartnerChanged(), "Partnership was not registered");
        softAssert.assertEquals(man.getPartner().getFirstName(), woman.getFirstName());
        softAssert.assertAll();
    }

    @Test(dataProvider = "couple", dataProviderClass = TestDataProvider.class)
    public void testDeregisterPartnership(Man man, Woman woman) {
        man.deregisterPartnership(true);
        Assert.assertFalse(man.isRegisterPartnership());
    }

    @Test(dataProvider = "men", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManLastName(Man man) {

        softAssert.assertEquals(man.getLastName(), "Perry", "Lastname is not correct");
        softAssert.assertEquals(man.getLastName(), "Volt", "Lastname is not correct");
    }

    @Test(dataProvider = "men", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManFirstName(Man man) {

        softAssert.assertEquals(man.getFirstName(), "Luke", "Firstname is not correct");
        softAssert.assertEquals(man.getFirstName(), "Jerry", "Firstname is not correct");
    }

    @Test(dataProvider = "men", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManAge(Man man) {
        softAssert.assertEquals(man.getAge(), 35, "Age is not correct");
        softAssert.assertEquals(man.getAge(), 75, "Age is not correct");
    }

    @Test(dataProvider = "men", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManHasNoPartner(Man man) {
        man = new Man(false);
        Assert.assertEquals(man.getPartner(), null);
    }

    @Test(dataProvider = "couple", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManHasPartner(Man man, Woman woman) {
        man.registerPartnership(woman);
        Assert.assertEquals(man.getPartner().getFirstName(), woman.getFirstName());
    }

    @Test(dataProvider = "couple", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void isRegisterPartnership(Man man, Woman woman) {
        man.registerPartnership(woman);
        Assert.assertTrue(man.isRegisterPartnership(), "You are not married");
    }


}

