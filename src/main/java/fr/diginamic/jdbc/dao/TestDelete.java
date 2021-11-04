package fr.diginamic.jdbc.dao;

import fr.diginamic.entites.Fournisseur;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fournisseur delete = new Fournisseur(14, "Le Fournil");
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		
		if (fournisseur.delete(delete))
			System.out.println("Le delete a réussi!");

	}

}
