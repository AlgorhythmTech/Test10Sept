package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.RegionRepository;
import newdemo.app.shared.location.Region;
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
public class RegionTestCase {

    @Autowired
    private RegionRepository<Region> regionRepository;

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
            country.setCapital("aMeolZBbMKCj5WtMs5r3hfgO3gWsJJNk");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(7);
            country.setCountryCode1("6Uu");
            country.setCountryCode2("3Tc");
            country.setCountryFlag("aYY42tkLTBgSaFzB2q45CPdFD9yUv6VFDlBY3z0RAypK0rqCZY");
            country.setCountryName("62jJhAe6THF894aG7povEZJJ6WUwTdvvVEX7DpavK3WBKlT7Sb");
            country.setCurrencyCode("BYH");
            country.setCurrencyName("sqGuHY7SeIjo7g6TetUbLhCwlIEswJshqbIaVh5m3KiQv7Pld0");
            country.setCurrencySymbol("UpKYtHqOPYkWW2f7iqhVLHNCKMTv7aCN");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            System.setProperty("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("8UUTmcBRz6GQFvS7dkFkCkna8PgN7gt09N1nZ2p2IuanLwC9kE");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(4);
            state.setStateCode(1);
            state.setStateCodeChar2("04f9Tdj7LqvXZKhi0YhdjztUvOH5TYyT");
            state.setStateCodeChar3("hL12iP4iRCVKqRKwDYWeesCOpYLyFiEj");
            state.setStateDescription("bQeD4lvbg5iYk5WZWiSHJjuxq8jHgdoYEwrxq6G2EAnFUWMnRp");
            state.setStateFlag("uShDQVCHggRPyamTBnOsnDfLfBcmr38X5YhmOu7Y1ydXhSriu2");
            state.setStateName("LkvtllQ7GKZzUdG8pmi1TDwxBv7SuOJo7UNUmxyjNs6PbE1UjZ");
            State StateTest = stateRepository.save(state);
            System.setProperty("StatePrimaryKey", state._getPrimarykey());
            Region region = new Region();
            region.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(0);
            region.setRegionCodeChar2("wVMLZnS8UIGhEX4G83zt86bZnXcV8yQo");
            region.setRegionDescription("Sx1EAe4lDNLmdmrut6G4T9BvejQhrgUJVSE5klAPOasNVtRYlU");
            region.setRegionFlag("KLUF9w8BwoWRE2JQaOKaIurslcjuU8nQ7joDE294dtgMwYvPLp");
            region.setRegionLatitude(6);
            region.setRegionLongitude(3);
            region.setRegionName("VDlMY7CK29IkD2jURl9BMLTRCwaQvoKW4gIpcqVGlASIYTtKOP");
            region.setStateId(StateTest._getPrimarykey());
            region.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            region.setEntityValidator(entityValidator);
            region.isValid();
            regionRepository.save(region);
            System.setProperty("RegionPrimaryKey", region._getPrimarykey());
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
            org.junit.Assert.assertNotNull(System.getProperty("RegionPrimaryKey"));
            Region region = regionRepository.findById(System.getProperty("RegionPrimaryKey"));
            region.setRegionCode1(3);
            region.setRegionCodeChar2("QwcBGpdyaMwPkE5oBwWrURQqBSANoBJf");
            region.setRegionDescription("72ohWHKxzdqkxlLc5epM1tD08mkbMkxtSh2y4AHVd7P9up8FbU");
            region.setRegionFlag("u8AXgQ97V1muQOproXWU3348R2hXQLGk3LfxIz1d267QVeQI5H");
            region.setRegionLatitude(6);
            region.setRegionLongitude(10);
            region.setRegionName("ZIYbkxmAagiYf6NpCr9Dhxj2j4dfIojaw3qMZYY8U2nmilcY4A");
            region.setVersionId(1);
            region.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            regionRepository.update(region);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Region> listofcountryId = regionRepository.findByCountryId(System.getProperty("CountryPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("RegionPrimaryKey"));
            regionRepository.findById(System.getProperty("RegionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Region> listofstateId = regionRepository.findByStateId(System.getProperty("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(System.getProperty("RegionPrimaryKey"));
            regionRepository.delete(System.getProperty("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete(System.getProperty("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete(System.getProperty("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
