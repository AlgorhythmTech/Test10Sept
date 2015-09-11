package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.DistrictRepository;
import newdemo.app.shared.location.District;
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
import newdemo.app.shared.location.Region;
import newdemo.app.server.repository.RegionRepository;
import newdemo.app.shared.location.State;
import newdemo.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DistrictTestCase {

    @Autowired
    private DistrictRepository<District> districtRepository;

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
            country.setCapital("XKnnTH0XfxpXJpzIl5qh5w3HY6rCI0Yl");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(9);
            country.setCountryCode1("zv8");
            country.setCountryCode2("IJm");
            country.setCountryFlag("g9i54PcOjt8KXCv8ttmPV76o0kchCvuCwAyqsIVIxLwffqVd6n");
            country.setCountryName("pypmIC1JKCsQ3TIAZEbgYO3f85LwVEYWQrdkQpIVulE8UIcMet");
            country.setCurrencyCode("Gjd");
            country.setCurrencyName("UoVLp4wRpKxY4wVcADhmrikmK1za5VeIz9fj3w4sS98ZJ2pI7z");
            country.setCurrencySymbol("Nfrd5h0X88iCrn8ezmB5JW96wb4NoG3Z");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            System.setProperty("CountryPrimaryKey", country._getPrimarykey());
            Region region = new Region();
            State state = new State();
            state.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("tJru198vK5ilydnjqxSAHna4wMxamZ7SI3ZxxNxcL2hFi0MLkn");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(3);
            state.setStateCode(1);
            state.setStateCodeChar2("iH9yfw2yt1v6HUbnLq6GFPPUpyQyY4lo");
            state.setStateCodeChar3("7FbBhP7ugfDWJ5a42XnLCAQ4jqwnvQBW");
            state.setStateDescription("1EyJaQdW7zF4gPAyzMReIlUxXunho1ZbbgQoIly2X8WdKWxBDA");
            state.setStateFlag("quV095mlIPHJUrZpbwmMSeOsBSWhTDN67z9CAO8FqR0gwOmLgw");
            state.setStateName("6JAi1F02fuP5ZM36RtZyxdelhAtg5wlr3KBKeWlezQJXslStTz");
            State StateTest = stateRepository.save(state);
            System.setProperty("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(3);
            region.setRegionCodeChar2("epxqtXI1O0ex4HLQXcHMl48CV9xRQG69");
            region.setRegionDescription("SpfmtbM5SQE469KmFRiiSFQNTwgRyv3JgDXNPZHSxeSa0MGVlB");
            region.setRegionFlag("U6S0O4HEVR4OX9NxdAjeyXic6noKjPkVq5kZTA2mn8QWa9dj4q");
            region.setRegionLatitude(0);
            region.setRegionLongitude(1);
            region.setRegionName("h3BohmfnAvMNPSIBxL0xPgE3EalTpvpWRUv8FREV10p14f3tFm");
            region.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            System.setProperty("RegionPrimaryKey", region._getPrimarykey());
            District district = new District();
            district.setCode2("jC7iq8QLA3yu51hWmg2v42sYSRbND3uh");
            district.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("j0riFLDPrA9z5GHzEB6hjIJeQroK6OLhDwKfgAP37eIV6RrxnC");
            district.setDistrictFlag("k7Oe3dm5d9AAi3eucsWiZepjT7Ie4VveHaSOLpxuljRbrQODRK");
            district.setDistrictLatitude(4);
            district.setDistrictLongitude(9);
            district.setName("11gNXcSbsDWIk750sGhcQhrNhwidLwzXAnBSUB8S8NZKHkCNCg");
            district.setRegionId(RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId(StateTest._getPrimarykey());
            district.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            district.setEntityValidator(entityValidator);
            district.isValid();
            districtRepository.save(district);
            System.setProperty("DistrictPrimaryKey", district._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("DistrictPrimaryKey"));
            District district = districtRepository.findById(System.getProperty("DistrictPrimaryKey"));
            district.setCode2("CH55SAgVnzyAMo81h0UCPrExMSlqPfrJ");
            district.setDistrictDescription("gRJpSyflEvY1bMjKguxPDUVRckH5rODQTGnNbeiUVxLlPFwE0q");
            district.setDistrictFlag("R5wwwnLP1cBntmqeTP0nc2A3HbFpaFd0bpysJCjTruk8YLhjNt");
            district.setDistrictLatitude(4);
            district.setDistrictLongitude(9);
            district.setName("UaLsimkl8XRR4gVG6vsAqfi8kCQHG8rqU2pmDAW2ueD1ZIROp7");
            district.setVersionId(1);
            district.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            districtRepository.update(district);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<District> listofcountryId = districtRepository.findByCountryId(System.getProperty("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(System.getProperty("DistrictPrimaryKey"));
            districtRepository.findById(System.getProperty("DistrictPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<District> listofregionId = districtRepository.findByRegionId(System.getProperty("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<District> listofstateId = districtRepository.findByStateId(System.getProperty("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(System.getProperty("DistrictPrimaryKey"));
            districtRepository.delete(System.getProperty("DistrictPrimaryKey")); /* Deleting refrenced data */
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
