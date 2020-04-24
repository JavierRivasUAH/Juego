package generardatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerarDatos {

    public static void main(String[] args) {
        File tienda = new File("tienda.txt");
        File tienda_productos = new File("tienda_productos.txt");
        File productos = new File("productos.txt");
        File trabajador = new File("trabajador.txt");
        File ticket = new File("ticket.txt");
        File ticket_productos = new File("ticket_productos.txt");

        FileWriter writer;
        BufferedWriter salida;

        String tiendas = null;
        String tiendas_productos = null;
        String producto = null;
        String trabajadores = null;
        String tickets = null;

        String[] provincias = {"Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón ", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "La Coruña ", "La Rioja", "Las Palmas", "León", "Lérida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", " Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};

        String[] nombre_tienda = {"Golositos", "Mercadona", "Carrefour", "Lidl", "Acomer", "BollosSA", "CampoSA", "AhorraMas", "Eroski", "Aldi", "Dia", "Alcampo"};

        String[] barrio = {"Adelfas", "Albaicín", "Alcosa", "Albaicín", "Ambroz", "Aravaca", "Atocha", "Barajas", "Cantoblanco"};
        String[] nombreproducto = {"collar", "mesa", "silla", "Guitarra", "Papel", "gasolina"};
        String[] tipo = {"a", "b", "c", "d", "e", "f"};
        String[] descripcion = {"Elegante collar de perlas", "Mesa de roble redinado", "Silla de abeto", "Guitarra espanola ideal para principiantes", "Papel de colores semiopaco", "gasolina sin plomo 95"};
        
        String[] trabajadores_nombres = {"Javier", "Andres", "Laura", "lucia", "Marta", "Sonia"};
        String[] trabajadores_apellidos = {"Suarez", "Cristiano", "Fernandez", "Garcia", "Lopez", "Gil"};
        String[] trabajadores_puesto = {"Limpiador", "Dependiente", "Encargado", "Reponedor", "Carnicero", "Frutero"};

        int precio;
        int aleatorio;
        int salario;
        int importe;
        int tienda_aleatorio;
        int producto_aleatorio;
        int cantidad_stock;
        int cantidad_productos;
        //fechas
        int dia;
        int mes;
        String fecha;

        try {
            crearFicheros(tienda, tienda_productos, productos, trabajador, ticket, ticket_productos);

            /*GENERAR TIENDAS*/
            writer = new FileWriter(tienda);
            salida = new BufferedWriter(writer);
            Random r = new Random();
            for (int i = 0; i < 200000; i++) {
                aleatorio = r.nextInt(50);
                tiendas = i + "," + nombre_tienda[r.nextInt(12)] + "," + provincias[aleatorio] + "," + barrio[r.nextInt(9)] + "," + provincias[aleatorio];
                salida.write(tiendas);
                salida.newLine();
            }
            salida.close();
            writer.close();
            
            /*GENERAR  PRODUCTOS*/
            writer = new FileWriter(productos);
            salida = new BufferedWriter(writer);
            for (int i = 0; i < 1000000; i++) {
                precio = r.nextInt(950) + 50;
                producto = i + "," + nombreproducto[r.nextInt(6)] + "," + tipo[r.nextInt(6)] + "," + descripcion[r.nextInt(6)] + "," + precio;
                salida.write(producto);
                salida.newLine();
            }
            salida.close();
            writer.close();

            /*GENERAR  TRABAJADOR*/
            writer = new FileWriter(trabajador);
            salida = new BufferedWriter(writer);
            int z=0;
            for (int i = 0; i < 1000000; i++) {
                salario = r.nextInt(4000) + 1000;
                aleatorio = r.nextInt(6);
                trabajadores = i + "," + i + "," + trabajadores_nombres[aleatorio] + "," + trabajadores_apellidos[aleatorio] + "," + trabajadores_puesto[aleatorio] + "," + salario + "," + z;
                z++;
                if (z==200000){z=0;}
                salida.write(trabajadores);
                salida.newLine();
            }
            salida.close();
            writer.close();
            /*GENERAR TIENDAS_Productos*/
            
            writer = new FileWriter(tienda_productos);
            salida = new BufferedWriter(writer);
            int aux=0;
            for (int i = 0; i < 200000; i++) {
                for (int u = 0; u < 100; u++) {
                    cantidad_stock = r.nextInt(190) + 10;
                    producto_aleatorio = r.nextInt(1000000);
                    tiendas_productos = i + "," + aux + "," + cantidad_stock;
                    aux++;
                    salida.write(tiendas_productos);
                    salida.newLine();
                    if(aux==1000000){aux=0;}
                }
            }
            salida.close();
            writer.close();

            /*GENERAR  Tickets*/
            writer = new FileWriter(ticket);
            salida = new BufferedWriter(writer);
            for (int i = 0; i < 5000000; i++) {
                importe = r.nextInt(9900) + 100;
                dia = r.nextInt(27) + 1;
                mes = r.nextInt(12) + 1;
                fecha = "2019"+"-"+mes + "-" + dia ;
                tickets = i + "," + importe + "," + fecha + "," + r.nextInt(1000000);
                salida.write(tickets);
                salida.newLine();
            }
            salida.close();
            writer.close();
            /*GENERAR  Tickets_Productos*/
            writer = new FileWriter(ticket_productos);
            salida = new BufferedWriter(writer);
            
            
            int contador=0;
            for (int i = 0; i < 5000000; i++) {
                cantidad_productos = r.nextInt(9) + 1;
                for (int u = 0; u < cantidad_productos; u++) {
                    cantidad_stock = r.nextInt(9) + 1;
                    
                    
                    tickets = i + "," + contador + "," + cantidad_stock;            
                    salida.write(tickets);
                    salida.newLine();
                    contador++;
                    if(contador==1000000){contador=0;}
                }
                
                
                
                
            }
            salida.close();
            writer.close();

        } catch (IOException e) {
        }
    }

    public static void crearFicheros(File tienda, File productos, File tienda_productos, File trabajador, File ticket, File ticket_productos) throws IOException {
        if (tienda.exists()) {
            tienda.delete();
            tienda.createNewFile();
        } else {
            tienda.createNewFile();
        }

        if (productos.exists()) {
            productos.delete();
            productos.createNewFile();
        } else {
            productos.createNewFile();
        }
        if (ticket_productos.exists()) {
            ticket_productos.delete();
            ticket_productos.createNewFile();
        } else {
            ticket_productos.createNewFile();
        }

        if (tienda_productos.exists()) {
            tienda_productos.delete();
            tienda_productos.createNewFile();
        } else {
            tienda_productos.createNewFile();
        }

        if (trabajador.exists()) {
            trabajador.delete();
            trabajador.createNewFile();
        } else {
            trabajador.createNewFile();
        }

        if (ticket.exists()) {
            ticket.delete();
            ticket.createNewFile();
        } else {
            ticket.createNewFile();
        }

        

    }
}
