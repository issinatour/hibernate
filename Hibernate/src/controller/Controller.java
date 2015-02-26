package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clases.HibernateHelper;




public class Controller {
	VentanaInsertar view;
	HibernateHelper model;
	
	
	Controller() {
		
		view = new VentanaInsertar();
		model = new HibernateHelper();	

		launchMainWindow();		
		
		
		actionSavePregunta();
		actionsaveRespuesta();
	}


	private void launchMainWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private void actionSavePregunta() {
		view.getbtninsertarPregunta().addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	
		 

				System.out.println("pregunta guardada");
				
				String titulo=view.gettexttitulopregunta().getText();
				String categoria = view.gettextcategoriapregunta().getText();
				String nombreImagen = view.gettextnombreimagenpregunta().getText();
				String tipo = view.gettexttipopregunta().getText();
				String consejo = view.gettextconsejopregunta().getText();
				int idpreguntaforeign = Integer.parseInt((view.getIDPREGUNTA().getText()));
				
				model.addQuestion(titulo,categoria,nombreImagen,idpreguntaforeign,tipo,consejo);

	
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							view.ReCargarTablas();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
	}


	private void actionsaveRespuesta() {
		view.getbtnInsertarrespuesta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String titulo=view.getTEXTOrespuesta().getText();
				boolean seleccion=false;
				 boolean selected = view.getcheckTrueFalse().isSelected();
			        if (selected) {
			        	seleccion=true;
			            System.out.println("Check box state is selected.");
			        } else {
			        	seleccion=false;
			            System.out.println("Check box state is not selected.");
			        }
				
				
				//int idpreguntaforeign = Integer.valueOf(textField.getText());
				
				model.addRespuestas(titulo,seleccion,Integer.parseInt((view.getIDPREGUNTA().getText())));

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							view.ReCargarTablas();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
	}



}