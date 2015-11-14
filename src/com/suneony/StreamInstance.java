package com.suneony;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class StreamInstance extends Instance{
	private TwitterStreamFactory twitterStreamFactory=null;
	private TwitterStream streamObj=null;
	public StreamInstance(){
		super();
		twitterStreamFactory=new TwitterStreamFactory(super.cb.build());
		streamObj=twitterStreamFactory.getInstance();
	}
	public TwitterStream connect(){
		return this.streamObj;
	}
}
