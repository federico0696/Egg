package Servicios;

import Entidades.Producto;
import java.util.ArrayList;
import java.util.Scanner;


public class ServicioProducto {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Producto> producto = new ArrayList();
    
    public void crearProducto(){
        String nombre;
        Integer precio;
        System.out.println("ingrese el nombre del nuevo producto: ");
        nombre = leer.next();
        System.out.println("ingrece el precio del producto "+nombre+": ");
        precio=leer.nextInt();
        producto.add(new Producto(nombre,precio));
    }

    
    public ArrayList<Producto> getProducto(){
        return producto;
    }
    
    public void eliminarProducto(int i){
        producto.remove(i);
    }
    
    
    
}
