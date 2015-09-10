package com.nirvana.dao;

public interface BaseDao<T> {
	public T load(T entity);
}
