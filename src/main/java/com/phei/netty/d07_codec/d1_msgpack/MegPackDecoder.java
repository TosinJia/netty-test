package com.phei.netty.d07_codec.d1_msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

import org.msgpack.MessagePack;

public class MegPackDecoder extends MessageToMessageDecoder<ByteBuf> {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		int len=msg.readableBytes();
		byte[] arr=new byte[len];
		msg.getBytes(msg.readerIndex(), arr,0,len);
		MessagePack mPack=new MessagePack();
		out.add(mPack.read(arr));
	}
}
