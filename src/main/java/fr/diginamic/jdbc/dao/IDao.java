package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.entites.Article;

public interface IDao<T> {
	List<T> extraire();
	void insert(T object);
	int update(T ancienObject, T nouvelObject);
	boolean delete(T object);

}
