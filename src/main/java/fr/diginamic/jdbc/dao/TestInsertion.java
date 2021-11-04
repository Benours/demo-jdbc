package fr.diginamic.jdbc.dao;

import fr.diginamic.entites.Fournisseur;

public class TestInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fournisseur insert = new Fournisseur(2, "La Maison du Pain");
//		Fournisseur insertQuote = new Fournisseur(6, "L'Espace Création");
		
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		fournisseur.insert(insert);
//		fournisseur.insert(insertQuote);

	}

}
