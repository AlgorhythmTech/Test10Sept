package newdemo.app.server.repository;
import com.athena.server.repository.SearchInterfaceImpl;
import newdemo.app.shared.contacts.CommunicationType;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

@Repository
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Repository for CommunicationType Master table Entity", complexity = Complexity.LOW)
public class CommunicationTypeRepositoryImpl extends SearchInterfaceImpl implements CommunicationTypeRepository<CommunicationType> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<CommunicationType> findAll() throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<newdemo.app.shared.contacts.CommunicationType> query = emanager.createQuery("select u from CommunicationType u where u.systemInfo.activeStatus=1").getResultList();
            return query;
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in retrieving entity", e);
        }
    }

    @Override
    @Transactional
    public CommunicationType save(CommunicationType entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.persist(entity);
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public List<CommunicationType> save(List<CommunicationType> entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                newdemo.app.shared.contacts.CommunicationType obj = entity.get(i);
                emanager.persist(obj);
            }
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity Saving", e);
        }
    }

    @Transactional
    @Override
    public void delete(String id) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            newdemo.app.shared.contacts.CommunicationType s = emanager.find(newdemo.app.shared.contacts.CommunicationType.class, id);
            emanager.remove(s);
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void update(CommunicationType entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.merge(entity);
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public void update(List<CommunicationType> entity) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                newdemo.app.shared.contacts.CommunicationType obj = entity.get(i);
                emanager.merge(obj);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity updation", e);
        }
    }

    @Transactional
    public List<Object> search(String finderName, Map<String, Object> fields, Map<String, String> fieldMetaData) throws Exception {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery(finderName);
            java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
            Map<String, String> metaData = new java.util.HashMap<String, String>();
            metaData = fieldMetaData;
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");
            String inputStr = "01-01-1850";
            java.util.Date date = formatter.parse(inputStr);
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            for (Map.Entry<String, String> entry : metaData.entrySet()) {
                boolean matched = false;
                for (Map.Entry<String, Object> entry1 : fields.entrySet()) {
                    if (entry.getKey() == entry1.getKey()) {
                        if (entry.getValue().equalsIgnoreCase("integer") || entry.getValue().equalsIgnoreCase("double") || entry.getValue().equalsIgnoreCase("long")) {
                            map.put("min" + entry1.getKey(), entry1.getValue());
                            map.put("max" + entry1.getKey(), entry1.getValue());
                        } else if (entry.getValue().equalsIgnoreCase("String")) {
                            map.put(entry1.getKey(), "%" + entry1.getValue() + "%");
                        } else {
                            map.put(entry1.getKey(), entry1.getValue());
                        }
                        matched = true;
                        break;
                    }
                }
                if (!matched) {
                    if (entry.getValue().equalsIgnoreCase("String")) {
                        map.put(entry.getKey(), "%");
                    } else if (entry.getValue().equalsIgnoreCase("integer")) {
                        map.put("min" + entry.getKey(), Integer.MIN_VALUE);
                        map.put("max" + entry.getKey(), Integer.MAX_VALUE);
                    } else if (entry.getValue().equalsIgnoreCase("double")) {
                        map.put("min" + entry.getKey(), java.lang.Double.MIN_VALUE);
                        map.put("max" + entry.getKey(), java.lang.Double.MAX_VALUE);
                    } else if (entry.getValue().equalsIgnoreCase("long")) {
                        map.put("min" + entry.getKey(), java.lang.Long.MIN_VALUE);
                        map.put("max" + entry.getKey(), java.lang.Long.MAX_VALUE);
                    } else if (entry.getValue().equalsIgnoreCase("Date") || entry.getValue().equalsIgnoreCase("DATETIME")) {
                        map.put(entry.getKey(), date);
                    } else if (entry.getValue().equalsIgnoreCase("TINYINT")) {
                        map.put(entry.getKey(), 1);
                    } else if (entry.getValue().equalsIgnoreCase("timestamp")) {
                        map.put(entry.getKey(), timestamp);
                    } else if (entry.getValue().equalsIgnoreCase("integer_userAccesCode")) {
                        map.put(entry.getKey(), runtimeLogInfoHelper.getUserAccessCode());
                    }
                }
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            java.util.List<Object> list = query.getResultList();
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public List<CommunicationType> findByCommGroupId(String commGroupId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CommunicationType.findByCommGroupId");
            query.setParameter("commGroupId", commGroupId);
            java.util.List<newdemo.app.shared.contacts.CommunicationType> listOfCommunicationType = query.getResultList();
            return listOfCommunicationType;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public CommunicationType findById(String commType) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CommunicationType.findById");
            query.setParameter("commType", commType);
            newdemo.app.shared.contacts.CommunicationType listOfCommunicationType = (newdemo.app.shared.contacts.CommunicationType) query.getSingleResult();
            return listOfCommunicationType;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }
}
