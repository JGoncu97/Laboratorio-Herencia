package logica;


import javax.swing.JOptionPane;

import clase.empleado.EmpleadoEventual;
import clase.empleado.EmpleadoPlanilla;
import clase.empleado.Medico;
import clases.ModeloDatos;
import clases.Paciente;
import hospital.CitaMedica;

public class Procesos {
    
    ModeloDatos miModeloDatos;
    
    public Procesos() {
        miModeloDatos = new ModeloDatos();
        presentarMenuOpciones();
    }
    
    private void presentarMenuOpciones() {
        String menu = "Menu Hospital \n\n";
        menu += "1. Registrar Pacientes\n";
        menu += "2. Registrar Empleado\n";
        menu += "3. Registrar Cita Medica\n";
        menu += "4. Imprimir Informacion\n";
        menu += "5. Consultar Datos\n";
        menu += "6. Salir\n\n";
        menu += "Ingrese una Opción\n";
        
        int opcion = 0;
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una opción válida.");
                continue;
            }
            switch (opcion) {
                case 1: 
                	
                	registrarPaciente(); 
                	break;
                case 2: registrarEmpleado(); 
                	break;
                case 3: registrarCitaMedica(); 
                	break;
                case 4: imprimirInformacion(); 
                	break;
                case 5: consultarDatos(); 
                	break;
                case 6: System.out.println("El sistema ha terminado!"); 
                	break;
                default: System.out.println("No existe el código, verifique nuevamente"); 
                	break;
            }
        } while (opcion != 6);
    }

    private void imprimirInformacion() {
        String menuImprimir = "Menu Impresiones\n\n";
        menuImprimir += "1. Listar Pacientes\n";
        menuImprimir += "2. Listar Empleados Eventuales\n";
        menuImprimir += "3. Listar Empleados por Planilla\n";
        menuImprimir += "4. Listar Médicos\n";
        menuImprimir += "5. Listar Citas Programadas\n";
        menuImprimir += "6. Regresar al Menú Principal\n";
        menuImprimir += "Ingrese una opción\n\n";

        int opcion = 0;
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una opción válida.");
                continue;
            }
            switch (opcion) {
                case 1: miModeloDatos.imprimirPacientes(); 
                	break;
                case 2: miModeloDatos.imprimirEmpleadosEventuales(); 
                	break;
                case 3: miModeloDatos.imprimirEmpleadosPlanilla(); 
                	break;
                case 4: miModeloDatos.imprimirMedico(); 
                	break;
                case 5: miModeloDatos.imprimirCitasMedicasProgramadas(); 
                	break;
                case 6: return;
                default:
                	JOptionPane.showMessageDialog(null, "Opción no válida.");
                	break;
            }
        } while (opcion != 6);
    }

    private void registrarEmpleado() {
        String menuTipoEmpleado = "Registro de empleado\n";
        menuTipoEmpleado += "1. Empleado Eventual\n";
        menuTipoEmpleado += "2. Empleado por Planilla\n";
        menuTipoEmpleado += "Seleccione el tipo de empleado a registrar\n\n";
        
        int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
        
        switch (tipoEmpleado) {
            case 1: 
                EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
                miEmpleadoEventual.registrarDatos();
                miModeloDatos.registrarPersona(miEmpleadoEventual);
                break;
            case 2:
                String resp = JOptionPane.showInputDialog("Ingrese 'si' si es un médico, de lo contrario es otro tipo de empleado");
                if (resp.equalsIgnoreCase("si")) {
                    
                    Medico miMedico = new Medico();
                    miMedico.registrarDatos();
                    miModeloDatos.registrarPersona(miMedico);
                } else {
                    
                    EmpleadoPlanilla miEmpleadoPlanilla = new EmpleadoPlanilla();
                    miEmpleadoPlanilla.registrarDatos();
                    miModeloDatos.registrarPersona(miEmpleadoPlanilla);
                }
                break;
            default: System.out.println("El tipo de empleado no es válido, intente nuevamente"); break;
        }
    }

    private void registrarPaciente() {
        Paciente miPaciente = new Paciente();
        miPaciente.registrarDatos();
        miModeloDatos.registrarPersona(miPaciente);
    }

    private void registrarCitaMedica() {
        String dniPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente");
        Paciente pacienteEncontrado = miModeloDatos.consultarPacienteDocumento(dniPaciente);
        
        if (pacienteEncontrado != null) {
            String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico");
            Medico medicoEncontrado = miModeloDatos.consultarMedicoNombre(nombreMedico);
            if (medicoEncontrado != null) {
                String servicio = JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
                String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
                String hora = JOptionPane.showInputDialog("Ingrese la hora de la consulta");
                
                String lugar = "La cita será en el consultorio " + medicoEncontrado.getNumConsultoria();
                CitaMedica miCita = new CitaMedica(pacienteEncontrado, medicoEncontrado, servicio, fecha, hora, lugar);
                miModeloDatos.registrarCitaMedica(miCita);
            } else {
                System.out.println("El médico no se encuentra registrado en el sistema");
            }
        } else {
            System.out.println("El paciente no se encuentra registrado en el sistema");
        }
    }

    private void consultarDatos() {
        String menuConsulta = "Menu Consultas\n\n";
        menuConsulta += "1. Consultar Paciente por Documento\n";
        menuConsulta += "2. Consultar Empleado Eventual por DNI\n";
        menuConsulta += "3. Consultar Empleado por Planilla por DNI\n";
        menuConsulta += "4. Consultar Médico por DNI\n";
        menuConsulta += "5. Consultar Médico por Nombre\n";
        menuConsulta += "6. Regresar al Menú Principal\n";
        menuConsulta += "Ingrese una opción\n\n";

        int opcion = 0;
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menuConsulta));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una opción válida.");
                continue;
            }
            switch (opcion) {
                case 1:
                    String dniPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente");
                    Paciente paciente = miModeloDatos.consultarPacienteDocumento(dniPaciente);
	                    if (paciente != null) {
	                        paciente.imprimirDatosPersona("");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Paciente no encontrado.");
	                    }
                    break;
                case 2:
                    String dniEmpleadoEventual = JOptionPane.showInputDialog("Ingrese el documento del empleado eventual");
                    EmpleadoEventual empleadoEventual = miModeloDatos.consultarEmpleadoV(dniEmpleadoEventual);
	                    if (empleadoEventual != null) {
	                        empleadoEventual.imprimirDatosPersona("");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Empleado Eventual no encontrado.");
	                    }
                    break;
                case 3:
                    String dniEmpleadoPlanilla = JOptionPane.showInputDialog("Ingrese el documento del empleado por planilla");
                    EmpleadoPlanilla empleadoPlanilla = miModeloDatos.consultarEmpleadoP(dniEmpleadoPlanilla);
	                    if (empleadoPlanilla != null) {
	                        empleadoPlanilla.imprimirDatosPersona("");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Empleado por Planilla no encontrado.");
	                    }
                    break;
                case 4:
                    String dniMedico = JOptionPane.showInputDialog("Ingrese el documento del médico");
                    Medico medico = miModeloDatos.consultarMedicoDni(dniMedico);
	                    if (medico != null) {
	                        medico.imprimirDatosPersona("");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Médico no encontrado.");
	                    }
                    break;
                case 5:
                    String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico");
                    Medico medicoPorNombre = miModeloDatos.consultarMedicoNombre(nombreMedico);
	                    if (medicoPorNombre != null) {
	                        medicoPorNombre.imprimirDatosPersona("");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Médico no encontrado.");
	                    }
                    break;
                case 6:
                    return; 
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (opcion != 6);
        
    }
}
