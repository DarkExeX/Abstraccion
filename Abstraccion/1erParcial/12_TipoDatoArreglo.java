public class Main {

    static class Auto {
        float precio;
        int anio;
    }

    static class Persona {
        String nombre;
        String ap;
        String am;
        char genero;
        int edad;
    }

    public static void main(String[] args) {

        // Personas
        Persona[] personas = new Persona[4];

        personas[0] = new Persona();
        personas[1] = new Persona();
        personas[2] = new Persona();
        personas[3] = new Persona();

        personas[0].nombre = "Juan";
        personas[0].ap = "Martinez";
        personas[0].am = "Ruiz";
        personas[0].genero = 'M';
        personas[0].edad = 25;

        personas[1].nombre = "Ana Lucia";
        personas[1].ap = "Romero";
        personas[1].am = "Hernandez";
        personas[1].genero = 'F';
        personas[1].edad = 30;

        personas[2].nombre = "Alfonso";
        personas[2].ap = "Herrera";
        personas[2].am = "Gonzalez";
        personas[2].genero = 'M';
        personas[2].edad = 14;

        personas[3].nombre = "Melisa";
        personas[3].ap = "Castañeda";
        personas[3].am = "Martinez";
        personas[3].genero = 'F';
        personas[3].edad = 19;

        // Mostrar las personas
        System.out.println("---- Personas ----");
        for (int i = 0; i < 4; i++) {
            System.out.println("Persona " + (i + 1));
            System.out.println("Nombre: " + personas[i].nombre);
            System.out.println("Apellido paterno: " + personas[i].ap);
            System.out.println("Apellido materno: " + personas[i].am);
            System.out.println("Genero: " + personas[i].genero);
            System.out.println("Edad: " + personas[i].edad);
            System.out.println();
        }

        // Autos
        Auto[] autos = new Auto[4];

        autos[0] = new Auto();
        autos[1] = new Auto();
        autos[2] = new Auto();
        autos[3] = new Auto();

        autos[0].precio = 290000;
        autos[0].anio = 2024;

        autos[1].precio = 309990;
        autos[1].anio = 2026;

        autos[2].precio = 450000;
        autos[2].anio = 2021;

        autos[3].precio = 250000;
        autos[3].anio = 2025;


        // Mostrar los autos
        System.out.println("---- Autos ----");
        for (int i = 0; i < 4; i++) {
            System.out.println("Auto " + (i + 1));
            System.out.println("Precio: " + autos[i].precio);
            System.out.println("Anio: " + autos[i].anio);
            System.out.println();
        }

    }
}