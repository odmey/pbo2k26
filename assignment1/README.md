# Assignment 1 - Bangun Datar

## Deskripsi

Assignment 1 merupakan latihan dasar Pemrograman Berorientasi Objek menggunakan Java dengan studi kasus **Bangun Datar** (persegi dan persegi panjang), dengan fokus pada **constructor overloading**.

Class `BangunDatar` punya 3 constructor berbeda: constructor default (semua atribut = 0), constructor 1 parameter (untuk sisi persegi), dan constructor 2 parameter (untuk panjang & lebar persegi panjang). `BangunDatarDemo` mendemonstrasikan ketiga cara pembuatan objek tersebut sekaligus.

## File

- `BangunDatar.java` - Class yang merepresentasikan bangun datar (persegi & persegi panjang), menyimpan atribut `side`, `length`, `width`, serta method untuk menghitung luas dan keliling masing-masing bentuk.
- `BangunDatarDemo.java` - Class utama yang mendemonstrasikan 3 cara berbeda membuat objek `BangunDatar`: lewat constructor 1 parameter, constructor default + setter, dan constructor 2 parameter.

## Konsep yang Dipelajari

- Class & Object
- Constructor Overloading (beberapa constructor dengan jumlah parameter berbeda)
- Attribute & Method
- Accessor (getter) & Mutator (setter)

## Tujuan

Memahami konsep dasar Object-Oriented Programming (OOP), khususnya cara membuat beberapa constructor untuk satu class (constructor overloading) yang menyesuaikan skenario pembuatan objek berbeda.

## Cara Menjalankan

Compile dan jalankan program:

```bash
javac BangunDatarDemo.java
java BangunDatarDemo
```

## Contoh Output
```
Area of square with side 7 = 49
Perimeter of square with side 7 = 28
Area of rectangle with length 10 and width 5 = 50
Perimeter of rectangle with length 10 and width 5 = 30
Area of rectangle with length 8 and width 4 = 32
Perimeter of rectangle with length 8 and width 4 = 24
```