# Las Vegas Algoritma Analizi ve Zaman Karmasikligi

Bu proje, buyuk bir veri seti (10^6 eleman) icerisinde belirli bir matematiksel kosulu (mod 777) saglayan ozel bir elemanin **Las Vegas Yaklasimi** ile tespit edilmesini amaclar. Proje kapsaminda rastgeleligin calisma suresi ve adim sayisi uzerindeki etkileri deneysel olarak ispatlanmistir.

## Parametreler
- **Algoritma Tipi:** Las Vegas 
- **Veri Hacmi (n):** 1.000.000 
- **Rastgele Sayi Uretici (Seed):** 1240505015
- **Basari Kriteri:** %100 dogru sonuc bulana kadar calisma.

## Deneysel Sonuclar (100 Tekrar Ortalamasi)
Yapilan testler sonucunda elde edilen veriler:

| Parametre | Deger |
|-----------|-------|
| Ortalama Adim Sayisi | 685.07 |
| Ortalama Calisma Suresi | 0.0952 ms |
| Sure Standart Sapmasi | 0.1062 ms |

## Kullanilan Teknolojiler
- **Dil:** Java
- **IDE:** IntelliJ IDEA
- **Yontem:** Olasiliksal Algoritmalar (Las Vegas)

## Matematiksel Ozet
Algoritmanin hedef elemani bulma olasiligi p = 1/777 olarak belirlenmistir. 
Teorik beklenen adim sayisi E[X] = 1/p = 777'dir. 
Deneysel olarak elde edilen 685.07 degeri, teorik beklentiyle istatistiksel olarak uyumludur.
