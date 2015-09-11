package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.CoreContactsRepository;
import newdemo.app.shared.contacts.CoreContacts;
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
import newdemo.app.shared.contacts.Gender;
import newdemo.app.server.repository.GenderRepository;
import newdemo.app.shared.location.Language;
import newdemo.app.server.repository.LanguageRepository;
import newdemo.app.shared.contacts.Title;
import newdemo.app.server.repository.TitleRepository;
import newdemo.app.shared.location.Address;
import newdemo.app.server.repository.AddressRepository;
import newdemo.app.shared.location.AddressType;
import newdemo.app.server.repository.AddressTypeRepository;
import newdemo.app.shared.location.City;
import newdemo.app.server.repository.CityRepository;
import newdemo.app.shared.location.Country;
import newdemo.app.server.repository.CountryRepository;
import newdemo.app.shared.location.State;
import newdemo.app.server.repository.StateRepository;
import newdemo.app.shared.contacts.CommunicationData;
import newdemo.app.shared.contacts.CommunicationGroup;
import newdemo.app.server.repository.CommunicationGroupRepository;
import newdemo.app.shared.contacts.CommunicationType;
import newdemo.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("HPGZF6ZjNV7ie9o0U6s9BlgHG8fu6XiFLm8KPLDiB7qnWMaEoi");
            Gender GenderTest = genderRepository.save(gender);
            System.setProperty("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("gr");
            language.setAlpha3("VE6");
            language.setAlpha4("EwQV");
            language.setAlpha4parentid(3);
            language.setLanguage("TIfyRD19aUUnJnHkBFFv30W5FJ1jhyXZqhFQ2qvr3Al9MXMjW0");
            language.setLanguageDescription("u9eO76OKyyIvaV4XzeiLHnbX29Ntn2qd9HOjHvxct7MsJI4kYd");
            language.setLanguageIcon("eVxCpDESeOLyKyOGL7lW9BVMZIdZRypWglDRj3DmqsMhyXFI5h");
            language.setLanguageType("B2BDKaIOEQubGdrNmPMohzR48Mhgl24B");
            Language LanguageTest = languageRepository.save(language);
            System.setProperty("LanguagePrimaryKey", language._getPrimarykey());
            Title title = new Title();
            title.setTitles("a1y6n312zbxuJu641ltfv86VJtTJLV0s9Bg0noyMfjuPEHaDob");
            Title TitleTest = titleRepository.save(title);
            System.setProperty("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(51);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("2kokxsyOvNjKuMMsveJUkhpK8X70JwwFlq6uCq49txzVeqKxGF");
            corecontacts.setFirstName("NbrClOBTO0rRqnJAzCiCwmY1UKe8Rc6mvpu7SJYGaxPg3ZYrMx");
            corecontacts.setGenderId(GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("xWkKllUkukCI6lSOGV0KLiqzuZEZoawxE1AmxZ4dWItn5GAqHL");
            corecontacts.setMiddleName("j2kYJX14rCl9JsV6OEZQrQ6AEZ4gP7zI3MBeGYCj6kYYSA2Lvk");
            corecontacts.setNativeFirstName("ycQIOOjcZ0VvcVyqcW9rpRA3ezh0tFn3mQaeCfsHtZEw6zSpER");
            corecontacts.setNativeLanguageCode(LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("RrT6ZiWQHsAT747GVEbztvIP6bTrlXOZWPxE3UrrdUNPupG7hL");
            corecontacts.setNativeMiddleName("Hxiqb0NRrfbmDGVFCtUPjYSzCJiSnJarJgeVupIt86nL3aq8WO");
            corecontacts.setNativeTitle("CKQkJCPBMA4FwE0b11fzLUFULQ4I8O4J3G68WRBnigSGaOn2B0");
            corecontacts.setPhoneNumber("gI24Pqk3Akionmwjzf9a");
            corecontacts.setTitleId(TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("QoR5Oq1ArqehdYcg9Kek5CsbAxB0ZnEbvIDhtLdQhjis8xV2GS");
            address.setAddress2("p6m81BmXOHVHCpxOVVIz2NKsituinhvFqyiYKGiTk4CWSLkg2D");
            address.setAddress3("rH7T9vDNG31gwtMTmOg4SXZsT5lCOYLOBTF23xZ4xUu64IGVkc");
            address.setAddressLabel("PwDwSCagfU9");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("U6ugROYSQ2yFwZiinDVNhsdaELVIrOwOKMyhwBQIQPGRQNdqU2");
            addresstype.setAddressTypeDesc("xyRa2biwtA4juQSWjSsLY6AQ9dGUwAASdV3gH2TdeaOooMCMtq");
            addresstype.setAddressTypeIcon("intskQNYysMScF4XsF3Fnp5yKNejbBCliMNHIVwh3nmvEtfad8");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            System.setProperty("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("WcG5Y91oCXayw8vBUAqIZKPnu7PY07Pz");
            city.setCityDescription("0ByvsEME91zl7M2pZOoG9IBLycQN2zpHSWxdpLm7sQ7RmRG069");
            city.setCityFlag("mWLiUNM13ZI3WuPozEnNnL3GefWYLpnZ0vbC9RRWhgKChHPzTg");
            city.setCityLatitude(2);
            city.setCityLongitude(3);
            city.setCityName("ZfQ0gX1KOQ1yPsNlfhid658sqewVO6eQQVRKAl2z85xxbedlVM");
            Country country = new Country();
            country.setCapital("S3sgxndaF0PF4aQHXXEalWTdMcjFEFD9");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(11);
            country.setCountryCode1("4Sg");
            country.setCountryCode2("m7w");
            country.setCountryFlag("NQTL3kRargSL5RYydqrJg53ZqpKuJD61sjZzCdFk0NkyBkvQlQ");
            country.setCountryName("YqZC1fkcxWFMgQuMnzbVOV1Rsjx5Mknc8UL5AddHeof3owFLzL");
            country.setCurrencyCode("tQW");
            country.setCurrencyName("QhDT0gCXxrj1uFvmqK7H9RUd7LXp29ZblErFfPX3CViLtnKKOf");
            country.setCurrencySymbol("7eeGUZvCebXrqv0ocZoWT4pLf3kXzZlP");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            System.setProperty("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("VAHVluhz0RVSAXWYXZRngu3op2ByWtoue853DarfL0RUQRLWok");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(5);
            state.setStateCode(2);
            state.setStateCodeChar2("Adi836SWIhzizv46eIcUZ2MPpKFjdja1");
            state.setStateCodeChar3("hMJTwcAkWxbLkovlDm2569TjIRNwVeLa");
            state.setStateDescription("meplGO9TegQ0S8pdVqjFQD8mGCzxd9pvda4G3zozTL3tFwmprV");
            state.setStateFlag("rYNCUSCIfQDVhnYETmtTT7qp3lZgX4IlZxwrULxfxbLdMFr3s6");
            state.setStateName("9jBLHxpPPQE6sQvhH4UuR7vW99keM07V7AsBhl4fTcQSkHDgm3");
            State StateTest = stateRepository.save(state);
            System.setProperty("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("P6Tw6IHpG99dKd7wVMtQyzQCOTVwZRLl");
            city.setCityDescription("yqKyCI249B0MIHIDs2ljzXtEVADBB9l5xLq3mDxG8QPnUjx9Fk");
            city.setCityFlag("5XvNwtFz4BuFOtpp1b3OxG5OoKC60u9McieM9GcCpmirke5gHt");
            city.setCityLatitude(6);
            city.setCityLongitude(11);
            city.setCityName("BBE9JFZ7dD38Hq4bSxgk0vcgO6yqixkfsFBN7ToMZNUNhFFn7J");
            city.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            System.setProperty("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("hwdryvKEIfVneRxCvs2Kycohkjo49dKBFWwrpKcEEMvuFxCAuP");
            address.setAddress2("5lwHRPEPVatPp2esSr8hmadKq4R37qLW5w6liraMcysaF8TwS6");
            address.setAddress3("arSVGS7u4xr4HjmDqlnnQpHTqqoUiQlHOTuHIgw1TZAXtUudRo");
            address.setAddressLabel("omu3CBByndB");
            address.setAddressTypeId(AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId(CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId(CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Ag9ND6I1RynGiBrEcpHvQT7082ppA2oarcQj24zlBh1gDyWsuR");
            address.setLongitude("rQw6h8gqzNTFfLTzRJsygVVCDtN1IXWVipyqMw93qR4Q9CoJis");
            address.setStateId(StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("XAzM4m");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("VGc");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("rI7PMdr8s492626JzQYAnjUdS14EezkcROiBA6fcgNkmR1tam4");
            communicationgroup.setCommGroupName("CmiMhep7KgdCraVqAeEmgPgB93a5orwmMtfHrCP4anjdg7gdQH");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            System.setProperty("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId(CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("dVhtPnY2lVFCNHryM4zMX0Dco28YGHICJ5XbwjflrHv9GGkl9V");
            communicationtype.setCommTypeName("eaEreQrx56ylbzO9GBpsw2fTk46TJIeJEXEMHaKNl5bEeJoJmy");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            System.setProperty("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("sJr");
            communicationdata.setCommGroupId(CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType(CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            System.setProperty("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById(System.getProperty("CoreContactsPrimaryKey"));
            corecontacts.setAge(86);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("pwPKJ50RjUPYP1TRnrDOD5y6KMJ8nKTUFMFYV7y88V3AAfvGif");
            corecontacts.setFirstName("tFNU5mYRPvGvb1RJfvG9ggMqCpqRbHFZJp51EXU0nmLEDqksci");
            corecontacts.setLastName("P5gXGveCJSIaNNOs7JfkY4Z6m1CTaExeSTJa77Hd1QTmdexTCu");
            corecontacts.setMiddleName("RBBJyFPmkhmoIqSnFGIoJu0DSlXBfMcJsWcch0SEuYaHF4zfor");
            corecontacts.setNativeFirstName("k75S2ULpckgbR8QB2NdqArhCUMMRAj63TddsMKOclpA90Lkjec");
            corecontacts.setNativeLastName("2wzxyTlFudBU8uyyvRylzKZHs9jPayMPKB6WFmx6bTF6iZMRmr");
            corecontacts.setNativeMiddleName("yBnAb90cFyEl1Kvieu8DvuZzFhWHtGbjS13kwTkJ71niWRGgMt");
            corecontacts.setNativeTitle("b71bXqLuZsqFdTC6bjZ7YfcqbhSlNGZwvKrYeQX0F6liC2x8DR");
            corecontacts.setPhoneNumber("okP7DTGrQjiDnpYCtEy8");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("CoreContactsPrimaryKey"));
            corecontactsRepository.findById(System.getProperty("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId(System.getProperty("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode(System.getProperty("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId(System.getProperty("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(System.getProperty("CoreContactsPrimaryKey"));
            corecontactsRepository.delete(System.getProperty("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete(System.getProperty("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete(System.getProperty("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete(System.getProperty("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete(System.getProperty("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete(System.getProperty("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete(System.getProperty("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete(System.getProperty("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete(System.getProperty("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete(System.getProperty("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
