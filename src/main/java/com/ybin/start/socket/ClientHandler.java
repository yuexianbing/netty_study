package com.ybin.start.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/6/24
 * @category
 */
@Slf4j
public class ClientHandler {

    private static final int DATA_LENGTH = 1024;

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        log.info("新客户端接入!!");
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                byte[] data = new byte[DATA_LENGTH];
                int length;
                if ((length = inputStream.read(data)) != -1) {
                    log.info("客户端传来数据:\n{}", new String(data, 0, length));
                    socket.getOutputStream().write(data);
                }
            }
        } catch (Exception e) {
            log.info("客户端处理数据异常:\n{}", e.getMessage());
        }
    }
}
