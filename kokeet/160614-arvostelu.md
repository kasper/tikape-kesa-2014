Kokeen arvosteluperusteet
=========================

1. **Miksi tietoa ei kannata aina tallentaa yksittäisiin tiedostoihin itse? Mitä tietokannat ja tietokantajärjestelmät tarjoavat tiedon käsittelyyn? (4p)**

    Vastauksesta odotettiin löytyvän *vähintään neljä hyvin perusteltua selitystä tietokantojen eduista* (piste per peruste). Alla on kahdeksan keskeistä syytä, myös muut järkevät perustelut hyväksyttiin.

    1. **Riippumattomuus**

        Tietokanta tarjoaa abstraktion tiedon tallentamiseen. Ohjelmien ei tarvitse toteuttaa tiedon rakennetta, tallentamista tai lukemista. Näin useat ohjelmat ja ohjelmointikielet voivat käsitellä tietoa riippumatta tiedon muodosta. Tietokanta tarjoaa siis yhteensopivuuden, jolla helpotetaan muun muassa ohjelmien ylläpitoa.

    2. **Tiedon haku**

        Tietokannat tarjoavat laajat hakutyökalut tietojen sisältöön ja näiden käsittelyyn.

    3. **Rinnakkaisuus**

        Sovelluksilla on usein useita samanaikaisia käyttäjiä. Tietokannat pystyvät hallitsemaan rinnakkaisuuden ja varmistamaan, että tiedot pysyvät eheinä. Esimerkiksi kaksi käyttäjää ei saa muokata samaa tietoa yhtäaikaisesti, sillä tällöin tiedosta saattaa hävitä jotain. Tietokannat tarjoavat operaatioille jonoja ja pystyvät hallitsemaan resursseja niin, että niitä tarjotaan vain silloin kuin ne ovat käytettävissä.

    4. **Tietosuoja**

        Tietokannoissa pystytään asettamaan oikeuksia ja rajoituksia käyttäjille tietoon. Näin varmistetaan, että käyttäjä pystyy käsittelemään pelkästään tietoa johon käyttäjällä on oikeudet.

    5. **Säilyvyys**

        Tietokannat pystyvät varmuuskopioimaan tietoa. Poikkeustilanteissa tietokannat pystyvät takaamaan muutosten pysyvyyden ja varautumaan mahdollisiin ongelmiin (esim. transaktiot).

    6. **Tehokkuus**

        Monipuolinen tiedonkäsittely tarvitsee tehokkaita teknisiä ratkaisuja. Tietokantajärjestelmät tarjoavat muun muassa indeksejä, joilla haut voidaan toteuttaa nopeasti. Tietokannat pystyvät palvelemaan suuria käyttäjämääriä samanaikaisesti.

    7. **Suuret tietomäärät**

        Tietokantoihin voidaan tallentaa suuria tietomääriä. Määrän kasvaessa, pystytään tietokantaa optimoimaan toimimaan tehokkaammin.

    8. **Tietojen yhteydet**

        Usein tietoihin liittyy (monimutkaisia) yhteyksiä ja lainalaisuuksia. Tietokantajärjestelmät pystyvät mallintamaan näitä yhteyksiä ja tarjoamaan käyttäjälle keinoja näiden käsittelyyn. Relaatiotietokannat tarjoavat relaatiomallin tietojen yhteksiin.

    **Lyhyesti**: tietokannat ja tietokantajärjestelmät tarjoavat valmiita rakenteita ja välineitä tiedon hakemiseen ja tallentamiseen. Usein tätä toiminnallisuutta ei kannata toteuttaa itse (poikkeuksia on) vaan käyttää valmiita tehokkaita ratkaisuja. Näin voidaan keskittyä ohjelman toiminnallisuuteen.

