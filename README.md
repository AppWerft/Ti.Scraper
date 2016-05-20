Ti.Scraper
=========

This Titanium module scapes remote web pages and uses xpath for filtering. It uses [Xsoup](https://github.com/code4craft/xsoup). It is a mix between jsoup and xpath. [Here](https://github.com/code4craft/xsoup/blob/master/src/test/java/us/codecraft/xsoup/XsoupTest.java) you can find a lot of examples of possibilities.


Usage
----

~~~
require('de.appwerft.scraper').createScraper({
    url : "http://srv.deutschlandradio.de/aodlistaudio.1706.de.rpc?drau:station_id=4&drau:from=_DATE_&drau:to=_DATE_&drau:page=1&drau:limit=500",
    rootXpath : "//entries",
    useragent : "Das DRadio/6 CFNetwork/711.1.16 Darwin/14.0.0",
    subXpaths : {
        url : "//item/@url",
        author : "//item/author/text()",
        title : "//item/title/text()",
        id : "//item/@id",
        sendung : "//item/sendung/text()",
        sendungid : "//item/sendung/@id",
        duration : "//item/@duration",
        killtime : "//item/@killtime",
        deliveryMode : "//item/@deliveryMode",	
        datetime : "//item/datetime/text()" 
    }
    },function(_e) {
        _e.list.forEach(function(_e){
            console.log(_e.success);
            console.log(_e.items);
            console.log(_e.count);
      });
});
~~~

The module works asynchronously. Here you can find a typical [use case](https://github.com/AppWerft/DLRmediathek/blob/master/Resources/controls/earlybird.adapter.js    ). 


~~~
require('de.appwerft.scraper').createScraper({
    url : "http://srv.deutschlandradio.de/aodlistaudio.1706.de.rpc?drau:station_id=4&drau:from=_DATE_&drau:to=_DATE_&drau:page=1&drau:limit=500",
    useragent : "Das DRadio/6 CFNetwork/711.1.16 Darwin/14.0.0",
    filters : {
        url : "item/@url",
        datetime : "//item/datetime/text()" 
    }
    },function(_e) {
    _e.list.forEach(function(_e){
        console.log(_e.success);
        console.log(_e.items);
        console.log(_e.count);
    }); 
});
~~~
More jou can find [here in this cookbook](https://jsoup.org/cookbook/extracting-data/selector-syntax)


INSTALL YOUR MODULE
-------------------

Mac OS X
--------
Copy the distribution zip file into the `~/Library/Application Support/Titanium` folder

Linux
-----
Copy the distribution zip file into the `~/.titanium` folder

Windows
-------
Copy the distribution zip file into the `C:\ProgramData\Titanium` folder


