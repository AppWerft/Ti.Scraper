Ti.Scaper
=========

This Titanium module scapes remote web pages and uses xpath for filtering.



Usage
----

~~~
var Scraper = require('de.appwerft.scraper');
Scraper.get({
    url : "http://dradiowissen.de/early-bird/p1",
    xpath : "//figure[@class=teaser__image]/button"
    },function(_e){
        _e.list.forEach(function(_e){
            console.log(_e);
    });
});
~~~



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