2. **Tietokantakaavio Kumpulan jäätelötehdas Oy:n tietokannasta. (5p)**

    Alla on *yksi* (pitkälle viety) esimerkki halutusta tietokannasta. Ratkaisuja löytyy useita. *Kaikkea ei tarvinnut löytyä omasta vastauksesta.* Taulut `Palkkalaji` ja `Maksutapa` voisivat olla myös attribuutteja viitetauluissaan (tosin tällöin tietoa toistuisi tietokannassa). Taulu `Jäätelösaldo` oli vapaaehtoinen kuvauksessa.

    **Keskeistä arvostelussa oli**:
    * Keskeisimmät taulut (1p)
    * Keskeisimmät attribuutit ja tyypit (1p)
    * Yhteykset ja osallistumisrajoitteet (1p)
    * Viiteavaimet (1p)
    * Liitostaulut (1p)

    Puolikkaita pisteitä sai oikeansuuntaisista ratkaisuista.

    ![Kumpulan jäätelötehdas Oy](http://yuml.me/07f071fe/)

3. **Kesälaitumien niittokoneet Ky:n käyttötapausten SQL-kyselyt.**

    Tehtävistä sai pisteitä jos ratkaisu oli ymmärrettävissä ja oikeansuuntainen. Pienistä syntaksivirheistä ei rokotettu. Yhden pisteen tehtävistä sai myös puolikkaita pisteitä mikäli ratkaisu oli osittain oikea. Käyttötapauksiin löytyy *useita* SQL-ratkaisuja. Alla on muutamia esimerkkejä kuhunkin kohtaan käyttäen sekä `JOIN`- että `WHERE`-liitoksia.

    1. **Hae kaikki ruohonleikkurit joiden mallin nimi on ”TurboCutter 3000”. (0,5p)**

            SELECT * FROM Ruohonleikkuri ruohonleikkuri, Malli malli WHERE ruohonleikkuri.malli_id = malli.id AND malli.nimi = 'TurboCutter 3000';

        Tai:

            SELECT ruohonleikkuri.* FROM Ruohonleikkuri ruohonleikkuri JOIN Malli malli ON ruohonleikkuri.malli_id = malli.id WHERE malli.nimi = 'TurboCutter 3000';

    2. **Lisää uusi ruohonleikkuri, jonka mallin nimi on ”TurboSlicer 100”, sarjanumero on ”4404” ja hyllypaikka ”A1”. Voit olettaa, että järjestelmä asettaa avaimet automaattisesti ja että malli on jo olemassa. Sarjanumero ja hyllypaikka ovat merkkijonoja. (1p)**

        Olemassaoleva malli piti hakea alikyselyllä `Malli`-taulusta. Muutoin tehtävästä sai korkeintaan puolikkaan pisteen.

            INSERT INTO Ruohonleikkuri (malli_id, sarjanumero, hyllypaikka) VALUES ((SELECT id From Malli WHERE nimi = 'TurboSlicer 100'), '4404', 'A1');

        Tai:

            INSERT INTO Ruohonleikkuri (malli_id, sarjanumero, hyllypaikka) SELECT id, '4404', 'A1' FROM Malli WHERE nimi = 'TurboSlicer 100' LIMIT 1;

    3. **Laske myyntitulot (myyntihintojen summa) päivälle 14.6.2014. Päivämäärä on ilmaistu date-tyyppinä. (0,5p)**

            SELECT SUM(myyntihinta) FROM Myynti WHERE päivämäärä = DATE '2014-06-01';

    4. **Laske myyntivoitto yhteensä (ostohinta vähennettynä myyntihinnasta) kaikille ruohonleikkureille joiden voimanlähde on ”ihminen” (voimanlähteen nimi). Myyntihinta pitää tarkistaa aina Myynti-taulusta, sillä asiakas on saattanut saada alennusta. (1p)**

            SELECT SUM(myynti.myyntihinta - hinta.ostohinta) FROM Myynti myynti, Ruohonleikkuri ruohonleikkuri, Malli malli, Voimalähde voimalähde, Hinta hinta WHERE myynti.ruohonleikkuri_id = ruohonleikkuri.id AND ruohonleikkuri.malli_id = malli.id AND malli.voimalähde_id = voimalähde.id AND malli.id = hinta.malli_id AND voimalähde.nimi = 'ihminen';

        Tai:

            SELECT SUM(myynti.myyntihinta) - SUM(hinta.ostohinta) FROM Myynti myynti JOIN Ruohonleikkuri ruohonleikkuri ON myynti.ruohonleikkuri_id = ruohonleikkuri.id JOIN Malli malli ON ruohonleikkuri.malli_id = malli.id JOIN Voimalähde voimalähde ON malli.voimalähde_id = voimalähde.id JOIN Hinta hinta ON malli.id = hinta.malli_id WHERE voimalähde.nimi = 'ihminen';

4. **Selitä lyhyesti seuraavat käsitteet. Anna kustakin käsitteestä myös lyhyt esimerkki.**

    Puolikkaan pisteen sai selityksestä, puolikkaan esimerkistä.

    1. **Relaatiomalli (1p)**

        Relaatiomalli on relaatiotietokannoissa oleva looginen tietomalli tiedolle. Relaatiomallissa voidaan täsmällisesti kuvata tietojen rakenne sekä tietoaineistoihin tehtävät haut, lisäykset ja muokkaukset. Relaatiomalli koostuu tauluista ja niiden sarakkeista, joissa jokainen rivi on samaa muotoa ja vastaa yksittäisestä tietueesta. Eri taulujen välillä tietoja yhdistetään yksikäsitteisten avainten avulla.

    2. **Tietokantaskeema (1p)**

        Tietokantaskeema kuvaa tietokannan rakenteen formaalisti. Mitä tauluja, attribuutteja, tietotyyppejä ja arvojoukkoja tietokantaan ja tauluihin liittyy. SQL-kielessä tietokantaskeema voidaan toteuttaa `CREATE TABLE`-lauseilla. Skeema siis määrittelee tiedon rakenteen ja mahdolliset siihen liittyvät rajoitteet.

    3. **Tietokantataulun avain, viiteavain ja yhdistelmäavain (1p)**

        Tietokantatauluilla on usein sarakkeena yksikäsitteinen avain (esimerkiksi tyypiltään numeraalinen arvo), joka yksilöi kunkin rivin (tietueen). Tällä avaimella voidaan helposti viitata yksittäiseen tietueeseen. Jokaiselle tietueella on oma avain. Taulun omaa avainta kutsutaan pääavaimeksi. Viiteavaimilla voidaan viitata toisen taulun tietueeseen. Viiteavain viittaa toisen taulun pääavaimeen ja on siksi samaa tyyppiä kuin pääavain. Taulun avain voi koostua myös monesta sarakkeesta. Sarakkeet yhdessä tekevät avaimesta yksilöllisen. Tälläistä avainta kutsutaan yhdistelmäavaimeksi.

    4. **Boyce-Codd normaalimuoto (1p)**

        Boyce-Codd normaalimuodon keskeinen idea on poistaa turha toisteisuus tietokannasta. Puhtaassa Boyce-Codd normaalimuodossa missään taulussa ei saa olla muita määrääviä funktionaalisia riippuvuuksia kuin pääavain. Mikäli taulusta löytyy useita määrääviä funktionaalisia riippuvuuksia, tulee riippuvuudet eriyttää omiin tauluihin.
