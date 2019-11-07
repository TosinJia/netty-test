package com.phei.netty.d07_codec.d1_msgpack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

public class MsgPack1 {
	
	public static void main(String[] args) {
		List<String> li=new ArrayList<String>();
		li.add("hell1");
		li.add("hi2");
		li.add("hi3");	
		MessagePack msgPack=new MessagePack();
		byte[] raw=null;
		try {//Serialize
			raw=msgPack.write(li);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {//Deserialize
			li=msgPack.read(raw,Templates.tList(Templates.TString));
			for (String ele : li) {
				System.out.println(ele);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
