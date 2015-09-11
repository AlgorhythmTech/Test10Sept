package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.AddressRepository;
import newdemo.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import newdemo.app.shared.location.AddressType;
import newdemo.app.server.repository.AddressTypeRepository;
import newdemo.app.shared.location.City;
import newdemo.app.server.repository.CityRepository;
import newdemo.app.shared.location.Country;
import newdemo.app.server.repository.CountryRepository;
import newdemo.app.shared.location.State;
import newdemo.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("vE99yG7b65g3GfrHD1o4TE2BaD56wLatFidZntaJ8lhsJjbTFv");
            addresstype.setAddressTypeDesc("tyflM6xtS1YjGuxoUFysjbq0MXiOEbWVjO3MWWA6ErhTZEivkB");
            addresstype.setAddressTypeIcon("qPUXEeEgLwnB5LlGOC4Fl9QnHUVrY2YCtkBXHWg8eN9if2yDVg");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            System.setProperty("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("f8SzVQRmZySz5aY4NFgXcJc4G9nQGkc1");
            city.setCityDescription("NlheW7Nzlb32xqlrc4r3S47Ij2Qe7NMuEDBwzrV45oQGfcNmqS");
            city.setCityFlag("MTjVnMdum3Acck5s3XXpxpXdmIudZX4wzrFLKXRsSjxEuy29Lo");
            city.setCityLatitude(2);
            city.setCityLongitude(2);
            city.setCityName("DIHbdYUfaP1qGBbtOgaVXypvgx4592FWTKJfQhqVgKvOU3jj8f");
            Country country = new Country();
            country.setCapital("k9011UT5bMGEg5rKHOh62DkJCQxeHZvf");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(5);
            country.setCountryCode1("2yN");
            country.setCountryCode2("VBp");
            country.setCountryFlag("bJdMzMPkimlhglswIM7Si4kY4U48Zl037tiUnEcVPdfoVpZHLh");
            country.setCountryName("JMG9wf6nkEXGgkIcnk8A02vf0EyMt0C0MXH5lXnuzQiSTtHew4");
            country.setCurrencyCode("9gZ");
            country.setCurrencyName("Kh2qUHMjOnLHySN7Q8gcBhouEhJG5MRNVpEoH0cRdz8tyPof0r");
            country.setCurrencySymbol("eR3W1oOUAOTri5tGNBoC9tsjbCqbsChA");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            System.setProperty("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("wbh8ZwjxqHN6jQMW3dopnU2IF3fijDb3bb3HiIy2RjWzJEIb7P");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(3);
            state.setStateCode(0);
            state.setStateCodeChar2("mzI4NNG05ySc19QFilUxTTtx5Y4RjMoM");
            state.setStateCodeChar3("tYhpe6vYH235oMRGT4oecgfyaBEfpmZC");
            state.setStateDescription("2ayjg4XC3qe0zlsxBKmzLDEELBGi6FMglIDNF8sDcqUlPFaPVe");
            state.setStateFlag("pIAlDsryOnUHF75eyKxH11vWujkX8yKuI5BECK9gPOFGMbIZ7Z");
            state.setStateName("0EMSoyMhKyGvtgsIa7BFcJhBv7illipg8JLc8sYhFW6rRo4sFj");
            State StateTest = stateRepository.save(state);
            System.setProperty("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("c2fatF9f4XXFzSzuNwzc3E5dy6jYXDO3");
            city.setCityDescription("mk2KGdf3wTscCzwiW7iZEB3F1IXItJ3bo18QPA9VnXS3hZOLSh");
            city.setCityFlag("dgYJhlu88reQy0uSXFSTAkxvNIYArF5nkXAwCoktFx6E57oFDK");
            city.setCityLatitude(4);
            city.setCityLongitude(3);
            city.setCityName("28IgCAGbpOB5qyXaYalYVhcAdGLXewo3csEw8tJeRuQtvVDqbj");
            city.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            System.setProperty("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("TBsf457NCKEXHtWpnR3RrV03URZ8GKrGQCUI3x6lcVR8ljYLEb");
            address.setAddress2("TvwS1sF8nKd9a5UdHCthWWYJacxotfK2uwjN0XJUpAE2HvbaRU");
            address.setAddress3("hdcvWDQQOa378XDXBEd1K8TxNbgABy0HYXWAvqzGsrViC7sByd");
            address.setAddressLabel("yYFIVubBcnI");
            address.setAddressTypeId(AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId(CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("nG5HaP0L48as96DtWKDa3ffwjql6BNaxrsCVjEYMD3ACo8Vrnc");
            address.setLongitude("7jVBAcMNQTp2py2q51wqeEMJsYJw0IQW9XKH7q4TVb6DMEmEj3");
            address.setStateId(StateTest._getPrimarykey());
            address.setZipcode("yAsaz2");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            System.setProperty("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("AddressPrimaryKey"));
            Address address = addressRepository.findById(System.getProperty("AddressPrimaryKey"));
            address.setAddress1("T1UGkTEzMylESutC8kFENeFehVwYLqwacjLOKT417hP8GRpDqs");
            address.setAddress2("5qopY7a5I88rheGGFcyCF2lXS3wXxDRTuLaazNGmsttg3Bwnap");
            address.setAddress3("DdbWHsyak6K6YN8XpghekuQh9n3q30Su1pgg8h4tMOM11D7sqV");
            address.setAddressLabel("1eVZhohd6wA");
            address.setLatitude("445NxuX1YMPuBl9rzKtoKhSajsXV5a54oKCP4K2xppsTWzY1HI");
            address.setLongitude("U5AUXZevC5ydJsIihzGZVxNNEUx6VeXntaWWIgrGLtx5tCsbgx");
            address.setVersionId(1);
            address.setZipcode("4iBSEU");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("AddressPrimaryKey"));
            addressRepository.findById(System.getProperty("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId(System.getProperty("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId(System.getProperty("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId(System.getProperty("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId(System.getProperty("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("AddressPrimaryKey"));
            addressRepository.delete(System.getProperty("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete(System.getProperty("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete(System.getProperty("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete(System.getProperty("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete(System.getProperty("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
