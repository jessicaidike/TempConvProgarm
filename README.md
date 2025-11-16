# COMP3520 – Assignment 4  
### Temperature Conversion Program (Refactored)

This repository contains both the original and refactored versions of the `TempConvProgram.java`.  
The goal of the assignment was to refactor the messy original code to improve readability, maintainability, and structure — while preserving the original behaviour.

---

## Summary of Improvements

### 1. Improved Naming and Java Conventions  
- Replaced unclear method names (`CtoF`, `f_to_c`, `CtoK`) with clear ones:  
  - `convertCelsiusToFahrenheit`  
  - `convertFahrenheitToCelsius`  
  - `convertCelsiusToKelvin`  
- Renamed vague variables (`t`, `x`, `rr`) to descriptive names.

---

## Removed Duplication & Magic Numbers  
- Added constants for menu options and Kelvin offset.  
- Centralized repeated strings and values.  
- Reduced repeated input reading logic.

---

## Improved Structure  
- Extracted repeated logic into helper methods:  
  - `printMenu()`  
  - `readMenuChoice()`  
  - `readTemperature()`  
- Clear separation between UI logic and conversion logic.

---

## Robust Input Validation  
- Added numeric input checking.  
- Prevents crashes from invalid user input.  
- Clear and user-friendly error messages.

---

## Behaviour Preserved  
Although the internal code is heavily cleaned and refactored:  
- The same menu options exist  
- The program runs the same conversions  
- Input/output behaviour stays the same  
- The user experience is unchanged  
- Legacy method names still work (wrappers)

---

## Files Included  
- `src/TempConvProgram.java` – refactored program  
- `original_version` commit – original code  
- `README.md` – documentation  

---
 
