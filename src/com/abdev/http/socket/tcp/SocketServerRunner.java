package com.abdev.http.socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(80);
             Socket socket = serverSocket.accept();
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) {
            var request = dataInputStream.readUTF();
            while (!"stop".equals(request)) {
                System.out.println("client request: " + request);
                var response = scanner.nextLine();
                dataOutputStream.writeUTF(response);
                request = dataInputStream.readUTF();
            }
        }
    }
}
