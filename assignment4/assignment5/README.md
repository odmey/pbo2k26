# Assignment 5 - Inheritance & Polymorphism

## Deskripsi

Assignment 5 membahas penerapan **Inheritance** dan **Polymorphism** menggunakan studi kasus berbagai jenis bangun (shape).

Program memiliki `Shape` sebagai parent class, dengan `Square` dan `Circle` sebagai child class langsung dari `Shape`, serta `Cylinder` sebagai child class dari `Circle` (multilevel inheritance).

## File

- `Shape.java` - Parent class untuk berbagai jenis shape. Menyimpan atribut `color` dan method `printInfo()`.
- `Square.java` - Class turunan `Shape`, merepresentasikan persegi.
- `Circle.java` - Class turunan `Shape`, merepresentasikan lingkaran.
- `Cylinder.java` - Class turunan `Circle`, merepresentasikan tabung.
- `ShapeMain.java` - Class utama untuk menjalankan program, termasuk input via `Scanner`.

## Struktur Class

```text
                Shape
               /     \
              /       \
         Square      Circle
                        |
                        |
                     Cylinder
```

## Konsep OOP yang Diterapkan

- **Inheritance**: `Square` dan `Circle` mewarisi atribut `color` dan method dari `Shape`; `Cylinder` mewarisi `radius` dan `PI` dari `Circle`.
- **Encapsulation**: atribut `side`, `radius`, `height` bersifat `private`/`protected`, diakses lewat getter/setter.
- **Polymorphism**: method `printInfo()` di-*override* di setiap child class, dan dipanggil secara dinamis (dynamic binding) lewat array bertipe `Shape[]`.

## Cara Menjalankan

```bash
javac *.java
java ShapeMain
```

Program akan meminta input jumlah shape, tipe shape (Square/Circle/Cylinder), warna, serta parameter ukurannya (side/radius/height), lalu menampilkan hasil `printInfo()` untuk setiap shape yang dibuat.

## Contoh Output

```
Square colored red, area = 25.0
Circle blue, area = 28.27431
Cylinder green, volume = 125.6636
```