package fr.diginamic.jdbc.dao;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		
		System.out.println("Nombre de ligne modifié : " + fournisseur.update("La Maison du Pain", "Le Fournil"));

	}

}
