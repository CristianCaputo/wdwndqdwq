import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainGrafico extends JFrame implements ActionListener,WindowListener {
	private JTextField titoloTx,autoreTx,nomemp3Tx,imgTx;
	private JLabel titoloL,autoreL,nomemp3L,imgL;
	private JLabel subtitL,titL,copL;
	private JButton play,stop,pause,resume,add;
	private JMenuItem agg,cercaB,cercaBA,viselenco,exit,help,about;
	private Jukebox juk;
	private Container c;
	private String nom;
	private JTextArea ta;
	private JScrollPane ja;
	
	public MainGrafico(String nF) {
		super("Jukebox");
		c = getContentPane();
		
		this.addWindowListener(this);
		
		nom=nF;
		
		menu();
 	    
 	    juk= new Jukebox(nF);
 	    
 	    JPanel nord,Nnord,Snord,centro,sud;
 	    
 	   //pannello nord
		nord=new JPanel(new GridLayout(2,1));
		nord.setBackground(Color.blue);
		
		//panello Nnord
		Nnord=new JPanel();
	    Nnord.setBackground(Color.yellow);
	    
	    //titolo
	  	titL=new JLabel("jukebox");
	   	titL.setForeground(Color.ref);
	   	titL.setBackground(Color.blue);
	    Nnord.add(titL);
	   	    
	   	nord.add(Nnord,"North");
	   	
	    //panello Snord
 	    Snord=new JPanel();
 	    Snord.setBackground(Color.white);
 	    
 	   
 	    //subtit
	    subtitL=new JLabel("MUSICA");
	    subtitL.setForeground(Color.red);
	    subtitL.setBackground(Color.green);
	    Snord.add(subtitL);
	    
       
	    //titolo
	    titoloL=new JLabel("TITOLO: ");
 	    titoloTx=new JTextField(10);
 	    titoloL.setVisible(false);
 	    titoloTx.setVisible(false);
 	    Snord.add(titoloL);
 	    Snord.add(titoloTx);
 	    
 	    //autore
	    autoreL=new JLabel("AUTORE: ");
	    autoreTx=new JTextField(10);
 	    autoreL.setVisible(false);
 	    autoreTx.setVisible(false);
 	    Snord.add(autoreL);
 	    Snord.add(autoreTx);
 	    
 	    //nomMp3
	    nomemp3L=new JLabel("NOME DEL BRANO: ");
	    nomemp3Tx=new JTextField(10);
	    nomemp3L.setVisible(false);
	    nomemp3Tx.setVisible(false);
 	    Snord.add(nomemp3L);
 	    Snord.add(nomemp3Tx);
	   	 
 	    //img
	    imgL=new JLabel("IMG DISCO: ");
	    imgTx=new JTextField(10);
	    imgL.setVisible(false);
	    imgTx.setVisible(false);
 	    Snord.add(imgL);
 	    Snord.add(imgTx);
 	    
 	    //add
	    add=new JButton("ADD");
	    add.addActionListener(this);
	    add.setVisible(false);
	    Snord.add(add);
	    
	    nord.add(Snord,"South");
	    
	    c.add(nord,"North");
	    
	    //pannello centro
	    centro=new JPanel();
	    centro.setBackground(Color.green);
	    
	    //copL
	    copL=new JLabel(new ImageIcon("img/vuoto.png"));
		centro.add(copL);
		
		//text area
		ta = new JTextArea(10, 60);
		ta.setVisible(false);
		ta.setEditable(false);
	    ja = new JScrollPane(ta);
		ja.setVisible(false);
		centro.add(ja);
		
		c.add(centro);
		
		//pannello sud
		sud=new JPanel();
	    sud.setBackground(Color.green);
	    
	    //bottoni controllo musica
	    play=new JButton(new ImageIcon("img/play.png"));
	    play.setBackground(Color.green);
	    play.addActionListener(this);
	    sud.add(play);
	    
	    pause=new JButton(new ImageIcon("img/pause.png"));
	    pause.setBackground(Color.green);
	    pause.addActionListener(this);
	    sud.add(pause);
	    
	    resume=new JButton(new ImageIcon("img/resume.png"));
	    resume.setBackground(Color.green);
	    resume.addActionListener(this);
	    sud.add(resume);
	    
	    c.add(sud,"South");
	    
    	setSize(950, 500);
		setLocation(100, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
 	    
 	    
	}
	
	private void menu() {
		JMenuBar mb = new JMenuBar();
		
		setJMenuBar(mb);
		
		JMenu menuSetup = new JMenu("Setup");
		JMenu menuHelp = new JMenu("Help");
		
		mb.add(menuSetup);
		mb.add(menuHelp);
		
		//voci setup
	    agg = new JMenuItem("Aggiungi Brano");
		cercaB = new JMenuItem("Cerca Brano");
		cercaBA = new JMenuItem("Cerca per autore");
		viselenco = new JMenuItem("Vedi elenco");
		exit = new JMenuItem("Exit");
		
		menuSetup.add(agg);
		menuSetup.add(cercaB);
		menuSetup.add(cercaBA);
		menuSetup.add(viselenco);
		menuSetup.addSeparator();
		menuSetup.add(exit);
		
		agg.addActionListener(this);
		cercaB.addActionListener(this);
		cercaBA.addActionListener(this);
	    viselenco.addActionListener(this);
	    exit.addActionListener(this);
	    
	   //voci help
	    help = new JMenuItem("Help");
		about = new JMenuItem("About");
				
		menuHelp.add(help);
		menuHelp.add(about);
				
		help.addActionListener(this);
		about.addActionListener(this);
	}
	
	private void visibili(boolean v) {
		titoloL.setVisible(v);
		titoloTx.setVisible(v);
		autoreL.setVisible(v);
		autoreTx.setVisible(v);
		nomemp3L.setVisible(v);
		nomemp3Tx.setVisible(v);
		imgL.setVisible(v);
		imgTx.setVisible(v);
		add.setVisible(v);
		subtitL.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		//Aggiungi song
		if(o==agg) {
			visibili(true);
			ta.setVisible(false);
			ja.setVisible(false);
			copL.setVisible(true);
			copL.setIcon(new ImageIcon("img/vuoto.png"));
			add.setText("ADD");
		}
		if(o==add && add.getText().trim().compareTo("ADD")==0) {
			Brano br=new Brano("","","","");
			
			copL.setIcon(new ImageIcon("img/vuoto.png"));
			
			String t = titoloTx.getText().trim();
			
			String a = autoreTx.getText().trim();
			
			String nm = ("suono/"+nomemp3Tx.getText().trim());
			
			String di = ("img/"+imgTx.getText().trim());
			
			if(t.compareTo("")==0 ||
					a.compareTo("")==0 ||
					nm.compareTo("")==0||
					di.compareTo("")==0 ){    
				JOptionPane.showMessageDialog(this, "Inserisci i campi obbligatori");
				titoloTx.setBorder(BorderFactory.createLineBorder(Color.red, 2));
				autoreTx.setBorder(BorderFactory.createLineBorder(Color.red, 2));
				nomemp3Tx.setBorder(BorderFactory.createLineBorder(Color.red, 2));
				imgTx.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			}
			else {
				titoloTx.setBorder(null);
				autoreTx.setBorder(null);
				nomemp3Tx.setBorder(null);
				imgTx.setBorder(null);
				if(imgTx.getText().trim().compareTo("")==0) {
					 br = new Brano(t,a,nm,"img/vuoto.png");
					 copL.setIcon(new ImageIcon("img/vuoto.png"));
				}
				else {
					br=new Brano(t, a, nm, di);
				    copL.setIcon(new ImageIcon(di));
				}
				juk.addBrano(br);
				JOptionPane.showMessageDialog(this,"INSERIMENTO EFFETTUATO");
				titoloTx.setText("");
				autoreTx.setText("");
				nomemp3Tx.setText("");
				imgTx.setText("");
			}	
		}
		////////////////////////////////////////////////////////////////////////////
		if(o==cercaB) {
			visibili(true);
			ta.setVisible(false);
			ja.setVisible(false);
        	copL.setVisible(true);
        	copL.setIcon(new ImageIcon("img/vuoto.png"));
			nomemp3L.setVisible(false);
			nomemp3Tx.setVisible(false);
			imgL.setVisible(false);
			imgTx.setVisible(false);
			add.setText("Cerca Brano");
		}
		if(o==add && add.getText().trim().compareTo("Cerca Brano")==0) {
        	visibili(false);
        	ta.setVisible(false);
        	ja.setVisible(false);
    		copL.setVisible(true);
        	if(titoloTx.getText().compareTo("")==0 || autoreTx.getText().compareTo("")==0) {
        		JOptionPane.showMessageDialog(this,"RIEMPI TUTTI I CAMPI");
        	}
        	else {
        		titoloTx.setvisible(true); titoloL.setivisible(true);autoreTx.setvisible(true);autoreL.setvisibile(true)
            	copL.setIcon(new ImageIcon(juk.cercaBrano(titoloTx.getText().trim(),autoreTx.getText().trim()).getImg().toString()));
            	titoloTx.setText("");
            	autoreTx.setText("");
        	}
		}
		/////////////////////////////////////////////////////////////////////////////////////////
		if(o==cercaBA) {
			play.setVisible(false);
			pause.setVisible(false);
			resume.setVisible(false);
			visibili(false);
			copL.setVisible(false);
			ta.setVisible(true);
			ja.setVisible(true);
			autoreL.setVisible(true);
			autoreTx.setVisible(true);
			add.setVisible(true);
			add.setText("Cerca Autore");
		}
		if(o==add && add.getText().trim().compareTo("Cerca Autore")==0) {
			if(autoreTx.getText().compareTo("")==0) {
        		JOptionPane.showMessageDialog(this,"RIEMPI TUTTI I CAMPI");
        	}
			else {
				juk.cercaBrano(autoreTx.getText().trim());
				ta.append(juk.cercaBrano(autoreTx.getText().trim()).toString());
				autoreTx.setText("");
			}
		}
		if(o==exit) {
			juk.ScriviFile();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nf=JOptionPane.showInputDialog("Inserisci nome file collezione");
        new MainGrafico(nf);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		juk.ScriviFile();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}