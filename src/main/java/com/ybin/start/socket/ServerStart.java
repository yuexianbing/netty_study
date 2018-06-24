package com.ybin.start.socket;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/6/24
 * @category
 */
public class ServerStart {

    public static void main(String[] args) {
        new Server(8088).start();
    }
}
