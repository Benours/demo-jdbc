package fr.diginamic.entites;

public class Article {
	private int id;
	private String ref;
	private String designation;
	private float prix;
	private Fournisseur fournisseur;
	/**
	 * @param id
	 * @param ref
	 * @param designation
	 * @param prix
	 * @param fournisseur
	 */
	public Article(int id, String ref, String designation, float prix, Fournisseur fournisseur) {
		this.id = id;
		this.ref = ref;
		this.designation = designation;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @return the prix
	 */
	public float getPrix() {
		return prix;
	}
	/**
	 * @return the fournisseur
	 */
	public Fournisseur getfournisseur() {
		return fournisseur;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", ref=" + ref + ", designation=" + designation + ", prix=" + prix
				+ ", fournisseur=" + fournisseur.toString() + "]";
	}
	
	

}
