package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import clase.empleado.EmpleadoEventual;
import clase.empleado.EmpleadoPlanilla;
import clase.empleado.Medico;
import hospital.CitaMedica;

public class ModeloDatos {
	HashMap<String, Paciente> pacientesMap;
	HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	HashMap<String, EmpleadoEventual> empleadosEventualMap;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;
	
	public ModeloDatos() {
		pacientesMap= new HashMap<String, Paciente>();
		empleadosPlanillaMap= new HashMap<String,EmpleadoPlanilla>();
		empleadosEventualMap= new HashMap<String, EmpleadoEventual>();
		medicosMap=new HashMap<String, Medico>();
		citasList=new ArrayList<CitaMedica>();
		
	}
	
	public void registrarPersona(Paciente miPaciente) {
		if(pacientesMap.containsKey(miPaciente.getDni())) {
			System.out.println("El paciente con el documento :" + miPaciente.getDni() + " ya está registrado.");
			
		}else {
			pacientesMap.put(miPaciente.getDni(), miPaciente);
			System.out.println("Se ha registrado el Paciente "+ miPaciente.getNombre()+" Satisfactoriamente");
		}

	}
	
	public void registrarPersona(EmpleadoPlanilla miEmpleado) {
		if(empleadosPlanillaMap.containsKey(miEmpleado.getDni())) {
			System.out.println("El empleado de planilla con el documento :"+miEmpleado.getDni()+" ya esta registrado.");
		}else {
			empleadosPlanillaMap.put(miEmpleado.getDni(), miEmpleado);
			System.out.println("Se ha registrado el Empleado por Planilla "+miEmpleado.getNombre()+" Satisfactoriamente");
		}
		
	}
	
	public void registrarPersona(EmpleadoEventual miEmpEvent) {
		if(empleadosEventualMap.containsKey(miEmpEvent.getDni())) {
			System.out.println("El empleado eventual con el documento :"+miEmpEvent.getDni()+" ya esta registrado.");
		}else {
		empleadosEventualMap.put(miEmpEvent.getDni(), miEmpEvent);
		System.out.println("Se ha registrado el Empleado eventual "+ miEmpEvent.getNombre()+" Satisfactoriamente");
		}
	}
	
	public void registrarPersona(Medico miMedico) {
		if(medicosMap.containsKey(miMedico.getDni())) {
			System.out.println("El Medico con el documento :"+miMedico.getDni()+" ya esta registrado.");
		}else {
		medicosMap.put(miMedico.getDni(), miMedico);
		System.out.println("Se ha registrado el Medico "+ miMedico.getNombre()+ " Satisfactoriamente");
		}
	}

	public void imprimirPacientes() {
		
		if(pacientesMap.isEmpty()) {
			System.out.println("No hay pacientes registrados");
		}else {
			String msj="Pacientes Registrados\n";
			Iterator<String> iterador= pacientesMap.keySet().iterator();
			
			while(iterador.hasNext()) {
				String clave = iterador.next();
				pacientesMap.get(clave).imprimirDatosPersona(msj);
			}
		}
		
	}

	public void imprimirEmpleadosEventuales() {
		if(empleadosEventualMap.isEmpty()) {
			
			System.out.println("No hay Empleados Eventuales registrados");
		}else {
		
			String msj="Empleados Eventuales Registrados\n";
			
			for(String clave: empleadosEventualMap.keySet()) {
				empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
			}
		}
		
	}

	public void imprimirEmpleadosPlanilla() {
		if(empleadosPlanillaMap.isEmpty() && medicosMap.isEmpty()) {
			
			System.out.println("No hay Empleados por Planilla, ni medicos registrados");
		}else {
			if(empleadosPlanillaMap.isEmpty()) {
				
				System.out.println("No hay Empleados por Planilla registrados");
			}else {
				String msj="Empleados por Planilla Registrados\n";
				
				for(EmpleadoPlanilla empleadoPlanilla: empleadosPlanillaMap.values()) {
					empleadoPlanilla.imprimirDatosPersona(msj);
				}
				
			}	
			
			if(!medicosMap.isEmpty()) {
				System.out.println("\n Y los medicos registrados son: \n");
				imprimirMedico();
			}else {
				
				System.out.println("\nNo hay Médicos registrados.");
			}
		}
		
		
		
		
	}

	public void imprimirMedico() {
		
		
			String msj="Medicos Registrados\n";
			
			for(Entry<String, Medico> elemento: medicosMap.entrySet()) {
				
				elemento.getValue().imprimirDatosPersona(msj);
			}
		
		
	}
	
	public Paciente consultarPacienteDocumento(String dniPaciente) {
		Paciente miPaciente=null;
		
		if(pacientesMap.containsKey(dniPaciente)) {
			miPaciente=pacientesMap.get(dniPaciente);
		}
		return miPaciente;
	}
	public EmpleadoPlanilla consultarEmpleadoP(String dniEmpleadoP) {
		EmpleadoPlanilla miEmpleadoP=null;
		
		if(empleadosPlanillaMap.containsKey(dniEmpleadoP)) {
			miEmpleadoP=empleadosPlanillaMap.get(dniEmpleadoP);
		}
		return miEmpleadoP;
	}
	
	public EmpleadoEventual consultarEmpleadoV(String dniEmpleadoV) {
		EmpleadoEventual miEmpleadoV=null;
		
		if(empleadosEventualMap.containsKey(dniEmpleadoV)) {
			miEmpleadoV=empleadosEventualMap.get(dniEmpleadoV);
		}
		return miEmpleadoV;
	}
	
	public Medico consultarMedicoDni(String dniMedico) {
		Medico miMedico=null;
		
		if(medicosMap.containsKey(dniMedico)) {
			miMedico=medicosMap.get(dniMedico);
		}
		return miMedico;
	}
	public Medico consultarMedicoNombre(String nombreMedico) {
		
		for(Medico medico: medicosMap.values()) {
			if(medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;//Al retornar automaticamente cierra el ciclo
			}
		}
		//en caso de no encontrarlo retorna null
		return null;
	}
	
	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		
		System.out.println("Se ha registrado la cita exitosamente\n");
		System.out.println(miCita.informacionCitaMedica());
	}

	public void imprimirCitasMedicasProgramadas() {
		String msj="Citas Medicas Programas\n";
		CitaMedica miCita=null;
		
		System.out.println(msj+"\n");
		
		if(citasList.size()>0) {
			for(int i=0;i <citasList.size();i++) {
				miCita=citasList.get(i);
				System.out.println(miCita.informacionCitaMedica());
			}
		}else {
			System.out.println("No existe citas medicas programadas");
		}
		
	}
	
	
	
}
