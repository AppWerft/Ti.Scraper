/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */

// http://billdawson.com/using-custom-titanium-modules-for-performance/
package de.appwerft.scraper;

import org.appcelerator.kroll.*;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;
import java.io.IOException;
import android.os.AsyncTask;
import java.net.MalformedURLException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import us.codecraft.xsoup.*;


@Kroll.module(name = "Scraper", id = "de.appwerft.scraper")
public class ScraperModule extends KrollModule {

	// Standard Debugging variables
	private static final String LCAT = "ScraperModule";
	public KrollFunction mCallback;

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
	public void createScraper(final KrollDict options,final
			@Kroll.argument(optional = true) KrollFunction mCallback) {
		AsyncTask<Void, Void, Void> doRequest = new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void[] arg0) {
				int timeout = 10000;
				String url = null;
				String useragent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:46.0) Gecko/20100101 Firefox/46.0";
				String xpath = "//body";

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
				List<String> list = null;
				KrollDict data = new KrollDict();
				try {
					Document doc = Jsoup.connect(url).userAgent(useragent)
							.timeout(timeout).ignoreContentType(true).get();
					if (xpath != null) {
						list = Xsoup.compile(xpath).evaluate(doc).list();
					}
					
					data.put("list", list.toArray());
					data.put("success", true);
					mCallback.call(ScraperModule.this.getKrollObject(), data);
				} catch (MalformedURLException e) {
					data.put("success", false);
					data.put("error", "MalformedURLException");
					mCallback.call(ScraperModule.this.getKrollObject(), data);
					e.printStackTrace();
				} catch (IOException e) {
					data.put("success", false);
					data.put("error", "IOException");
					mCallback.call(ScraperModule.this.getKrollObject(), data);
					e.printStackTrace();
				}
				return null;
			}
		};
		doRequest.execute();
	}
}
