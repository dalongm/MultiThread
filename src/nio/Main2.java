package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Socket client = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            client = new Socket("localhost",8000);
            writer = new PrintWriter(client.getOutputStream(),true);
            writer.println("Hello World!");
            writer.flush();
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("from server: "+reader.readLine());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                reader.close();
            }
            if(writer!=null){
                writer.close();
            }
            if(client!=null){
                client.close();
            }
        }

    }
}
