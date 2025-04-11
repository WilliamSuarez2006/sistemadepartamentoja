package org.example.controlador;

import controlador.ElControlador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class   ElControladorTest {

    @Test
    void crearDepartamento() {
        ElControlador unico = new ElControlador();
        unico.CrearDepartamento("Ingenieria de Sistemas");
        String nombre = unico.consultarNombreDepartamento();
        assertEquals(nombre, "Ingenieria de Sistemas");
        //fail ("Not yet implemented")
    }

    @Test
    void modificarNombreDepartamento() {
        ElControlador unico = new ElControlador();
        unico.CrearDepartamento("Ingenieria de Sistemas");
        unico.ModificarNombreDepartamento("ISyC");

        String nombre = unico.consultarNombreDepartamento();
        assertEquals(nombre,"Ingenieria de Sitemas");
        //fail ("Not yet implemented")
    }

    @Test
    void consultarNombreDepartamento() {
    }
}