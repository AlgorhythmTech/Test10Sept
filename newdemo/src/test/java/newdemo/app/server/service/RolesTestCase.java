package newdemo.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import newdemo.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import newdemo.app.server.repository.RolesRepository;
import newdemo.app.shared.authorization.Roles;
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
import newdemo.app.shared.authorization.RoleMenuBridge;
import newdemo.app.shared.authorization.AppMenus;
import newdemo.app.server.repository.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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
            Roles roles = new Roles();
            roles.setRoleDescription("qQaKlaHITYhbhZBWl1oZzXL7b5z3Jfk3ZAffHZzrzBovX2CJAC");
            roles.setRoleHelp("UIIdzlJYj6zJPLgdCwRJCu5NhoYno7BoHG0rgHHHBjLUF1T3B5");
            roles.setRoleIcon("ypneHCFBbgC3T7JQpuJ5pElyY12FAuTJZPOyRQam0g2t1Rkg6V");
            roles.setRoleName("w9uDDN49asVxV6UaxYcZT1tFVD6X52ssrvkOv1w7gvNiKr0XIG");
            java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
            RoleMenuBridge rolemenubridge = new RoleMenuBridge();
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("WfCkLWRBsRsHTTXcN7dF362mwKxHOz3zQyml5jjgB862CvpcgO");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(7);
            appmenus.setMenuAction("CCNQoByx6mIaXt60dmCisx5q0WO6Nf3sYw10ovQ22FzWkhsMpO");
            appmenus.setMenuCommands("tK1i0qZl5OYWsrk5WK0D8duCvsQq2PR203tgEyLPaGkUO2TMib");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("QvEdJ71BTPoNfpxfGlthDzksq9TlMXuHwD7V8viU3rh133fyTP");
            appmenus.setMenuLabel("c2DoJvS1jNkLnb1RbTdB30PrtbWC5UKldjJFinzgg0PhPBV4O2");
            appmenus.setMenuTreeId("50vszUjkL9QM53MObiEjQPAJmr50O5bnMoandtjGAq1IqYc5q9");
            appmenus.setRefObjectId("PJXfixsECWROym8trjxFx4hU6Qx2Dg2oq04u7mwU3O3Zpz9btE");
            appmenus.setUiType("fui");
            AppMenus AppMenusTest = appmenusRepository.save(appmenus);
            System.setProperty("AppMenusPrimaryKey", appmenus._getPrimarykey());
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            rolemenubridge.setMenuId(AppMenusTest._getPrimarykey());
            rolemenubridge.setRoles(roles);
            listOfRoleMenuBridge.add(rolemenubridge);
            roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.setEntityValidator(entityValidator);
            roles.isValid();
            rolesRepository.save(roles);
            System.setProperty("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById(System.getProperty("RolesPrimaryKey"));
            roles.setRoleDescription("4Yy2TtZ7Zu8IBk6PdlukDkquexeUFAHi20uSmI0HScQ5vKyYJX");
            roles.setRoleHelp("qewF8oJlmu48VfSQx4YCkfDQduL2XckdHK8maFttacKPB9W8Rv");
            roles.setRoleIcon("3R7DwNSywjfvUse44u6Hf8oAbhX1uYiwqXvuE9xMFkiQHXhVbH");
            roles.setRoleName("7vvrr0Mkv1mjfRKX5cEnqtXvGCHvhAyAnvosSSVIz9elb10H3V");
            roles.setVersionId(1);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("RolesPrimaryKey"));
            rolesRepository.findById(System.getProperty("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(System.getProperty("RolesPrimaryKey"));
            rolesRepository.delete(System.getProperty("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete(System.getProperty("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
