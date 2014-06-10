Harjoitus 4
===========

## Optimointi

1. **Selvitä mitä tarkoittavat funktionaalinen riippuvuus, Boyce-Codd analyysi ja -normaalimuoto. Onko alla oleva taulu normaalimuodossa? Mitä funktionaalisia riippuvuuksia siitä löytyy? Mieti ehdotelma miten ongelman voisi ratkaista.**

    | id | nimi      | syntymaaika | osasto_id | osasto_nimi | osasto_sijainti |
    |----|---------- |-------------|-----------|-------------|-----------------|
    | 1	 | Arvelo    | 1.3.80	   | 3	       | myynti	     | Helsinki        |
    | 2	 | Ahtisaari | 4.5.81	   | 3	       | myynti	     | Helsinki        |
    | 3	 | Ahtovuo   | 8.6.87	   | 4	       | hallinto	 | Espoo           |
    | 4  | Äimä      | 2.4.95	   | 4	       | hallinto	 | Espoo           |
    | 5	 | Alaja     | 1.2.85	   | 6         | tuotanto	 | Espoo           |

    Funktionaalisella riippuvuudella tarkoitetaan sitä, että sarakkeen arvon avulla pystytään selvittämään yksikäsitteinen arvo sarakkeesta funtionaalisesti riippuvalle sarakkeelle. Esimerkiksi henkilötunnuksen perusteella saadaan selville yksikäsitteinen nimi, syntymäaika, osoite, yms.

    **Boyce-Codd -normaalimuoto määritellään seuraavasti:**

    Relaatiokaavio on Boyce-Codd -normaalimuodossa, jos ja vain jos relaatiokaavioon ei liity yhtään sellaista funktionaalista riippuvuutta, jossa määrääjä ei sisältäisi relaation avainta.

    Boyce-Codd normaalimuodossa oleva tietokantakaavio voidaan määrätä minimaalisen riippuvuusjoukon perusteella seuraavasti:

    1. Ryhmittele riippuvuudet ryhmiin yhteisen määrääjän perusteella
    2. Muodosta kutakin ryhmää kohden relaatiokaavio, johon otat kaikki ryhmän riippuvuuksissa esiintyvät attribuutit
    3. Jos relaatiokaavion avain ei sisälly muodostettuihin relaatioihin, muodosta siihen kuuluvista attribuuteista oma relaatio
    4. Karsi mahdolliset saman asian toisteiset esitykset
    5. Anna muodostuneille relaatiokaavioille nimet. Jos niille löytyy nimet ja luonnollinen merkitys jakoa voi pitää onnistuneena.

    Kun tietokannan relaatiot ovat kaikki Boyce-Codd normaalimuodossa, ei tietokannassa ole lainkaan toisteista tietoa.

    Tehtävän tauluun liittyen voidaan löytää riippuvuudet:

        id → nimi
        id → syntymaaika
        id → osasto_id

        osasto_id → osasto_nimi
        osasto_id → osasto_sijainti

    Riippuvuuksien perusteella taulun avain on sarake id. Taulu ei ole Boyce-Codd -normaalimuodossa. Siinä esiintyy siis toistoa. Kun riippuvuudet ryhmitellään yhteisen määrääjän perusteella, saadaan ryhmät:

        id → nimi
        id → syntymaaika
        id → osasto_id

    ja

        osasto_id → osasto_nimi
        osasto_id → osasto_sijainti

    Näiden perusteella määräytyvät kaaviot:

        kaavio_1(id,  nimi, syntymaaika, osasto_id) ja
        kaavio_2(osasto_id, osasto_nimi, osasto_sijainti).

    Kun kaavioille annetaan uudet nimet, päädytään tauluihin:

        Työntekijä(_id_,  nimi, syntymaaika, osasto_id → Osasto) ja
        Osasto(_id_, osasto_nimi, osasto_sijainti).

