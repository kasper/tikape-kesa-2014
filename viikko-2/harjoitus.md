Harjoitus 2
===========

Harjoitukset on tarkoitus tehdä (tai rehellisesti yrittää) ennen tilaisuutta. Tilaisuudessa jakaudutaan ryhmiin, joissa pohditaan tehtäviä ja lopuksi ryhmät esittelevät ratkaisujaan.

## Relaatiomalli

1. Tietokohteisiin liittyy attribuutteja, arvoja ja arvojoukkoja. Mitä nämä tarkoittavat? Anna esimerkki.

2. Kartoita [viime viikon](/viikko-1/harjoitus.md) tehtävästä 5 tietokohteet, niiden väliset yhteydet ja osallistumisrajoitteet. Mieti tietokohteille attribuutit ja näille sopivia arvoja. Piirrä UML-luokkakaavio tietokohteista. Sisällytä luokkien attribuutit luokkakaavioon.

3. Selvitä mitä skeema, taulu, sarake ja rivi tarkoittavat tietokannassa.

4. Mitä tarkoittaa pääavain *Primary key (PK)* ja viiteavain *Foreign key (FK)*? Entä yhdistelmäavain?

5. Miten yhdestä–yhteen (Kaupunki → Postikoodi) ja yhdestä–moneen (Kaupunki → Asukas) relaatio toteutetaan relaatiomallissa? Entä monesta–yhteen (Asukas → Kaupunki)? Anna esimerkki tietokantakaaviona.

6. Miten monesta–moneen (Avainsana → Uutinen) relaatio toteutetaan relaatiomallissa? Anna esimerkki tietokantakaaviona.

7. Taulujen `Opettaa` ja `Kurssi` välille tehdään liitos jossa liitosehtona on sarakkeiden `kurssikoodi` yhtäsuuruus. Montako riviä on tulostaulussa?

        Opiskelija(_opiskelijanumero_, nimi, sahkoposti, paaaine) [2000 riviä]
        Kurssi(_kurssikoodi_, nimi, opintopisteita) [200 riviä]
        Opettaja(_opettajatunnus_, nimi, sahkoposti, opetusaine) [100 riviä]
        Opettaa(_kurssikoodi → Kurssi_, _opettajatunnus → Opettaja_, _lukuvuosi_, _lukukausi_, _tehtava_, tunnit) [400 riviä]

8. Seuraavassa on kuvattuna chat-palvelu. Mitä allevivaukset ja nuolet tarkoittavat tekstipohjaisessa tietokantakuvauksessa? Piirrä chat-palvelu tietokantakaaviona.

        Henkilo(_id_, kayttajatunnus, salasana)
        Huone(_id_, nimi, kuvaus)
        Viesti(_id_, henkilo_id → Henkilo, huone_id → Huone, aika, teksti)
