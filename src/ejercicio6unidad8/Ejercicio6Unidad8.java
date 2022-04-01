package ejercicio6unidad8;

import Entidades.Producto;
import Servicios.ServicioProducto;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio6Unidad8 {

    public static void main(String[] args) {
        /*
        Se necesita una aplicación para una tienda en la cual queremos almacenar los
        distintos productos que venderemos y el precio que tendrán. Además, se necesita
        que la aplicación cuente con las funciones básicas.
        Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio,
        eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
        Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
        Realizar un menú para lograr todas las acciones previamente mencionadas.
         */
        System.out.println("Bienvenido al programa que guarda productos y sus precios");
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ServicioProducto servProd = new ServicioProducto();
        ArrayList<Producto> producto = new ArrayList();
        int opcion;
        do {

            do {
                System.out.println("Que opción desea realizar?");
                System.out.println("Opcion 1: Agregar un nuevo producto al sistema");
                System.out.println("Opcion 2: Ver la lista de Productos");
                System.out.println("Opcion 3: Salir del programa");

                opcion = leer.nextInt();
                if (opcion == 1 || opcion == 2 || opcion == 3) {
                    break;
                } else {
                    System.out.println("Por favor ingrese una opción correcta");
                }
            } while (true);

            switch (opcion) {
                case 1: {
                    producto.clear();
                    servProd.crearProducto();
                    for (Producto aux : servProd.getProducto()) {
                        producto.add(aux);
                    }
                    for (int i = 0; i < producto.size(); i++) {
                        for (int j = 0; j < producto.size(); j++) {
                            if (i == j) {
                            } else {
                                if (producto.get(i).getNombre().equals(producto.get(j).getNombre())) {
                                    System.out.println("el producto que intenta ingresar ya existe");
                                    System.out.println("nombre: " + producto.get(i).getNombre() + " / precio: $" + producto.get(i).getPrecio());
                                    System.out.println("desea reemplacarlo?");
                                    System.out.println("en caso afirmativo ingrese (y)");
                                    System.out.println("en caso negativo presione cualquier tecla");
                                    if ("y".equals(leer.next())) {
                                        producto.remove(producto.get(i));
                                        servProd.eliminarProducto(i);
                                    } else {
                                        producto.remove(producto.get(j));
                                        servProd.eliminarProducto(j);
                                    }
                                }
                            }
                        }
                    }
                    break;
                }

                case 2: {
                    for (Producto aux : producto) {
                        System.out.println("nombre: " + aux.getNombre() + " / precio: $" + aux.getPrecio());
                    }
                    if (producto.size() == 0) {
                        System.out.println("No hay productos en la lista");
                    }
                    break;
                }
                case 3: {

                    break;
                }
            }
            if (opcion == 3) {
                System.out.println("Adios!!");
                break;
            }
        } while (true);
    }

}
