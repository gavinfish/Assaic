package com.cineplex.dao;

import java.io.Serializable;

/**
 * interface of base Dao
 * @author Andy 1993sj19993@gmail.com
 * @date 2015年2月1日 下午8:56:40
 * 
 * @param <T>
 *            entity type
 */

public interface BaseDao<T> {

	/**
	 * save an entity
	 * @param entity: entity needs to be saved
	 * @return Serializable:
	 * @throws
	 */
	public Serializable save(T entity);

	/**
	 * delete an entity
	 * @param entity: entity needs to be deleted
	 * @return void:
	 * @throws
	 */
	public void delete(T entity);

	/**
	 * update an entity
	 * @param entity: entity needs to be updated
	 * @return void:
	 * @throws
	 */
	public void update(T entity);

	/**
	 * if the entity exists, update it, or save it(used when
	 *               are not sure whether the entity exists)
	 * @param entity: entity needs to be saved or updated
	 * @return void:
	 * @throws
	 */
	public void saveOrUpdate(T entity);

	/**
	 * get entity by primary key
	 * @param c
	 * @param id: primary key
	 * @return T: result
	 * @throws
	 */
	public T get(Class<T> c, Serializable id);

}
