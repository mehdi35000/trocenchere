package trocenchere.bo;

public class Retrait {
	
	private int id_Article;
	private String rue;
	private String codePostal;
	private String ville;
	
	
	
	public Retrait () {}

	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	
	public Retrait(int id_Article, String rue, String codePostal, String ville) {
		super();
		this.id_Article = id_Article;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	
	
	public int getId_Article() {
		return id_Article;
	}

	public void setId_Article(int id_Article) {
		this.id_Article = id_Article;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	


	@Override
	public String toString() {
		return "Retrait [id_Article=" + id_Article + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
	
	
	
}
