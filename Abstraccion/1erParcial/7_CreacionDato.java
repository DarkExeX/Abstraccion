//Creacion tipo de dato


public class Main{
    
    static class Auto{
	float precio;
	int anio;
    }
	public static void main(String[] args){
		
		Auto auto1 = new Auto();
		
		auto1.precio = 290000;
		auto1.anio = 2024;
		
		System.out.println("Precio: " + auto1.precio);
		System.out.println("Año: " + auto1.anio);
	}
}