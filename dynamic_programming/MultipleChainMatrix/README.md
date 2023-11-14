# MultipleChainMatrix - Dynamic Programming

This repository implements the solution for the matrix chain multiplication problem using dynamic programming.

## Description

Given the number of cases `N` and the number of matrices `M`, where each matrix has dimensions represented as `Ai x Ai+1` for `i` in the range [0, M-1], find the optimal way to parenthesize the chain of matrices to minimize the number of scalar multiplications.

## Input

- **Number of Cases (N):** An integer representing the number of test cases.
- **Number of Matrices (M):** An integer representing the number of matrices in each case.
- **Matrix Dimensions:** For each case, provide `M + 1` space-separated integers representing the dimensions of the matrices in the chain.

## Output

For each case, output the minimum number of scalar multiplications needed along with the corresponding parenthesized expression.

## Example

### Input
```
1 // Number of Cases
3 // Number of Matrices
10 20 5 10 // M1 -> 10 x 20, M2 -> 20 x 5, M3 -> 5 x 10
```

### Output
```
((M1M2)M3)
1500 // the minimum number of scalar multiplications
```
