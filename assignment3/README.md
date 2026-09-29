# Assignment 3 - Composition (Ayah & Rumah)

## Deskripsi

Assignment 3 membahas konsep **Composition/Aggregation** dalam Pemrograman Berorientasi Objek menggunakan Java, melalui studi kasus perhitungan Pajak Bumi dan Bangunan (PBB).

Program terdiri dari class `Ayah` yang **memiliki** (*has-a*) objek `Rumah` sebagai atributnya, bukan mewarisi (*inheritance*) dari `Rumah`. `Rumah` menghitung besaran pajak berdasarkan tipe dan harga rumah, lalu `Ayah` memanfaatkan hasil perhitungan tersebut lewat method `getPBB()`.

## File

- `Rumah.java` - Class yang merepresentasikan rumah, menyimpan `price` dan `type`, serta method `CountTax()` untuk menghitung pajak berdasarkan tipe rumah.
- `Ayah.java` - Class yang merepresentasikan ayah, memiliki objek `Rumah` sebagai atribut (composition), dengan method `getPBB()` yang mengambil hasil perhitungan pajak dari `Rumah`.
- `Main.java` - Class utama untuk menjalankan program, membuat beberapa objek `Ayah` dengan `Rumah` berbeda-beda dan menampilkan hasil PBB masing-masing.

## Konsep yang Dipelajari

- Composition / Aggregation (*has-a* relationship)
- Class saling berhubungan tanpa pewarisan (`extends`)
- Encapsulation (`private final` attribute)
- Delegasi method (`Ayah.getPBB()` memanggil `Rumah.CountTax()`)

## Tujuan

Memahami bagaimana sebuah class dapat **memiliki** objek dari class lain sebagai atributnya (composition), dan bagaimana class tersebut dapat memanfaatkan method dari objek yang dimilikinya — sebagai pembeda dari konsep inheritance (*is-a* relationship).

## Cara Menjalankan

Compile program:

```bash
javac Main.java
java Main
```

## Contoh Output

```
PBB Akbar (rumah tipe 36, harga 300,000,000) = pajak Rp. 12,000,000
PBB Bambang (rumah tipe 45, harga 450,000,000) = pajak Rp. 27,000,000
PBB Charlie (rumah tipe 90, harga 900,000,000) = pajak Rp. 81,000,000
```