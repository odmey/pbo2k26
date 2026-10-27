# Case Study: Mini Bank System
### Abstract Class, Interface, Inheritance & Polymorphism in Java

**Course:** PBO (Object-Oriented Programming), review before the midtest
**Name / NIM / Class:** `<Name>`, `<NIM>`, 5A *(fill in before submitting)*
**Based on:** slides *PBO 5 & 6* and *PBO 7 & 8*

---

## 1. Background

A bank has customers, and a customer has accounts. In `assignment4` every account was the same plain class. Real
accounts differ: a **savings account** pays interest, a **checking account** may go below zero and charges a fee.
This case study models that difference with an **abstract class**, **interfaces**, **inheritance** and
**polymorphism**, and nothing else beyond what the slides cover.

## 2. Problem

1. Savings and checking accounts share some behaviour (balance, deposit) but differ in others (withdraw rule,
   what happens at month end). How do we model that without copying code?
2. How can one line of code treat every account the same way while each one does the right thing?
3. `BankCustomer` and `BaseAccount` are **not** related by inheritance, yet both must print a report. How?
4. Only *some* accounts earn interest. How do we express that?

## 3. Name Changes (same class names in other folders)

All assignments live in one repository, and some names were already used:

| Old name | Already used in | New name |
|---|---|---|
| `Account` | `assignment4` | `BaseAccount` |
| `Customer` | `assignment4` | `BankCustomer` |
| `Bank` | `assignment2` | *(removed, see section 8)* |
| `BankDemo` | `assignment2` | `MiniBankDemo` |

`BankAccount` was not chosen for the abstract class because `assignment4` already has it.

## 4. Design

![Class diagram](docs/class-diagram.png)

| Class / interface | Kind | Role |
|---|---|---|
| `BaseAccount` | abstract class | Shared state (`accountNumber`, `balance`) and methods (`deposit`, `withdraw`). Forces children to write `getAccountType()` and `monthEndUpdate()`. |
| `SavingsAccount` | concrete class | Pays monthly interest. Implements `InterestBearing`. |
| `CheckingAccount` | concrete class | Overdraft allowed, pays a monthly fee. |
| `Reportable` | interface | "Can produce a report": `BaseAccount` and `BankCustomer`. |
| `InterestBearing` | interface | "Can earn interest": only `SavingsAccount`. |
| `BankCustomer` | class | **Has** many accounts (composition). |
| `MiniBankDemo` | class | `main()` with expected values. |

**Why an abstract class for `BaseAccount`?** The account types share state and code, and the relationship is
**is-a** (slide *Interface vs Abstract Class*: abstract class = state + constructor + concrete methods).

**Why interfaces for `Reportable` and `InterestBearing`?** They describe a **can-do** ability that unrelated
classes share (`Reportable`) or that only some classes have (`InterestBearing`).

**Why does `BankCustomer` not extend `BaseAccount`?** *"A customer IS AN account"* is wrong, *"a customer HAS
accounts"* is right (slide *is-a vs has-a*), so it uses an `ArrayList<BaseAccount>`.

## 5. Where Each Slide Topic Appears

| Topic from the slides | In the code |
|---|---|
| Abstract method (no body, `abstract`) | `BaseAccount.getAccountType()`, `monthEndUpdate()` |
| Abstract class cannot be instantiated | `new BaseAccount(...)` does not compile (comment in `MiniBankDemo`) |
| What an abstract class can have: fields, constructor, concrete methods, abstract methods | all in `BaseAccount` |
| Concrete class must implement every abstract method | `SavingsAccount`, `CheckingAccount` |
| `extends`, `super(...)` as first line, `super.method()` | child constructors, `super.toReport()` |
| Encapsulation: private field + getter, validation in constructor | `accountNumber`, `initBalance > 0` check |
| Interface: constant, abstract, default, static method | `Reportable` (`BANK_NAME`, `toReport`, `printReport`, `printHeader`) |
| One class, many interfaces; one object, many types | `SavingsAccount extends BaseAccount implements InterestBearing` |
| Using an object through the interface type | `Reportable[]`, `InterestBearing[]` in `MiniBankDemo` |
| `instanceof` | `a instanceof InterestBearing` |
| Overloading | two `SavingsAccount` constructors (`this(...)` calls the longer one) |
| Overriding / dynamic binding | `withdraw()`, `monthEndUpdate()`, `toReport()` |
| Composition (has-a) with `ArrayList` | `BankCustomer.accounts` |
| `static final` constant | `CheckingAccount.MONTHLY_FEE`, `SavingsAccount.DEFAULT_RATE` |

### Polymorphism in one example

```java
// BankCustomer.java
public void monthEnd() {
    for (BaseAccount a : accounts) {
        a.monthEndUpdate();      // the REAL object decides what happens
    }
}
```

The variable type is `BaseAccount`, but a savings account adds interest while a checking account subtracts the
fee. The loop does not care which account it holds (like the `Animal[] zoo` example in the slides).

## 6. Test Scenario and Results

| Customer | Account | Opening balance | Setting |
|---|---|---|---|
| Akbar Pratama | Savings #1001 | 1000.0 | 12% per year |
| Akbar Pratama | Checking #1002 | 500.0 | overdraft limit 300 |
| Citra Dewi | Savings #1003 | 300.0 | default rate 4% (overloaded constructor) |

**Withdraw 600 from every account** (same call, different rules):

| Account | Rule | Result |
|---|---|---|
| Savings #1001 | 1000 ≥ 600 | `true` (balance 400.0) |
| Checking #1002 | 500 + 300 overdraft = 800 ≥ 600 | `true` (balance -100.0) |
| Savings #1003 | 300 < 600 | `false` |

**Month end** (`monthEnd()` on each customer):

| Account | Before | Change | After |
|---|---|---|---|
| Savings #1001 | 400.0 | + 4.0 interest (400 × 0.12 / 12) | 404.0 |
| Checking #1002 | -100.0 | - 5.0 fee | -105.0 |
| Savings #1003 | 300.0 | + 1.0 interest (300 × 0.04 / 12) | 301.0 |

`instanceof InterestBearing` gives `true` for both savings accounts and `false` for the checking account.
**13 of 13 checks match their expected value** (`docs/sample-output.txt`).

## 7. Conclusion

An **abstract class** (`BaseAccount`) holds what all accounts share and forces each type to define its own name and
month-end behaviour. **Interfaces** describe abilities (`Reportable`, `InterestBearing`) that do not belong to one
family tree. **Inheritance** removes repeated code and **polymorphism** lets the same call behave differently per
object. A quick rule: **is-a** with shared code → abstract class, **can-do** → interface, **has-a** → composition.

## 8. What Was Simplified

The first version of this project went beyond the slides. These parts were **removed** to stay within the topics
taught: the extra `MiniBank` class and a third account type (`FixedDepositAccount`), the `AccountFilter` search,
`final` methods, a static account counter, `Collections.unmodifiableList`, `String.format`/`Locale`, downcasting,
the Java 9 `private` interface method, and the Mermaid diagram. The project now also works on **JDK 8**.

## 9. How to Run

```bash
cd assignment6-case-study
javac -d out src/*.java
java -cp out MiniBankDemo
```
