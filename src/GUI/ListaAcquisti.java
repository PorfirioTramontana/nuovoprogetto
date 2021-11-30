package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Acquisto;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaAcquisti extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JFrame frame;
	private JTable table;

	/**
	 * Create the frame.
	 * @param frameChiamante 
	 * @param controller 
	 */
	public ListaAcquisti(Controller c, JFrame frameChiamante) {
		frame=this;
		controller=c;
		setTitle("Lista Acquisti di "+controller.getNomeGiocatore());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameChiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Societa", "Prezzo Acquisto", "Prezzo Attuale", "Quantita"
			}
		));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList<Acquisto> tabellaAcquisti = new ArrayList();
		tabellaAcquisti = (ArrayList<Acquisto>) controller.getListaAcquisti();
		if (tabellaAcquisti!=null)
			for (Acquisto a:tabellaAcquisti) 
				model.addRow(new Object[]{a.getSocieta().getNome(),a.getPrezzoAcquisto(),a.getSocieta().getPrezzoAzione(),a.getQuantita()});
		contentPane.add(table);
		contentPane.add(btnOK);
	}

}
