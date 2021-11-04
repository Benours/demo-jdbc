package fr.diginamic.entites;

public class Fournisseur {
	private int id;
	private String nom;
	/**
	 * @param id
	 * @param nom
	 */
	public Fournisseur(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
