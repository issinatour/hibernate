package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Preguntas;
import clases.HibernateHelper;




public class Controller {
	VentanaInsertar view;
	HibernateHelper model;
	
	
	//PREGUNTA
	 Integer idPreguntas;
	 String titulo;
	 String categoria;
	 String imagen;
	 int fidPreguntas;
	 String tipo;
	 String consejo;
	 
	 Preguntas mipregunta;
	////
	
	int iddepregunta=0;
	int idderespuesta = 0;
	
	Controller() {
		
		view = new VentanaInsertar();
		model = new HibernateHelper();	

		launchMainWindow();		
		
		
		actionSavePregunta();
		actionsaveRespuesta();
		borrarPregunta();
		borrarRespuesta();
		modificarPregunta();
		view.getTablePreguntas().addMouseListener(ListenertablaPreguntas);
		view.getTableRespuestas().addMouseListener(ListenertablaRespuestas);
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

	            //cargo el id de la pregunta introducida en el id de la respuesta (fk)
	            view.getIDPREGUNTA().setText(String.valueOf(model.getLastQuestion().getIdPreguntas()));
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

	MouseAdapter ListenertablaPreguntas = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			String[] nombresdefila = new String[8];

			int fila = view.getTablePreguntas().rowAtPoint(e
					.getPoint());
			int columna = view.getTablePreguntas().columnAtPoint(e
					.getPoint());
			if ((fila > -1) && (columna > -1)) {

				for (int i = 0; i < view.getTablePreguntas().getColumnCount(); i++) {
					nombresdefila[i] = String.valueOf(view.getTablePreguntas().getValueAt(fila, i));
	

				}
				 iddepregunta=Integer.valueOf(nombresdefila[0]);
				 titulo=nombresdefila[1];
				 categoria=nombresdefila[2];
				 imagen=nombresdefila[3];
				 fidPreguntas=0;
				 tipo=nombresdefila[4];
				 consejo=nombresdefila[5];
				
				mipregunta=new Preguntas(titulo,categoria,imagen,fidPreguntas,tipo,consejo);
				
				System.out.println(mipregunta.getTitulo());
			}

		}

	};
	
	MouseAdapter ListenertablaRespuestas = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			String[] nombresdefila = new String[8];

			int fila = view.getTableRespuestas().rowAtPoint(e
					.getPoint());
			int columna = view.getTableRespuestas().columnAtPoint(e
					.getPoint());
			if ((fila > -1) && (columna > -1)) {

				for (int i = 0; i < view.getTableRespuestas().getColumnCount(); i++) {
					nombresdefila[i] = String.valueOf(view.getTableRespuestas().getValueAt(fila, i));
	

				}
				idderespuesta=Integer.valueOf(nombresdefila[0]);
				System.out.println(nombresdefila[0]);
			}

		}

	};
	
	private void borrarPregunta() {
		view.getBorrarPreguntas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							model.borrarPregunta(iddepregunta);
							view.ReCargarTablas();
							view.getTablePreguntas().addMouseListener(ListenertablaPreguntas);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
						
			}
		});
	}

	
	private void borrarRespuesta() {
		view.getBorrarRespuestas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							model.borrarRespuesta(idderespuesta);
							view.ReCargarTablas();
							view.getTableRespuestas().addMouseListener(ListenertablaRespuestas);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
						
			}
		});
	}
	
	
	private void modificarPregunta() {
		view.getModificarPregunta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							model.updatePreguntas(mipregunta,iddepregunta);
							view.ReCargarTablas();
							view.getTablePreguntas().addMouseListener(ListenertablaPreguntas);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	
			}
		});
	}

}