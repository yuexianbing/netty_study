package com.ybin.start;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/6/14
 * @category
 */
@Slf4j
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        try {
//            log.info("receive message!!!!!");
//            ByteBuf buf = (ByteBuf)msg;
//            while (buf.isReadable()) {
//                System.out.print((char) buf.readByte());
//                System.out.flush();
//            }
//            log.info("end !!!!!");

            ctx.write(msg);
            ctx.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
