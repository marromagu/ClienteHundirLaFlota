package HundirLaFlotaSockets;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author DAM_M
 */
public class ClienteMain {

    static final String HOST = "localHost";
    static final int Puerto = 2001;

    public ClienteMain() {
        Scanner sc = new Scanner(System.in);
        try {
            //Socket
            Socket sCliente = new Socket(HOST, Puerto);
            
            InputStream auxIn = sCliente.getInputStream();
            OutputStream auxOut = sCliente.getOutputStream();
            
            DataInputStream flujo_entrada = new DataInputStream(auxIn);
            DataOutputStream flujo_salida = new DataOutputStream(auxOut);

                       // Bucle para leer continuamente desde el servidor
            while (true) {
                // Leer datos del servidor
                String informacion = flujo_entrada.readUTF();
                System.out.println(flujo_entrada.readUTF());
                if (informacion.equals("exit")) {
                    System.out.println("Saliendo del bucle de escucha.");
                    break;
                }
            }

            //sCliente.close();
        } catch (Exception e) {
        } finally {

        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new ClienteMain();
    }

}
