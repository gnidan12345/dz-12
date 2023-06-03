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

import javax.swing.plaf.metal.MetalBorders;

public class WomanTests {
    SoftAssert softAssert = new SoftAssert();
    private Woman woman;
    private Man man;

    @Test(dataProvider = "womanIsRetireData", dataProviderClass = TestDataProvider.class)
    public void testisRetired(Woman woman, boolean expectedRetiredResult) {

        Assert.assertEquals(woman.isRetired(), expectedRetiredResult, "Wrong retirement result");

    }

    @Test(dataProvider = "registerPartnershipWoman", dataProviderClass = TestDataProvider.class)
    public void testRegisterPartnership(Woman woman, Man man, boolean expectedRegisteredResult) {

        woman.registerPartnership(man);
        Assert.assertEquals(woman.isRegisterPartnership(), expectedRegisteredResult, "Partnership was not registered");

    }

    @Test(dataProvider = "deRegisterPartnershipWoman", dataProviderClass = TestDataProvider.class)
    public void testDeregisterPartnership(Man man, Woman woman, boolean expectedDeRegisteredResult) {
        woman.deregisterPartnership(woman.isRegisterPartnership());
        Assert.assertEquals(woman.isRegisterPartnership(), expectedDeRegisteredResult);

    }

    @Test(dataProvider = "WomanLastName", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanLastName(Woman woman, String expectedLastName) {
        Assert.assertEquals(woman.getLastName(), expectedLastName, "Lastname is not correct");
    }

    @Test(dataProvider = "WomanFirstName", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanFirstName(Woman woman, String expectedFirstName) {
        Assert.assertEquals(woman.getFirstName(), expectedFirstName, "Firstname is not correct");
    }

    @Test(dataProvider = "WomanAge", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanAge(Woman woman, int expectedAge) {
        Assert.assertEquals(woman.getAge(), expectedAge, "Age is not correct");
    }

    @Test(dataProvider = "WomanHasNoPartner", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanHasNoPartner(Woman woman, Person expectedResult) {
        Assert.assertEquals(woman.getPartner(), expectedResult);

    }

    @Test(dataProvider = "WomanHasPartner", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testWomanHasPartner(Woman woman, Man man, Person expectedResult) {
        woman.registerPartnership(man);
        Assert.assertEquals(woman.getPartner(), expectedResult);
    }

}
