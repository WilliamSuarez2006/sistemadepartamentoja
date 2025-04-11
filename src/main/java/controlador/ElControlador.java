package controlador;

import modelo.Departamento;
import modelo.Asignatura;
import modelo.Asistencia;
import modelo.Estudiante;
import java.util.ArrayList;

public class ElControlador {
    private Departamento departamento = null;

    public ElControlador() {
        departamento = Departamento.singleton();
    }

    public String crearDepartamento(String nombre) {
        departamento.setNombre(nombre);
        return "Departamento creado: " + nombre;
    }

    public String consultarNombreDepartamento() {
        return departamento.getNombre();
    }

    public String modificarNombreDepartamento(String nombre) {
        departamento.setNombre(nombre);
        return "Nombre actualizado: " + nombre;
    }

    public String adicionarAsignatura(String codigo, String nombre,String seccion, String semestre,  String creditos) {
        boolean res = departamento.adicionarAsignatura(codigo, nombre,seccion, semestre,  creditos);
        return res ? "Asignatura agregada exitosamente." : "Error al agregar asignatura.";
    }

    public String consultarAsignatura(String codigo, String seccion, String semestre) {
        Asignatura asig = departamento.consultarAsignatura(codigo, seccion, semestre);
        return asig != null ? "Nombre: " + asig.getNombre() + ", Creditos: " + asig.getCreditos() : "Asignatura no encontrada.";
    }

    public String actualizarAsignatura(String codigo, String seccion, String semestre, String nombre, String creditos) {
        boolean res = departamento.actualizarAsignatura(codigo, seccion, semestre, nombre, creditos);
        return res ? "Asignatura actualizada." : "Error al actualizar.";
    }
    public String registrarEstudianteDepartamento(String numDoc, String tipoDoc, String nombre) {
        boolean resultado = departamento.registrarEstudianteDepartamento(numDoc, tipoDoc, nombre);
        return resultado ? "Estudiante registrado exitosamente"
                : "Error: Estudiante ya existe o datos inválidos";
    }

    public String registrarEstudianteEnAsignatura(String numDoc, String tipoDoc, String semestre,
                                                  String codAsig, String seccion) {
        Estudiante estudiante = departamento.consultarEstudianteDepartamento(numDoc, tipoDoc);
        if (estudiante == null) {
            return "Error: Estudiante no registrado en el departamento";
        }

        Asignatura asignatura = departamento.consultarAsignatura(codAsig, seccion, semestre);
        if (asignatura == null) {
            return "Error: Asignatura no encontrada";
        }

        boolean resultado = asignatura.adicionarEstudiante(estudiante.getDocumento(), estudiante.getTdocumento(), estudiante.getNomb());
        return resultado ? "Estudiante registrado en asignatura exitosamente"
                : "Error al registrar en asignatura";
    }

    public String crearListaAsistenciaVacia(String codAsig, String seccion, String semestre,
                                            String fecha, String horaIni, String horaFin) {
        Asignatura asignatura = departamento.consultarAsignatura(codAsig, seccion, semestre);
        if (asignatura == null) {
            return "Error: Asignatura no encontrada.";
        }

        ArrayList<String> idsEstudiantes = new ArrayList<>();
        ArrayList<String> estados = new ArrayList<>();
        for (Estudiante e : asignatura.getEstudiantes()) {
            idsEstudiantes.add(e.getDocumento());
            estados.add("2");
        }

        boolean res = asignatura.adicionaAsistencia(fecha, horaIni, horaFin, idsEstudiantes, estados);
        return res ? "Lista de asistencia creada con los estudiantes ausentes por el sistenma."
                : "Error al crear lista de asistencia.";
    }
    public String consultarEstudianteDepartamento(String numDoc, String tipoDoc) {
        Estudiante estudiante = departamento.consultarEstudianteDepartamento(numDoc, tipoDoc);
        if (estudiante == null) {
            return "Estudiante no encontrado";
        }
        return "Estudiante: " + estudiante.getNomb() +
                "\nTipo Doc: " + estudiante.getTdocumento() +
                "\nNúmero Doc: " + estudiante.getDocumento();
    }

    public String modificarEstudianteDepartamento(String numDoc, String tipoDocActual,
                                                  String tipoDocNuevo, String nombresNuevos) {
        boolean resultado = departamento.modificarEstudianteDepartamento(
                numDoc, tipoDocActual, tipoDocNuevo, nombresNuevos);
        return resultado ? "Estudiante modificado exitosamente"
                : "Error: Estudiante no encontrado";
    }

