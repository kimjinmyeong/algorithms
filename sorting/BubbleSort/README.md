# BubbleSort

This program implements and compares the performance of the standard Bubble Sort algorithm with two optimized versions.

## Input 

The input is structured as follows:

- The first line represents the number of test cases.
- The second line represents the number of integers to be sorted.
- The third line contains the integers to be sorted.

## Output 

The output is structured as follows:

- The first and second numbers represent the number of comparisons and swaps made during the sorting process by the standard Bubble Sort.
- The third and fourth numbers represent the number of comparisons and swaps made by the first optimized version of Bubble Sort.
- The fifth and sixth numbers represent the number of comparisons and swaps made by the second optimized version of Bubble Sort.

## Optimizations

### Optimized Version 1

The first optimization added to the Bubble Sort checks if any swaps were made during an iteration. If no swaps were made, it breaks out of the loop, as this indicates the list is already sorted.

### Optimized Version 2

The second optimization saves the index of the last swap made during an iteration. On the next iteration, the algorithm starts sorting from this saved index, as any elements beyond this point are already sorted.

## Example
```shell
1
5
1 7 9 2 3
10 4 4 0 9 4
```
