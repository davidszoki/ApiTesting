### For English version, please read below
# API Test

Egy általam választott ingyenes API-t teszteltem DDT (Data Driven Test) formájában. Az API [itt](https://github.com/Hipo/university-domains-list) érhető el. Arra kerestem a választ, hogy az általam manuálisan letesztelt adatokat egymás után folyamatosan lefuttatva is ugyanazokat az adatokat kapom vissza mint manuálisan. Az adatokat két .csv fájlba vettem fel, ezeket aztán a megfelelő teszt request beállítások után hozzá illesztettem a végponthoz változóként. Majd az elküldött keresési adatokat egy státusz kód ellenőrzés értékelése után kiírtam egy fájlba. A fájlok tartalmának olvashatósága érdekében készítettem egy segéd függvényt melyben ezeket átformázom így azok emberi szemmel is jól olvasható információkat tartalmaznak, mivel egyetlen egy soros Array of Objects-ként térnek vissza.

A repository klónozását követően nincs szükség változtatásra a fájlutvonalak tekintetében.

#### Felhasznált tecnológiák:
Java – Maven

Rest Assured

#### English Version:

I tested a free API of my choice in the form of a DDT (Data Driven Test). The API is available here (URL). I sought to answer whether the data I manually tested would return the same results when run continuously in sequence as they did manually. I recorded the data in two .csv files, which I then attached to the endpoint as variables after setting the appropriate test request configurations. Then, after evaluating the status code check of the sent search data, I wrote the results to a file. To ensure the readability of the file contents, I created a helper function that reformats the data, making it easily readable by humans since they return as a single-line Array of Objects.

After cloning the repository, no changes to the file paths are necessary.

#### Technologies used:
Java - Maven

Rest Assured
