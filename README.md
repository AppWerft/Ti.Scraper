Ti.Scraper
=========

This Titanium module scapes remote web pages and uses xpath for filtering. It uses [Xsoup](https://github.com/code4craft/xsoup). It is a mix between jsoup and xpath. [Here](https://github.com/code4craft/xsoup/blob/master/src/test/java/us/codecraft/xsoup/XsoupTest.java) you can find a lot of examples of possibilities.


Usage
----

~~~
require('de.appwerft.scraper').createScraper({
    url : "http://dradiowissen.de/early-bird/p1",
    rootXpath : "//figure[@class=teaser__image]/button",
    childXpaths : {
        title : "//button/@data-title",
        mp3 : "//button/@data-mp3",
        image : "//a/img/@src"
    },
    timeout : 3000, // optional
    useragent : "my sweet browser", // optional 
},function(_e){
      _e.list.forEach(function(_e){
          console.log(_e.success);
          console.log(_e.list);
    });
});
~~~

The module works asynchronously. Here you can find a typical [use case](https://github.com/AppWerft/DLRmediathek/blob/master/Resources/controls/earlybird.adapter.js    ). 


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


