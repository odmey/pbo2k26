# PBO2K26 - Java Programming Assignments

Repository ini berisi kumpulan tugas dan latihan **Pemrograman Berorientasi Objek (PBO)** menggunakan bahasa Java.
*This repository contains a collection of assignments and exercises for **Object-Oriented Programming (OOP)** using Java.*

Project ini dibuat sebagai bagian dari pembelajaran konsep dasar hingga penerapan **Object-Oriented Programming (OOP)**, seperti class, object, constructor, encapsulation, composition, inheritance, dan polymorphism.
*This project was created as part of learning core to applied concepts of OOP, such as classes, objects, constructors, encapsulation, composition, inheritance, and polymorphism.*

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
└── assignment5/
    ├── Shape.java
    ├── Square.java
    ├── Circle.java
    ├── Cylinder.java
    ├── ShapeMain.java
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

## ⚙️ Cara Menjalankan / How to Run

Masuk ke folder assignment yang ingin dijalankan, lalu compile dan run seperti biasa:
*Navigate to the assignment folder you want to run, then compile and run as usual:*

```bash
cd assignment5
javac *.java
java ShapeMain
```

> Untuk `assignment4` dan `assignment5`, program meminta input lewat `Scanner`, jadi jalankan di terminal interaktif (bukan hanya run button IDE tanpa console).
> *For `assignment4` and `assignment5`, the program requests input via `Scanner`, so run it in an interactive terminal (not just an IDE run button without console access).*

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

## 🧑‍💻 Requirements

- JDK 8 atau lebih baru / JDK 8 or later
- Text editor / IDE (VS Code, IntelliJ, Eclipse, dll)

## 📌 Catatan / Notes

Setiap folder `assignmentX/` memiliki `README.md` sendiri yang menjelaskan detail deskripsi, struktur class, dan contoh output masing-masing tugas.
*Each `assignmentX/` folder has its own `README.md` explaining the detailed description, class structure, and example output for that assignment.*