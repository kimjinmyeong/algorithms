# BalanceScale - Dynamic Programming

This repository implements the BalanceScale algorithm using Dynamic Programming to calculate the minimum number of coins needed to make change for a given amount **gap**.

## Overview

The BalanceScale algorithm is designed to efficiently determine the minimum number of coins required for change using denominations of 1, 2, 5, 10, 20, 50, and 100. The implementation employs Dynamic Programming techniques for optimal efficiency.

## Usage

To use the program, provide the following inputs:

1. The number of attempts you wish to make.
2. The number of coin denominations.
3. The specific amount for which you want to calculate the minimum number of coins.

The program will output the minimum number of coins required for each attempt.

## Example

Suppose you want to make three attempts:
- Attempt 1: Calculate the minimum coins needed for 10 units.
- Attempt 2: Calculate the minimum coins needed for 25 units.
- Attempt 3: Calculate the minimum coins needed for 50 units.

Then, gap is |10 - 25 - 50| = 35

35 can be made with 10 + 20 + 5, so it can be achieved with 3 coins.

Input
```
1 // Number of cases
3 // Number of input
10 25 50
```
Output
```
3 // the minimum number of coins needed to make change
```
