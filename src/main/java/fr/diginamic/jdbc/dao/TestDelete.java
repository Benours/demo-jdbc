package fr.diginamic.jdbc.dao;

import fr.diginamic.entites.Article;
import fr.diginamic.entites.Fournisseur;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fournisseur deleteFournisseur = new Fournisseur(17, "LDLC");
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		Article deleteArticle = new Article(1, "PC", "PC INTEL 10", 750, deleteFournisseur);
		ArticleDaoJdbc article = new ArticleDaoJdbc();
		
		if (fournisseur.delete(deleteFournisseur))
			System.out.println("Le delete a réussi!");
		if (article.delete(deleteArticle))
			System.out.println("Le delete a réussi!");

	}

}
