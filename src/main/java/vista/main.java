package vista;

import controlador.ElControlador;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElControlador controlador = new ElControlador();
        String opcion = "";

        while (!opcion.equalsIgnoreCase("15")) {
            System.out.println("SISTEMA DE GESTION DE UN DEPARTAMENTO\n" +
                    "OPCIONES DISPONIBLES:\n"+
                    "1) CONSULTAR DEPARTAMENTO\n"+
                    "2) MODIFICAR DEPARTAMENTO\n" +
                    "3) REGISTRAR ESTUDIANTE EN DEPARTAMENTO\n" +
                    "4) CONSULTAR ESTUDIANTE EN EL DEPARTAMENTO\n" +
                    "5) MODIFICAR ESTUDUANTE DE DEPARTAMENTO\n" +
                    "6) AGREGAR UNA ASIGNATURA\n" +
                    "7) CONSULTAR UNA ASIGNATURA\n" +
                    "8) MODIFICAR UNA ASIGNATURA\n" +
                    "9) REGISTRAR ESTUDIANTE EN ASIGNATURA\n" +
                    "10) CONSULTAR ESTUDIANTE EN ASIGNATURA\n" +
                    "11) CREAR LISTA DE ASISTENCIA VACIA\n" +
                    "12) LLENAR LA ASISTENCIA\n" +
                    "13) MODIFICAR ASISTENCIA\n" +
                    "14) MOSTRAR ASISTENCIA\n" +
                    "15) SALIR DEL PROGRAMA\n" +
                    "DIGITE LA OPCION QUE DESEA UTILIZAR: ");

            opcion = scanner.nextLine();
            if (opcion.equals("1")) {
                System.out.println("NOMBRE DEL DEPARTAMENTO:");
                System.out.println(controlador.consultarNombreDepartamento());

            } else if (opcion.equals("2")) {
                System.out.print("INGRESE EL NUEVO NOMBRE DEL DEPARTAMENTO: ");
                System.out.println(controlador.modificarNombreDepartamento(scanner.nextLine()));

            } else if (opcion.equals("3")) {
                System.out.print("INGRESE EL DOCUMENTO DEL ESTUDIANTE: ");
                String idDept = scanner.nextLine();
                System.out.print("INGRESE EL TIPO DE DOCUMENTO QUE TIENE EL ESTUDAINTE: ");
                String tipoIdDept = scanner.nextLine();
                System.out.print("INGRESE EL NOMBRE COMPLETO DEL ESTUDIANTE: ");
                System.out.println(controlador.registrarEstudianteDepartamento(
                        idDept, tipoIdDept, scanner.nextLine()));

            } else if (opcion.equals("4")) {
                System.out.print("INGRESE EL TIPO DE DOCUMENTO: ");
                String tipoDoc = scanner.nextLine();
                System.out.print("INGRESE EL NUMERO DE DOCUMENTO: ");
                System.out.println("\nInformación del estudiante:\n" +
                        controlador.consultarEstudianteDepartamento(scanner.nextLine(), tipoDoc));

            } else if (opcion.equals("5")) {
                System.out.print("INGRESE EL NUMERO DE DOCUMENTO ACTUAL: ");
                String numDocumento = scanner.nextLine();
                System.out.print("INGRESE EL TIPO DE DOCUMENTO QUE TIENE ACTUALMENTE: ");
                String tipoDocActual = scanner.nextLine();
                System.out.print("INGRESE EL NUEVO TIPO DE DOCUMENTO: ");
                String tipoDocNuevo = scanner.nextLine();
                System.out.print("INGRESE EL NUEVO NOMBRE COMPLETO: ");
                System.out.println(controlador.modificarEstudianteDepartamento(
                        numDocumento, tipoDocActual, tipoDocNuevo, scanner.nextLine()));

            } else if (opcion.equals("6")) {
                System.out.print("INGRESE EL CODIGO DE LA AIGNATURA: ");
                String codigoassig = scanner.nextLine();
                System.out.print("INGRESE EL NOMBRE DE LA ASIGNATURA: ");
                String nombreassig = scanner.nextLine();
                System.out.print("INGRESE LA SECCION: ");
                String secciondeassig = scanner.nextLine();
                System.out.print("INGRESE EL SEMESTRE: ");
                String semestreassig = scanner.nextLine();
                System.out.print("INGRESE LOS CREDITOS: ");
                System.out.println(controlador.adicionarAsignatura(
                        codigoassig, nombreassig, secciondeassig, semestreassig, scanner.nextLine()));

            } else if (opcion.equals("7")) {
                System.out.print("INGRESE CODIGO DE LA ASIGNATURA: ");
                String codigo = scanner.nextLine();
                System.out.print("INGRESE LA SECCION: ");
                String seccion = scanner.nextLine();
                System.out.print("INGRESE EL SEMESTRE: ");
                System.out.println("\nINFORMACION DE LA ASIGNATURA:\n" +
                        controlador.consultarAsignatura(codigo, seccion, scanner.nextLine()));

            } else if (opcion.equals("8")) {
                System.out.print("INGRESE EL CODIGO DE LA ASIGNATURA: ");
                String codigo = scanner.nextLine();
                System.out.print("INGRESE LA SECCION: ");
                String seccion = scanner.nextLine();
                System.out.print("INGRESE EL SEMESTRE: ");
                String semestre = scanner.nextLine();
                System.out.print("INGRESE EL NUEVO NOMBRE: ");
                String nuevonom = scanner.nextLine();
                System.out.print("INGRESE LOS NUEVOS CREDITOS: ");
                System.out.println(controlador.actualizarAsignatura(
                        codigo, seccion, semestre, nuevonom, scanner.nextLine()));

            } else if (opcion.equals("9")) {
                System.out.println("REGISTRAR ESTUDIANTE EN ASIGNATUTA");
                System.out.println("INGRESE EL TIPO DE DOCUMENTO:");
                String tipoDoc = scanner.nextLine();
                System.out.println("INGRESE EL NUMERO DE DOCUMENTO:");
                String numDoc = scanner.nextLine();
                System.out.println("INGRESE EL SEMESTRE:");
                String semestre = scanner.nextLine();
                System.out.println("INGRESE EL CODIGO DE LA ASIGNATURA:");
                String codAsig = scanner.nextLine();
                System.out.println("IGRESE LA SECCION:");
                String grupo = scanner.nextLine();
                System.out.println(controlador.registrarEstudianteEnAsignatura(numDoc, tipoDoc, semestre, codAsig, grupo));

            } else if (opcion.equals("10")) {
                System.out.print("INGRESE CODIGO DE LA ASEGNATURA: ");
                String codAsig = scanner.nextLine();
                System.out.print("INGRESE EL SEMESTRE: ");
                String semestre = scanner.nextLine();
                System.out.print("INGRESE LA SECCION: ");
                System.out.println("\nESTUDIANTES QUE ESTAN INSCRITOS :\n" +
                        controlador.consultarEstudiantesAsignatura(codAsig, semestre, scanner.nextLine()));

            } else if (opcion.equals("11")) {
                System.out.println("CREAR LISTA VACIA DE ASITENCIA");
                System.out.print("INGRESE EL CODIGO DE LA ASIGNATURA: ");
                String codAsigLista = scanner.nextLine();
                System.out.print("INGRESE LA SECCION: ");
                String seccionLista = scanner.nextLine();
                System.out.print("INGRESE EL SEMESTRE: ");
                String semestreLista = scanner.nextLine();
                System.out.print("INGRESE LA FECHA (AAAA/MM/DD): ");
                String fechaLista = scanner.nextLine();
                System.out.print("INGRESE LA HORA INICIAL: ");
                String horaIniLista = scanner.nextLine();
                System.out.print("INGRESE LA HORA FINAL: ");
                System.out.println(controlador.crearListaAsistenciaVacia(
                        codAsigLista, seccionLista, semestreLista, fechaLista,
                        horaIniLista, scanner.nextLine()));

            } else if (opcion.equals("12")) {
                System.out.print("INGRESE EL CODIGO DE LA ASIGNATURA: ");
                String codigoAsig = scanner.nextLine();
                System.out.print("INGRESE EL SEMESTRE: ");
                String semestre = scanner.nextLine();
                System.out.print("INGRESE LA SECCION: ");
                String seccion = scanner.nextLine();
                System.out.print("INGRESE LA FECHA (AAAA/MM/DD): ");
                String fecha = scanner.nextLine();
                System.out.print("INGRESE LA HORA INICIAL: ");
                String horaIni = scanner.nextLine();
                System.out.print("INGRESE LA HORA FINAL: ");
                String respuesta = controlador.llenarAsistencia(
                        codigoAsig, semestre, seccion, fecha, horaIni, scanner.nextLine());

                if (respuesta.startsWith("INICIAR-LLENADO-ASISTENCIA")) {
                    String[] datos = respuesta.split(":");
                    codigoAsig = datos[1];
                    seccion = datos[2];
                    semestre = datos[3];
                    fecha = datos[4];
                    horaIni = datos[5];
                    String horaFin = datos[6];

                    int indiceEstudiante = 0;
                    while (true) {
                        String estudianteInfo = controlador.obtenerSiguienteEstudiante(
                                codigoAsig, seccion, semestre, fecha, horaIni, horaFin, indiceEstudiante);

                        if (estudianteInfo.startsWith("FIN:")) {
                            System.out.println(estudianteInfo.split(":")[1]);
                            break;
                        }

                        String[] estudianteData = estudianteInfo.split(":");
                        System.out.print("\nEstudiante: " + estudianteData[3] +
                                " (" + estudianteData[2] + ": " + estudianteData[1] +
                                ")\nEstado (0:Asistió, 1:Tarde, 2:Ausente): ");
                        String estado = scanner.nextLine();
                        String resultado = controlador.procesarEstudianteAsistencia(
                                codigoAsig, seccion, semestre, fecha, horaIni, horaFin,
                                estudianteData[1], estado);

                        if (!resultado.equals("ESTADO_ACTUALIZADO")) {
                            System.out.println("Error: " + resultado);
                        }
                        indiceEstudiante++;
                    }
                } else {
                    System.out.println(respuesta);
                }

            } else if (opcion.equals("13")) {
                System.out.print("INGRESE EL CODIGO DE ASIGNATURA: ");
                String codAsig = scanner.nextLine();
                System.out.print("INGRESE EL SEMESTRE: ");
                String semestre = scanner.nextLine();
                System.out.print("INGRESE LA SECCION: ");
                String seccion = scanner.nextLine();
                System.out.print("INGRESE FECHA (AAAA/MM/DD): ");
                String fecha = scanner.nextLine();
                System.out.print("INGRESE LA HORA INICIAL: ");
                String horaIni = scanner.nextLine();
                System.out.print("INGRESE LA HORA FINAL: ");
                String horaFin = scanner.nextLine();
                System.out.print("INGRESE EL TIPO DE DOCUMENTO: ");
                String tipoDoc = scanner.nextLine();
                System.out.print("INGRESE EL NUMERO DE DOCUMENTO ");
                String numDoc = scanner.nextLine();
                System.out.print("INGRESE EL NUEVO ESTADO (0:ASISTIO, 1:LLEGO TARDE, 2:AUSENTE): ");
                System.out.println(controlador.modificarAsistencia(
                        codAsig, semestre, seccion, fecha, horaIni, horaFin,
                        numDoc, tipoDoc, scanner.nextLine()));

            } else if (opcion.equals("14")) {
                System.out.print("INGRESE CODIGO DE LA ASIGNATURA: ");
                String codAsig = scanner.nextLine();
                System.out.print("INGRESE LA SECCION: ");
                String seccion = scanner.nextLine();
                System.out.print("INGRESE EL SEMESTRE: ");
                String semestre = scanner.nextLine();
                System.out.print("INGRESE LA FECHA (AAAA/MM/DD): ");
                String fecha = scanner.nextLine();
                System.out.print("INGRESE LA HORA INICIAL: ");
                String horaIni = scanner.nextLine();
                System.out.print("INGRESE LA HORA FINAL: ");
                System.out.println("\nEL REGISTRO DE ASISTENCIA ES EL SIGUIENTE:\n" +
                        controlador.mostrarAsistencia(
                                codAsig, seccion, semestre, fecha, horaIni, scanner.nextLine()));

            } else if (opcion.equals("15")) {
                System.out.print("\n¿ESTA SEGURO QUE DESEA SALIR DEL SISTEMA :( ? (S/N): ");
                String confirmacion = scanner.nextLine();

                if (confirmacion.equalsIgnoreCase("S")) {
                    System.out.println("\nSALIENDO DEL SISTEMA...");
                    break; // Sale del bucle while
                } else {
                    System.out.println("\nCONTINUANDO EN EL PROGRAMA...");
                    opcion = "";
                }

            } else {
                System.out.println("\nOPCION INVALIDA");
            }
        }
    }
}
