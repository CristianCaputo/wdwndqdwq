public class Brano {

	private String nomeF,foto,titolo,autore;
	
	public Brano(String titolo, String autore, String nomeF, String foto) {
		this.titolo = titolo;
		this.autore = autore;
		this.nomeF = nomeF;
		this.foto=foto;
	}
	
	public String getNomeF() {
		return nomeF;
	}
	
	public void setNomeF(String nomeF) {
		this.nomeF = nomeF;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		return "Brano [titolo=" + titolo + ", autore=" + autore + "]";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Brano br=new Brano("Alive","Neffex","Canzoni/alive..mp3",""); //metti il nome della foto
		System.out.println(br);
		Mp3 m=new Mp3("Brani/"+br.nomeF);
	}



}