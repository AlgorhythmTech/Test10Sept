package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.AppCustomerRepository;
import newdemo.app.shared.customers.AppCustomer;
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
import newdemo.app.shared.customers.AppCustomerCategory;
import newdemo.app.server.repository.AppCustomerCategoryRepository;
import newdemo.app.shared.customers.AppCustomerType;
import newdemo.app.server.repository.AppCustomerTypeRepository;
import newdemo.app.shared.contacts.CoreContacts;
import newdemo.app.server.repository.CoreContactsRepository;
import newdemo.app.shared.contacts.Gender;
import newdemo.app.server.repository.GenderRepository;
import newdemo.app.shared.location.Language;
import newdemo.app.server.repository.LanguageRepository;
import newdemo.app.shared.contacts.Title;
import newdemo.app.server.repository.TitleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("vjBVqlXUPSe7jCVg4fzj6afcbN20OdYjfVQy1IceNQ4sNqchIV");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            System.setProperty("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("XKvo7hhObXksQ4sqSg6zN5kVD1DPtVLeWRnHjizVCFMTVKwA9Q");
            appcustomertype.setDefaults(1);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            System.setProperty("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(90);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("qd3jmF2q7qjUhAkjCqUxvWXLzowe0LuwoU2mD0Tu3KaHLTuNtK");
            corecontacts.setFirstName("ruTvHzmyiSyKgD07N6nlctinc2Fc88wXNvFLVI3RhQylRplr1r");
            Gender gender = new Gender();
            gender.setGender("FNPNnrlSlKobh2FkJ6nJYpj8u9NpBBSaRl3uUyvGDJLUlq0Fsu");
            Gender GenderTest = genderRepository.save(gender);
            System.setProperty("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("3D");
            language.setAlpha3("5Qi");
            language.setAlpha4("Aajm");
            language.setAlpha4parentid(3);
            language.setLanguage("LeIKNwMH48bVbZT07f9Q8AsvWXILV5u4hgdpvuSS9MZNd4u6Ei");
            language.setLanguageDescription("sCMUyHRBkymlsZYgQWruzRh2dqy4tw50nEYd9N3ChNycMU7mYZ");
            language.setLanguageIcon("lSe6SO3st5fFd8MkWdmNUrhPDaTJodn6T1HZos1AqJskILoXK3");
            language.setLanguageType("SyUdmGz52Hhyi8k5Ly8ZZvcoUZz2bKhK");
            Language LanguageTest = languageRepository.save(language);
            System.setProperty("LanguagePrimaryKey", language._getPrimarykey());
            Title title = new Title();
            title.setTitles("LX5pWfou5iBTXrMuaOAHmCQZDXUBcCvDXd5aXpp9FHqzu9TJ2v");
            Title TitleTest = titleRepository.save(title);
            System.setProperty("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(91);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("yIDxTdq1pnsWw9QmKMTqXAIdl4mmDUrkupUQwPbNFUAgsUxwH2");
            corecontacts.setFirstName("fi9ybAHG85rYejheVgGlcnbgdXGYUfkqcAB1bh9DbmIDhEhAoI");
            corecontacts.setGenderId(GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("ac0nyx7ZXIJVIXUcaaeDhh22cCTnPfneN69hq2SuUZ1n4o2hqf");
            corecontacts.setMiddleName("FwkKzD3mfjUDw6Q9zH1sonDaUZF8dRKUQ0GwTVdERcWhI28Cjw");
            corecontacts.setNativeFirstName("vV9gt4bgkB7uK9vVs8B7WqdHnSEmVNGuBYzehhgorO6RUv016d");
            corecontacts.setNativeLanguageCode(LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("xG9Q7InpHiSOmUMhj9EZHR360ovDdVwiASurPCLaHpw7wgS9eg");
            corecontacts.setNativeMiddleName("kEDGh3dYvpgCLosLfeshPAo5eRJ4aDnqRlUJzNJeFyDopTevAy");
            corecontacts.setNativeTitle("Fr4TkuljVzO5U3STCaN8ae9Luj57Lja56SIl9JhGB869O4lx1Y");
            corecontacts.setPhoneNumber("H4u7v8dT2yo5QeRPdyje");
            corecontacts.setTitleId(TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            System.setProperty("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory(AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType(AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId(CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("VqpDXrBXcyNId500AaXp4JELD9IafktQpWrnsv5yr4OgKrNoLV");
            appcustomer.setCustomerStatus(1);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            System.setProperty("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById(System.getProperty("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("Pp0TJOsLXhWesJtvhMo5QZ76vzrXqUu7xH3swfngCYlQqfLjvD");
            appcustomer.setCustomerStatus(1);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory(System.getProperty("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
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
            org.junit.Assert.assertNotNull(System.getProperty("AppCustomerPrimaryKey"));
            appcustomerRepository.findById(System.getProperty("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType(System.getProperty("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId(System.getProperty("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(System.getProperty("AppCustomerPrimaryKey"));
            appcustomerRepository.delete(System.getProperty("AppCustomerPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete(System.getProperty("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete(System.getProperty("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete(System.getProperty("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete(System.getProperty("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete(System.getProperty("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete(System.getProperty("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
