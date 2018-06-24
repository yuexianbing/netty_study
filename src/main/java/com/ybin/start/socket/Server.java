package com.ybin.start.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/6/24
 * @category
 */
@Slf4j
public class Server {

    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            log.info("服务端初始化成功!");
        } catch (IOException e) {
            log.info("初始化服务端异常:\n{}", e.getMessage());
        }
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart() {
        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                new ClientHandler(socket).start();
            } catch (IOException e) {
                log.info("服务端异常:\n{}", e.getMessage());
            }
        }
    }
}
