package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.entites.Fournisseur;

public class TestInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Fournisseur insertQuote = new Fournisseur(6, "L'Espace Création");
		
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		List<Fournisseur> liste = fournisseur.extraire();
		Fournisseur insert = new Fournisseur(liste.get(liste.size() - 1).getId() + 1, "La Maison du Pain");
		System.out.println(liste.get(liste.size() - 1).getId() + 1);
		fournisseur.insert(insert);
//		fournisseur.insert(insertQuote);

	}

}
