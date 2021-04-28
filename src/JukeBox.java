import java.util.*;
import java.io.*;
/**versione 2**/

public class JukeBox {

	private ArrayList<Brano> juk;
	private String nfile;
	
	public JukeBox(String nf) {
		juk=new ArrayList<Brano>();
		nfile=nf;
		try {
			FileReader fin=new FileReader(nfile);			
			BufferedReader in=new BufferedReader(fin);		
			String s="";
			while((s=in.readLine())!=null) {
				StringTokenizer st=new StringTokenizer(s,"#");

			fin.close();
		}
		}
		catch(IOException e) {
			System.out.println("Errore di lettura del file: "+ e);
		}
		}




	
	public void scriviFile() {
		try {
	
			f.close();
			out.close();
		}catch(IOException e) {
			System.out.println("Errore di scrittura del file: "+ e);
		}
	}
	

	public void addBrano(Brano b) {
		juk.add(b);
	}
	
	Brano cercaBrano(String t,String a) {
		for(Brano b:juk) {
			if(b.getAutore().compareToIgnoreCase(a)==0 && b.getTitolo().compareToIgnoreCase(t)==0);
			return b;
		}
		return null;
	} 
	
	public ArrayList<Brano> cercaBrano(String a){
		ArrayList<Brano> v=new ArrayList<Brano>();
		for(Brano b:juk) {
			if(b.getAutore().compareToIgnoreCase(a)==0);
			v.add(b);
		}
		return v;
	}
	
	public ArrayList<Brano> getElenco(){
		return juk;
	}

	public String toString() {
		String s="";
		for(Brano b:juk)
			s+=b+"\n";
		return s;
	}
	
	public static void main(String[] args) {
	/*	Brano br=new Brano("Alive","Neffex","Canzoni/Alive..mp3");
		br.setFoto("Canzoni/Alive.jpg");
		Brano br1=new Brano("Centuries","Fall Out Boy","Canzoni/Centuries..mp3");
		br1.setFoto("Canzoni/Centuries.jpg");
		JukeBox j=new JukeBox();
		j.addBrano(br);
		j.addBrano(br1);*/
		JukeBox juk=new JukeBox("Canzoni/file.txt");
		System.out.println(juk.getElenco());
		Brano b=new Brano("Alive","Neffex","Canzoni/Alive..mp3");
		juk.addBrano(b);
		Brano b1=new Brano("Centuries","Fall Out Boy","Canzoni/Centuries..mp3");
		Brano b2=new Brano("LND","Lol","Canzoni/LND.mp3");
		juk.addBrano(b1);
		juk.addBrano(b2);
		for(Brano br:juk.getElenco())
			System.out.println(br);
		ArrayList<Brano> v=juk.cercaBrano("Neffex");
		for(Brano br:v)
			System.out.println("#"+br);
		juk.scriviFile();
	}

}
