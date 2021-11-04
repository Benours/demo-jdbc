package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.entites.Article;
import fr.diginamic.entites.Fournisseur;

public class TestInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		List<Fournisseur> liste = fournisseur.extraire();
		int nb = liste.get(liste.size() - 1).getId();
		Fournisseur insert = new Fournisseur(nb + 1, "La Maison du Pain");
		Fournisseur insertQuote = new Fournisseur(nb + 2, "L'Espace Création");
		fournisseur.insert(insert);
		fournisseur.insert(insertQuote);
		Article article = new Article(0, "PC", "PC INTEL 9", 75, insert);
		ArticleDaoJdbc articleDao = new ArticleDaoJdbc();
		articleDao.insert(article);

	}

}
