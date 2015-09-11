package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.VillageRepository;
import newdemo.app.shared.location.Village;
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
import newdemo.app.shared.location.Taluka;
import newdemo.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            country.setCapital("cmgslODZiDui5cjAwqeL7Fsu9NuimeBr");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(10);
            country.setCountryCode1("Stz");
            country.setCountryCode2("8l4");
            country.setCountryFlag("uaVFROzDhDJTYKJFuAE0VE1XdeWe2kXsyb1whFotKL1AvzZVGg");
            country.setCountryName("45CtewLWgNSG0zkS8kPMpVwjhn1lcPakEyEcET2BZiiUyjDjd4");
            country.setCurrencyCode("E6Z");
            country.setCurrencyName("nMJXs4T9rQDPLRUbAaHJXuv2usdrJRpRvopPjyFKApVcvysZwi");
            country.setCurrencySymbol("t0WP1z7Pko3NwpehlqKxCaI0jBsGzoUN");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            System.setProperty("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("jLFat8Y9B2oWqkXRmW3a1SnzRZPapzzz");
            Region region = new Region();
            State state = new State();
            state.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("oOdnUGXSCs9vOLAtME9ryPwptXw8zkihaVqM3ReBSnka6Ttfxu");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(0);
            state.setStateCode(0);
            state.setStateCodeChar2("Tbx6U4mmfZiG9sERwXZ9YTvd3jwp4ChK");
            state.setStateCodeChar3("XhfLF78f7AfW0Olmu6lYD8mle4Xkw16q");
            state.setStateDescription("Ema3bvTt2tdwhQAPtSb75gdmMwp7ZPn9uQmIeFJEsZrEGKH5sG");
            state.setStateFlag("oEefR9p2hTNtOC4dOcizP7lnb1FkmCmzorEEruwOn8aezyYXiY");
            state.setStateName("NAoV339dGrC1gZVfNk5iH2p24woVWHT4LUvwTJiyZYKVZ3i7C3");
            State StateTest = stateRepository.save(state);
            System.setProperty("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("nebVmhVAZOaeV4jqEwv72WPAj6Di7q6R");
            region.setRegionDescription("FysZpIScl6JOjZEZdd7aGcxRsrMQlSlB3kwq8ZdWVLQKMn4kGv");
            region.setRegionFlag("9al0EFZsgpy4uFInQhUkeXQQqe2FGQn938yWVhaiVtivwYtmX9");
            region.setRegionLatitude(4);
            region.setRegionLongitude(7);
            region.setRegionName("z9L9TAohR2KT3FnnJjL5452enZI4DJXZgcz84htuDKA3zQKLmH");
            region.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            System.setProperty("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("H02mQRhabpkH9xfLznQL8NyfTN4tcFx2");
            district.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("yhKq0aQUMZlNFMZK2rTFtfbiInfLcZH5aGiQ2ZB9yBv5f0Viee");
            district.setDistrictFlag("QjRZzjiZLtGj6hzqabQfPHDquuwc3ADigAGSdQi2SWjAvsT6X6");
            district.setDistrictLatitude(3);
            district.setDistrictLongitude(4);
            district.setName("DaAquT0CKO45pVHCjoA21ytz47qVuI6ED6qpK0546NrrBokwBo");
            district.setRegionId(RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            System.setProperty("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId(DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId(RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("jaZHuXdCNCZ4o0dLgN2qUg5FTSI1YIXx");
            taluka.setTalukaDescription("40pjqAtPASvkogjarjjghGKLJDsH9SJbVzqauBjzW7oF4N4QDO");
            taluka.setTalukaFlag("iz0Q7DQj1PVMItUNB2w6o76cVXLjQTlROLlmwILAAHfX5TcrVj");
            taluka.setTalukaLatitude(9);
            taluka.setTalukaLongitude(10);
            taluka.setTalukaName("u4YPhuBk4aYm5ttoQD9HWtdSBpkbueVRP7A2RypLqN0mjSky9t");
            Taluka TalukaTest = talukaRepository.save(taluka);
            System.setProperty("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId(DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId(RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId(TalukaTest._getPrimarykey());
            village.setVillageCode("1Xm1F2MTfocX0eGNuOQ4Gy4kwaUThgS5");
            village.setVillageDescription("6iQLAoUCkM4nrZbB6rknOzJGCxrVZunD1Z4h3xVdCWxQ3uyrFY");
            village.setVillageFlag("2l3klxQoWic8ZHPl7odUQ4Mfs3H3IvNrBvejc1EDoBoru0y5vg");
            village.setVillageLatitude(0);
            village.setVillageLongtitude(3);
            village.setVillageName("TjpRA25ZvCjQlvkm19dYqv63QyuN9kXGCgNb6Vi8fbAwVAW68i");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            System.setProperty("VillagePrimaryKey", village._getPrimarykey());
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

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("VillagePrimaryKey"));
            Village village = villageRepository.findById(System.getProperty("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("GAGbcQrjQafo7plitgz12iQzvrHYjVIa");
            village.setVillageDescription("BkMMk7WxeNQqCPTcWCuo6eUEm7r4PfpjRFGDtJ2m8OsoHIpTnl");
            village.setVillageFlag("pcr8ccO8riWGODwJYauzWUMxPuMECghn1KD071ITJr5Uv9QB5s");
            village.setVillageLatitude(5);
            village.setVillageLongtitude(0);
            village.setVillageName("3AD1Ic1w0rBbwijrkKVMebN3xjuV2UNCP49asHRY7r3pQ6DTDK");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId(System.getProperty("CountryPrimaryKey"));
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
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId(System.getProperty("DistrictPrimaryKey"));
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
            java.util.List<Village> listofregionId = villageRepository.findByRegionId(System.getProperty("RegionPrimaryKey"));
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId(System.getProperty("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId(System.getProperty("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(System.getProperty("VillagePrimaryKey"));
            villageRepository.findById(System.getProperty("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("VillagePrimaryKey"));
            villageRepository.delete(System.getProperty("VillagePrimaryKey")); /* Deleting refrenced data */
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
