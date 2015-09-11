package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.CityRepository;
import newdemo.app.shared.location.City;
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
import newdemo.app.shared.location.Country;
import newdemo.app.server.repository.CountryRepository;
import newdemo.app.shared.location.State;
import newdemo.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase {

    @Autowired
    private CityRepository<City> cityRepository;

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
            Country country = new Country();
            country.setCapital("H7su6mnTGJWa15TzAQ83SdFMsmlHmVSU");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(3);
            country.setCountryCode1("0PH");
            country.setCountryCode2("cpW");
            country.setCountryFlag("sGYI16FuFqJB9FCEK85QvNbmXBjlMNINqhoCTx8vW6wtBcrbmJ");
            country.setCountryName("g3XhAz0IUgY4ohIpuYdHCufBrGqjlG0jdYS1Vkysild4IOoaxt");
            country.setCurrencyCode("VoD");
            country.setCurrencyName("X8SuPI9exRyBfNCUSgX97dwSiDCXWvmAboBuwfSxq02FdZD3yU");
            country.setCurrencySymbol("ZJloX1NMIUauD07y1CA9gKr9CrmaivIL");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            System.setProperty("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("XzNIG4lZX0EYI2Z2TlEsyt2LRobPJTFgGKzgBYi8zFV34BeF11");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(1);
            state.setStateCode(0);
            state.setStateCodeChar2("r8yDfv6lTm0pS8Z2IcNvFwFh9lE4A1Av");
            state.setStateCodeChar3("fMmSdLFGdlAjVYQ6UwMxdD4F18Lma0C2");
            state.setStateDescription("kgCKg162GUMXxcdl34eewgikZf5OoRZqd6cuvI5iRGyHkB5o6q");
            state.setStateFlag("PLNa5yy5mBRTTq7JeGiGGSPnyZexX6Vb63OBCw4s949Gg7oBqA");
            state.setStateName("PW9rhldmjizpTqMVe6g0GjO2uyeduYrbLntKUS5xFSKO5xt7RG");
            State StateTest = stateRepository.save(state);
            System.setProperty("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("zFvxdKt6rPp4qDycr0zkutqtcU6gD83J");
            city.setCityDescription("gihELXM9vi2piPqZSXNu0MtkeiqjVvD9TbGTrJoM8CUmY2DkCC");
            city.setCityFlag("DLhvdYlxF3Mnq4tmAEbWKGJ9vjxO9yyrpM2dFzoH87uEj6CWdX");
            city.setCityLatitude(10);
            city.setCityLongitude(6);
            city.setCityName("kSfSWua3wla6yMdfW3KjrfhaINUKu436k6N59i3CeyANmly6WL");
            city.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId(StateTest._getPrimarykey());
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
            city.isValid();
            cityRepository.save(city);
            System.setProperty("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("CityPrimaryKey"));
            City city = cityRepository.findById(System.getProperty("CityPrimaryKey"));
            city.setCityCode(1);
            city.setCityCodeChar2("lv46H4y74to8A3Mf0Gtu42GV3XSgYIMW");
            city.setCityDescription("rwfKhVxkPOXTmwuxJlR1TrkcolWPJR5txj5PA5ds8VO9QmZJTL");
            city.setCityFlag("S3zGdV9BVdckamWR96s2YPh2BwNEITq2dLYOtvNfCgeVVIBTgS");
            city.setCityLatitude(3);
            city.setCityLongitude(10);
            city.setCityName("bhkRQJf351kdnRmHwbC95Ao3l4mn4YvDH09M7usqa4XjIGKNCr");
            city.setVersionId(1);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("CityPrimaryKey"));
            cityRepository.findById(System.getProperty("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId(System.getProperty("CountryPrimaryKey"));
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
            java.util.List<City> listofstateId = cityRepository.findByStateId(System.getProperty("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(System.getProperty("CityPrimaryKey"));
            cityRepository.delete(System.getProperty("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete(System.getProperty("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete(System.getProperty("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
