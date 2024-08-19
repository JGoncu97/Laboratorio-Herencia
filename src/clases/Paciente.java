package clases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Paciente extends Persona {
	private int numHistoria;
	private String sexo;
	private String grupoSanguineo;
	private ArrayList<String> listaMedicamentos;
	/**
	* @return the numHistoria
	*/
	public int getNumHistoria() {
	return numHistoria;
	}
	/**
	* @param numHistoria the numHistoria to set
	*/
	public void setNumHistoria(int numHistoria) {
	this.numHistoria = numHistoria;
	}
	/**
	* @return the sexo
	*/
	public String getSexo() {
	return sexo;
	}
	/**
	* @param sexo the sexo to set
	*/
	public void setSexo(String sexo) {
		this.sexo = sexo;
		}
		/**
		* @return the grupoSanguineo
		*/
		public String getGrupoSanguineo() {
		return grupoSanguineo;
		}
		/**
		* @param grupoSanguineo the grupoSanguineo to set
		*/
		public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
		}
		/**
		* @return the listaMedicamentos
		*/
		public ArrayList<String> getListaMedicamentos() {
		return listaMedicamentos;
		}
		/**
		* @param listaMedicamentos the listaMedicamentos to set
		*/
		public void setListaMedicamentos(ArrayList<String> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
		}
		
		@Override
		public void registrarDatos() {
			//Llamamos al metodo para registrar datos de la SuperClase para continuar llenando los datos del paciente junto con los heredados 
			super.registrarDatos();
			
			//Llenamos los datos especificos del paciente
			listaMedicamentos=new ArrayList<String>();
			try {
			    numHistoria = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la historia de la clinica"));
			} catch (NumberFormatException e) {
			    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
			}
			sexo=JOptionPane.showInputDialog("Ingrese el sexo");
			grupoSanguineo=JOptionPane.showInputDialog("Ingrese el grupo sanguineo");
			
			String pregunta=JOptionPane.showInputDialog("¿Es usted es alergico a algun medicamento?");
			
				if(pregunta.equalsIgnoreCase("si")) {
					String medicamento="";
					String continuar="";
					do {
						medicamento=JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alergico");
						listaMedicamentos.add(medicamento);
						
					}while(continuar.equalsIgnoreCase("si"));
				}
				
		}
		
		@Override
		public void imprimirDatosPersona(String datos) {
			super.imprimirDatosPersona(datos);
			
			datos="Numero Historia clinica: "+ numHistoria+"\n";
			datos+="Sexo :"+sexo+"\n";
			datos+="Grupo Sanguineo :"+grupoSanguineo+"\n";
				
				if(listaMedicamentos.size()>0) {
					datos+="Lista de medicamentos a los que es alergico\n";
					for(int i= 0;i<listaMedicamentos.size();i++) {
						datos+="\t"+listaMedicamentos.get(i)+"\n";
					}
				}else {
					datos+="El paciente, no es alergico a ningun medicamento";
				}
			
				System.out.println(datos);
		}
			
}
		
		

