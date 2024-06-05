
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coffee Coffee = new Coffee();
		System.out.println("Mostrar todos los cafés:");
		Coffee.showCoffee();
		
		// Insertar un nuevo café
        System.out.println("Insertar un nuevo café:");
        Coffee.insertarCafe("NuevoCafe", 150, 8.99, 150, 200);

        // Buscar un café por nombre
        System.out.println("Buscar un café por nombre:");
        Coffee.buscarCafePorNombre("NuevoCafe");

        // Mostrar los cafés de un proveedor
        System.out.println("Mostrar los cafés de un proveedor:");
        Coffee.mostrarCafesPorProveedor(150);

        // Borrar un café
        System.out.println("Borrar un café:");
        Coffee.borrarCafe("NuevoCafe");
        
		Coffee.close();
		
	}

}
