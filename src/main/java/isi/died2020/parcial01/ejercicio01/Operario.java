package isi.died2020.parcial01.ejercicio01;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Operario extends Empleado {
	
	List<Viajante> viajantesQueAtiende;

	public Operario(int cuil, String nombre, String apellido, double sueldoBasico, List<Viajante> viajantesQueAtiende) {
		super(cuil, nombre, apellido, sueldoBasico);
		this.viajantesQueAtiende=viajantesQueAtiende;
		// TODO Auto-generated constructor stub
	}
	
	public double calcularSueldo(Month month){
		double comisiones = 0.05 * this.viajantesQueAtiende.stream()
				.flatMap(viajante->viajante.getVentas().stream())
				.filter(v->v.getFechaVenta().getMonth()==month)
				.mapToDouble(v->v.getTotalVenta())
				.sum();
		return this.sueldoBasico + comisiones;
		
	}
}
