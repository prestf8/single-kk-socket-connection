package app;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KKServer {
    public static void main (String[] args) {

        if (args.length != 1) {
            System.err.println("Server needs one parameter: <Port Number>");
            System.exit(0);
        }

        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Need a proper port number");
            System.exit(0);
        }

        try(
            ServerSocket serverS = new ServerSocket(portNumber);
            Socket clientS = serverS.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(clientS.getInputStream()));
            PrintWriter output = new PrintWriter(clientS.getOutputStream(), true);
        ) {
            
            KKProtocol protocol = new KKProtocol(); // Instantiate protocol 
            output.println(protocol.processInput(null)); // Startup message server -> client (Brings protocol to stage 1)
            
            String inpStr; // input for communication with the client
            String outStr; // output for communication with the client
            while ((inpStr = input.readLine()) != null) {
                outStr = protocol.processInput(inpStr);
                output.println(outStr);

                if (outStr.equals("Your momma ohhhhhh")) {
                    break;
                }
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