    public String consultarEstudiantesAsignatura(String codAsig, String semestre, String seccion) {
        Asignatura asignatura = departamento.consultarAsignatura(codAsig, seccion, semestre);
        if (asignatura == null) {
            return "Asignatura no encontrada";
        }

        StringBuilder resultado = new StringBuilder("Estudiantes inscritos:\n");
        for (Estudiante e : asignatura.getEstudiantes()) {
            resultado.append(e.getNomb())
                    .append(" - ").append(e.getTdocumento())
                    .append(": ").append(e.getDocumento())
                    .append("\n");
        }
        return resultado.toString();
    }
    public String llenarAsistencia(String codAsig, String semestre, String seccion,
                                   String fecha, String horaInicial, String horaFinal) {
        Asignatura asignatura = departamento.consultarAsignatura(codAsig, seccion, semestre);
        if (asignatura == null) {
            return "Error: Asignatura no encontrada.";
        }

        Asistencia asistencia = asignatura.consultaAsistencia(fecha, horaInicial, horaFinal);
        if (asistencia == null) {
            return "Error: No hay lista de asistencia para esta fecha/hora.";
        }

        ArrayList<Estudiante> estudiantes = asignatura.getEstudiantes();
        if (estudiantes.isEmpty()) {
            return "Error: No hay estudiantes inscritos en esta asignatura.";
        }
        return "INICIAR_LLENADO_ASISTENCIA:" + codAsig + ":" + seccion + ":" + semestre + ":" + fecha + ":" + horaInicial + ":" + horaFinal;
    }

    public String procesarEstudianteAsistencia(String codAsig, String seccion, String semestre,
                                               String fecha, String horaInicial, String horaFinal,
                                               String numDoc, String estado) {
        Asignatura asignatura = departamento.consultarAsignatura(codAsig, seccion, semestre);
        if (asignatura == null) {
            return "Error: Asignatura no encontrada.";
        }

        Asistencia asistencia = asignatura.consultaAsistencia(fecha, horaInicial, horaFinal);
        if (asistencia == null) {
            return "Error: No hay lista de asistencia para esta fecha/hora.";
        }

        boolean resultado = asistencia.modificarAsistencia(numDoc, estado);
        return resultado ? "ESTADO_ACTUALIZADO" : "Error: No se pudo actualizar el estado.";
    }

    public String obtenerSiguienteEstudiante(String codAsig, String seccion, String semestre,
                                             String fecha, String horaIni, String horaFin,
                                             int indiceActual) {
        Asignatura asignatura = departamento.consultarAsignatura(codAsig, seccion, semestre);
        if (asignatura == null) {
            return "FIN:Asignatura no encontrada";
        }

        ArrayList<Estudiante> estudiantes = asignatura.getEstudiantes();
        if (indiceActual >= estudiantes.size()) {
            return "FIN:Todos los estudiantes procesados";
        }

        Estudiante estudiante = estudiantes.get(indiceActual);
        return "ESTUDIANTE:" + estudiante.getDocumento() + ":" + estudiante.getTdocumento() + ":" + estudiante.getNomb();
    }

    public String mostrarAsistencia(String codAsig, String semestre, String seccion,
                                    String fecha, String horaIni, String horaFin) {
        Asignatura asignatura = departamento.consultarAsignatura(codAsig, seccion, semestre);
        if (asignatura == null) {
            return "Error: Asignatura no encontrada";
        }

        Asistencia asistencia = asignatura.consultaAsistencia(fecha, horaIni, horaFin);
        if (asistencia == null) {
            return "No se encontró registro de asistencia";
        }

        StringBuilder resultado = new StringBuilder("Registro de asistencia:\n");
        for (int i = 0; i < asistencia.getCodigos().size(); i++) {
            Estudiante e = asignatura.consultarEstudiante(asistencia.getCodigos().get(i));
            String estado = asistencia.getEstados().get(i).equals("0") ? "Asistió" :
                    asistencia.getEstados().get(i).equals("1") ? "Tarde" : "Ausente";

            resultado.append(e.getNomb())
                    .append(" (").append(e.getTdocumento()).append(": ").append(e.getDocumento()).append(")")
                    .append(" - ").append(estado)
                    .append("\n");
        }
        return resultado.toString();
    }
    public String modificarAsistencia(String codAsig, String seccion, String semestre,
                                      String fecha, String horaIni, String horaFin,
                                      String numDoc, String tipoDoc, String estado) {
        Asignatura asignatura = departamento.consultarAsignatura(codAsig, seccion, semestre);
        if (asignatura == null) {
            return "Error: Asignatura no encontrada";
        }

        Asistencia asistencia = asignatura.consultaAsistencia(fecha, horaIni, horaFin);
        if (asistencia == null) {
            return "Error: No existe un registro de asistencia para la fecha/hora";
        }

        Estudiante estudiante = departamento.consultarEstudianteDepartamento(numDoc, tipoDoc);
        if (estudiante == null) {
            return "Error: Estudiante no encontrado";
        }

        boolean resultado = asistencia.modificarAsistencia(estudiante.getDocumento(), estado);
        return resultado ? "Asistencia actualizada correctamente"
                : "Error al actualizar asistencia";
    }
}




