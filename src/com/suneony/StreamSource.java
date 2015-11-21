package com.suneony;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;

public class StreamSource {
	private TwitterStream stream=null;
	private String savePath=null;
	private String queuePath=null;
	public StreamSource(TwitterStream stream,String savePath,String queuePath){
		this.stream=stream;
		this.savePath=savePath;
		this.queuePath=queuePath;
	}
	public void generate(String[] keywords){
		 FilterQuery fq = new FilterQuery();
		 fq.track(keywords);
		 stream.addListener(new MyStreamListener(this.savePath,this.queuePath));
		 stream.filter(fq); 
	}
	public void generate(){
		stream.addListener(new MyStreamListener(this.savePath,this.queuePath));
		stream.sample();
	}
	/**
	 * 运行时，设置命令行参数
	 * 第一个参数是指存放Twitter Stream 路径
	 * 第二个参数是指记录打包文件名的文件（status.in）(采用两个文件实现的一个队列)
	 * */
	public static void main(String[] args){
		StreamInstance streamInstance=new StreamInstance();
		StreamSource streamSource=new StreamSource(streamInstance.connect(),args[0],args[1]);
		streamSource.generate();
	}
}
