package Ejercicio2;

import java.time.LocalDate;


public class Ejercicio2 {
    public static void ejercicioD () {
        Empleado empleado1 = new Empleado(100, "Ignacio", "Vazquez", LocalDate.of(2021, 3, 17),100,1);
        Empleado empleado2 = new Empleado(200, "Martin", "Vera", LocalDate.of(2021, 3, 17),200,2);
            Empleado empleado3 = new Empleado(300, "Pedro", "Yañez", LocalDate.of(2021, 3, 17),300,3);
        Empleado [] empleados = {empleado1, empleado2, empleado3};
        for(Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
    }
}
