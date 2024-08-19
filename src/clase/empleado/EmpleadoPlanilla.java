package clase.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado{
	private double salarioMensual;
	private double porcentajeAdicional;
	/*
	 * @return salarioMensual
	 * */
	public double getSalarioMensual() {
		return salarioMensual;
	}
	/*
	 *@param salarioMensual the salarioMensual to set 
	 * */
	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual=salarioMensual;
	}
	/*
	 * @return the porcentajeAdicional
	 * */
	public double getPorcentajeAdicional() {
		return porcentajeAdicional;
	}
	/*
	 * @param porcentajeAdicional the porcentajeAdicional to set
	 * */
	public void setPorcentajeAdicional(double porcentajeAdicional) {
		this.porcentajeAdicional=porcentajeAdicional;
	}
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		salarioMensual=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
		porcentajeAdicional=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje adicional por Horas extras"));
		
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Salario Mensual :"+ salarioMensual+"\n";
		datos+="Porcentaje Adicional por Horas Extra :"+porcentajeAdicional+"\n";
		
		System.out.println(datos);
	}
	
}
