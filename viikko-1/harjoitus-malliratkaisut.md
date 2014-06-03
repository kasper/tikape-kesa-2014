Harjoitus 1
===========

1. **Kerro mitä käsitteet *tietokanta* (database) ja *tieto* (data) tarkoittavat. Miksi kaikkea tietoa ei kannata tallentaa yksittäisiin tiedostoihin? Tieto voidaan jakaa kolmeen tasoon: käsitetaso, rakennetaso ja talletustaso. Mikä näiden tasojen rooli on?**

  **Tieto**: digitaalisesti tallennettua informaatiota jostakin kohteesta.

  **Tietokanta**: jotakin käyttötarkoitusta varten laadittu kokoelma toisiinsa liittyviä säilytettäviä tietoja.
    
  Yksittäisiin tiedostoihin tallentaminen ei ole kätevää jos datamäärä on suurta ja siitä pitää esimerkiksi etsiä osia. Lisäksi yksittäisen tiedoston samanaikainen käyttö (esim. monen ohjelman toimesta) on todella hidasta. Lisää syitä tehtävässä 3 (Mitä tietokannat tarjoavat?).

  **Käsitetaso**
  * Mitä tietoja käsitellään?
  * Miten tiedot liittyvät yhteen?
  * Mitä sääntöjä tietoihin liittyy?

  **Rakennetaso**
  * Minkälaisia käsiteltäviä rakenteita tiedot muodostavat?
  * Esim. eri ohjelmointikielten näkemykset tiedosta
  * Millaisina rakenteina ohjelmoijat ja tietokannan suorakäyttäjät näkevät tiedot?

  **Talletustaso**
  * Minkälaisina rakenteina tiedot tallennetaan ja miten niitä voidaan käsitellä?
  * Miten tieto on koodattu, tiivistetty ja suojattu?
  * Minkälaiset rakenteet tehostavat tiedon hakua?
  * Onko tiedot hajautettu vai keskitetty?

  Eli lyhyesti: käsitetasolla tarkastellaan sisältöä, rakennetasolla muotoa ja talletustasolla teknistä toteutusta.

2. **Mitä rakenteiset JSON- ja XML-tietoformaatit ovat ja miten ne sisältävät tietoa? Selvitä mitä XML-skeema tarkoittaa.**

  JSON on tiedon esitysmuoto, jossa tieto koostuu avain–arvo -pareista.

  XML on tiedon esitysmuoto, jossa tiedon merkityksen voi upottaa tiedon sekaan. XML koostuu elementeistä, joissa on alku- ja lopputagit. Tagien välissä on elementin sisältö. Elementit voivat lisäksi sisältää attribuutteja.

  XML-skeema määrittelee mitä elementtejä XML-dokumentissa saa käyttää, mitä attribuutteja niihin sisältyy, missä järjestyksessä ne voivat olla sekä mitkä elementit voivat sisältää mitäkin elementtejä.

3. **Mitä tietokannat tarjoavat? Mikä on relaatiotietokanta ja mitä eri relaatiotietokantajärjestelmiä on olemassa? Mihin nämä tietokannat tallentavat tiedon?**

  Tietokannat tarjoavat mm.
  * Tietoriippumattomuuden (tietokanta toimii abstraktiona ja sitä käyttävillä ohjelmilla voi olla oma "käsitys" tietokannan tiedosta)
  * Usean käyttäjän samanaikaisen käytön
  * Laajat hakumahdollisuudet
  * Tarkan suojauksen (jopa yksittäisen kentän tasolla)
  * Vahvistetut operaatiot, virheistä toipuminen

  Relaatiotietokannassa tieto on jaoteltuna osiin, tauluihin. Taulujen välille voi luoda yhteyksiä.

  Tiedon tallentaminen on riippuvainen toteutuksesta. Kaikki tieto voi olla esim. yhdessä tiedostossa tai tiedostoja voi olla yksi per taulu. Tietokannat voivat tallentaa tiedon myös väliaikaismuistiin. (http://en.wikipedia.org/wiki/Database_storage_structures)

4. **Anna vähintään kaksi erillistä esimerkkiä palveluista jotka käyttävät tietokantaa. Yritä selvittää mitä tietokantaa (esim. PostgreSQL) palvelut käyttävät.**

  Twitterillä on käytössä mm. MySQL, lisäksi he ovat kehittäneet omaan käyttöönsä FlockDB-nimisen tietokannan graafien tallentamiseen (suhteet Twitter-verkostossa, esim. kuka seuraa ketä).

  Github käyttää mm. MySQL ja Redis -tietokantoja.

5. **Hae seuraavasta tekstistä vähintään neljä käsitettä (esim. uimaseura), joiden ilmentymiä (esim. Loch Nessin hirviöt) voisi mielestäsi tallentaa uimaseurojen tuloksia sisältävään tietokantaan. Keksitkö myös muita mahdollisia tallennettavia asioita?**

    > Uimaseuramme Loch Nessin hirviöt on tähän päivään asti käyttänyt paperia uimareidensa tulosten seuraamiseen ja ylläpitoon. Uimaseuraamme juuri liittynyt valmennuspäällikkö vaatii kirjanpidon nykyaikaistamista, ja haluaa että tulokset tallennetaan tietokoneelle.

    > Valmennuspäällikkömme antoi minulle tehtäväksi välittää tietoa seurastamme, eli tässäpä sitä: Meillä on noin sata mies- ja naispuolista uimaria. Uimarit kilpailevat yleensä yhdessä lajissa, esimerkiksi selkäuinnissa, mutta jotkut uimarit kilpailevat useammassakin lajissa. Tuloksia kirjataan sekä kuukausittain järjestettävistä seuran sisäisistä "kuukauden vesihiisi"-kisoista, että jokaisesta seuran ulkopuolella järjestettävästä kilpailusta. Valmentajien tulee pystyä käyttämään tietokoneelle tallennettuja tietoja myös kotoa esimerkiksi internetin välityksellä.

    > Mitä mieltä olette edeltävästä järjestelmätarpeesta, olisiko sellainen mahdollista toteuttaa?

    > Ystävällisin terveisin,  
    > Hengenpelastaja Arto Vihavainen

  **Käsitteet**: Uimaseura, Uimari, Laji, Tulos, Kilpailu/Kisa. Mahdollisesti myös Valmentaja, mutta voi olla Uimarissa lisäattribuuttina jos Valmentajat ovat aina Uimareita.

6. **Kerro sanallisesti miten edellisessä tehtävässä löydetyt käsitteet liittyvät toisiinsa.**

  Uimaseurassa on monta Uimaria, Uimari on myös mahdollisesti monessa Uimaseurassa. Uimari kilpailee monessa Lajissa, ja Lajiin liittyy monta Uimaria. Kisassa on monta Tulosta, Tulos liittyy yhteen Kisaan. Tulokseen liittyy yksi Uimari tai mahdollisesti monta joukkuelajeissa. Uimarilla voi olla monta Valmentajaa ja Valmentajalla voi olla monta Uimaria valmennettavana.
