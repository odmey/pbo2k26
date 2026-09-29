# Assignment 2 - Bank

## Deskripsi

Assignment 2 menggunakan studi kasus **Bank** sederhana untuk menerapkan konsep **Encapsulation** dalam Java.

Class `Bank` menyimpan tiga atribut `private` (`balance`, `deposit`, `withdraw`) dengan getter/setter untuk masing-masing, ditambah dua method transaksi: `addDeposit()` untuk menambah saldo, dan `withdrawMoney()` untuk mengurangi saldo.

## File

- `Bank.java` - Class yang merepresentasikan akun bank, menyimpan `balance`, `deposit`, `withdraw` sebagai atribut `private`, beserta method `addDeposit(double deposit)` dan `withdrawMoney(double w)`.
- `BankDemo.java` - Class utama yang membuat objek `Bank`, mengatur nilai awal lewat setter, lalu melakukan simulasi deposit dan withdraw.

## Konsep yang Dipelajari

- Encapsulation (`private` attribute + getter/setter)
- Class & Object
- Method untuk memanipulasi state objek (`addDeposit`, `withdrawMoney`)

## Tujuan

Memahami penerapan **encapsulation** dengan menyembunyikan atribut lewat `private` dan mengontrol perubahan nilainya lewat method publik, dalam studi kasus transaksi bank sederhana.

## Cara Menjalankan

Compile dan jalankan program:

```bash
javac BankDemo.java
java BankDemo
```

## Contoh Output
```
Welcome to Bank ABC
Current Balance: 100000.0
Deposit: 500000.0
Current Balanced: 600000.0
Withdraw: 150000.0
Current Balanced: 450000.0
```