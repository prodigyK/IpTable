package com.prodigy.ipaddresses.dao;

import com.prodigy.ipaddresses.model.*;
import com.prodigy.ipaddresses.to.IpAddressFilter;
import com.prodigy.ipaddresses.to.IpSearch;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository
public class IpAddressDaoImpl implements IpAddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public IpAddress save(IpAddress ipAddress) {

        if (ipAddress.isNew()) {
            entityManager.persist(ipAddress);
            return ipAddress;
        } else {
            return entityManager.merge(ipAddress);
        }

    }

    @Override
    public boolean delete(int id) {
        return entityManager.createQuery("DELETE FROM IpAddress ip WHERE ip.id=?1")
                .setParameter(1, id)
                .executeUpdate() != 0;
    }

    @Override
    public IpAddress get(int id) {
        return entityManager.find(IpAddress.class, id);
    }

    @Override
    public List<IpAddress> getByFilter(IpAddressFilter ipAddressFilter) {

        Department dep = new Department(ipAddressFilter.getDepartment());
        Subnet subnet = new Subnet(ipAddressFilter.getSubnet());
        DeviceType deviceType = new DeviceType(ipAddressFilter.getDeviceType());

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<IpAddress> criteria = builder.createQuery(IpAddress.class);
        Root<IpAddress> ipRoot = criteria.from(IpAddress.class);
        criteria.select(ipRoot);

        List<Predicate> predicates = new ArrayList<>();
        Predicate pDep = builder.equal(ipRoot.get("department"), dep);
        Predicate pSubnet = builder.equal(ipRoot.get("subnet"), subnet);
        Predicate pType = builder.equal(ipRoot.get("deviceType"), deviceType);

        if (dep.getId() != null) {
            predicates.add(pDep);
        }
        if (subnet.getId() != null) {
            predicates.add(pSubnet);
        }
        if (deviceType.getId() != null) {
            predicates.add(pType);
        }

        criteria.where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(criteria).getResultList();

    }

    @Override
    public IpAddress searchIp(IpSearch ip) {

        // Search by IP Address
        List<IpAddress> list = entityManager.createQuery("SELECT ip FROM IpAddress ip WHERE ip.ipAddress=?1 OR ip.compName=?2 OR ip.userName=?3")
                .setParameter(1, ip.getIp())
                .setParameter(2, ip.getIp())
                .setParameter(3, ip.getIp())
                .getResultList();

        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public List<Department> getAllDepartments() {
        return entityManager.createQuery("SELECT d FROM Department d")
                .getResultList();
    }

    @Override
    public List<DeviceType> getAllDeviceTypes() {
        return entityManager.createQuery("SELECT t FROM DeviceType t")
                .getResultList();
    }

    @Override
    public List<Subnet> getAllSubnets() {
        return entityManager.createQuery("SELECT s FROM Subnet s")
                .getResultList();
    }

    @Override
    public Subnet getSubnet(Integer id) {
        return (Subnet) entityManager.createQuery("SELECT s FROM Subnet s WHERE s.id=?1")
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public User getUserByName(String name) {
        List<User> users = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:username")
                .setParameter("username", name)
                .getResultList();

        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User addUser(User user) {

        if(this.getUserByName(user.getLogin()) == null){
            entityManager.persist(user);
        }

        return user;
    }

    @Override
    public LogChanges saveLogChanges(LogChanges log) {

        entityManager.persist(log);

        return log;
    }

    @Override
    public List<LogChanges> getHistory() {
        return entityManager.createQuery("SELECT h FROM LogChanges h")
                .getResultList();
    }
}
