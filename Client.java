package socketPrograming;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // Initialize socket and input output streams
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream out = null;

        // Establish the connection between the server and the client 
        try {
            socket = new Socket("LocalHost", 1254); // specify the ip address and the portnumber
            System.out.println("Connected");

            // Takes input from the console
            input = new DataInputStream(System.in);//input streamer

            // Sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());//outputstreamer
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        // String to read message from input
        String line = "";

        // Keep reading until "Over" is input
        while (!line.equals("exit")) {
            try {
                line = input.readUTF();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        // Close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}
