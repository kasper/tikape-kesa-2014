Harjoitus 2
===========

## Relaatiomalli

1. **Tietokohteisiin liittyy attribuutteja, arvoja ja arvojoukkoja. Mitä nämä tarkoittavat? Anna esimerkki.**

    Jokaiseen tietokohteeseen liittyy ominaisuuksia, jotka halutaan esittää datana. Tällaisia ominaisuuksia mallinnetaan kohdetyyppeihin liittyvillä attribuuteilla (attribute). Kohdetyyppiin opiskelija liittyviä attribuutteja voisivat olla opiskelijanumero, syntymäaika, osoite, opiskelun aloitusvuosi, jne. Kohdetyyppiin kurssi liittyviä attribuutteja voisivat olla kurssinumero, nimi, opintopisteiden määrä ja kurssikuvaus.
    
    Tietyn yksittäisen kohteen ominaisuus esitetään datana attribuuttiin liitettävän arvon (value) avulla. Attribuutin kelvolliset arvot kuuluvat samaan arvojoukkoon (domain). Jokaisella arvojoukon arvolla on merkitys, kun sitä tarkastellaan attribuutin yhteydessä. Tarkastellaan arvojoukkona esimerkiksi pienten kokonaislukujen 0-300 järjestettyä joukkoa. Luvuilla itsessään ei ole mitään merkitystä. Kun näitä lukuja käytetään tietokohteen henkilö attribuutin pituus arvoina, niihin liitetään merkitys ’henkilön pituus senttimetreinä’. Tällöin esimerkiksi arvo 170 esittää, että kuvattava henkilö on 170 cm pitkä. Tietosisällön määrittelyssä esitellään attribuuttien arvojoukot ja kerrotaan yleisesti arvojen merkitykset. Merkitykset voi joutua kertomaan arvokohtaisesti, jos arvot ovat koodattua tietoa.

2. **Kartoita [viime viikon](/viikko-1/harjoitus.md) tehtävästä 5 tietokohteet, niiden väliset yhteydet ja osallistumisrajoitteet. Mieti tietokohteille attribuutit ja näille sopivia arvoja. Piirrä UML-luokkakaavio tietokohteista. Sisällytä luokkien attribuutit luokkakaavioon.**

    ![UML](http://yuml.me/3c7f6501)

3. **Selvitä mitä skeema, taulu, sarake ja rivi tarkoittavat tietokannassa.**

    **Skeema:** Relaatiotietokannan taulujen, eheysehtojen ja käyttöoikeuksien määrittely, joka on esitetty tietokannan määrittelykielellä.
    
    **Taulu:** Samaan rivin määrittelyyn liittyvien rivien monijoukko. Taulu on relaation toteutus relaatiotietokannassa. Taulu esitetään usein käyttäjälle siten, että rivit ovat allekkain vaakasuunnassa, sarakkeet pystysuunnassa. 
    
    **Sarake:** Taulussa eri riveillä samaan arvoalueen määrittelyyn liittyvien arvojen lista.
    
    **Rivi:** Arvojen lista, jossa esiintyy yksi tietyn arvoalueen arvo kutakin rivin määrittelyssä osoitettua arvoaluetta kohti näiden järjestyksessä.

4. **Mitä tarkoittaa pääavain *Primary key (PK)* ja viiteavain *Foreign key (FK)*? Entä yhdistelmäavain?**

    **Pääavain:** Monikon (rivin) pääasialliseksi tunnisteeksi valittu avainehdokas.
    
    **Viiteavain:** Attribuutti tai attribuuttiyhdistelmä (sarakenimien yhdistelmä), jonka avulla voidaan osoittaa jokin tietokannan yksittäinen monikko (rivi) käyttäen tämän perusavainta.
    
    **Yhdistelmäavain:** Kahdesta tai useammasta sarakkeesta muodostuva avain.

5. **Miten yhdestä–yhteen (Kaupunki → Postikoodi) ja yhdestä–moneen (Kaupunki → Asukas) relaatio toteutetaan relaatiomallissa? Entä monesta–yhteen (Asukas → Kaupunki)? Anna esimerkki tietokantakaaviona.**

    Yhdestä-yhteen -relaatiossa toinen puoli pitää viiteavainta toiseen (kumpi tahansa puoli käy).
    
    Yhdestä-moneen -relaatiossa "moni"-puoli pitää viiteavaimen "yksi"-puoleen, muuten sama kuin yhdestä-yhteen.
    
    Monesta-yhteen -relaatio on sama kuin yhdestä-moneen.
    
    ![Tietokantakaavio](http://yuml.me/9488db53)
    
    HUOM! Sekä yhdestä-yhteen, että yhdestä-moneen -relaatiot on mahdollista toteuttaa välitaululla, mutta tämä ei pääasiassa ole tarpeellista.

6. **Miten monesta–moneen (Avainsana → Uutinen) relaatio toteutetaan relaatiomallissa? Anna esimerkki tietokantakaaviona.**

    Monesta-moneen -relaatio vaatii lisätaulun, joka säilyttää viitteet kummankin osapuolen pääavaimiin.
    
    ![Tietokantakaavio](http://yuml.me/1866827c)

7. **Taulujen `Opettaa` ja `Kurssi` välille tehdään liitos jossa liitosehtona on sarakkeiden `kurssikoodi` yhtäsuuruus. Montako riviä on tulostaulussa?**

        Opiskelija(_opiskelijanumero_, nimi, sahkoposti, paaaine) [2000 riviä]
        Kurssi(_kurssikoodi_, nimi, opintopisteita) [200 riviä]
        Opettaja(_opettajatunnus_, nimi, sahkoposti, opetusaine) [100 riviä]
        Opettaa(_kurssikoodi → Kurssi_, _opettajatunnus → Opettaja_, _lukuvuosi_, _lukukausi_, _tehtava_, tunnit) [400 riviä]
        
    400 riviä. Kun kyselyn FROM-osassa annetaan useita tauluja, on tuloksena näiden taulujen ristitulo. Liitosehto kuitenkin karsii riviyhdistelmiä. Jokaiseen Opettaa-taulun riviin liittyy nyt oikeat kurssitiedot, mutta mitään ei myöskään rajata pois. Lisäinfoa esim. [http://www.cs.helsinki.fi/u/laine/tkp/sql/kysely3.html](http://www.cs.helsinki.fi/u/laine/tkp/sql/kysely3.html).

8. **Seuraavassa on kuvattuna chat-palvelu. Mitä allevivaukset ja nuolet tarkoittavat tekstipohjaisessa tietokantakuvauksessa? Piirrä chat-palvelu tietokantakaaviona.**

        Henkilo(_id_, kayttajatunnus, salasana)
        Huone(_id_, nimi, kuvaus)
        Viesti(_id_, henkilo_id → Henkilo, huone_id → Huone, aika, teksti)
        
    Alleviivatut attribuutit ovat pääavaimia ja nuolet osoittavat viiteavaimen kohteen (kohdetaulun pääavain).
    
    ![Tietokantakaavio](http://yuml.me/0968b72b)
