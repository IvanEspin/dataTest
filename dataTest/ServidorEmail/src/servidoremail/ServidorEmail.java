package servidoremail;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEmail {
    private static PrintStream flujout;
    
    public static void main(String[] args) {
        // TODO code application logic here
    ServerSocket socketnums = null;
    DataInputStream flujoin;
    PrintStream flujouto;
    Socket cliente = null;
    String texto;
    try{
        System.out.println("Servidor Email ejecutandose");
        socketnums = new ServerSocket(2025);
        cliente = socketnums.accept();
        flujoin = new DataInputStream(cliente.getInputStream());
        flujout = new PrintStream(cliente.getOutputStream());
        while(true){
            texto = flujoin.readLine();
            flujout.println(texto);            
        }
    }catch(IOException e){
        System.out.println(e);
    }
    }
    
}
