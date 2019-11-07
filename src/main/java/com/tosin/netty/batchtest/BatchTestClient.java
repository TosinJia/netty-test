package com.tosin.netty.batchtest;

import com.phei.netty.d05_basic.TimeClient;

public class BatchTestClient {
	public static void main(String[] args) throws Exception {
		String host="192.168.1.200";
		int port = 8080;
		int threadCount=100;
		if (args != null && args.length > 0) {
			try {
				host=args[0];
				port = Integer.valueOf(args[1]);
				threadCount = Integer.valueOf(args[2]);
			} catch (NumberFormatException e) {
				// 采用默认值
			}
		}
		final String finalHost=host;
		final int finalPort = port;
		final int finalThreadCount=threadCount;
		for (int i = 0; i < threadCount; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						new TimeClient().connect(20048, finalHost);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}).start();
		}
	}
}
