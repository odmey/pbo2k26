# Assignment 4 - Account, Customer & BankAccount

## Deskripsi

Assignment 4 menggunakan studi kasus **Account, Customer, dan BankAccount** untuk menerapkan **Encapsulation** sekaligus pengelolaan **array of objects bertingkat** (array of `Customer`, di mana tiap `Customer` juga punya array `Account` sendiri).

`BankAccount` mengelola array `Customer` (maksimal 10), tiap `Customer` mengelola array `Account` miliknya sendiri (maksimal 5), dan `BankMain` menjadi program utama yang menerima input dari user lewat `Scanner`.

## File

- `Account.java` - Class dasar yang merepresentasikan rekening bank, menyimpan `balance` (`protected`), dengan method `deposit()` dan `withdraw()` yang mengembalikan `boolean` (berhasil/gagal, misal saat saldo tidak cukup).
- `Customer.java` - Class yang merepresentasikan customer, menyimpan `firstName`, `lastName`, dan array `Account[5]` miliknya sendiri lewat method `setAccount()`/`getAccount()`.
- `BankAccount.java` - Class yang mengelola array `Customer[10]`, dengan method `addCustomer()` untuk membuat & menambahkan `Customer` baru, serta `getCustomer()`/`getNumOfCustomers()`.
- `BankMain.java` - Class utama yang menerima input jumlah customer, nama, dan saldo awal lewat `Scanner`, lalu menampilkan ringkasan seluruh customer.

## Konsep yang Dipelajari

- Encapsulation (`private`/`protected` attribute + getter/setter)
- Array of Objects (array `Customer` di dalam `BankAccount`, array `Account` di dalam tiap `Customer`)
- Constructor
- Input interaktif menggunakan `Scanner`

## Tujuan

Memahami bagaimana beberapa class dapat saling berhubungan dan disusun secara berjenjang (`BankAccount` → banyak `Customer` → banyak `Account`), sekaligus menerapkan encapsulation pada tiap levelnya.

## Cara Menjalankan

Compile program:

```bash
javac BankMain.java
java BankMain
```

> Program ini interaktif — jalankan di terminal yang mendukung input (`System.in`), bukan hanya run button IDE tanpa console.

## Contoh Jalannya Program

```
Berapa customer yang mau ditambahkan?: 2
Customer ke-1
Nama depan: Andi
Nama belakang: Wijaya
Saldo awal account: 500000
Customer ke-2
Nama depan: Budi
Nama belakang: Santoso
Saldo awal account: 750000

=== Daftar Customer ===
Jumlah customer: 2
1. Andi Wijaya | Saldo: 500000.0
2. Budi Santoso | Saldo: 750000.0
```