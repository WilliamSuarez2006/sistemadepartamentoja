package modelo;

import java.util.ArrayList;

public class Asignatura {
    private String codigo = "";
    private String seccion = "";
    private String semestre = "";
    private String nombre="";
    private String creditos="";
    private ArrayList<Asistencia> asistencias=new ArrayList<Asistencia>();
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public Asignatura() {
        this.codigo = "";
        this.nombre = "";
        this.seccion = "";
        this.semestre = "";
        this.creditos = "";
    }
    public Asignatura(String codigo,String nombre,String seccion,String semestre,String creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.seccion = seccion;
        this.semestre = semestre;
        this.creditos = creditos;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getseccion() {
        return seccion;
    }
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public boolean adicionaAsistencia(String fecha, String horainicial, String horafinal, ArrayList<String> codigos, ArrayList<String> estados){
        Asistencia asistencia=new Asistencia(fecha,horainicial,horafinal);
        for (int vc=0;vc<codigos.size();vc++){
            String codigo=codigos.get(vc);
            String estado=estados.get(vc);
            asistencia.adicionarAsistencia(codigo,estado);
        }
        asistencias.add(asistencia);
        return true;
    }
    public Asistencia consultaAsistencia(String fecha, String horainicial, String horafinal){
        for (int vc=0;vc<asistencias.size();vc++){
            if(asistencias.get(vc).getFecha().equalsIgnoreCase(fecha) &&
                    asistencias.get(vc).getHorainicial().equalsIgnoreCase(horainicial) &&
                    asistencias.get(vc).getHorafinal().equalsIgnoreCase(horafinal)){
                return asistencias.get(vc);
            }
        }
        return null;
    }
    public boolean modificaAsistencia(String fecha, String horainicial, String horafinal, String fechan,String horainicialn,
                                      String horafinaln,ArrayList<String> codigos, ArrayList<String> estados){
        Asistencia laasistencia=this.consultaAsistencia(fecha,horainicial,horafinal);
        if (laasistencia!=null){
            laasistencia.setFecha(fechan);
            laasistencia.setHorafinal(horainicialn);
            laasistencia.setHorafinal(horafinaln);
            laasistencia.setCodigos(codigos);
            laasistencia.setEstados(estados);
            return true;
        }
        return false;
    }
    public boolean adicionarEstudiante(String documento, String tdocumento, String nomb) {
        Estudiante nuevo = new Estudiante(documento, tdocumento, nomb);
        estudiantes.add(nuevo);
        return true;
    }
    public Estudiante consultarEstudiante(String documento) {
        for (Estudiante e : estudiantes) {
            if (e.getDocumento().equalsIgnoreCase(documento)) {
                return e;
            }
        }
        return null;
    }

    public boolean actualizarEstudiante(String documento, String tdocumento, String nomb) {
        Estudiante estudiante = this.consultarEstudiante(documento);
        if (estudiante != null) {
            estudiante.setTdocumento(tdocumento);
            estudiante.setNomb(nomb);
            return true;
        }
        return false;
    }

    public boolean borrarEstudiante(String documento) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getDocumento().equalsIgnoreCase(documento)) {
                estudiantes.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean llenarAsistencia(String fecha, String horaIni, String horaFin) {
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> estados = new ArrayList<>();

        for (Estudiante e : estudiantes) {
            ids.add(e.getDocumento());
            estados.add("2");
        }

        return adicionaAsistencia(fecha, horaIni, horaFin, ids, estados);
    }
}

