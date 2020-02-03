package nal.test.planning.repository;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseRepository<E, K extends Serializable>{
    private Class<E> persistentClass;

    @Autowired
    private EntityManager sessionFactory;

    public Session getSessionFactory() {
        return sessionFactory.unwrap(Session.class);
    }

    public void setSessionFactory(EntityManager sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public BaseRepository() {
        this.persistentClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public K save(E instance) {
        try {
            K id = (K) getSessionFactory().save(instance);
            return id;
        } catch (RuntimeException re) {
            re.printStackTrace();
            //throw new AppException(Messages.EC_00008, re);
            throw re;
        }
    }

    public void update(E instance) {
        try {
            getSessionFactory().update(instance);
        } catch (RuntimeException re) {
            re.printStackTrace();
            throw re;
        }
    }

    public void delete(E instance) {

        try {
            getSessionFactory().delete(instance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public E findById(K id) {
        try {
            E instance = (E) getSessionFactory().get(persistentClass.getName(), id);
            if (instance == null) {
            } else {

            }
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<E> findByCriterion(Criterion criterion) {
        
        try {
            List results = getSessionFactory().createCriteria(persistentClass.getName()).add(criterion)
                    .list();
            return results;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<E> findByCriteria(Criterion... criterion) {
        Criteria crit = getSessionFactory().createCriteria(persistentClass.getName());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    public SQLQuery createNativeSQL(String queryString) {
        try {
            SQLQuery sqlQuery = getSessionFactory().createSQLQuery(queryString);
            return sqlQuery;
        } catch (RuntimeException re) {
            re.printStackTrace();
            throw re;
        }
    }

    public void saveOrUpdate(E instance) {
        try {
            getSessionFactory().saveOrUpdate(instance);
        } catch (RuntimeException re) {
            re.printStackTrace();
            throw re;
        }
    }

    public K saveAndCommit(E instance) {
        try {
            K id = (K) getSessionFactory().save(instance);
            getSessionFactory().flush();
            return id;
        } catch (RuntimeException re) {
            re.printStackTrace();
            throw re;
        }
    }
   
}
