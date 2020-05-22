package isi.died2020.parcial01.ejercicio01;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Function;


public abstract class Empleado {
	
	
	protected int cuil;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaIngreso;
	protected double sueldoBasico;
	
	protected abstract double calcularSueldo(Month month);
	
	public LocalDate getFechaIngreso() {
		return this.fechaIngreso;
	}

	public Empleado(int cuil, String nombre, String apellido, double sueldoBasico) {
		// TODO Auto-generated constructor stub
		this.cuil=cuil;
		this.nombre=nombre;
		this.apellido=apellido;
		this.sueldoBasico=sueldoBasico;
		this.fechaIngreso=LocalDate.now();
	}
	
	public double getSueldoBasico() {
		return this.sueldoBasico;
	}

}
