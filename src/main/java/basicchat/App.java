package basicchat;

import basicchat.server.Server;
import basicchat.client.Client;

public class App {
    public static void main(String[] args) {
        System.out.println("Basic Chat System Starting...");
        
        if (args.length < 1) {
            System.out.println("Usage: java -jar basicchat.jar [server|client]");
            return;
        }

        if (args[0].equalsIgnoreCase("server")) {
            System.out.println("Starting server...");
            new Server().start(); 
        } else if (args[0].equalsIgnoreCase("client")) {
            System.out.println("Starting client...");
            new Client().start();  
        } else {
            System.out.println("Invalid argument. Use 'server' or 'client'");
        }
    }
}