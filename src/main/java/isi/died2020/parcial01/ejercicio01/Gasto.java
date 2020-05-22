package isi.died2020.parcial01.ejercicio01;

public class Gasto {
	private int nroComprobante;
	private String descripcion;
	private double totalGasto;
	
	public Gasto(int nroComprobante, String descripcion, double totalGasto) {
		// TODO Auto-generated constructor stub
		this.nroComprobante=nroComprobante;
		this.descripcion=descripcion;
		this.totalGasto=totalGasto;
	}
	
	
	
	double getTotalGasto() {
		return this.totalGasto;
	}

}
