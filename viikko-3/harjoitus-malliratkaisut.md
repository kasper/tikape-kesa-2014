Harjoitus 3
===========

## SQL

1. **Mitä SQL-standardeja on olemassa ja tukevatko kaikki tietokannat näitä samalla tavalla? Mitä yleisiä tietotyyppejä SQL-tietokannoissa on?**

    SQL on ANSI-standardisoitu vuonna 1986 ja ISO-standardisoitu vuonna 1987. Nykyään standardia ylläpitää ISO:on ja IEC:in liittyvä "Joint Technical Committee ISO/IEC JTC 1, Information technology, Subcommittee SC 32, Data management and interchange". SQL-standardia on tarkennettu seitsemän kertaa julkaisun jälkeen. Viimeisin standardi on nimeltään SQL:2011 tai ISO/IEC 9075:2011. SQL-standardi on jaoteltu yhdeksään osaan.

    Kaikki tietokannat eivät tue koko standardia. Esimerkiksi lainauksena SQLiten sivuilta:

    "SQLite understands most of the standard SQL language. But it does omit some features while at the same time adding a few features of its own."

    Pääasiassa suurin osa ydinstandardista on toteutettuna kaikissa tietokannoissa. Suurimmat tietokannat toteuttavat standardin lähes täysin. Lisäksi lähes kaikki tietokannat lisäävät omia ei-standardisoituja ominaisuuksia, kuten apufunktioita. Esimerkkinä MySQL datediff() verrattuna esim. Oraclen date - date.

    Yleisiä tietotyyppejä ovat mm. vaihtelevan pituinen merkkijono VARCHAR(n), totuusarvo BOOLEAN, kokonaisluku INTEGER, liukuluku FLOAT ja päivämäärä DATE.

2. **Käyttötapauksia [viime viikon](/viikko-2/harjoitus.md) tehtävän 8 chat-palveluun liittyen. Kerro minkälaisella SQL-kyselyllä seuraavat käyttötapaukset luonnistuisivat.**
    * **Palvelun ylläpitäjä haluaa lisätä uuden chat-huoneen. Chat-huoneen nimi on `viherpeukalot` ja kuvaus on `Vihreä kesä`.**

            INSERT INTO Huone (id, nimi, kuvaus) VALUES (1, "viherpeukalot", "Vihreä kesä");
    * **Palvelun ylläpitäjä haluaa lisätä uuden käyttäjän. Uuden käyttäjän käyttäjätunnus on `aimo` ja salasana `porkkana`.**

            INSERT INTO Henkilo (id, kayttajatunnus, salasana) VALUES (1, "aimo", "porkkana");

        Huom! Salasanan säilyttäminen tietokannassa salaamattomana on todella huono idea.
    * **Käyttäjä `aimo` kirjoittaa viestin `Moi kaikki!` huoneeseen `virherpeukalot`**

            INSERT INTO Viesti (id, henkilo_id, huone_id, aika, teksti) VALUES (1, 1, 1, "2014-06-01T10:11:12", "Moi kaikki!");
    * **Tuntematon käyttäjä yrittää kirjautua käyttäen käyttäjätunnusta `testi` ja salasanaa `salasana`**

        Kirjautumisyritys aiheuttaa kantaan kyselyn

            SELECT * FROM Henkilo WHERE kayttajatunnus = "testi" AND salasana = "salasana";

        joka palauttaa 0 riviä (oletetaan, että kannassa vain aimo). Ohjelma tulkitsee tämän vääränä tunnus-salasana -yhdistelmänä.

3. **Luo [viime viikon](/viikko-2/harjoitus.md) tehtävän 8 tietokantatauluille SQL CREATE-TABLE-lauseet. Mieti sopivat rajoitteet sarakkeille.**

        CREATE TABLE Henkilo (id INTEGER PRIMARY KEY NOT NULL, kayttajatunnus VARCHAR(255) NOT NULL UNIQUE, salasana VARCHAR(255) NOT NULL);
        CREATE TABLE Huone (id INTEGER PRIMARY KEY NOT NULL, nimi VARCHAR(255) NOT NULL, kuvaus VARCHAR(255));
        CREATE TABLE Viesti (id INTEGER PRIMARY KEY NOT NULL, henkilo_id INTEGER, huone_id INTEGER, aika DATETIME, teksti VARCHAR(255), FOREIGN KEY (henkilo_id) REFERENCES Henkilo(id), FOREIGN KEY (huone_id) REFERENCES Huone(id));

    Vaatisi lisäksi Huonetta poistettaessa Viestien poiston aiheuttavan lisäehdon.

