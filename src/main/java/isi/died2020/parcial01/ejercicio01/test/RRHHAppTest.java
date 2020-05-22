package isi.died2020.parcial01.ejercicio01.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import isi.died2020.parcial01.ejercicio01.Empleado;
import isi.died2020.parcial01.ejercicio01.Gasto;
import isi.died2020.parcial01.ejercicio01.Operario;
import isi.died2020.parcial01.ejercicio01.RRHHApp;
import isi.died2020.parcial01.ejercicio01.ReciboDeSueldo;
import isi.died2020.parcial01.ejercicio01.Venta;
import isi.died2020.parcial01.ejercicio01.Viajante;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

public class RRHHAppTest {
	private List<Empleado> empleados;

	@Before
	public void setUp() {
		Gasto gasto1 = new Gasto(1, "test", 100);
		Gasto gasto2 = new Gasto(1, "test", 200);
		Gasto gasto3 = new Gasto(1, "test", 1000);
		Venta venta1 = new Venta(1000);
		Venta venta2 = new Venta(100);
		Venta venta3 = new Venta(10);
		List<Gasto> gastos1 = new ArrayList<Gasto>();
		gastos1.add(gasto1);
		gastos1.add(gasto3);
		List<Gasto> gastos2 = new ArrayList<Gasto>();
		gastos2.add(gasto1);
		gastos2.add(gasto2);
		List<Venta> ventas1 = new ArrayList<Venta>();
		List<Venta> ventas2 = new ArrayList<Venta>();
		ventas1.add(venta1);
		ventas1.add(venta3);
		ventas2.add(venta2);
		Viajante viajante1 = new Viajante(1, "juan", "perez", 500, gastos1, ventas1);
		Viajante viajante2 = new Viajante(2, "tomas", "onur", 500, gastos1, ventas2);
		Viajante viajante3 = new Viajante(3, "judith", "elsa", 1000, gastos2, ventas2);

		List<Viajante> viajantes = new ArrayList<Viajante>();
		viajantes.add(viajante1);
		viajantes.add(viajante2);
		viajantes.add(viajante3);
		
		Operario operario = new Operario(1,"roberto", "maidana", 1000, viajantes);
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.addAll(viajantes);
		empleados.add(operario);
		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		List<ReciboDeSueldo> recibos = RRHHApp.liquidar(empleados, LocalDate.now().getMonth());
		assertEquals(500 + 250 + 100 + 0.15*100 , recibos.get(0).getTotalPago());
		
	}

}
