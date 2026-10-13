package tema1;

import java.net.*;
import java.util.Scanner;

/**
 * Ejercicio1
 * Crea una clase Java que obtenga la dirección IP y
 * el nombre de tu máquina local. A continuación, solicita al usuario
 * una dirección de red (por ejemplo, 192.168.1.) e intenta comprobar las
 * direcciones IP del rango 1 al 10 de esa subred mediante
 * InetAddress.getByName(ip) enviando un ping lógico con el método
 * isReachable(timeout) para mostrar qué hosts responden
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        InetAddress dir = null;
        try {
            dir = InetAddress.getByName("localhost");
            System.out.println("IP de la maquina: " + dir.getHostAddress());
            System.out.println("Nombre del host: " + dir.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // Segunda parte del ejercicio

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce los tres primeros numeros de una direccion IP(Ejemplo: 192.168.1. ");
        String direccionRed = sc.nextLine();

        for (int i = 0; i <= 10; i++) {
            String IP = direccionRed + i;

            try {
                InetAddress direccion = InetAddress.getByName(IP);

                if (direccion.isReachable(1000)) {
                    System.out.println("Host respondiendo: " + IP);
                } else {
                    System.out.println("Host no respondiendo: " + IP);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        sc.close();
    }

}
