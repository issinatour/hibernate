package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JToolBar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.Preguntas;
import model.Respuestas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.SessionFactoryUtil;
import javax.swing.JCheckBox;

public class VentanaInsertar {

	private JFrame frame;
	private JTextField texttitulopregunta;
	private JTextField textcategoriapregunta;
	private JTextField textnombreimagenpregunta;
	private JTextField textforeignpregunta;
	private JTextField texttipopregunta;
	private JTextField textconsejopregunta;
	
	 private SessionFactory sesion;
	 private JTextField TEXTOrespuesta;
	 private JTextField textField;
	 JCheckBox checkTrueFalse;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInsertar window = new VentanaInsertar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaInsertar() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsertarpregunta = new JLabel("InsertarPregunta");
		lblInsertarpregunta.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblInsertarpregunta, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(7, 6, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblId = new JLabel("Titulo");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblId);
		
		texttitulopregunta = new JTextField();
		panel_6.add(texttitulopregunta);
		texttitulopregunta.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel);
		
		textcategoriapregunta = new JTextField();
		panel_7.add(textcategoriapregunta);
		textcategoriapregunta.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNombreimagen = new JLabel("NombreImagen");
		lblNombreimagen.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNombreimagen);
		
		textnombreimagenpregunta = new JTextField();
		textnombreimagenpregunta.setText("imagen");
		panel_8.add(textnombreimagenpregunta);
		textnombreimagenpregunta.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblTipo);
		
		texttipopregunta = new JTextField();
		panel_9.add(texttipopregunta);
		texttipopregunta.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		panel_10.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblConsejo = new JLabel("Consejo");
		lblConsejo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblConsejo);
		
		textconsejopregunta = new JTextField();
		panel_10.add(textconsejopregunta);
		textconsejopregunta.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblForeginpreguntas = new JLabel("ForeginIdPreguntas");
		lblForeginpreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblForeginpreguntas);
		
		textforeignpregunta = new JTextField();
		textforeignpregunta.setText("1");
		panel_11.add(textforeignpregunta);
		textforeignpregunta.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);
		
		JButton btnInsertarpregunta = new JButton("InsertarPregunta");
		panel_12.add(btnInsertarpregunta);
		
		btnInsertarpregunta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String titulo=texttitulopregunta.getText();
					String categoria = textcategoriapregunta.getText();
					String nombreImagen = textnombreimagenpregunta.getText();
					String tipo = texttipopregunta.getText();
					String consejo = textconsejopregunta.getText();
					int idpreguntaforeign = Integer.valueOf(textforeignpregunta.getText());
					
					addQuestion(titulo,categoria,nombreImagen,idpreguntaforeign,tipo,consejo);
		

					
				}

			});
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsertarrespuesta = new JLabel("InsertarRespuesta");
		lblInsertarrespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblInsertarrespuesta, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTitulorespuesta = new JLabel("TituloRespuesta");
		lblTitulorespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblTitulorespuesta);
		
		TEXTOrespuesta = new JTextField();
		panel_13.add(TEXTOrespuesta);
		TEXTOrespuesta.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_5.add(panel_14);
		panel_14.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("essolucion");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(lblNewLabel_1);
		
		 checkTrueFalse = new JCheckBox("si o no");
		panel_14.add(checkTrueFalse);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblIdpregunta = new JLabel("idPREGUNTA");
		lblIdpregunta.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(lblIdpregunta);
		
		textField = new JTextField();
		textField.setText("5");
		panel_15.add(textField);
		textField.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_5.add(panel_16);
		
		JButton btnInsertarrespuesta = new JButton("InsertarRespuesta");
		panel_16.add(btnInsertarrespuesta);
		
		btnInsertarrespuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String titulo=TEXTOrespuesta.getText();
				boolean seleccion=false;
				 boolean selected = checkTrueFalse.isSelected();
			        if (selected) {
			        	seleccion=true;
			            System.out.println("Check box state is selected.");
			        } else {
			        	seleccion=false;
			            System.out.println("Check box state is not selected.");
			        }
				
				
				int idpreguntaforeign = Integer.valueOf(textField.getText());
				
				addRespuestas(titulo,seleccion,idpreguntaforeign);
	

				
			}

		});
		
		 sesion = SessionFactoryUtil.getSessionFactory();
	}
	
	
	
	public void addQuestion( String titulo, String categoria,String imagen,int fidPreguntas,String tipo,String consejo){
		 Session session = sesion.openSession();
		 Transaction tx = session.beginTransaction();
		 

		 Preguntas question = new Preguntas(titulo,categoria,imagen,fidPreguntas,tipo,consejo
				 );
		 
		 session.save(question);
		 tx.commit();
		 session.close();
		 }
	
	
	 public void addRespuestas(String respuestas,boolean solucion,int idpregunta){
			
		 Session session = sesion.openSession();
		 Transaction tx = session.beginTransaction();
		 
		 Respuestas respuesta = new Respuestas(respuestas,solucion,idpregunta);
			 
		 
		 session.save(respuesta);
		 tx.commit();
		 session.close();
	 }

}
