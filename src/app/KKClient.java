package app;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.io.IOException;

public class KKClient {
    public static void main (String[] args) {

        if (args.length != 2) {
            System.err.println("Client needs two parameters: <Hostname/IP Address> <Port Number>");
            System.exit(0);
        }

        String host = args[0];
        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Need a proper port number");
            System.exit(0);
        }

        try(
            Socket clientS = new Socket(host, portNumber);
            PrintWriter output = new PrintWriter(clientS.getOutputStream(), true);
        ) {
            output.println("this is from the client");
        } catch (UnknownHostException e) {
            System.err.println("Need a proper host name (127.0.0.1)");
            System.exit(0);
        } catch (IOException e) {
            System.err.println("I/O Error with Connection");
            System.exit(0);
        }
    }
}
