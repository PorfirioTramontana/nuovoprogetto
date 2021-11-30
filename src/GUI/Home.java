package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Controller.Controller;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Home extends JFrame {

	private Controller controller;
	JFrame frame;
	JLabel lblBorsa;
	JMenu mnListino;
	JMenu mnSocieta;
	JMenu mnAcquisto;
	JLabel lblBilancio;

	public Home(Controller c) {
		controller=c;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 732, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 frame.addComponentListener( new ComponentListener() {
			 @Override
             public void componentShown( ComponentEvent e ) {
            	 aggiorna();
             }
			@Override
			public void componentResized(ComponentEvent e) {}
			@Override
			public void componentMoved(ComponentEvent e) {}
			@Override
			public void componentHidden(ComponentEvent e) {}
         } );
		 
		String nomeGiocatore="";
		do {
			nomeGiocatore=JOptionPane.showInputDialog("Chi sta giocando?");
		} while (nomeGiocatore.contentEquals(""));
		controller.nuovoGiocatore(nomeGiocatore);
		frame.setTitle(nomeGiocatore+ " gioca in borsa");
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnBorsa = new JMenu("Borsa");
		menuBar.add(mnBorsa);
		
		JMenuItem mntmNuovaBorsa = new JMenuItem("Nuova");
		mntmNuovaBorsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frameBorsa=new NuovaBorsa(controller,frame);
				frame.setVisible(false);
				frameBorsa.setVisible(true);
				}
		});
		mnBorsa.add(mntmNuovaBorsa);

		mnListino = new JMenu("Listino");
		mnListino.setEnabled(false);
		menuBar.add(mnListino);
		JMenuItem mntmApriListino = new JMenuItem("Apri Listino");
		mntmApriListino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frameListino=new Listino(controller,frame);
				frame.setVisible(false);
				frameListino.setVisible(true);	
			}
		});
		mnListino.add(mntmApriListino);
		
		mnSocieta = new JMenu("Societa");
		mnSocieta.setEnabled(false);
		menuBar.add(mnSocieta);
		
		JMenuItem mntmNewSocieta = new JMenuItem("Aggiungi Nuova Societa");
		mntmNewSocieta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frameSocieta=new NuovaSocieta(controller,frame);
				frame.setVisible(false);
				frameSocieta.setVisible(true);
			}
		});
		mnSocieta.add(mntmNewSocieta);
		
		JMenuItem mntmModificaPrezzo = new JMenuItem("Modifica Prezzo Azione");
		mntmModificaPrezzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String societa=JOptionPane.showInputDialog("Inserisci la societa");
				boolean esiste=controller.cercaSocieta(societa);
				float nuovoPrezzoFloat=0.0f;
				if (esiste) {
					String nuovoPrezzo=JOptionPane.showInputDialog("Quanto vale ora?");
					try {
						nuovoPrezzoFloat=Float.parseFloat(nuovoPrezzo);
						controller.setPrezzoAzione(societa,nuovoPrezzoFloat);
						aggiorna();
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(frame,"valore non valido");
					}
				}
				
			}
		});
		mnSocieta.add(mntmModificaPrezzo);
		
		mnAcquisto = new JMenu("Acquisto");
		mnAcquisto.setEnabled(false);
		menuBar.add(mnAcquisto);
		
		JMenuItem mntmAcquisto = new JMenuItem("Acquista");
		mntmAcquisto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frameAcquistoDaListino=new AcquistoDaListino(controller,frame);
				frame.setVisible(false);
				frameAcquistoDaListino.setVisible(true);
			}
		});
		mnAcquisto.add(mntmAcquisto);
		
		JMenuItem mntmListaAcquisti = new JMenuItem("Lista Acquisti");
		mntmListaAcquisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frameListaAcquisti=new ListaAcquisti(controller,frame);
				frame.setVisible(false);
				frameListaAcquisti.setVisible(true);
			}
		});
		mnAcquisto.add(mntmListaAcquisti);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelBorsa = new JPanel();
		frame.getContentPane().add(panelBorsa);
		panelBorsa.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelBilancio = new JPanel();
		frame.getContentPane().add(panelBilancio);
		
		lblBilancio = new JLabel("");
		panelBilancio.add(lblBilancio);
		
		lblBorsa = new JLabel("");
		panelBorsa.add(lblBorsa);
		

	}

	void aggiorna() {
		lblBorsa.setText(controller.getCittaBorsa());
		if (!(lblBorsa.getText().contentEquals(""))) {
			lblBorsa.setText("Stiamo giocando nella borsa di "+lblBorsa.getText());
			mnListino.setEnabled(true);
			mnSocieta.setEnabled(true);
			mnAcquisto.setEnabled(true);
			lblBilancio.setText("Bilancio attuale : "+controller.getBilancio());
			
		}
	}
}