2. **Relaatiotietokantojen suunnittelussa lähtöideana on tiedon toiston välttäminen. Tähän on muutamia syitä: toistuva tieto vie "turhaan" tilaa ja toistuvan tiedon ylläpitäminen on vaikeaa sillä jokaista kopiota on ylläpidettävä. Seuraavassa on esitetty Pankkitapahtuma-niminen relaatio. Jaa relaatio useampaan osaan siten, että suurin osa toisteisesta tiedosta vältetään.**

        Pankkitapahtuma(_id_, pankkitilin_numero, asiakkaan_etunimi, asiakkaan_sukunimi,
                        asiakkaan_henkilötunnus, otto_vai_pano, summa, tapahtumapäivä,
                        pankkivirkailija_etunimi, pankkivirkailija_sukunimi, tapahtuman_lisakuvaus)

    Löydetään riippuvuudet:

    |||
    |--- |---|
    | id → otto_vai_pano | Pankkitapahtumalla on tyyppi |
    | id → summa | Pankkitapahtumaan liittyy tietty määrä rahaa |
    | id → tapahtumapäivä | Pankkitapahtuma tapahtuu tiettyyn aikaan |
    | id → tapahtuman_lisakuvaus | Pankkitapahtumaan voi liittyä lisätietoja |
    | id → asiakas_id | Pankkitapahtuma liittyy tietyn asiakkaan tietoihin ja tiliin. Tämä sarake on uusi ja voisi olla tässä tapauksessa myös asiakkaan_henkilötunnus. |
    | asiakas_id → asiakkaan_henkilötunnus | Asiakkaalla on henkilötunnus |
    | asiakas_id → pankkitilin_numero | Asiakkaalla on pankkitili, tässä esimerkkiratkaisussa sallitaan asiakkaalle vain yksi tili, jos tilejä olisi enemmän per asiakas, pitäisi ne erottaa vielä omaan tauluunsa |
    | asiakas_id → asiakkaan_etunimi | Asiakkaalla on etunimi |
    | asiakas_id → asiakkaan_sukunimi | Asiakkaalla on sukunimi |
    | id → pankkivirkailija_id | Pankkitapahtuman käsittelee virkailija. Tämä sarake on uusi ja tässä tapauksessa lähes pakollinen lisäys, tunnistavaksi tekijäksi tuskin kannattaa laittaa etunimi-sukunimi -yhdistelmää. |
    | pankkivirkailija_id → pankkivirkailija_etunimi | Pankkivirkailijalla on etunimi |
    | pankkivirkailija_id → pankkivirkailija_sukunimi | Pankkivirkailijalla on sukunimi |

    Saadaan kaaviot:

        kaavio_1(id, otto_vai_pano, summa, tapahtumapäivä, tapahtuman_lisakuvaus, asiakas_id, pankkivirkailija_id)
        kaavio_2(asiakas_id, asiakkaan_henkilötunnus, pankkitilin_numero, asiakkaan_etunimi, asiakkaan_sukunimi)
        kaavio_3(pankkivirkailija_id, pankkivirkailija_etunimi, pankkivirkailija_sukunimi)

    ja näistä nimeällä taulut:

        Pankkitapahtuma(_id_, otto_vai_pano, summa, tapahtumapäivä, tapahtuman_lisakuvaus, asiakas_id → Asiakas, pankkivirkailija_id → Pankkivirkailija)
        Asiakas(_id_, asiakkaan_henkilötunnus, pankkitilin_numero, asiakkaan_etunimi, asiakkaan_sukunimi)
        Pankkivirkailija(_id_, pankkivirkailija_etunimi, pankkivirkailija_sukunimi)

3. **Selvitä mitä tarkoittaa ORM (Object-relational mapping). Mitä ORM-toteutukset (esim. Rails ActiveRecord tai Spring ORM) yleensä tarjoavat ja mikä niiden hyöty on?**

    ORM muuntaa dataa tietokantojen ja olio-ohjelmointikielten välillä. ORM toimii siis rajapintana dataan ja sen avulla pystytään käsittelemään tietoa suoraan ohjelmointikielen keinoin ilman kyselyjen kirjoittamista.

    Esimerkiksi: sen sijaan, että kirjoitettaisiin

        String kysely = "SELECT ... FROM kayttajat WHERE id = 10";
        TkKomento komento = new TkKomento(kysely);
        Tulos tulos = komento.execute();
        String nimi = res.get(0)["NIMI"];

    voidaan kirjoittaa

        Kayttaja k = kayttajaRepository.find(10);
        String nimi = k.getNimi();

    Jokainen kirjasto tarjoaa oman toteutuksen tähän, joten syntaksieroja on paljon.

    ORM-toteutukset tarjoavat mm.

        * Tietokantamallien muuntamisen olio-ohjelmointiparadigmaan (sarakkeista olioiden kentiksi jne.)
        * Olioiden validoinnin ennen tallennusta
        * Välimuistit
        * Helpot rajapinnat tiedon hakemiseen, tallentamiseen, päivittämiseen ja poistamiseen
        * Skeeman ylläpito (migraatiot, esim. tietokantataulujen sarakkeiden muutokset)
        * Yhteensopivuuden eri tietokantajärjestelmien kanssa (SQLite, PostgreSQL, Oracle, MongoDB)

4. **Relaatiotietokannat ovat vain eräs tietokantatyyppi. 2000-luvulla nousi suosioon NoSQL-käsite. Mitä NoSQL:llä tarkoitetaan ja mitä NoSQL-tietokantoja on olemassa?**

    NoSQL-tietokannat on tehty säilyttämään ei-relationaalista dataa. Tällaista dataa on esim. avain-arvo -parit, graafit ja dokumentit.

    NoSQL-tietokantoja ovat mm.

        * Hadoop
        * MongoDB
        * Redis
        * Neo4j

    NoSQL-tietokannat tarjoavat optimoituja malleja tiedon tallentamiseen tietyissä käyttötarkoituksissa (mm. suuret määrät dataa, tehokas rinnakkaisuus ja spesifit tietorakenteet kuten verkot).

5. **NoSQL-tietokannat ovat menettäneet hieman nostettaan. Mistä tämä voisi johtua?**

    Suurin osa datasta sisältää relaatioita. NoSQL-tietokantoja sopivat huonosti yhteyksiä sisältävän datan käsittelyyn (monta kyselyä vs. relaatiotietokannan ~yksi) ja relaatiot on hallittava itse. Käyttötarkoitus ja tietokantatyyppi on siis sovitettava yhteen — jokaisella on hyvät ja huonot puolet.

6. **MongoDB on yksi *dokumenttipohjainen* NoSQL-tietokanta. Mitkä ovat sen edut? Tutustu MongoDB:n käyttörajapintaan osoitteessa http://try.mongodb.org.**

    * Kyselykieli on hyvin tarkka, verrattavissa SQL:ään yhden taulun tasolla (http://docs.mongodb.org/manual/core/read-operations-introduction/)
    * Skeematon (ei välttämättä etu)
    * Rakennettu skaalautuvaksi (esim. monelle palvelimelle)
    * MongoDB:n dokumentit ovat hyvin verrattavissa esim. JSON:iin ja Rubyn Hasheihin ja mm. näissä kielissä dokumenttien käsittely on helppoa
