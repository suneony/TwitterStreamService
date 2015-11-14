package com.suneony;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;

public class StreamSource {
	private TwitterStream stream=null;
	private String savePath=null;
	public StreamSource(TwitterStream stream,String savePath){
		this.stream=stream;
		this.savePath=savePath;
	}
	public void generate(String[] keywords){
		 FilterQuery fq = new FilterQuery();
		 fq.track(keywords);
		 stream.addListener(new MyStreamListener(this.savePath));
		 stream.filter(fq); 
	}
	public void generate(){
		stream.addListener(new MyStreamListener(this.savePath));
		stream.sample();
	}
	public static void main(String[] args){
		StreamInstance streamInstance=new StreamInstance();
		StreamSource streamSource=new StreamSource(streamInstance.connect(),"C:\\Users\\admin\\Desktop\\suneony\\temp\\");
		streamSource.generate();
	}
}
