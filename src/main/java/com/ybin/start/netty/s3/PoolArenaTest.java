package com.ybin.start.netty.s3;

import io.netty.buffer.PooledByteBufAllocator;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/7/16
 * @category
 */
public class PoolArenaTest {
    public static void main(String[] args) {
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        allocator.directBuffer(16);
        allocator.directBuffer(38);
    }
}
