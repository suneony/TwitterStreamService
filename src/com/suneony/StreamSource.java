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
	 * ����ʱ�����������в���
	 * ��һ��������ָ���Twitter Stream ·��
	 * �ڶ���������ָ��¼����ļ������ļ���status.in��(���������ļ�ʵ�ֵ�һ������)
	 * */
	public static void main(String[] args){
		StreamInstance streamInstance=new StreamInstance();
		StreamSource streamSource=new StreamSource(streamInstance.connect(),args[0],args[1]);
		streamSource.generate();
	}
}
