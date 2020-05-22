package isi.died2020.parcial01.ejercicio01;

import java.time.Month;

public class ReciboDeSueldo {
	
	public static int numeroDisponible = 1;
	
	private int numero;
	private Month mes;
	private double totalPago;
	private Empleado empleado;
	

	public ReciboDeSueldo(int numero, Month mes, double totalPago, Empleado empleado) {
		// TODO Auto-generated constructor stub
		this.numero=numero;
		this.mes=mes;
		this.totalPago=totalPago;
		this.empleado=empleado;
	}
	
	public static int obtenerNumeroParaAsignar() {
		return ReciboDeSueldo.numeroDisponible++;
	}
	
	public double getTotalPago() {
		return this.totalPago;
	}

}
