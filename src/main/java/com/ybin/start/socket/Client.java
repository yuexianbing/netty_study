package com.ybin.start.socket;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.Socket;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/6/24
 * @category
 */
@Slf4j
public class Client {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8088;
    private static final Long SHEEP_TIME = 5000L;

    public static void main(String[] args) {
        try {
            final Socket socket = new Socket(HOST, PORT);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    log.info("客户端开始发送消息!");
                    while (true) {
                        try {
                            socket.getOutputStream().write("socket start send message".getBytes());
                        } catch (IOException e) {
                            log.info("客户端发送消息异常:\n{}", StringUtils.isBlank(e.getMessage()) ? e : e.getMessage());
                        }

                        sheep();
                    }
                }
            }).start();
        } catch (Exception e) {
            log.info("客户端初始化异常:\n{}", e.getMessage());
        }
    }

    private static void sheep() {
        try {
            Thread.sleep(SHEEP_TIME);
        } catch (InterruptedException e) {
            log.info("线程sheep异常:\n{}", e.getMessage());
        }
    }
}
