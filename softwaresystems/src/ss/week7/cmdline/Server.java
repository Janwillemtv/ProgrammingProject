
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
        if (args.length !=2) {
            System.out.println(USAGE);
            System.exit(0);
        }

        String name = args[0];
        InetAddress addr = null;
        int port = 0;
        ServerSocket sock = null;
        Socket s;


        // parse args[2] - the port
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[2]
                    + " is not an integer");
            System.exit(0);
        }

        // try to open a Socket to the server
        try {
            sock = new ServerSocket(port);

            System.out.println("Server socket created. Waiting for clients");

            s = sock.accept();

            System.out.println("Connection: " + s.getInetAddress().getHostName() + " : " + s.getPort());

            Peer peer = new Peer(name,s);

            Thread t = new Thread(peer);
            t.start();
            peer.handleTerminalInput();
            peer.shutDown();
            t.interrupt();

            sock.close();

        } catch (IOException e) {
            System.out.println("ERROR: could not create a socket on " + addr
                    + " and port " + port);
        }


    }


} // end of class Server
