# Case Study: Logistics & Delivery Fleet Management System

**Subject:** `5A_F1D02410072_Meisya Ananda Puteri`

## 1. Domain Overview
This case study models a logistics hub managing delivery drivers and different types of delivery vehicles (`ElectricVan` and `HeavyTruck`) to demonstrate **Abstract Classes**, **Interfaces**, **Inheritance**, **Composition**, **Encapsulation**, and **Polymorphism**.

## 2. Core OOP Concepts Explained

1. **Abstract Class & Abstract Methods (`DeliveryVehicle.java`)**
   - `DeliveryVehicle` is declared `abstract` because "a generic delivery vehicle" is an incomplete concept (`new DeliveryVehicle(...)` does not compile).
   - It holds shared state (`private final int vehicleId` and `protected double energyLevel`), a constructor called via `super(...)`, concrete methods (`refuel`, `consumeEnergy`, `toStatusLog`), and abstract methods (`getVehicleType()`, `endOfShiftUpdate()`) that every concrete subclass must implement.

2. **Interfaces & Multiple Inheritance (`Trackable.java`, `FastChargeable.java`)**
   - **`Trackable` (Unrelated Classes Sharing a Contract):** Implemented by both `DeliveryVehicle` and `CourierDriver`. Even though a driver is not a vehicle, both can produce a status log (`toStatusLog()`). It also demonstrates an interface constant (`HUB_NAME`), a Java 8 `default` method (`printStatusLog()`), and a `static` method (`printHeader()`).
   - **`FastChargeable` (Selective Capability):** Only `ElectricVan` can regenerate battery power at the solar dock, while `HeavyTruck` cannot. `ElectricVan` demonstrates Java's form of multiple inheritance by extending one class and implementing interfaces (`extends DeliveryVehicle implements FastChargeable`).

3. **Inheritance (`is-a`) vs. Composition (`has-a`)**
   - **Inheritance (`is-a`):** `ElectricVan` *is a* `DeliveryVehicle`; `HeavyTruck` *is a* `DeliveryVehicle`.
   - **Composition (`has-a`):** `CourierDriver` *has* an `ArrayList<DeliveryVehicle>`.

4. **Polymorphism**
   - **Compile-Time Polymorphism (Overloading):** `ElectricVan` overloads its constructor—one takes a custom `regenRate`, while the other uses `DEFAULT_REGEN_RATE` (`0.04`).
   - **Run-Time Polymorphism (Overriding / Dynamic Binding):**
     - `HeavyTruck` overrides `consumeEnergy(double amount)` so it can dip into its `reserveLimit` when its main fuel gauge reaches `0`.
     - `CourierDriver.finishShift()` loops over `ArrayList<DeliveryVehicle>` and calls `v.endOfShiftUpdate()`. At runtime, `ElectricVan` adds solar regeneration energy while `HeavyTruck` deducts depot cooldown fuel.

## 3. How to Compile and Run
```bash
cd src
javac *.java
java LogisticsFleetDemo