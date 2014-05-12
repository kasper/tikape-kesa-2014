SQLite
======

SQLite on kevyt relaatiotietokantajärjestelmä, joka tallentaa koko tietokannan yhteen tiedostoon. Siksi SQLite sopii hyvin kehitysympäristöön. SQLiteä voi käyttää myös tuotannossa, mutta se asettaa joitakin rajoitteita hieman rajoitetumman SQL-tuen ja rinnakkaisuuden takia. Tietokannan tiedosto muun muassa lukitaan transaktioiden ajaksi.

## Asennus

Useimmissa käyttöjärjestelmissä `sqlite3`-tulkki on jo asennettu valmiiksi. Jos näin ei ole tai käytät Windowsia, asenna käännetty SQLite (command-line shell) lataamalla se [tästä](http://www.sqlite.org/download.html).

## Nopea opastus käyttöön

Uuden tietokannan saa luotua seuraavasti. Tietokanta luodaan työhakemistoon joka on aktiivisena komentorivillä. Samalla komennolla saa avattua myös jo olemassa olevan tietokannan.

    sqlite3 nimi.sqlite 

Komennolla `.help` saat näkyville kaikki tuetut komennot. Komento `.schema` näyttää tietokannan skeeman. Tulkkiin voi kirjoittaa suoraan SQL-operaatioita, joista jokainen operaatio loppuu puolipisteeseen. Tulkista pääsee ulos kirjoittamalla komennon `.quit`.
