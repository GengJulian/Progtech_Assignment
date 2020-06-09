# Progtech beadandó
Raktárrendszert menedzselő program, a manager felületen lehetőség van rendelést leadni, a raktárakról különféle információkat lekérdezni, menedezselni a beszállítókat. 
## Felhasznált tervezési minták
### Factory
A különféle termékek, különböző raktárak létrehozásához használtam, így a későbbiekben könnyeben lehet kibővíteni új típusú termékekkel,raktárakkal a programot.

### Singleton
A termék és raktár objektumokat példányosító factory osztályokat a singleton tervezési minta felhasználásával valósítottam meg, mert nem láttam értelmét annak hogy egyszerre több factory-t lehessen példányosítani a manager osztályból.

### Observer
Az observer tervezési mintát használtam fel a raktárak autómatikus feltöltésére. Ha a rendelt termék egyik raktárban sincs készleten, akkor a megfelelő típusú beszállító jelzést kap, és visszaküldi a raktárba a megfelelő terméket.

### Template
A template patternt a termékek előállításánál alkalmaztam, az előállítás menete adott, viszont a különféle fázisok típusonként változhatnak pl. csomagolás.

### Adapter
A warehouse interfészt nem implementáló raktárak csatlakoztatását valósítottam meg az adapter pattern felhasználásával az WarehouseFactory osztályban.
Megfeleltettem az "idegen" raktár metódusait a warehouse interfészt implementáló raktárak metódusainak.

## Teszt
Teszteléshez a JUnit5 keretrendszert használtam.
Letesztelt osztályok, azok metódusai:
* BookSupplier
    * produce: Előállítja a rendelésnek megfelelő mennyiségű könyvet.
    * getType: Visszaadja a beszzállító típusát.
    * sendProduct: Elküldi a raktárnak a legyártott termékeket.
    * packageProduct: Az előállított terméket becsomgaolja.
    * update: A raktártól érkező megrendelés kezelését végzi.
* ItemFactory
    * getInstance: Visszaad egy factory példányt.
    * createBook: Példányosít egy új book példányt.
    * createFood: Példányosít egy új food példányt.
    * createElectronicDevice: Példányosít egy új ElectronicDevice példányt.
* LargeWarehouse
    * listStockpile: Kilistázza a raktár tartalmát.
    * listSuppliers: Kilistázza a beszállítókat.
    * getItem: A rendelés kiszolgálása. 
    * orderSupply: Raktár feltöltése áruval manuálisan.
    * registerSupplier: Új besszállító hozzáadása.
    * unregisterSupplier: Besszállító eltávolítása.
    * notifySuppliers: Beszállítók értesítése áruhiány esetén.
* Manager
    * numberOfWarehouses: Visszadja a menedzselt raktárak számát.
    * addWarehouse: Felvesz egy új raktárat a menedzselt raktárak közé.
    * removeWarehouse: Eltávolítja a kiválasztott raktárat a menedzselt raktárak közül.
    * registerSupplier: Új beszállítót adunk hozzá a kiválasztott raktárhoz.
    * unregisterSupplier: Eltávolítunk egy beszállítót a kiválasztott raktártól.
    * listWarehouses: Kilistázza a menedzselt raktárakat.
    * listStockpile: Kilistázza a kiválasztott raktár tartalmát.
    * listSuppliers: Kilistázza egy adott raktárhoz tartozó beszállítókat.
    * orderItem: Rendelés leadása a raktárakhoz. 
    * orderSupply: Kiválasztott raktárba szállítmány rendelése.
    * numOfSpecificItemInWarehouse: Adott tárgy darabszámának lekérdezése egy adott raktárból.



