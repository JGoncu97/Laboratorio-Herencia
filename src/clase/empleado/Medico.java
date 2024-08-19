package clase.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla{
	private String especialidad;
	private int numConsultorio;
	/**
	* @return the especialidad
	*/
	public String getEspecialidad() {
		return especialidad;
	}
	/**
	* @param especialidad the especialidad to set
	*/
	public void setEspecialidad(String especialidad) {
		this.especialidad=especialidad;
	}
	/**
	* @return the numConsultorio
	*/
	public int getNumConsultoria() {
		return numConsultorio;
	}
	/**
	* @param numConsultorio the numConsultorio to set
	*/
	public void setNumConsultorio(int numConsultorio) {
		this.numConsultorio=numConsultorio;
	}
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		especialidad=JOptionPane.showInputDialog("Ingrese su especialidad");
		numConsultorio=Integer.parseInt(JOptionPane.showInputDialog("¿Cual es el numero de consultorio?"));
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Especialidad :"+especialidad+"\n";
		datos+="Numero Consultorio :"+numConsultorio+"\n";
		
		System.out.println(datos);
	}
	

}
