/**
 * 
 */
package com.phei.netty.d07_codec.d1_msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

import org.msgpack.MessagePack;

/**
 * @author 李林峰
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> outList) throws Exception {
		final byte[] array;
		final int length = buf.readableBytes();
		array = new byte[length];
		buf.getBytes(buf.readerIndex(), array, 0, length);
		MessagePack msgpack = new MessagePack();
		outList.add(msgpack.read(array));
	}
}
