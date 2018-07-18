package com.ybin.start.netty.s1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/6/25
 * @category
 */
public class ChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("handlerAdded");
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
        super.channelRead(ctx, msg);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ctx.writeAndFlush("hello word");
                    ctx.executor().schedule(new Runnable() {
                        @Override
                        public void run() {
//                            System.out.println(msg);
                        }
                    }, 1, TimeUnit.SECONDS);
                }
            }
        }).start();
    }
}
