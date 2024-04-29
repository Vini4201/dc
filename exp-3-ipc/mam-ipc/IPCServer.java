import java.net.*;
import java.io.*;

public class IPCServer {
    public static void main(String args[]) {
        System.out.println("\n** INTERPROCESS COMMUNICATION **\n");
        System.out.println("\n** SERVER PROCESS STARTED **\n");
        System.out.println("\n* SERVER IS READY AND WAITING TO RECEIVE DATA ON PORT 1200 ");
        try {
            ServerSocket ss = new ServerSocket(1200);
            Socket clientSocket = ss.accept();
            System.out.println("\n* Client connected: " +
                    clientSocket.getInetAddress() + ":" + clientSocket.getPort());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            int operation = dis.readInt(); // Read the operation code
            int a = dis.readInt();
            int b = dis.readInt();
            int result = 0;
            switch (operation) {
                case 1: // Addition
                    result = a + b;
                    break;
                case 2: // Modulus
                    result = a % b;
                    break;
                case 3: // Division
                    if (b == 0) {
                        System.out.println("\nError: Division by zero");
                    } else {
                        result = a / b;
                    }
                    break;
                default:
                    System.out.println("\nInvalid operation code");
            }
            dos.writeInt(result);
            System.out.println("\nSERVER PROCESSED AND SENT RESULT " + result +
                    " TO CLIENT");
            clientSocket.close();
            ss.close();
            System.out.println("\nSERVER PROCESS EXITING");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}