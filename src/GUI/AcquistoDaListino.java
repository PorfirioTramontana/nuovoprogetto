package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AcquistoDaListino extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JFrame frame;
	private JTable table;
	private String nomeSocieta="";

	/**
	 * Create the frame.
	 * @param frameChiamante 
	 * @param controller 
	 */
	public AcquistoDaListino(Controller c, JFrame frameChiamante) {
		frame=this;
		setTitle("Listino Azioni");
		controller=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	
		JButton btnAcquisto = new JButton("Acquista");
		btnAcquisto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(nomeSocieta.contentEquals(""))) {
					String quantitaString=JOptionPane.showInputDialog("Quante ne vuoi comprare?");
					int quantita;
					try {
						quantita=Integer.parseInt(quantitaString);
					}catch (Exception ex) {
						quantita=0;
					}
					if (quantita>0) {
						boolean esito=controller.acquista(nomeSocieta,quantita);
						if (!esito)
								JOptionPane.showMessageDialog(frame,"Acquisto non completato");
					}
					
				}
					
				frameChiamante.setVisible(true);			
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int riga=table.getSelectedRow();
				nomeSocieta=new String(table.getModel().getValueAt(riga, 0).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Societa", "Prezzo"
			}
		));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList tabellaListino = new ArrayList();
		tabellaListino = controller.getListinoSocietaPrezzo();
		if (tabellaListino!=null)
			for (int i=0;i<tabellaListino.size();i=i+2) 
				model.addRow(new Object[]{tabellaListino.get(i),tabellaListino.get(i+1)});
		contentPane.add(table);
		contentPane.add(btnAcquisto);
	}

}
