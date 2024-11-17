package basicchat;

import basicchat.server.Server;
import org.junit.Test;
import java.io.*;
import java.net.Socket;
import static org.junit.Assert.*;

public class AppTest {
    private static final int PORT = 12345;
    private static final String HOST = "localhost";

    @Test
    public void testServerStartup() {
        Thread serverThread = new Thread(() -> {
            Server server = new Server();
            server.start();
        });
        serverThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (Socket socket = new Socket(HOST, PORT)) {
            assertTrue("Should be able to connect to server", socket.isConnected());
        } catch (IOException e) {
            fail("Could not connect to server: " + e.getMessage());
        }
    }

    @Test
    public void testClientConnection() throws IOException {
        Thread serverThread = new Thread(() -> {
            Server server = new Server();
            server.start();
        });
        serverThread.start();
        
        try {
            Thread.sleep(1000);
            
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String response = in.readLine();
            assertEquals("Enter your username:", response);
            
            socket.close();
        } catch (InterruptedException | IOException e) {
            fail("Test failed: " + e.getMessage());
        }
    }
}