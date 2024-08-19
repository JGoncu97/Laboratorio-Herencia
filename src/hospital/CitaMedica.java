package hospital;

import clase.empleado.Medico;
import clases.Paciente;

public class CitaMedica {
	// Atributo que representa el tipo de servicio que se prestará en la cita médica.
	private String servicio;
	// Atributo que almacena la información del paciente que asistirá a la cita.
	private Paciente paciente;
	// Atributo que almacena la información del médico que atenderá la cita.
	private Medico medico;
	// Atributo que representa la fecha en que se llevará a cabo la cita.
	private String fecha;
	// Atributo que representa la hora en que se llevará a cabo la cita.
	private String hora;
	
	private String lugar;
	
	public CitaMedica(Paciente paciente, Medico medico, String servicio, String fecha, String hora, String lugar) {
		
		this.paciente=paciente;
		this.medico=medico;
		this.servicio=servicio;
		this.fecha=fecha;
		this.hora=hora;
		this.lugar=lugar;
	}
	
	public String informacionCitaMedica() {
		String datosCita="<< Información  Cita Medica >>\n";
		datosCita+="Paciente :"+paciente.getNombre()+"\n";
		datosCita+="Medico :"+medico.getNombre()+"\n";
		datosCita+="Motivo consulta :"+servicio+"\n";
		datosCita+="Fecha Consulta :"+fecha+"\n";
		datosCita+="Hora :"+hora+"\n";
		datosCita+="Lugar :"+lugar+"\n";
		
		return datosCita;
	}
	/**
	 *  Método getter para obtener el servicio médico de la cita.
	* @return the servicio
	*/
	public String getServicio() {
	return servicio;
	}
	/**
	 *  Método setter para establecer el servicio médico de la cita.
	* @param servicio the servicio to set
	*/
	public void setServicio(String servicio) {
		this.servicio = servicio;
		}
		/**
		 * Método getter para obtener la información del paciente asignado a la cita.
		* @return the paciente
		*/
		public Paciente getPaciente() {
		return paciente;
		}
		/**
		 *  Método setter para establecer el paciente asignado a la cita.
		* @param paciente the paciente to set
		*/
		public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
		}
		/**
		 * Método getter para obtener la información del médico que atenderá la cita.
		* @return the medico
		*/
		public Medico getMedico() {
		return medico;
		}
		/**
		 * Método setter para establecer el médico que atenderá la cita.
		* @param medico the medico to set
		*/
		public void setMedico(Medico medico) {
		this.medico = medico;
		}
		/**
		 *  Método getter para obtener la fecha de la cita.
		* @return the fecha
		*/
		public String getFecha() {
		return fecha;
		}
		/**
		 *  Método setter para establecer la fecha de la cita.
		* @param fecha the fecha to set
		*/
		public void setFecha(String fecha) {
		this.fecha = fecha;
		}
		/**
		 * Método getter para obtener la hora de la cita.
		* @return the hora
		*/
		public String getHora() {
		return hora;
		}
		/**
		 * Método setter para establecer la hora de la cita.
		* @param hora the hora to set
		*/
		public void setHora(String hora) {
		this.hora = hora;
		}
		/**
		 * @return the lugar
		 */
		public String getLugar() {
			return lugar;
		}
		/**
		 * @param lugar the lugar to set
		 */
		public void setLugar(String lugar) {
			this.lugar = lugar;
		}
		
		
}
