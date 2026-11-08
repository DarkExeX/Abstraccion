
public class Main {

    static class Auto {
        float precio;
        int anio;
    }

    static class Persona {
        char[] nombre = new char[30];
        char[] ap = new char[30];
        char[] am = new char[30];
        char genero;
        int edad;
    }

    public static void main(String[] args) {

        Persona persona = new Persona();

        // Clase Auto
        System.out.println("--- Clase Auto ---");
        System.out.println("float precio: " + Float.BYTES + " bytes");
        System.out.println("int anio: " + Integer.BYTES + " bytes");

        int tamAuto = Float.BYTES + Integer.BYTES;
        System.out.println("Auto: " + tamAuto + " bytes");

        // Clase Persona
        System.out.println("\n--- Clase Persona ---");
        System.out.println("nombre: " + persona.nombre.length * 2 + " bytes");
        System.out.println("ap: " + persona.ap.length * 2 + " bytes");
        System.out.println("am: " + persona.am.length * 2 + " bytes");
        System.out.println("char genero: " + Character.BYTES + " bytes");
        System.out.println("int edad: " + Integer.BYTES + " bytes");

        int tamPersona = persona.nombre.length + persona.ap.length + persona.am.length + Character.BYTES + Integer.BYTES;
            System.out.println("Persona: " + tamPersona + " bytes");
    }
}
