Harjoitus 4
===========

Harjoitukset on tarkoitus tehdä (tai rehellisesti yrittää) ennen tilaisuutta. Tilaisuudessa jakaudutaan ryhmiin, joissa pohditaan tehtäviä ja lopuksi ryhmät esittelevät ratkaisujaan.

## Optimointi

1. Selvitä mitä tarkoittavat funktionaalinen riippuvuus, Boyce-Codd analyysi ja -normaalimuoto. Onko alla oleva taulu normaalimuodossa? Mitä funktionaalisia riippuvuuksia siitä löytyy? Mieti ehdotelma miten ongelman voisi ratkaista?

    | id | nimi      | syntymaaika | osasto_id | osasto_nimi | osasto_sijainti |
    |----|---------- |-------------|-----------|-------------|-----------------|
    | 1	 | Arvelo    | 1.3.80	   | 3	       | myynti	     | Helsinki        |
    | 2	 | Ahtisaari | 4.5.81	   | 3	       | myynti	     | Helsinki        |
    | 3	 | Ahtovuo   | 8.6.87	   | 4	       | hallinto	 | Espoo           |
    | 4  | Äimä      | 2.4.95	   | 4	       | hallinto	 | Espoo           |
    | 5	 | Alaja     | 1.2.85	   | 6         | tuotanto	 | Espoo           |

2. Relaatiotietokantojen suunnittelussa lähtöideana on tiedon toiston välttäminen. Tähän on muutamia syitä: toistuva tieto vie "turhaan" tilaa ja toistuvan tiedon ylläpitäminen on vaikeaa sillä jokaista kopiota on ylläpidettävä. Seuraavassa on esitetty Pankkitapahtuma-niminen relaatio. Jaa relaatio useampaan osaan siten, että suurin osa toisteisesta tiedosta vältetään.

        Pankkitapahtuma(_id_, pankkitilin_numero, asiakkaan_etunimi, asiakkaan_sukunimi,
                        asiakkaan_henkilötunnus, otto_vai_pano, summa, tapahtumapäivä,
                        pankkivirkailija_etunimi, pankkivirkailija_sukunimi, tapahtuman_lisakuvaus)

3. Selvitä mitä tarkoittaa ORM (Object-relational mapping). Mitä ORM-toteutukset (esim. Rails ActiveRecord tai Spring ORM) yleensä tarjoavat ja mikä niiden hyöty on?

4. Relaatiotietokannat ovat vain eräs tietokantatyyppi. 2000-luvulla nousi suosioon NoSQL-käsite. Mitä NoSQL:llä tarkoitetaan ja mitä NoSQL-tietokantoja on olemassa?

5. NoSQL-tietokannat ovat menettäneet hieman nostettaan. Mistä tämä voisi johtua?

6. MongoDB on yksi *dokumenttipohjainen* NoSQL-tietokanta. Mitkä ovat sen edut? Tutustu MongoDB:n käyttörajapintaan osoitteessa http://try.mongodb.org.
