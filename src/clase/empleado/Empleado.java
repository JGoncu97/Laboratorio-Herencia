package clase.empleado;

import javax.swing.JOptionPane;

import clases.Persona;

public class Empleado extends Persona {
	private String codEmpleado;
	private int numHorasExtras;
	private String fechaIngreso;
	private String area;
	private String cargo;
	
	/**
	 * @return the codEmpleado
	 * */
	public String getCodEmpleado() {
		return codEmpleado;
	}
	
	/*
	 * @param codEmpleado the codEmpleado to set 
	 * */
	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado=codEmpleado;
	}
	/*
	 * @return the numHorasExtras
	 * */
	public int getNumHorasExtras() {
		return numHorasExtras;
	}
	/*
	 * @param numHorasExtras the numHorasExtras to set
	 * */
	public void setNumHorasExtras(int numHorasExtras) {
		this.numHorasExtras=numHorasExtras;
	}
	/*
	 * @return the fechaIngreso
	 * */
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	/*
	 * @params fechaIngreso the fechaIngreso to set
	 * */
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso=fechaIngreso;
	}
	/**
	* @return the area
	*/
	public String getArea() {
		return area;
	}
	/**
	* @param area the area to set
	*/
	public void setArea(String area) {
		this.area = area;
	}
	/*
	 * @return the cargo
	 * */
	public String getCargo() {
		return cargo;
	}
	/*
	 * @param cargo the cargo to set
	 * */
	public void setCargo(String cargo) {
		this.cargo=cargo;
	}
	
	
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		codEmpleado=JOptionPane.showInputDialog("Ingrese el codigo del empleado");
		numHorasExtras=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de horas extras"));
		fechaIngreso=JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/mm/aa)");
	 	area=JOptionPane.showInputDialog("Ingrese el area");
		cargo=JOptionPane.showInputDialog("Ingrese el cargo");
		
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		System.out.println("\n");
		
		datos="Codigo Empleado :"+codEmpleado+"\n";
		datos+="Numero de Horas Extras :"+numHorasExtras+"\n";
		datos+="Fecha de ingreso :"+fechaIngreso+"\n";
		datos+="Area :"+area+"\n";
		datos+="Cargo :"+cargo+"\n";
		
		System.out.println(datos);
	}
	
}
