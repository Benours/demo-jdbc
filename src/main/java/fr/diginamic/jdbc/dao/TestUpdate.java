package fr.diginamic.jdbc.dao;

import fr.diginamic.entites.Article;
import fr.diginamic.entites.Fournisseur;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		ArticleDaoJdbc articleDao = new ArticleDaoJdbc();
		Fournisseur ancienFournisseur = new Fournisseur(20, "L'Espace Création");
		Fournisseur nouveauFournisseur = new Fournisseur(20, "La Marquise");
		Article ancienArticle = new Article(0, "PC", "PC INTEL 9", 75, new Fournisseur(17, "La Maison du Pain"));
		Article nouvelArticle = new Article(0, "PC", "PC INTEL 10", 750, new Fournisseur(17, "La Maison du Pain"));

		System.out.println("Nombre de ligne modifié : " + fournisseur.update(ancienFournisseur, nouveauFournisseur));
		System.out.println("Nombre de ligne modifié : " + articleDao.update(ancienArticle, nouvelArticle));

	}

}
