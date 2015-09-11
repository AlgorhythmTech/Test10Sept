package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.LoginRepository;
import newdemo.app.shared.authentication.Login;
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
import newdemo.app.shared.contacts.CoreContacts;
import newdemo.app.server.repository.CoreContactsRepository;
import newdemo.app.shared.contacts.Gender;
import newdemo.app.server.repository.GenderRepository;
import newdemo.app.shared.location.Language;
import newdemo.app.server.repository.LanguageRepository;
import newdemo.app.shared.contacts.Title;
import newdemo.app.server.repository.TitleRepository;
import newdemo.app.shared.authentication.User;
import newdemo.app.server.repository.UserRepository;
import newdemo.app.shared.authentication.UserAccessDomain;
import newdemo.app.server.repository.UserAccessDomainRepository;
import newdemo.app.shared.authentication.UserAccessLevel;
import newdemo.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(125);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("WLgV8yBYLlgR3pwAZxpyrn4CzpJ7Jap1Y6EQo0HfSOzL7wcnLz");
            corecontacts.setFirstName("DMC2YoReHYavHjPnVmG26GZm83nx5w5wg2Dw4Mj27leXOTvuXh");
            Gender gender = new Gender();
            gender.setGender("ys7VvTZGk0hSutXTROHHC61GIE7IzdEhIuVmjnpaZqulhFRe9o");
            Gender GenderTest = genderRepository.save(gender);
            System.setProperty("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("sf");
            language.setAlpha3("NRG");
            language.setAlpha4("N8cb");
            language.setAlpha4parentid(10);
            language.setLanguage("fecFcRF4yXY9RDtJl7nEpg6u85lHQ0F3x2zmqCP6k3saUKjowf");
            language.setLanguageDescription("0tki8a87ThtdAyeNLmW7D85OjANbUGGNtB9qpLhdbyraBPgifS");
            language.setLanguageIcon("g04dn61zZlfc3rI01lADWXXSpAicaa9CwmY6TLfRjlmsVBK0tj");
            language.setLanguageType("uRJC8nizrjOZb09PFe6NRMv3E7fK4J09");
            Language LanguageTest = languageRepository.save(language);
            System.setProperty("LanguagePrimaryKey", language._getPrimarykey());
            Title title = new Title();
            title.setTitles("PLsaWMB3ld06q519yzI2imzxiyFgonfH9ealfV9To5P0m9Ej5s");
            Title TitleTest = titleRepository.save(title);
            System.setProperty("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(31);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("OsUKjVbJ5DRyvQDGoTn4UZ5S3qhBwVABwvPpOL7G3O2hkEFBcb");
            corecontacts.setFirstName("CeVFKQ9GQK0TSDykzTfEZpJrxluwlF8rhPDoHoXZAzm6dVLxOJ");
            corecontacts.setGenderId(GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("JtaVjIAtYU5Wt9WqyiNydLKKeG56R9oqhOG7tiRRc79CnHlKaz");
            corecontacts.setMiddleName("fX3eaOLlqwfJW49MPFaaHATxswFzWWPNSAVVO82ulYKvW7lu5m");
            corecontacts.setNativeFirstName("xXbIlc2F9ZmGeZ8WbWPcIuSiVYw8t3DmymRihVBbMvItmWUeLa");
            corecontacts.setNativeLanguageCode(LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("RfiTatDdftV1BiZuVmyQDgqWxrxdP7VdIsHUfO1LzJK716nK9V");
            corecontacts.setNativeMiddleName("9IHPdBO3LyXgLdUaqdg9DmGzwlIaCvBwcmwzVuYFH3igK3Jwz7");
            corecontacts.setNativeTitle("XqbaynMZ5oLlDuVoOzLXuOvxWDxlG7v62WKWCquAgwl9GGCI59");
            corecontacts.setPhoneNumber("sDi7KQKNLH2QK6ir1sr0");
            corecontacts.setTitleId(TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("HAeM9Ft7lWM4Qbc0qbBStEJk95pNqDj27wCCBOBrig7fbGkEyh");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1145);
            user.setUserAccessCode(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("aHaZfjJ0SvmLcTdskJzdeHYcVu3kEsL0c5Hvtw64KLx9crIgsX");
            useraccessdomain.setDomainHelp("7CwHeIDWqrUzWTdxG1D9vPOBxgDJa2WmKubu87gYsEg7TINiFT");
            useraccessdomain.setDomainIcon("SZeS3fAC6YVXer4EbrXmG8N3bOd3goqp2cj4B6nvIf3aLMvqOz");
            useraccessdomain.setDomainName("RBP7wI7CDnud9sDUQMYU6XWU2GXJU3SWdx3oPVVU1GzqxVEJax");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            System.setProperty("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("C3pyJ54s57TONsk6AJYVWZcHKrGGVbLCG8jchNRNuhTBASOUD6");
            useraccesslevel.setLevelHelp("uEbW3zHxkg2UlvEo0dXj1WwxSf1vwKwq3Zzl8RWwAlrRBnY1QW");
            useraccesslevel.setLevelIcon("mMw41B0I1e1SBzF4SCc03ysi7KSiMRzsvoQX07VjnbHom3fjbj");
            useraccesslevel.setLevelName("w5zCLxuK1VAnCpltZoginqaG7adtbtC6kZGbXdZ4jc1q52FYrr");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            System.setProperty("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("6ypkN9mLOeB1mZPOkzHm9ZEh7AWJwSDpNxranuO79t4WrclXGY");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3421);
            user.setUserAccessCode(3);
            user.setUserAccessDomainId(UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId(UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(7);
            login.setIsAuthenticated(true);
            login.setLoginId("sVPjYowVXZYcBAgXFDvi9jxguurkJmTzNP6l6irFoZZRQBeDlx");
            login.setServerAuthImage("X9PXmzkKFaF52RBCe4ncFu07STcTP4K9");
            login.setServerAuthText("IZWm4Z7KO6lbrBOD");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            System.setProperty("LoginPrimaryKey", login._getPrimarykey());
            System.setProperty("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            System.setProperty("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("LoginPrimaryKey"));
            Login login = loginRepository.findById(System.getProperty("LoginPrimaryKey"));
            login.setFailedLoginAttempts(7);
            login.setLoginId("jhtSTHcSroduPJ5lWbm8HWeA5xwVSqymeqF7IhQr0Wc76BMyXq");
            login.setServerAuthImage("vwhJY3TFKOoLF8hj2bIEovWpYUlk1XZX");
            login.setServerAuthText("EBfcGZSRHCUSGlrh");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<Login> listofcontactId = loginRepository.findByContactId(System.getProperty("CoreContactsPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("LoginPrimaryKey"));
            loginRepository.findById(System.getProperty("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<Login> listofuserId = loginRepository.findByUserId(System.getProperty("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("LoginPrimaryKey"));
            loginRepository.delete(System.getProperty("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete(System.getProperty("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete(System.getProperty("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
