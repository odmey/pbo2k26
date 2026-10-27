# PBO2K26 - Java Programming Assignments

Repository ini berisi kumpulan tugas dan latihan **Pemrograman Berorientasi Objek (PBO)** menggunakan bahasa Java.
*This repository contains a collection of assignments and exercises for **Object-Oriented Programming (OOP)** using Java.*

Project ini dibuat sebagai bagian dari pembelajaran konsep dasar hingga penerapan **Object-Oriented Programming (OOP)**, seperti class, object, constructor, encapsulation, composition, inheritance, polymorphism, abstract class, dan interface.
*This project was created as part of learning core to applied concepts of OOP, such as classes, objects, constructors, encapsulation, composition, inheritance, polymorphism, abstract classes, and interfaces.*

## 📁 Struktur Project / Project Structure

```text
pbo2k26/
│
├── assignment1/
│   ├── BangunDatar.java
│   ├── BangunDatarDemo.java
│   └── README.md
│
├── assignment2/
│   ├── Bank.java
│   ├── BankDemo.java
│   └── README.md
│
├── assignment3/
│   ├── Ayah.java
│   ├── Rumah.java
│   ├── Main.java
│   └── README.md
│
├── assignment4/
│   ├── Account.java
│   ├── BankAccount.java
│   ├── Customer.java
│   ├── BankMain.java
│   └── README.md
│
├── assignment5/
│   ├── Shape.java
│   ├── Square.java
│   ├── Circle.java
│   ├── Cylinder.java
│   ├── ShapeMain.java
│   └── README.md
│
└── library-case-study/
    ├── src/
    │   ├── Describable.java
    │   ├── Renewable.java
    │   ├── LibraryItem.java
    │   ├── Book.java
    │   ├── Magazine.java
    │   ├── LibraryMember.java
    │   └── MiniLibraryDemo.java
    ├── docs/
    │   ├── class-diagram.png
    │   ├── class-diagram.dot
    │   └── sample-output.txt
    ├── CASE-STUDY.md
    └── README.md
```

## 📚 Daftar Assignment / Assignment List

| Assignment | Topik / Topic | Ringkasan (ID) | Summary (EN) |
|---|---|---|---|
| `assignment1` | Class, Object & Constructor Overloading | Class `BangunDatar` merepresentasikan persegi dan persegi panjang, dengan 3 constructor berbeda (default, satu parameter untuk sisi, dua parameter untuk panjang & lebar) serta method perhitungan luas dan keliling. | The `BangunDatar` class represents a square and a rectangle, with 3 different constructors (default, single parameter for side, two parameters for length & width) plus area and perimeter calculation methods. |
| `assignment2` | Encapsulation | Class `Bank` menyimpan `balance`, `deposit`, dan `withdraw` sebagai atribut `private` dengan getter/setter, ditambah method `addDeposit()` dan `withdrawMoney()` untuk mengubah saldo. | The `Bank` class stores `balance`, `deposit`, and `withdraw` as `private` attributes with getters/setters, plus `addDeposit()` and `withdrawMoney()` methods to modify the balance. |
| `assignment3` | Composition / Aggregation | Class `Ayah` memiliki (*has-a*) objek `Rumah` sebagai atributnya untuk menghitung PBB (`CountTax()`) berdasarkan tipe dan harga rumah. | The `Ayah` class has (*has-a*) a `Rumah` object as its attribute to calculate property tax (`CountTax()`) based on house type and price. |
| `assignment4` | Encapsulation + Array of Objects | Class `BankAccount` mengelola array `Customer` (maks. 10), dan tiap `Customer` mengelola array `Account` (maks. 5) miliknya sendiri — input data dilakukan lewat `Scanner` di `BankMain`. | The `BankAccount` class manages an array of `Customer` objects (max. 10), and each `Customer` manages its own array of `Account` objects (max. 5) — data input is handled via `Scanner` in `BankMain`. |
| `assignment5` | Inheritance & Polymorphism | `Square` dan `Circle` mewarisi `Shape` (atribut `color`), sedangkan `Cylinder` mewarisi `Circle` (multilevel inheritance). Method `printInfo()` di-*override* di tiap child class. | `Square` and `Circle` inherit from `Shape` (the `color` attribute), while `Cylinder` inherits from `Circle` (multilevel inheritance). The `printInfo()` method is *overridden* in each child class. |
| `library-case-study` | Abstract Class, Interface, Inheritance & Polymorphism | Studi kasus perpustakaan mini. Abstract class `LibraryItem` (atribut `itemId`, `title`, `borrowed`; method abstract `getItemType()` dan `getLoanDays()`) diwarisi oleh `Book` (bisa diperpanjang lewat interface `Renewable`, constructor di-*overload*) dan `Magazine` (meng-*override* `calculateFine()` dengan denda lebih tinggi). Interface `Describable` dipakai bersama oleh `LibraryItem` dan `LibraryMember`, sedangkan `LibraryMember` memiliki (*has-a*) `ArrayList<LibraryItem>`. | A mini library case study. The abstract class `LibraryItem` (attributes `itemId`, `title`, `borrowed`; abstract methods `getItemType()` and `getLoanDays()`) is inherited by `Book` (can be renewed through the `Renewable` interface, with an *overloaded* constructor) and `Magazine` (*overrides* `calculateFine()` with a higher fine). The `Describable` interface is shared by `LibraryItem` and `LibraryMember`, while `LibraryMember` has (*has-a*) an `ArrayList<LibraryItem>`. |

