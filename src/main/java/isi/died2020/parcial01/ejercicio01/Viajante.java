package isi.died2020.parcial01.ejercicio01;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Function;

public class Viajante extends Empleado {
	List<Gasto> gastos;
	List<Venta> ventas;

	public Viajante(int cuil, String nombre, String apellido, double sueldoBasico, List<Gasto> gastos, List<Venta> ventas) {
		super(cuil, nombre, apellido, sueldoBasico);
		this.gastos=gastos;
		this.ventas=ventas;
		// TODO Auto-generated constructor stub
	}
	
	public double calcularSueldo(Month month){
		double reintegroGastos = this.gastos.stream()
			.mapToDouble(g->(g.getTotalGasto()))
			.sum();
		double comisiones = 0.15 * this.ventas.stream()
				.filter(v->v.getFechaVenta().getMonth()==month)
				.mapToDouble(v->v.getTotalVenta())
				.sum();
		return this.sueldoBasico + reintegroGastos + comisiones;
		
	}

	public List<Venta> getVentas(){
		return this.ventas;
	}
}
