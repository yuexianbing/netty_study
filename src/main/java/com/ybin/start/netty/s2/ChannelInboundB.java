package com.ybin.start.netty.s2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/7/6
 * @category
 */
public class ChannelInboundB extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ChannelInboundB" + msg);
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.pipeline().fireChannelRead("ybin hello wword");
    }
}