## ⚙️ Cara Menjalankan / How to Run

Masuk ke folder assignment yang ingin dijalankan, lalu compile dan run seperti biasa:
*Navigate to the assignment folder you want to run, then compile and run as usual:*

```bash
cd assignment5
javac *.java
java ShapeMain
```

Khusus `library-case-study`, source code ada di folder `src/` dan class utamanya adalah `MiniLibraryDemo`:
*For `library-case-study` only, the source code is in the `src/` folder and the main class is `MiniLibraryDemo`:*

```bash
cd library-case-study
javac -d out src/*.java
java -cp out MiniLibraryDemo
```

> Untuk `assignment4` dan `assignment5`, program meminta input lewat `Scanner`, jadi jalankan di terminal interaktif (bukan hanya run button IDE tanpa console). `library-case-study` tidak memakai `Scanner`, jadi langsung menampilkan hasil (`OK` / `WRONG`) tanpa input.
> *For `assignment4` and `assignment5`, the program requests input via `Scanner`, so run it in an interactive terminal (not just an IDE run button without console access). `library-case-study` does not use `Scanner`, so it prints its results (`OK` / `WRONG`) directly with no input.*

## 🎯 Tujuan Pembelajaran / Learning Objectives

Melalui rangkaian assignment ini, project ini bertujuan untuk memahami dan menerapkan pilar-pilar utama OOP:
*Through this series of assignments, this project aims to understand and apply the main pillars of OOP:*

- **Encapsulation** — menyembunyikan detail implementasi lewat access modifier (`private`, `protected`) dan accessor/mutator.
  *Hiding implementation details through access modifiers (`private`, `protected`) and accessors/mutators.*
- **Composition / Aggregation** — membangun relasi *has-a* antar class, seperti `Ayah` yang memiliki `Rumah`.
  *Building has-a relationships between classes, such as `Ayah` having a `Rumah`.*
- **Inheritance** — mewariskan atribut dan method dari parent class ke child class (`Shape` → `Square`/`Circle` → `Cylinder`).
  *Passing down attributes and methods from a parent class to a child class (`Shape` → `Square`/`Circle` → `Cylinder`).*
- **Polymorphism** — satu method yang berperilaku berbeda tergantung objek yang memanggilnya (method overriding & dynamic binding).
  *A single method behaving differently depending on the object calling it (method overriding & dynamic binding).*
- **Abstract Class & Interface** — mendefinisikan *apa* yang harus dilakukan tanpa menentukan *bagaimana*: abstract class untuk relasi *is-a* dengan kode bersama (`LibraryItem` → `Book`/`Magazine`), interface untuk kemampuan *can-do* (`Describable`, `Renewable`).
  *Defining what must be done without saying how: abstract classes for is-a relationships with shared code (`LibraryItem` → `Book`/`Magazine`), interfaces for can-do abilities (`Describable`, `Renewable`).*

## 🧑‍💻 Requirements

- JDK 8 atau lebih baru / JDK 8 or later
- Text editor / IDE (VS Code, IntelliJ, Eclipse, dll)

## 📌 Catatan / Notes

Setiap folder `assignmentX/` memiliki `README.md` sendiri yang menjelaskan detail deskripsi, struktur class, dan contoh output masing-masing tugas. Folder `library-case-study/` juga memiliki `CASE-STUDY.md` (laporan lengkap) dan folder `docs/` (class diagram dan sample output).
*Each `assignmentX/` folder has its own `README.md` explaining the detailed description, class structure, and example output for that assignment. The `library-case-study/` folder also has a `CASE-STUDY.md` (full write-up) and a `docs/` folder (class diagram and sample output).*