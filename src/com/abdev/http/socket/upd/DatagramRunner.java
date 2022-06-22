package com.abdev.http.socket.upd;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        var localhost = Inet4Address.getByName("localhost");
        try (var datagramSocket = new DatagramSocket()) {
            var bytes = "Hello from UPD client".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, localhost, 7777 );
            datagramSocket.send(packet);
        }
    }
}
