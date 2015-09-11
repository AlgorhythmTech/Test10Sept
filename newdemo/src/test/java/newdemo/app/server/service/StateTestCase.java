package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.StateRepository;
import newdemo.app.shared.location.State;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase {

    @Autowired
    private StateRepository<State> stateRepository;

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
            country.setCapital("LmUqILvecpRA8WqKXn04LeRQn2DbOq21");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(1);
            country.setCountryCode1("Hew");
            country.setCountryCode2("FbJ");
            country.setCountryFlag("FXu5Smre3YScouUhNPf7pta3pObxF0nWfpgRLiGlXHiYbUKggq");
            country.setCountryName("nvIYBeavE5RZ6AIJl1e38WmoqjgDg28XRLZGCUCjGq1eRgssIA");
            country.setCurrencyCode("OlQ");
            country.setCurrencyName("ncQN2EW2E6FPKDCitv491jOw6y4jtnLKyLANykLsMOHZqTlTDN");
            country.setCurrencySymbol("urfsCFa4kAAaH2tHM4xDRjAFla60Rtc0");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            System.setProperty("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId(CountryTest._getPrimarykey());
            state.setStateCapital("74JUW73KsawRncehv5AM417FzI83ubgUbUuxQBtrYOWs9z6JUf");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(6);
            state.setStateCode(1);
            state.setStateCodeChar2("AqGr9BCIdATTGHjAsUET3NEHcEQF9lNI");
            state.setStateCodeChar3("lQ3ktCA7WhWrzRliSJfPtn0pLJo8pnFi");
            state.setStateDescription("somilSkXRfRqJKInVYFekJBiO1Jm7okzcrV5HPFrt8eL6gfObY");
            state.setStateFlag("JCtftpwV9hZch18Hm5uPohpRxCadUPSItSLbDdgSGrgdIM8p7J");
            state.setStateName("y0eDIg2Pv1Szd8bZMpySe0h8yd6FdjqHXgNzd2FuUfj4cUIbMn");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.setEntityValidator(entityValidator);
            state.isValid();
            stateRepository.save(state);
            System.setProperty("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("StatePrimaryKey"));
            State state = stateRepository.findById(System.getProperty("StatePrimaryKey"));
            state.setStateCapital("7WAXNv5YgvkmAB1t0XMPhwArhuNBf4oA5SZI61Dx68hn0Vl28N");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(4);
            state.setStateCode(0);
            state.setStateCodeChar2("fgOql4upuJQSECQN8nNbmgVOXJCLVQjS");
            state.setStateCodeChar3("xooAUaaRPsmiYiXxgwdUVAwhWHpVtJOj");
            state.setStateDescription("m8hVEOgkiHT8V0XtKMmnViSPzQWuQmpRYNrZ8IiTzMo8xCZ8Ct");
            state.setStateFlag("PWwSoillv8ymrqvMXuynd1oyT0qlreraPagd6xH3JXb9syA0p3");
            state.setStateName("giyvfZDCkJMBDxExTGteE1MaZaoHm8J4k7o5SOP80hK8XaI1B1");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId(System.getProperty("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(System.getProperty("StatePrimaryKey"));
            stateRepository.findById(System.getProperty("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("StatePrimaryKey"));
            stateRepository.delete(System.getProperty("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete(System.getProperty("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
