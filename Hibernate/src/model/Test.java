package model;

// Generated 18-feb-2015 17:40:19 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Test generated by hbm2java
 */
public class Test implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private Integer casilla;
	private Float puntuacion;
	private Integer monedas;
	private Integer diamantes;
	private Float experiencia;
	private Date fecha;

	public Test() {
	}

	public Test(String nombre, Integer casilla, Float puntuacion,
			Integer monedas, Integer diamantes, Float experiencia, Date fecha) {
		this.nombre = nombre;
		this.casilla = casilla;
		this.puntuacion = puntuacion;
		this.monedas = monedas;
		this.diamantes = diamantes;
		this.experiencia = experiencia;
		this.fecha = fecha;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCasilla() {
		return this.casilla;
	}

	public void setCasilla(Integer casilla) {
		this.casilla = casilla;
	}

	public Float getPuntuacion() {
		return this.puntuacion;
	}

	public void setPuntuacion(Float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Integer getMonedas() {
		return this.monedas;
	}

	public void setMonedas(Integer monedas) {
		this.monedas = monedas;
	}

	public Integer getDiamantes() {
		return this.diamantes;
	}

	public void setDiamantes(Integer diamantes) {
		this.diamantes = diamantes;
	}

	public Float getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(Float experiencia) {
		this.experiencia = experiencia;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
