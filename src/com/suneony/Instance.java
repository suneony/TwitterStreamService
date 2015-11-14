package com.suneony;

import twitter4j.conf.ConfigurationBuilder;

public class Instance {
	public ConfigurationBuilder cb = null;

	public Instance() {
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("YTvq84wxSAgJwtv0CDP42fmX9")
				.setOAuthConsumerSecret("nzNr82NTAiMMCgjQyN8Z5BDl71I1kUkqSsCg9zyyAMEdPuLvrw")
				.setOAuthAccessToken("3645009020-MeicCdgCaJoR7nAboBfMReXWyjCrowTirmmP7Lc")
				.setOAuthAccessTokenSecret("mLcZNRVnnFVq7FfmgktH79qnwNtvKykMWIem4C0TBO45H");
	}
}
