package cn.tangsu99.fspServerStatus.packet;

import java.io.*;
import java.net.Socket;

public class Packet {
    public static String serverName;
    public static String serverAddress;
    public static int serverPort;

    public static void sendStatus(int i) {
        try {
            Socket s = new Socket(serverAddress, serverPort);
            OutputStream os = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(i + serverName);
            bw.flush();
            s.close();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
