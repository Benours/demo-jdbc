package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FournisseurDaoJdbc fournisseurDao = new FournisseurDaoJdbc();
		List<Fournisseur> liste = fournisseurDao.extraire();
		
		for (Fournisseur fournisseur : liste) {
			System.out.println(fournisseur.toString());
		}

	}

}
