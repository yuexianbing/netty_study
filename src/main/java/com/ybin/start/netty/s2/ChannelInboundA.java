package com.ybin.start.netty.s2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/7/6
 * @category
 */
public class ChannelInboundA extends SimpleChannelInboundHandler {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ChannelInboundA" + msg);
        ctx.fireChannelRead(msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.pipeline().fireChannelRead("ybin hello wword-----");
        ctx.fireChannelRead("-----");
    }
}
