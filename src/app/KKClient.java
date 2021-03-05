package app;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            BufferedReader inp = new BufferedReader(new InputStreamReader(clientS.getInputStream()));
            BufferedReader stdInp = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(clientS.getOutputStream(), true);
        ) {
            String inpStr; // input for communication with the server
            String stdInpStr; // input for communication with the user

            while((inpStr = inp.readLine()) != null) {
                System.out.println("SERVER -> CLIENT: " + inpStr);

                if (inpStr.equals("Your programming skills are wack...")) {
                    break;
                }

                stdInpStr = stdInp.readLine(); // Everytime server sends us something lets us respond
                if (stdInpStr != null) {
                    out.println(stdInpStr);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Need a proper host name (127.0.0.1)");
            System.exit(0);
        } catch (IOException e) {
            System.err.println("I/O Error with Connection");
            System.exit(0);
        }
    }
}
