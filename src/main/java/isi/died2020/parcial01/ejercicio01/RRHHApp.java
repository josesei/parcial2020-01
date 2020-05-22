package isi.died2020.parcial01.ejercicio01;

import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;



public class RRHHApp {

	public RRHHApp() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static List<ReciboDeSueldo> liquidar (List<Empleado> listaEmpleados, Month mes){
		return listaEmpleados.stream()
			.map((Empleado e)-> {
				double sueldo = e.calcularSueldo(mes);
				double bonificacion = 0;
				if(mes == e.getFechaIngreso().getMonth()) {
				bonificacion =  sueldo * 0.5;
				}
				
				return new ReciboDeSueldo(ReciboDeSueldo.obtenerNumeroParaAsignar(), mes, sueldo + bonificacion , e);
				})
			.collect(Collectors.toList());
	
	}

}
