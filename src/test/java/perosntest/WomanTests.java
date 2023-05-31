package perosntest;

import com.rd.person.Man;
import com.rd.person.Person;
import com.rd.person.Woman;
import dataproviders.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WomanTests {
    SoftAssert softAssert = new SoftAssert();
    private Woman woman;
    private Man man;

    @BeforeMethod(alwaysRun = true)
    public void createWoman() {
        woman = new Woman("Kate", "Dase", 25, null, "Btick", false, false);
    }


    @BeforeMethod(alwaysRun = true)
    public void createMan() {
        man = new Man("Klark", "Huge", 35, null, null, false, false);
    }


    @Test(dataProvider = "women", dataProviderClass = TestDataProvider.class)
    public void testisRetired(Woman woman) {

        Assert.assertTrue(woman.isRetired(), "You are not of retirement age");
    }

    @Test(dataProvider = "couple", dataProviderClass = TestDataProvider.class)
    public void testRegisterPartnership(Man man, Woman woman) {

        woman.registerPartnership(man);
        softAssert.assertTrue(woman.isPartnerChanged(), "Partnership was not registered");
        softAssert.assertEquals(woman.getPartner().getFirstName(), man.getFirstName());
        softAssert.assertNotEquals(woman.getLastName(), woman.getPreviousLastName());
    }

    @Test(dataProvider = "couple", dataProviderClass = TestDataProvider.class)
    public void testDeregisterPartnership(Man man, Woman woman) {
        woman.deregisterPartnership(false);
        softAssert.assertFalse(woman.isRegisterPartnership());
        softAssert.assertEquals(woman.getPreviousLastName(), "Mjk");
        softAssert.assertAll();
    }

    @Test(dataProvider = "women", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanLastName(Woman woman) {
        softAssert.assertEquals(woman.getLastName(), "KLart", "Lastname is not correct");
        softAssert.assertEquals(woman.getLastName(), "Lol", "Lastname is not correct");
    }

    @Test(dataProvider = "women", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanFirstName(Woman woman) {
        softAssert.assertEquals(woman.getFirstName(), "Olga", "Firstname is not correct");
        softAssert.assertEquals(woman.getFirstName(), "Dina", "Firstname is not correct");
    }

    @Test(dataProvider = "women", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanAge(Woman woman) {
        Assert.assertEquals(woman.getAge(), 25, "Age is not correct");

    }

    @Test(dataProvider = "women", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanHasNoPartner(Woman woman) {
        woman = new Woman(false);

        Assert.assertEquals(woman.getPartner(), null);
    }

    @Test(dataProvider = "women", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanHasPartner(Woman woman) {
        woman.registerPartnership(man);
        Assert.assertEquals(woman.getPartner().getFirstName(), man.getFirstName());
    }



}
