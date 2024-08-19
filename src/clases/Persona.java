package clases;

import javax.swing.JOptionPane;

public class Persona {
	// Atributo que almacena el DNI de la persona.
	private String dni;
	// Atributo que almacena el nombre de la persona.
	private String nombre;
	// Atributo que almacena el apellido de la persona
	private String apellido;
	// Atributo que almacena la fecha de nacimiento de la persona.
	private String fechaNacimiento;
	// Atributo que almacena la dirección de la persona.
	private String direccion;
	private String ciudad;
	
	
	/*
	 * @return the dni
	 * */
	public String getDni() {
		
		return dni;
	}
	
	/*
	 * @params dni the  dni to set
	 * */
	public void setDni(String dni) {
		this.dni=dni;
	}
	
	/*
	 * @return the nombre
	 * */
	
	public String getNombre() {
		return nombre;
	}
	
	/*
	 * @param nombre the nombre to set
	 * */
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	/*
	 * return apellido
	 * */
	public String getApellido() {
		return apellido;
	}
	
	/*
	 * @param apellido the apellido to set
	 * */
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	
	/*
	 * @return the FechaNacimiento
	 * */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	/*
	 * @params fecha de nacimiento the fechaNacimiento to set 
	 * */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento=fechaNacimiento;
	}
	/*
	 * @return the direccion
	 * */
	public String getDireccion() {
		return direccion;
	}
	/*
	 * @params direccion the direccion to set 
	 * */
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	/*
	 * @return the ciudad
	 * */
	public String ciudad() {
		return ciudad;
	}
	/*
	 * @params ciudad the ciudad to set
	 * **/
	public void setCiudad(String ciudad) {
		this.ciudad=ciudad;
	}
	
	public void imprimirDatosPersona(String datos) {
		
			datos+="Documento ="+dni+ "\n";
			datos+="Nombre ="+nombre+"\n";
			datos+="Apellido ="+apellido+" \n";
			datos+="Fecha de Nacimiento ="+fechaNacimiento+"\n";
			datos+="Direccion ="+direccion+"\n";
			datos+="Ciudad de Origen ="+ciudad+"\n";
			
			System.out.println(datos);
	}
	
	public void registrarDatos() {
		boolean validacionDni=false;
		
		while(!validacionDni) {
			try {
				 String inputDni = JOptionPane.showInputDialog("Ingrese el número de documento (solo números):");
		            if (inputDni == null) {
		                return;
		            }
		           
		            Integer.parseInt(inputDni);
		            dni = inputDni; 
		            validacionDni = true;
				
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El Documento debe ser un número. Por favor, intente de nuevo.");
			}
		}
		
		
		nombre=JOptionPane.showInputDialog("Ingrese el nombre");
		apellido=JOptionPane.showInputDialog("Ingrese el apellido");
		fechaNacimiento=JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (dd/mm/aa)");
		direccion=JOptionPane.showInputDialog("Ingrese la direccion");
		ciudad=JOptionPane.showInputDialog("Ingrese la ciudad de Procedencia");
	}
	
	
}	
