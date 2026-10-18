package Boletin_03;

import java.util.Scanner;

/**
 * Nombre: Xinyi 
 * Apellidos: Ye
 * Fecha: 18/10/2026
 *
 * Sistema de venta de entradas "MEDAC Park".
 * Solo se usan estructuras condicionales (if / else if / else / switch).
 * No hay bucles ni arrays.
 */

public class Ejercicio_16 {
    public static void main(String[] args) {

        //Consola.iniciar();   //Para mostral bien €.

        Scanner scanner = new Scanner(System.in);
        //Requisito 1: Menú y Selección del Pase (Uso obligatorio de 'switch')
        System.out.println("------MEDAC PARK------");
        System.out.println("1: Pase Estándar (40.00 €)");
        System.out.println("2: Pase Acuático (55.00 €)");
        System.out.println("3: Pase Total VIP (80.00 €)");

        System.out.println("Elige un pase: ");
        int opcionPase = scanner.nextInt();

        String nombrePase;
        double precioBase;

        switch (opcionPase) {
            case 1:
                nombrePase = "Pase Estándar";
                precioBase = 40.00;
                break;
            case 2:
                nombrePase = "Pase Acuático";
                precioBase = 55.00;
                break;
            case 3:
                nombrePase = "Pase Total VIP";
                precioBase = 80.00;
                break;
            default:
                System.out.println("Opción de pase no válida. Fin del programa");
                scanner.close();
                return; //Aquí se termina el programa
        }

        //Requisito 2: Edad del Visitante y Descuentos por Tramo (Uso obligatorio de 'if-else')
        System.out.println("Introducir la edad del visitante: ");
        int edad = scanner.nextInt();

        if (edad < 0 || edad >120){
            System.out.println("Edad no válida. Fin del programa");
            scanner.close();
            return;
        }

        //Bebé: precio gratis, ticker directo y fin ( sin pedir día ni familia numerosa.)
        if (edad < 4){
            System.out.println("-------------TICKET MEDAC PARK-------------");
            System.out.printf("Pase:                       %s%n", nombrePase);
            System.out.printf("Precio base:            %.2f €%n", precioBase);
            System.out.println("Categoría de edad:  Bebé (<4 años) - GRATIS");
            System.out.println("-------------------------------------------");
            System.out.printf("Importe final:                 %.2f €%n", 0.0);
            System.out.println("===========================================");
            scanner.close();
            return;
        }

        double precio = precioBase;
        String categoriaEdad;

        if (edad < 12){
            categoriaEdad = "Infantil (-25%)";

        }else if (edad <= 64) {
            categoriaEdad = "Adulto (sin descuento)";

        }else {
            categoriaEdad = "Senior (-30%)";
            precio = precio * 0.70;
        }

        //Requisito 3: Día de la Visita y Ajustes de Calendario (Uso de 'switch' o 'if')
        System.out.print("Introducir el día de la semana (1=Lunes ... 7=Domingo):");
        int dia = scanner.nextInt();

        String ajusteDia;

        switch (dia) {
            case 1:
            case 2:
            case 4:
            case 5:
                ajusteDia = "Tarifa ordinaria (sin variación)";
                break;

            case 3:
                ajusteDia = "Día del Espectador (-5.00 €)";
                precio = precio - 5.00;
                if (precio < 0) {   //El precio nunca puede ser negativo
                    precio = 0;
                }
                break;

            case 6:
            case 7:
                ajusteDia = "Fin de semana (+10% del precio base)";
                precio = precio + precioBase * 0.10;   //10% calculado sobre el precio base del pase elegido.
                break;
            default:
                System.out.println("Día no válido. Fin del programa.");
                scanner.close();
                return;
        }

        //Requisito 4: Descuento por Familia Numerosa (Uso de 'if')
        System.out.println("Tienes carné de Familia Numerosa? (1=Sí / 0=No):");
        int familiaNumerosa = scanner.nextInt();

        String familia;
        if(familiaNumerosa == 1) {
            familia = "Sí (-15%)";
            precio = precio * 0.85;
        }else if (familiaNumerosa == 0) {
            familia = "No";
        }else {
            System.out.println("Respuesta no válida. Fin del programa.");
            scanner.close();
            return;
        }

        //Requisito 5: Emisión y Formato del Ticket Final
        System.out.println("-------------TICKET MEDAC PARK-------------");
        System.out.printf("Pase:                       %s%n", nombrePase);
        System.out.printf("Precio base:            %.2f €%n", precioBase);
        System.out.printf("Categoría de edad:       %s%n", categoriaEdad);
        System.out.printf("Ajuste por día:              %s%n", ajusteDia);
        System.out.printf("Familia numerosa:              %s%n", familia);
        System.out.println("-------------------------------------------");
        System.out.printf("Importe final:              %.2f €%n", precio);
        System.out.println("===========================================");

        scanner.close();
    
    }
    
}