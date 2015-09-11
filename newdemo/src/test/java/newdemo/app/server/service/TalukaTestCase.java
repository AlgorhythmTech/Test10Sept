package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.TalukaRepository;
import newdemo.app.shared.location.Taluka;
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
import newdemo.app.shared.location.District;
import newdemo.app.server.repository.DistrictRepository;
import newdemo.app.shared.location.Region;
import newdemo.app.server.repository.RegionRepository;
import newdemo.app.shared.location.State;
import newdemo.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TalukaTestCase {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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
            country.setCapital("0JBjYysbVwhNB1Esv5NsP37rjWBvBqHp");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(9);
            country.setCountryCode1("T2d");
            country.setCountryCode2("Lv9");
            country.setCountryFlag("DDAAbSCzHvmXrfUm5a2gQLOAD3zmQolPwzzDhvCpOb3eAPC1IB");
            country.setCountryName("EqNxGsqNDPJxexvPcC6B2HFSSQd7OpoFSXk44xrtn0zLflomv7");
            country.setCurrencyCode("kTm");
            country.setCurrencyName("VIoQLoEz0b7d0e7EzYamKqKxckzOVngUDkOOIvfdcMEj2aYIsj");
            country.setCurrencySymbol("GjfEzzEcxKAKlV7GheQkpmto7Hf3W7dN");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            System.setProperty("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("D2WGDVyJobI5Op5A7rhiiJlxiTqT32Uh");
            Region region = new Region();
            State state = new State();
            state.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("tyFqEi20l0r0nCn7hZmB4N9oPsMVoKeqHvQ5cbkPtmiffsUvt4");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(0);
            state.setStateCode(1);
            state.setStateCodeChar2("eIjVOCAN7f9IAIFE0yxvV5HrpbreDHQC");
            state.setStateCodeChar3("0JaYqrCzynFrYPEdwj0uytd8gsjFRhtO");
            state.setStateDescription("0uZQnNOHXrvp7O2B9FKbSIFOmj9Lk10xphDrogZLnnBdMrTYnt");
            state.setStateFlag("SQyKnITrRF3R4Uv9LRGSzYgeH1nSDtJXvOGzZxkSxJ3a286SmA");
            state.setStateName("97IL8WqCdiMbRxsPregsLwaKIcDKY64UtRlDRj6mxGJvGKqHO0");
            State StateTest = stateRepository.save(state);
            System.setProperty("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(3);
            region.setRegionCodeChar2("M9xaeCSD3EzwHHLuqsFEi602GUuc4zef");
            region.setRegionDescription("JTiMf1OrHphyMarcGF7wsjQEvSe53z8RGu72hFN1uT4vDg41Hp");
            region.setRegionFlag("pN1OqMrAm6rF76p82CCS88UBw4mLZEnaf3eDv10mpKq6hM6rD0");
            region.setRegionLatitude(2);
            region.setRegionLongitude(9);
            region.setRegionName("pXLoiVIHyLADtlJ58lwznhEOm3pm8MsmD1vwKdlnIYcH5coAdg");
            region.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            System.setProperty("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("EUY7GsgrkacjF3SduKTK0jHQxmqgADHX");
            district.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("90I1FxFtNPaZfFORoHNzSKHJoE8ceuwTF8FYlPy8uB3HuozSTA");
            district.setDistrictFlag("hp3It0viFYL0H3SGiee25vhut4ekWzmNy0m4X0GSbjWI6yyIt1");
            district.setDistrictLatitude(11);
            district.setDistrictLongitude(0);
            district.setName("TfgxoKuY54sfbSfRgxnPdQZQWBQDXEzF3Yu105rKQ3L8vdYTpg");
            district.setRegionId(RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            System.setProperty("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId(DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId(RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId(StateTest._getPrimarykey());
            taluka.setTalukaCode("6Vg36qVCkzHgAP5Lww3uNegnFLQ9lcE5");
            taluka.setTalukaDescription("9lT4mvX5jRalFjVnZycekSDXidm4Nsapombc8DRB8p3DHGwckq");
            taluka.setTalukaFlag("PfVmcoH6lFdrkcGD4fYkO1Q7MEAQLReNKTIEebuJDihQbILkzs");
            taluka.setTalukaLatitude(7);
            taluka.setTalukaLongitude(6);
            taluka.setTalukaName("n2XLkavf4leWI0vu2GORSeQ47tWXQU0VHzlb3y6ojl6qxYyzzW");
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.setEntityValidator(entityValidator);
            taluka.isValid();
            talukaRepository.save(taluka);
            System.setProperty("TalukaPrimaryKey", taluka._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById(System.getProperty("TalukaPrimaryKey"));
            taluka.setTalukaCode("ZM8t1Q2VgAo9HEcrSPhIKouYB5b7VZ9M");
            taluka.setTalukaDescription("UAjZ6OzYKMqYBqY83bnmlQV7xdvv1UjcieAnxapYmLiVix9mnr");
            taluka.setTalukaFlag("Y8qEH6JgUp6KbgT1ZYK3sAJ9F92wmprKuPcQsOAGOMSo9lYfe4");
            taluka.setTalukaLatitude(0);
            taluka.setTalukaLongitude(11);
            taluka.setTalukaName("vAR8g2K1RnwiE76Vc0cEuX6lLjAL6riakVX1ogb03a3uYpxEcR");
            taluka.setVersionId(1);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Taluka> listofcountryId = talukaRepository.findByCountryId(System.getProperty("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Taluka> listofdistrictId = talukaRepository.findByDistrictId(System.getProperty("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Taluka> listofregionId = talukaRepository.findByRegionId(System.getProperty("RegionPrimaryKey"));
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
            java.util.List<Taluka> listofstateId = talukaRepository.findByStateId(System.getProperty("StatePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("TalukaPrimaryKey"));
            talukaRepository.findById(System.getProperty("TalukaPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("TalukaPrimaryKey"));
            talukaRepository.delete(System.getProperty("TalukaPrimaryKey")); /* Deleting refrenced data */
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
