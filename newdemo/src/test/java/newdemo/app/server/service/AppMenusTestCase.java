package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.AppMenusRepository;
import newdemo.app.shared.authorization.AppMenus;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppMenusTestCase {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("Il39rB6y5xY1I4A6iGl11PNmCvjhAp4eNb9uBE16AvMtrTjQir");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(8);
            appmenus.setMenuAction("lGjcmyTmzvKF0VrL3vgt3EsMqvMN6r4NmCSfWVPWDSpLFo7yO7");
            appmenus.setMenuCommands("QTSc4LBxvxyL9zWhtm6m3knZovYln4Kpy729Xequj2NqbgBedS");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("WfJZdMaI19ac5iQNWqZHfxwupvSWzglHaI6QjUukbcaHjoTexC");
            appmenus.setMenuLabel("V56tlaFQcjugyilgyuqkUPJgTagzeaJzpeVO0daWtJjMvFJ7GQ");
            appmenus.setMenuTreeId("2NCdX49NsY4r3tTJk01ZwvJ5T4GKvp3z0t5y9q8v6andxa9BtN");
            appmenus.setRefObjectId("VVpbmWocppL8thTsO5xqUaCA3urhIl1QRTkLKcGAjDnfzFTIqM");
            appmenus.setUiType("WbP");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.setEntityValidator(entityValidator);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            System.setProperty("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById(System.getProperty("AppMenusPrimaryKey"));
            appmenus.setAppId("uZBxfe64FEDKAlzJPB5A0HX8OPcl5hzPRYXECMFQIr4jMdtV3D");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(2);
            appmenus.setMenuAction("KWXpHOKFWOkQIE5lH9h6hs4tQHHoFETGDBSLnTuLYRX1dFnhih");
            appmenus.setMenuCommands("OZk8zAupE0KueLvGZVAIuX1I9AGi78Cwt4E7FO1z5cK5w3gZlP");
            appmenus.setMenuIcon("9I4bMasyvG2hiU7CXJ7k4tUj7uD09y8B47MNIpgyIVVRXOGCaF");
            appmenus.setMenuLabel("Zttcd5cZL41QwRxnm6SzxCKuTTNnSh7Pp6iJSM3pN7LC3BGcJ3");
            appmenus.setMenuTreeId("KFxueNZgdKbG83kbeN5jy7KtUZ7GlBjrui7n3Z58S9TOEjPwaA");
            appmenus.setRefObjectId("Lcyh4YWIE43GZ2HFwkxtsBUjaLXismVp6WHinnJyQPHwU4fRcf");
            appmenus.setUiType("sfP");
            appmenus.setVersionId(1);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("AppMenusPrimaryKey"));
            appmenusRepository.findById(System.getProperty("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("AppMenusPrimaryKey"));
            appmenusRepository.delete(System.getProperty("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