4. **Tee SQLite-tietokanta, johon suoritat edelliset tehtävät. Lisää tietokantaan lisää käyttäjiä, kanavia ja viestejä. Lisää tietokantaan myös joku uusi vapaavalintainen taulu ja siihen tietoja. Pääset tehtävässä alkuun katsomalla lyhyen [SQLite-oppaan](/sqlite.md). Ota komennot ja tulokset talteen.**

    Tämän voi tehdä esimerkkiratkaisujen mukaisesti omatoimisesti.

5. **[Tik](http://tik.herokuapp.com) on tehtävälistasovellus. Löydät sovelluksen SQLite-tietokannan [tästä](/tehtavat/tik.sqlite?raw=true). Suorita seuraavat käyttötapaukset ja ota ne talteen.**

    ```
    sqlite> .schema
    CREATE TABLE "schema_migrations" ("version" varchar(255) NOT NULL);
    CREATE TABLE "taggings" ("id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "tag_id" integer, "task_id" integer, "created_at" datetime, "updated_at" datetime);
    CREATE TABLE "tags" ("id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "name" varchar(255), "created_at" datetime, "updated_at" datetime);
    CREATE TABLE "tasks" ("id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "description" varchar(255), "completed" boolean, "owner_id" integer, "created_at" datetime, "updated_at" datetime, "creator_id" integer);
    CREATE TABLE "teams" ("id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "name" varchar(255), "created_at" datetime, "updated_at" datetime);
    CREATE TABLE "users" ("id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "username" varchar(255), "created_at" datetime, "updated_at" datetime, "team_id" integer, "password_digest" varchar(255), "admin" boolean);
    CREATE UNIQUE INDEX "unique_schema_migrations" ON "schema_migrations" ("version");
    ```
    * **Hae kaikki käyttäjän `kasper` tehtävät**

        ```
        sqlite> SELECT description, users.id AS user_id, creator_id FROM tasks, users WHERE tasks.creator_id = users.id AND users.username = "kasper";
        description        user_id     creator_id
        -----------------  ----------  ----------
        Create a new task  1           1
        Code Tik           1           1
        ```
    * **Lisää käyttäjälle `jack` uusi tehtävä, jonka omistaja on `kasper`**

        ```
        sqlite> SELECT id, username FROM users;
        id          username
        ----------  ----------
        1           kasper
        2           jack
        sqlite> INSERT INTO tasks (creator_id, owner_id, description) VALUES (2, 1, "uusi tehtävä");
        sqlite> SELECT description, creator_id, owner_id, id FROM tasks;
        description        creator_id  owner_id    id
        -----------------  ----------  ----------  ----------
        Create a new task  1           1           1
        Code Tik           1           1           2
        Create another ta  2           2           3
        uusi tehtävä     2           1           4
        ```
    * **Liitä tehtävään avainsanoiksi `critical` ja `enhancement`**
        ```
        sqlite> SELECT name, id FROM tags;
        name        id
        ----------  ----------
        critical    1
        enhancemen  2
        feature     3
        sqlite> SELECT description, creator_id, owner_id, id FROM tasks;

        description        creator_id  owner_id    id
        -----------------  ----------  ----------  ----------
        Create a new task  1           1           1
        Code Tik           1           1           2
        Create another ta  2           2           3
        uusi tehtävä     2           1           4
        sqlite> INSERT INTO taggings (tag_id, task_id) VALUES (1, 4);
        sqlite> INSERT INTO taggings (tag_id, task_id) VALUES (2, 4);
        sqlite> SELECT tags.name, description FROM tags, taggings, tasks WHERE tags.id = taggings.tag_id AND tasks.id = taggings.task_id AND tasks.id = 4;
        name        description
        ----------  --------------
        critical    uusi tehtävä
        enhancemen  uusi tehtävä
        ```
    * **Lisää uusi `User Experience`-tiimi ja liitä sekä `kasper` että `jack` sen jäseniksi**

        ```
        sqlite> INSERT INTO teams (name) VALUES ("User Experience");
        sqlite> SELECT name, id FROM teams;
        name        id
        ----------  ----------
        Software    1
        User Exper  2
        sqlite> SELECT users.id as user_id, teams.id as team_id, username, name FROM users, teams WHERE teams.id = users.team_id;
        user_id     team_id     username    name
        ----------  ----------  ----------  ---------------
        1           1           kasper      Software
        2           1           jack        Software
        sqlite> UPDATE users SET team_id = 2 WHERE username = "jack" OR username = "kasper";
        sqlite> SELECT users.id as user_id, teams.id as team_id, username, name FROM users, teams WHERE teams.id = users.team_id;
        user_id     team_id     username    name
        ----------  ----------  ----------  ---------------
        1           2           kasper      User Experience
        2           2           jack        User Experience
        ```
    * **Poista lopuksi `Software`-tiimi**

        ```
        sqlite> SELECT name, id FROM teams;
        name        id
        ----------  ----------
        Software    1
        User Exper  2
        sqlite> DELETE FROM teams WHERE id = 1;
        sqlite> SELECT name, id FROM teams;
        name             id
        ---------------  ----------
        User Experience  2
        ```

6. **Mitä tarkoittaa tietokantatransaktio? Milloin transaktiota kannattaa käyttää ja mitä hyötyä siitä on?**

    Tietokantatransaktio on tietokantaa käsittelevä prosessin osa, jonka vaikutusten halutaan muodostavan yhden jakamattoman (atomisen) kokonaisuuden.

    Esimerkiksi tilisiirtotapahtuma, kolmiosainen kysely:

    1. muokkaa siirtäjän tilitietoja
    2. muokkaa saajan tilitietoja
    3. lisää tilitapahtumiin tieto.

    Esimerkissä jakamattomuus merkitsee sitä, että kaikki 3 tietokantaoperaatiota suoritetaan eikä vain osaa niistä.

    Käsittelyssä voi sattua häiriöitä missä vaiheessa tahansa. Nämä voivat johtua ulkoisista syistä tai olla tietokannan itse aiheuttamia.
    Ilman transaktiota voisi siis käydä siten, että tililtä lähtee rahat, mutta saaja ei ikinä saa rahojaan – tällöin operaatio ei olisi jakamaton.

    Transaktiota kannattaa käyttää kun joukko muutoksia pitää tehdä kokonaisuudessaan ollakseen validi tapahtuma. Toisin sanoen: jos on mahdollisuus, että tietokannan tila on väärä kun vain osa kyselystä toteutuu, käytä transaktiota. Transaktio mahdollistaa mm. sen perumisen kokonaisuudessaan sen epäonnistuessa. Kyselyt suoritetaan myös kokonaisuutena, joten muutoksia ei voi tapahtua transaktion "keskellä".

7. **Mitä tarkoittaa SQL-injektio ja miten siihen voi varautua? Kokeile suorittaa SQL-injektioita [Väestörekisteriin](http://t-khirviko.users.cs.helsinki.fi/vaestorekisteri/). Arto Vihavaisen lompakko tippui Unicafen kassalle ja tiedämme hänen SOTU:n olevan `010190-111A`.**

    SQL-injektiossa ideana on saada ohjelma suorittamaan SQL-kyselyitä, joita ohjelmaa ei ole tarkoitettu tekemään. Esimerkiksi ohjelmakoodissa kysely voitaisiin muodostaa näin:

        statement = "SELECT * FROM users WHERE name ='" + userName + "';"

    ja käyttäjä voisi määritellä userName:ksi

        ' or '1'='1

    syntyisi kysely

        SELECT * FROM users WHERE name = '' OR '1'='1';

    Tällöin jos kyselyä käytettäisiin esimerkiksi autentikointiin tai tietojen listaukseen, saisi SQL-injektion tekijä oikeudet tai listauksen kaikista käyttäjistä.

    SQL-injektioita voidaan estää esimerkiksi parametrisoimalla kyselyt. Tällöin kyselyt ovat muotoa

        INSERT INTO PRODUCT (name, price) VALUES (?, ?)

    ja puuttuvat arvot (?) annetaan erikseen parametreina kyselylle. Kyselyn parametrit automaattisesti suodatetaan ("escaping" tai vastaava).

    Lisää tietoa esim. [http://en.wikipedia.org/wiki/Sql_injection](http://en.wikipedia.org/wiki/Sql_injection) tai [http://www.unixwiz.net/techtips/sql-injection.html](http://www.unixwiz.net/techtips/sql-injection.html)

    Väestörekisterikyselyssä tarvitsee tehdä oletuksia kyselyn muodosta. Voimme esimerkiksi olettaa, että kysely olisi muotoa

        SELECT * FROM taulu WHERE sotu = ?

    tai koska Väestörekisteri on huonosti suunniteltu voi ? olla muuttujana koodissa ja saamme määritellä sen itse. Eli oletetaan koodiksi jotain tällaista:

        String kysely = "SELECT * FROM taulu WHERE sotu = '" + sotu + "'";

    Nyt haluamme taulun koko sisällön eli laitamme lomakkeeseen kyselyksi sopivan pätkän, joka antaa hyväksyvän totuusarvon jokaisen rivin kohdalla taulussa. Eli

        ' OR 'x' = 'x

    Huomioi '-merkkien kohdat. Nyt kysely on muotoa

        SELECT * FROM taulu WHERE sotu = '' OR 'x' = 'x'

    eli "kaikki henkilöt, joiden sotu on tyhjä TAI kirjain x on kirjain x" ja testaamalla lomakkeeseen saadaan ulos suuri määrä henkilötietoja.
