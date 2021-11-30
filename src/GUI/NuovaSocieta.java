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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuovaSocieta extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JFrame frame;
	private JTextField textNomeSocieta;
	private JTextField textPrezzoAzione;


	/**
	 * Create the frame.
	 * @param frameChiamante 
	 * @param controller2 
	 */
	public NuovaSocieta(Controller c, JFrame frameChiamante) {
		frame=this;
		setTitle("Creazione di una nuova società");
		controller=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Nome Societa");
		contentPane.add(lblNewLabel, "2, 2, right, default");
		
		textNomeSocieta = new JTextField();
		contentPane.add(textNomeSocieta, "4, 2, fill, default");
		textNomeSocieta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prezzo Azione");
		contentPane.add(lblNewLabel_1, "2, 4, right, default");
		
		textPrezzoAzione = new JTextField();
		contentPane.add(textPrezzoAzione, "4, 4, fill, default");
		textPrezzoAzione.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errore=controller.nuovaSocieta(textNomeSocieta.getText(),textPrezzoAzione.getText());
				if (errore.contentEquals("OK")) {
					frameChiamante.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				}else
					JOptionPane.showMessageDialog(frame,errore);

			}
		});
		contentPane.add(btnOK, "4, 8");
		
		JButton btnCancel = new JButton("Annulla");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameChiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		contentPane.add(btnCancel, "4, 10");
	}

}
