package isi.died2020.parcial01.ejercicio01;

import java.time.LocalDate;

public class Venta {
	private LocalDate fechaVenta;
	private double totalVenta;
	public Venta(double totalVenta) {
		// TODO Auto-generated constructor stub
		this.totalVenta=totalVenta;
		this.fechaVenta=LocalDate.now();
	}
	public LocalDate getFechaVenta() {
		return this.fechaVenta;
	}
	public double getTotalVenta() {
		return this.totalVenta;
	}
}
