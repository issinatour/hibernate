package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JToolBar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.Preguntas;
import model.Respuestas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.HibernateHelper;
import clases.SessionFactoryUtil;

import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class VentanaInsertar extends JFrame {
	JButton btnInsertarrespuesta;
	private JFrame frame;
	private JTextField texttitulopregunta;
	private JTextField textcategoriapregunta;
	private JTextField textnombreimagenpregunta;
	private JTextField texttipopregunta;
	private JTextField textconsejopregunta;
	JScrollPane scrollPanePreguntas;
	private SessionFactory sesion;
	private JTextField TEXTOrespuesta;
	private JTextField textField;
	JCheckBox checkTrueFalse;

	
	JButton btnBorrarPreguntas;
	JButton btnBorrarRespuesta;
	JScrollPane scrollPaneRespuestas;
	HibernateHelper modelo;
	JButton btnInsertarpregunta;
	
	JTable tablarespuestas;
	JTable tablapreguntas;

	
	JButton btnModificarpregunta;
	public VentanaInsertar() {
		
		modelo = new HibernateHelper();
		initialize();
	}

	private void initialize() {

		setBounds(100, 100, 913, 481);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_17 = new JPanel();
		tabbedPane.addTab("Crear-insertar", null, panel_17, null);
		panel_17.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_17.add(panel_1);
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

		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);

		btnInsertarpregunta = new JButton("InsertarPregunta");
		panel_12.add(btnInsertarpregunta);

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

		btnInsertarrespuesta = new JButton("InsertarRespuesta");
		panel_16.add(btnInsertarrespuesta);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Ver datos", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_18 = new JPanel();
		panel.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_19 = new JPanel();
		panel_18.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));

		scrollPanePreguntas = new JScrollPane();
		panel_19.add(scrollPanePreguntas, BorderLayout.CENTER);

		JLabel lblPreguntas = new JLabel("Preguntas");
		lblPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblPreguntas, BorderLayout.NORTH);
		
		JPanel panel_21 = new JPanel();
		panel_19.add(panel_21, BorderLayout.SOUTH);
		panel_21.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_21.add(panel_22);
		panel_22.setLayout(new GridLayout(1, 0, 0, 0));
		
		 btnModificarpregunta = new JButton("Modificar_Pregunta");
		panel_22.add(btnModificarpregunta);
		
		JPanel panel_23 = new JPanel();
		panel_21.add(panel_23);
		
		JPanel panel_24 = new JPanel();
		panel_21.add(panel_24);
		
		 btnBorrarPreguntas = new JButton("Borrar");
		panel_21.add(btnBorrarPreguntas);

		JPanel panel_20 = new JPanel();
		panel_18.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));

		scrollPaneRespuestas = new JScrollPane();
		panel_20.add(scrollPaneRespuestas, BorderLayout.CENTER);

		JLabel lblRespuestas = new JLabel("Respuestas");
		lblRespuestas.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(lblRespuestas, BorderLayout.NORTH);
		
		JPanel panel_25 = new JPanel();
		panel_20.add(panel_25, BorderLayout.SOUTH);
		panel_25.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_25.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_25.add(panel_27);
		
		JPanel panel_28 = new JPanel();
		panel_25.add(panel_28);
		
		 btnBorrarRespuesta = new JButton("Borrar");
		panel_25.add(btnBorrarRespuesta);

		sesion = SessionFactoryUtil.getSessionFactory();

		cargarTablas();
		
	}


		public void cargarTablas() {

			DefaultTableModel modeloT = new DefaultTableModel();
			 tablapreguntas = new JTable(modeloT);
			
			modeloT.addColumn("idpregunta");
			modeloT.addColumn("titulo");
			modeloT.addColumn("categoria");
			modeloT.addColumn("imagen");
			modeloT.addColumn("tipo");
			modeloT.addColumn("consejo");
			
		
			DefaultTableModel modeloTRespuestas = new DefaultTableModel();
			tablarespuestas = new JTable(modeloTRespuestas);
			
			modeloTRespuestas.addColumn("idRespuestas");
			modeloTRespuestas.addColumn("respuesta");
			modeloTRespuestas.addColumn("solucion");
			modeloTRespuestas.addColumn("idPreguntas");

			List<Preguntas> Listapreguntas = modelo.getQuestion();
			List<Respuestas> Listarespuestas = modelo.getRespuestas();

			for (Preguntas s : Listapreguntas) {
				Object[] o = new Object[6];
				o[0] = s.getIdPreguntas();
				o[1] = s.getTitulo();
				o[2] = s.getCategoria();
				o[3] = s.getImagen();
				o[4] = s.getTipo();
				o[5] = s.getConsejo();

				modeloT.addRow(o);
			}

			for (Respuestas s : Listarespuestas) {
				Object[] o = new Object[4];
				o[0] = s.getIdRespuestas();
				o[1] = s.getRespuesta();
				o[2] = s.getSolucion();
				o[3] = s.getIdPreguntas();

				modeloTRespuestas.addRow(o);
			}

			scrollPanePreguntas.setViewportView(tablapreguntas);
			scrollPaneRespuestas.setViewportView(tablarespuestas);
		}
	

	public void ReCargarTablas() {
		cargarTablas();
	}

	public JButton getbtninsertarPregunta() {
		return btnInsertarpregunta;
	}

	public JTextField gettexttitulopregunta() {
		return texttitulopregunta;
	}

	public JTextField gettextcategoriapregunta() {
		return textcategoriapregunta;
	}

	public JTextField gettextnombreimagenpregunta() {
		return textnombreimagenpregunta;
	}

	public JTextField gettexttipopregunta() {
		return texttipopregunta;
	}

	public JTextField gettextconsejopregunta() {
		return textconsejopregunta;
	}

	public JButton getbtnInsertarrespuesta() {
		return btnInsertarrespuesta;
	}

	public JTextField getTEXTOrespuesta() {
		return TEXTOrespuesta;
	}

	public JCheckBox getcheckTrueFalse() {
		return checkTrueFalse;
	}

	public JTextField getIDPREGUNTA() {
		return textField;
	}
	
	public JButton getBorrarPreguntas(){
		return btnBorrarPreguntas;
	}
	
	public JButton getBorrarRespuestas(){
		return btnBorrarRespuesta;
	}
	
	public JTable getTablePreguntas(){
		return tablapreguntas;
	}
	
	public JTable getTableRespuestas(){
		return tablarespuestas;
	}
	
	public JButton getModificarPregunta(){
		return btnModificarpregunta;
	}
}
