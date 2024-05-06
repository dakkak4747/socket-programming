package socketPrograming;

import java.net.*;
import java.io.*;

public class Server {
    // Initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream write = null;

    // Constructor with port
    public Server(int port) {
        // Starts server and waits for a connection
        try {
            server = new ServerSocket(port);    
            System.out.println("Server started");

            System.out.println("Waiting for a client connection");

            socket = server.accept();// accept the client
            System.out.println("Client accepted");

            // Takes input from the client socket
            write = new DataInputStream(new BufferedInputStream(socket.getInputStream())); // use the inputStreamer

            String line = "";

            // Reads message from client until "Over" is sent so it can close the connection 
            while (!line.equals("exit")) {
              
            	try {
                    line = write.readUTF();
                    System.out.println(line);

                } catch (IOException i) {
                    System.out.println(i);
                }
             
            }
            System.out.println("Closing connection");

            // Close the connection
            socket.close();
            write.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(1254); // specify the port number 
                                          // creating the server object
    }
}
