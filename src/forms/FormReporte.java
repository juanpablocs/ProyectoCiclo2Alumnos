package forms;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import clases.Matricula;

public class FormReporte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReporte frame = new FormReporte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormReporte() {
		Matricula m = new Matricula();
		setBounds(100, 100, 478, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPORTE");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel.setBounds(189, 11, 64, 25);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 442, 235);
		contentPane.add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtS.setForeground(Color.BLACK);
		txtS.setText(m.reporte());
		scrollPane.setViewportView(txtS);
		
	}

}
