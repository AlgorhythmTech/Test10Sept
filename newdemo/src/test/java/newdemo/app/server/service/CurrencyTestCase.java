package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.CurrencyRepository;
import newdemo.app.shared.location.Currency;
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
public class CurrencyTestCase {

    @Autowired
    private CurrencyRepository<Currency> currencyRepository;

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
            country.setCapital("aVzNXGcojNf2BuCYq3FgjvoVe05SBDuG");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(11);
            country.setCountryCode1("45e");
            country.setCountryCode2("6f2");
            country.setCountryFlag("tJZblHn9WfvKcqHWi52q9rpEXjyZvsqZ9Cscyz9rLoSupPZ96X");
            country.setCountryName("8w6ExRLONktCL6yydpjLPlPQurXvwa753UuDzFgsfuANXW71rG");
            country.setCurrencyCode("U33");
            country.setCurrencyName("7cVtefDRH35LPxJUZkR8S9rV0D52h2uDcCBNJRln0vhyUr9fDV");
            country.setCurrencySymbol("fKu1IfzKHHesMbUsskJrRRwC4mp9OIrw");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            System.setProperty("CountryPrimaryKey", country._getPrimarykey());
            Currency currency = new Currency();
            currency.setCountryId(CountryTest._getPrimarykey());
            currency.setCurrencyCode("vTflauhGZ3mXRRemzHCxNLFlT9mrWCevpa74shQpe6AC37GCHK");
            currency.setUnicodeDecimal("BsgqrPu6FmJogqBdDENaBGWKq92qDMkNDH0VDklJGhAOhtJSbm");
            currency.setUnicodeHex("6Zw99mURkm8yENuuMs8jlr14GrUWlsFLgFdF6ZDJ0RETQyQHuG");
            currency.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            currency.setEntityValidator(entityValidator);
            currency.isValid();
            currencyRepository.save(currency);
            System.setProperty("CurrencyPrimaryKey", currency._getPrimarykey());
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
            org.junit.Assert.assertNotNull(System.getProperty("CurrencyPrimaryKey"));
            Currency currency = currencyRepository.findById(System.getProperty("CurrencyPrimaryKey"));
            currency.setCurrencyCode("5cAmM4MKJE9BdCnUT24tMAlYeXdIdVQNVJ6GUiQuLJbAPip0yu");
            currency.setUnicodeDecimal("Zsf196jyBQba6oxOAs2dIbmdEPR38TT8JoOUAlkuCYMOP4wSLC");
            currency.setUnicodeHex("uif2PkbsZKXJNdlxXWwiUXGUoKNfb5zapSEgSnXLf2LcbLflRE");
            currency.setVersionId(1);
            currency.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            currencyRepository.update(currency);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Currency> listofcountryId = currencyRepository.findByCountryId(System.getProperty("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(System.getProperty("CurrencyPrimaryKey"));
            currencyRepository.findById(System.getProperty("CurrencyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("CurrencyPrimaryKey"));
            currencyRepository.delete(System.getProperty("CurrencyPrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete(System.getProperty("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
