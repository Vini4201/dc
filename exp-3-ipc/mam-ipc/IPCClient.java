import java.net.*;
import java.io.*;

public class IPCClient {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 1200);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\n***** CLIENT PROCESS STARTED");
            System.out.println("\n** CHOOSE OPERATION:");
            System.out.println("1. Addition");
            System.out.println("2. Modulus");
            System.out.println("3. Division");
            int operation = Integer.parseInt(br.readLine());
            System.out.println("\n** ENTER NUMBERS:");
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            dos.writeInt(operation); // Send the operation code first
            dos.writeInt(a);
            dos.writeInt(b);
            int result = dis.readInt();
            switch (operation) {
                case 1:
                    System.out.println("\nSUM OF " + a + " AND " + b + " IS "
                            + result);
                    break;
                case 2:
                    System.out.println("\nMODULUS OF " + a + " AND " + b + " IS " + result);
                    break;
                case 3:
                    System.out.println("\nDIVISION OF " + a + " BY " + b + " IS " + result);
                    break;
                default:
                    System.out.println("\nInvalid operation");
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}