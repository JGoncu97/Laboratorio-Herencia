package clase.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado{
	private double honorariosHora;
	private String fechaTerminoContrato;
	/**
	* @return the honorariosHora
	*/
	public double getHonorariosHora() {
		return honorariosHora;
	}
	/**
	* @param honorariosHora the honorariosHora to set
	*/
	public void setHonorariosHora(double honorariosHora) {
		this.honorariosHora=honorariosHora;
	}
	/**
	* @return the fechaTerminoContrato
	*/
	public String getFechaTerminoContracto() {
		return fechaTerminoContrato;
	}
	/**
	* @param fechaTerminoContrato the fechaTerminoContrato to set
	*/
	public void setFechaTerminoContracto(String fechaTerminoContrato) {
		this.fechaTerminoContrato=fechaTerminoContrato;
	}
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		honorariosHora=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
		fechaTerminoContrato=JOptionPane.showInputDialog("Ingrese la fecha de termino de contrato (dd/mm/aa");
		
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Codigo de Empleado :"+honorariosHora+"\n";
		datos+="Fecha de termino de contrato :"+ fechaTerminoContrato+"\n";
		
		System.out.println(datos);
	}
}
