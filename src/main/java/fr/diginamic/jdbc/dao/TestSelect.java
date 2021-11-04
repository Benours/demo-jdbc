package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.entites.Article;
import fr.diginamic.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FournisseurDaoJdbc fournisseurDao = new FournisseurDaoJdbc();
		List<Fournisseur> liste = fournisseurDao.extraire();

		
		for (Fournisseur fournisseur : liste) {
			System.out.println(fournisseur.toString());
		}

		ArticleDaoJdbc articleDao = new ArticleDaoJdbc();
		List<Article> listeArticle = articleDao.extraire();
		
		for (Article article : listeArticle) {
			System.out.println(article.toString());
		}

	}

}
