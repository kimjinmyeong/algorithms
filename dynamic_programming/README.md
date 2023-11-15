# Dynamic Programming

Dynamic Programming is a powerful optimization technique used in computer science and mathematics to solve problems by breaking them down into smaller overlapping subproblems and solving each subproblem only once, storing the solutions to subproblems to avoid redundant computations.

## Key Concepts

1. **Optimal Substructure:** An optimal solution to the problem can be constructed from optimal solutions of its subproblems.

2. **Overlapping Subproblems:** The problem can be broken down into subproblems that are reused several times.

## Benefits of Dynamic Programming

- **Optimization:** Dynamic programming optimizes a problem by storing solutions to overlapping subproblems, reducing redundant computations.

- **Time Complexity:** It often results in more efficient algorithms by avoiding the repeated work of solving the same subproblems.

- **Memoization:** Memoization is a common technique used in dynamic programming to store the results of expensive function calls and returning the cached result when the same inputs occur again.

## How to Use

1. **Identify Overlapping Subproblems:** Determine if the problem can be broken down into smaller overlapping subproblems.

2. **Define Recursive Solution:** Create a recursive solution for the problem.

3. **Memoization or Tabulation:** Implement a mechanism to store and reuse solutions to subproblems, either through memoization (caching results) or tabulation (building a table of results).

4. **Optimize:** Analyze the algorithm's time and space complexity to ensure efficiency.

## Example

- **Problem:** Fibonacci sequence calculation.
- **Recursive Solution:**
    ```python
    def fibonacci(n):
        if n <= 1:
            return n
        return fibonacci(n - 1) + fibonacci(n - 2)
    ```

- **Dynamic Programming Solution:**
    ```python
    def fibonacci_dp(n, memo={}):
        if n <= 1:
            return n
        if n not in memo:
            memo[n] = fibonacci_dp(n - 1, memo) + fibonacci_dp(n - 2, memo)
        return memo[n]
    ```

## Further Reading

- [Wikipedia - Dynamic Programming](https://en.wikipedia.org/wiki/Dynamic_programming)
- [GeeksforGeeks - Dynamic Programming](https://www.geeksforgeeks.org/dynamic-programming/)
