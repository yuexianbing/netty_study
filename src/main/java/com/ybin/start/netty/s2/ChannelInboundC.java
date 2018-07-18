package com.ybin.start.netty.s2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/7/6
 * @category
 */
public class ChannelInboundC extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ChannelInboundC" + msg);
        ctx.fireChannelRead(msg);
    }
}
