/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package de.appwerft.scraper;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.KrollDict;

import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
//import org.appcelerator.kroll.common.TiConfig;
import org.jsoup.Jsoup;
//import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;

import us.codecraft.xsoup.*;

@Kroll.module(name = "Scraper", id = "de.appwerft.scraper")
public class ScraperModule extends KrollModule {

	// Standard Debugging variables
	private static final String LCAT = "ScraperModule";   
	// @Kroll.constant public static final String EXTERNAL_NAME = value;
	public ScraperModule() {
		super();
	}
	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Log.d(LCAT, "inside onAppCreate");
		// put module init code that needs to run when the application is
		// created
	}

	// Methods
	@Kroll.method
	public void get(KrollDict options) {
		int timeout = 10000;
		String url = null;
		String useragent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:46.0) Gecko/20100101 Firefox/46.0";
		String xpath = null;
		
		if (options.containsKey("timeout")) {
			timeout = options.getInt("timeout");
		}
		if (options.containsKey("url")) {
			url = options.getString("url");
		}
		if (options.containsKey("xpath")) {
			xpath = options.getString("xpath");
		}
		if (options.containsKey("useragent")) {
			useragent = options.getString("useragent");
		}
		try {
			Document doc = Jsoup.connect(url).userAgent(useragent).timeout(timeout)
					.ignoreContentType(true).get();
			if (xpath != null) {
				
			}
			Log.d("jsoup1", doc.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
