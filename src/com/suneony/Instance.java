package com.suneony;

import twitter4j.conf.ConfigurationBuilder;

public class Instance {
	public ConfigurationBuilder cb = null;

	public Instance() {
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("UIq2t0CAaCeWYhHxCd3rpzWnu")
				.setOAuthConsumerSecret("1LwR7RUYupoEtfJh5aLCLXIUHrA8HyU7xxP63SWeUFbslaE0ek")
				.setOAuthAccessToken("3645009020-UduprILldhpW0YCURAzQpL6sCOQvxUhpt51xCON")
				.setOAuthAccessTokenSecret("H6aosHeAorg9t6atLTQWqvgOCG44kOPj6j9us7DtoWeAM");
	}
}
