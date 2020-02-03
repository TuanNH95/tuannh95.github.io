package nal.test.planning.repository;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;


public interface BaseGeneric<E, K> {

	public K save(E entity);
	
	public void update(E entity);

	public void delete(E entity);

	public E findById(K id);

	public List<E> findByCriterion(Criterion criterion);

	public SQLQuery createNativeSQL(String queryString);
	
	void saveOrUpdate(E instance);
}
