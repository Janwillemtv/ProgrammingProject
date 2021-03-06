package ss.week7.cmdline;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;
    protected Scanner Terminal;

    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException
    {
        this.name = nameArg;
        this.sock = sockArg;

        InputStream instream = sock.getInputStream();
        OutputStream outstream = sock.getOutputStream();

        this.in = new BufferedReader(new InputStreamReader(instream));
        this.out = new BufferedWriter(new OutputStreamWriter(outstream));

        Terminal = new Scanner(System.in);

    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {

        while(true) {
            try {
                if (in.ready()) {
                    String msg = in.readLine();

                    if (msg.contains("EXIT")) {
                        break;
                    } else {
                        System.out.println(msg);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        shutDown();

    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() throws IOException {
        String lineIn = "";
        while(true) {
            if (Terminal.hasNextLine()) {
                lineIn = Terminal.nextLine();
                System.out.println(lineIn);


                try {
                    out.write(lineIn, 0, lineIn.length());
                    out.newLine();
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (lineIn.contains("EXIT")) {
                    break;
                }
            }
        }
        shutDown();
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**  returns name of the peer object*/
    public String getName() {
        return name;
    }

    /** read a line from the default input */
    static public String readString(String tekst) {
        System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
