# Mini Library: Abstract Class, Interface, Inheritance & Polymorphism

Case study for **PBO (Object-Oriented Programming with Java)**.

> **Name / NIM / Class:** `<Meisya Ananda Puteri>`, `<F1D02410072>`, `<A>`
> Full write-up: [`CASE-STUDY.md`](CASE-STUDY.md)

| Required topic | Where in this project |
|---|---|
| Abstract class | `LibraryItem` |
| Abstract method | `LibraryItem.getItemType()`, `LibraryItem.getLoanDays()` |
| Interface | `Describable`, `Renewable` |
| Inheritance | `Book`, `Magazine` extend `LibraryItem` |
| Polymorphism | overriding (`calculateFine`, `getLoanDays`, `describe`) + overloading (`Book` constructors) |

## Class diagram

![Class diagram](docs/class-diagram.png)

**solid line + hollow triangle** = `extends` (is-a), **dashed line + hollow triangle** = `implements` (can-do),
**filled diamond** = composition (has-a), *italic* = abstract.

## Project structure

```
src/
  Describable.java       interface: constant, abstract, default and static method
  Renewable.java         interface: "can be renewed"
  LibraryItem.java       ABSTRACT class
  Book.java              extends LibraryItem, implements Renewable
  Magazine.java          extends LibraryItem, overrides calculateFine()
  LibraryMember.java     has-a items (ArrayList), implements Describable
  MiniLibraryDemo.java   main(), prints every result next to its expected value
docs/
  class-diagram.png / .dot   diagram and its Graphviz source
  sample-output.txt          output of MiniLibraryDemo
```

## Build and run

Works with **JDK 8 or newer**.

```bash
javac -d out src/*.java
java -cp out MiniLibraryDemo
```

Every checked line of the output ends with `OK` or `WRONG` (see `docs/sample-output.txt`).
