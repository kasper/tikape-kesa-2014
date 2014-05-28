Harjoitus 3
===========

Harjoitukset on tarkoitus tehdä (tai rehellisesti yrittää) ennen tilaisuutta. Tilaisuudessa jakaudutaan ryhmiin, joissa pohditaan tehtäviä ja lopuksi ryhmät esittelevät ratkaisujaan.

## SQL

1. Mitä SQL-standardeja on olemassa ja tukevatko kaikki tietokannat näitä samalla tavalla? Mitä yleisiä tietotyyppejä SQL-tietokannoissa on?

2. Käyttötapauksia [viime viikon](/viikko-2/harjoitus.md) tehtävän 8 chat-palveluun liittyen. Kerro minkälaisella SQL-kyselyllä seuraavat käyttötapaukset luonnistuisivat.
    * Palvelun ylläpitäjä haluaa lisätä uuden chat-huoneen. Chat-huoneen nimi on `viherpeukalot` ja kuvaus on `Vihreä kesä`.
    * Palvelun ylläpitäjä haluaa lisätä uuden käyttäjän. Uuden käyttäjän käyttäjätunnus on `aimo` ja salasana `porkkana`.
    * Käyttäjä `aimo` kirjoittaa viestin `Moi kaikki!` huoneeseen `virherpeukalot`
    * Tuntematon käyttäjä yrittää kirjautua käyttäen käyttäjätunnusta `testi` ja salasanaa `salasana`

3. Luo [viime viikon](/viikko-2/harjoitus.md) tehtävän 8 tietokantatauluille SQL CREATE-TABLE-lauseet. Mieti sopivat rajoitteet sarakkeille.

4. Tee SQLite-tietokanta, johon suoritat edelliset tehtävät. Lisää tietokantaan lisää käyttäjiä, kanavia ja viestejä. Lisää tietokantaan myös joku uusi vapaavalintainen taulu ja siihen tietoja. Pääset tehtävässä alkuun katsomalla lyhyen [SQLite-oppaan](/sqlite.md). Ota komennot ja tulokset talteen.

5. [Tik](http://tik.herokuapp.com) on tehtävälistasovellus. Löydät sovelluksen SQLite-tietokannan [tästä](/tehtavat/tik.sqlite?raw=true). Suorita seuraavat käyttötapaukset ja ota ne talteen.
    * Hae kaikki käyttäjän `kasper` tehtävät
    * Lisää käyttäjälle `jack` uusi tehtävä, jonka omistaja on `kasper`
    * Liitä tehtävään avainsanoiksi `critical` ja `enhancement`
    * Lisää uusi `User Experience`-tiimi ja liitä sekä `kasper` että `jack` sen jäseniksi
    * Poista lopuksi `Software`-tiimi

6. Mitä tarkoittaa tietokantatransaktio? Milloin transaktiota kannattaa käyttää ja mitä hyötyä siitä on?

7. Mitä tarkoittaa SQL-injektio ja miten siihen voi varautua? Kokeile suorittaa SQL-injektioita [Väestörekisteriin](http://t-khirviko.users.cs.helsinki.fi/vaestorekisteri/). Arto Vihavaisen lompakko tippui Unicafen kassalle ja tiedämme hänen SOTU:n olevan `010190-111A`.
