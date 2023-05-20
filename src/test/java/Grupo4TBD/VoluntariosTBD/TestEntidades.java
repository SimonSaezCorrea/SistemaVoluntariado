package Grupo4TBD.VoluntariosTBD;

import Grupo4TBD.VoluntariosTBD.Entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Date;
import java.text.SimpleDateFormat;

@SpringBootTest
class TestEntidades {
    @Test
    void contextLoads() {
        /*
        Internal Variables.
        Entities for testing setters and getters.
        */
        Eme_habilidad Test_Emehabilidad;
        Emergencia Test_Emergencia;

        //INITIALIZATION.
        Test_Emehabilidad = new Eme_habilidad();
        Test_Emergencia = new Emergencia();

        /*
        PROCESS.
        Declaring tests cases for set functions.
        Lombok build all of these functions.
        Note: In this file, I did not create every test case
        because a lot of the functions are similar.
        */

        /*I used the getters for prints in screen*/

        //Set ID's.
        System.out.println("ID's Cases-----------------");
        //Default Case.
        Test_Emehabilidad.setId(12);
        System.out.println("Default case 1: " + Test_Emehabilidad.getId());
        Test_Emehabilidad.setId(0);
        System.out.println("Default case 2: " + Test_Emehabilidad.getId());
        Test_Emehabilidad.setId(-12);
        System.out.println("Default case 3: " + Test_Emehabilidad.getId());
        //Case for double or float number.
        Test_Emehabilidad.setId( (int) 0.5232 );
        System.out.println("Double or float number: " + Test_Emehabilidad.getId());
        //Case for strings and chars.
        Test_Emehabilidad.setId(Integer.parseInt("12132332"));
        System.out.println("Strings and chars 1: " + Test_Emehabilidad.getId());
        Test_Emehabilidad.setId((int) '1'); //ASCII
        System.out.println("Strings and chars 2: " + Test_Emehabilidad.getId());
        Test_Emehabilidad.setId(Character.getNumericValue('1')); //Real number.
        System.out.println("Strings and chars 3: " + Test_Emehabilidad.getId());
        //Maximum and Minimum allowed.
        Test_Emehabilidad.setId(999999999);
        System.out.println("Maximum: " + Test_Emehabilidad.getId());
        Test_Emehabilidad.setId(-999999999);
        System.out.println("Minimum: " + Test_Emehabilidad.getId());
        System.out.println("----------------------------------\n");

        //Set Names - descriptions (Text in general).
        System.out.println("Names Cases-----------------");
        //Default Test.
        Test_Emergencia.setNombre("Earthquake");
        System.out.println("Default Case 1: " + Test_Emergencia.getNombre());
        Test_Emergencia.setNombre("\tEarthquake\n");
        System.out.println("Default Case 2: " + Test_Emergencia.getNombre());
        //Numbers.
        Test_Emergencia.setNombre(" Earthquake grade " + Integer.toString(12323));
        System.out.println("Numbers Case 1: " + Test_Emergencia.getNombre());
        Test_Emergencia.setNombre(" Earthquake grade " + Double.toString(8.9));
        System.out.println("Numbers Case 2: " + Test_Emergencia.getNombre());
        //Character.
        Test_Emergencia.setNombre("Earthquake " + Character.toString('A'));
        System.out.println("Character Case 1: " + Test_Emergencia.getNombre());
        //Maximum and Minimum Allowed.
        Test_Emergencia.setNombre("");
        System.out.println("Minimum Case 1: " + Test_Emergencia.getNombre());
        //Total of character allowed by DB = 50 characters for names and 400 for descriptions.
        System.out.println("----------------------------------\n");

        //Set Dates.
        System.out.println("Dates Cases-----------------");
        //Default case.
        Date Init_D = new Date(12,12,1000);
        Test_Emergencia.setFinicio(Init_D);
        System.out.println("Default Case 1: " + Test_Emergencia.getFinicio());
        //Format date.
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        ft.format(Init_D);
        Test_Emergencia.setFinicio(Init_D);
        System.out.println("Format date Case 1: " + Test_Emergencia.getFinicio());
        //String.
        //Cannot resolve errors from this case.
        // String Date = "01/10/2001";
        // DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        // Date Init_Date = null;
        // try {
        //     Init_Date = formatoFecha.parse(Date);
        //     Test_Emergencia.setFinicio(Init_Date);
        //     System.out.println("String Case 1: " + Test_Emergencia.getFinicio());
        // } catch (ParseException e) {
        //     throw new RuntimeException(e);
        // }

        //Date Format allowed for BD: yyyy-MM-dd.
        System.out.println("----------------------------------\n");
    }

}
