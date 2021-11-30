package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Listino extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JFrame frame;
	private JTable table;

	/**
	 * Create the frame.
	 * @param frameChiamante 
	 * @param controller 
	 */
	public Listino(Controller c, JFrame frameChiamante) {
		frame=this;
		setTitle("Listino Azioni");
		controller=c;
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
		contentPane.add(btnOK);
	}

}
