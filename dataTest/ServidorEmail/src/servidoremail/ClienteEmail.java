package servidoremail;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteEmail {
    public static void main(String [] args){
        Socket socketnum = null;
        DataInputStream flujoin = null;
        DataOutputStream flujout = null;
        try{
            socketnum = new Socket("127.0.0.1",2025);
            flujoin = new DataInputStream(socketnum.getInputStream());
            flujout = new DataOutputStream(socketnum.getOutputStream());
        }catch(UnknownHostException e){
            System.out.println("No conozco el host");
        }catch(IOException e){
            System.out.println(e);
    }
        if (socketnum !=null && flujoin != null && flujout != null){
        try{
            flujout.writeBytes("De: java@espe.ec\n");
            flujout.writeBytes("Para: java@espe.ec\n");
            flujout.writeBytes("Asunto: Hola\n");
            flujout.writeBytes("TExto: Saludos desde Sangolqui jejejej\n");
            String respuesta;
            while ((respuesta = flujoin.readLine()) != null ){
                System.out.println("Servidor"+respuesta);
                if((respuesta.indexOf("Ok")) != -1)
                    break;
            }
            flujoin.close();
            flujout.close();
            socketnum.close();
        }catch (UnknownHostException e){
            System.out.println("Intentado conectar:"+e);
        }catch (IOException e){
            System.out.println(e);
        }
    }
    }
    
   
}
