# CS4472 - Assignment 2: White Box Testing

## 1 Withdrawal

### 1.1 Process and Assumption

### 1.2 Analysis Artifact: Slice

### 1.3 Test Cases

### 1.4 Test Results

### 1.5 Fault Localization



## 2. Deposit — DU-Path Testing

### 2.1 Process and Assumptions

### 2.2 Analysis Artifact: DU-Path Table

### 2.3 Test Cases

### 2.4 Test Results

### 2.5 Fault Localization



## 3. Transfer — Basis Path Testing

### 3.1 Process and Assumptions

Basis path testing was performed on the `calculateTransferFee` method in the `bank.utils.FeesCalculator` class.

The control-flow graph (CFG) was constructed by examining the existing Java implementation. Each decision and executable statement was assigned a unique node number, and conditional edges were labelled Yes or No to represent the outcome of each condition.

The cyclomatic complexity was calculated to determine the required number of independent basis paths. Each basis path was then identified by tracing a sequence of nodes from the method entry to the return statement.

**Assumptions:**

- The CFG represents the existing implementation, including any potential faults.
- Node 1 represents the method entry and variable declaration.
- Node 34 represents the method exit and return statement.
- `fromBal` represents `fromAccountBalance`.
- `toBal` represents `toAccountBalance`.
- Each basis path begins at node 1 and terminates at node 34.
- Test inputs are selected to execute the corresponding basis path in the implementation.
- Expected fees are calculated independently using the Assignment 2 business logic specification.
- The method is tested directly without mocking external dependencies.

### 3.2 Analysis Artifact: Control-Flow Graph and Basis Paths

#### Control-Flow Graph

![Transfer Control-Flow Graph](images/transfer-cfg.png)

#### Cyclomatic Complexity

The cyclomatic complexity is calculated using:

$$V(G) = E - N + 2$$

where:

- Number of edges (E) = 48
- Number of nodes (N) = 34

Therefore:

$$V(G) = 48 - 34 + 2 = 16$$

This result can also be verified using the number of decision nodes (D):

$$V(G) = D + 1$$

$$V(G) = 15 + 1 = 16$$

Therefore, 16 independent basis paths are required.

#### Basis Paths — Student

| Path ID | Node Sequence |
|---|---|
| P1 | 1 → 2 → 3 → 4 → 5 → 6 → 33 → 34 |
| P2 | 1 → 2 → 3 → 4 → 5 → 7 → 33 → 34 |
| P3 | 1 → 2 → 3 → 4 → 8 → 9 → 33 → 34 |
| P4 | 1 → 2 → 3 → 4 → 8 → 10 → 33 → 34 |
| P5 | 1 → 2 → 3 → 11 → 12 → 13 → 33 → 34 |
| P6 | 1 → 2 → 3 → 11 → 12 → 14 → 33 → 34 |
| P7 | 1 → 2 → 3 → 11 → 15 → 16 → 33 → 34 |
| P8 | 1 → 2 → 3 → 11 → 15 → 17 → 33 → 34 |

#### Basis Paths — Non-Student

| Path ID | Node Sequence |
|---|---|
| P9 | 1 → 2 → 18 → 19 → 20 → 21 → 33 → 34 |
| P10 | 1 → 2 → 18 → 19 → 20 → 22 → 33 → 34 |
| P11 | 1 → 2 → 18 → 19 → 23 → 24 → 33 → 34 |
| P12 | 1 → 2 → 18 → 19 → 23 → 25 → 33 → 34 |
| P13 | 1 → 2 → 18 → 26 → 27 → 28 → 33 → 34 |
| P14 | 1 → 2 → 18 → 26 → 27 → 29 → 33 → 34 |
| P15 | 1 → 2 → 18 → 26 → 30 → 31 → 33 → 34 |
| P16 | 1 → 2 → 18 → 26 → 30 → 32 → 33 → 34 |

#### Basis Path Independence

Each identified basis path introduces at least one edge not traversed by any preceding path. Specifically, each path traverses a unique fee percentage assignment node.

The number of independent paths equals the cyclomatic complexity of the CFG, V(G) = 16. Together, these paths cover all nodes and edges of the CFG.

### 3.3 Test Cases

Test cases are derived from the basis paths identified in Section 3.2. Inputs are selected to satisfy the conditions along each corresponding path. Expected fees are calculated using the Assignment 2 business logic specification.

#### Student Test Cases

| Test ID | Basis Path | Student | Amount ($) | From Balance ($) | To Balance ($) | Expected Fee ($) |
|---|---|---|---|---|---|---|
| T1 | P1 | True | | | | |
| T2 | P2 | True | | | | |
| T3 | P3 | True | | | | |
| T4 | P4 | True | | | | |
| T5 | P5 | True | | | | |
| T6 | P6 | True | | | | |
| T7 | P7 | True | | | | |
| T8 | P8 | True | | | | |

#### Non-Student Test Cases

| Test ID | Basis Path | Student | Amount ($) | From Balance ($) | To Balance ($) | Expected Fee ($) |
|---|---|---|---|---|---|---|
| T9 | P9 | False | | | | |
| T10 | P10 | False | | | | |
| T11 | P11 | False | | | | |
| T12 | P12 | False | | | | |
| T13 | P13 | False | | | | |
| T14 | P14 | False | | | | |
| T15 | P15 | False | | | | |
| T16 | P16 | False | | | | |

### 3.4 Test Results

The test cases are executed as JUnit tests against the existing implementation of `calculateTransferFee`.

| Test ID | Basis Path | Expected Fee ($) | Actual Fee ($) | Result |
|---|---|---|---|---|
| T1 | P1 | | | |
| T2 | P2 | | | |
| T3 | P3 | | | |
| T4 | P4 | | | |
| T5 | P5 | | | |
| T6 | P6 | | | |
| T7 | P7 | | | |
| T8 | P8 | | | |
| T9 | P9 | | | |
| T10 | P10 | | | |
| T11 | P11 | | | |
| T12 | P12 | | | |
| T13 | P13 | | | |
| T14 | P14 | | | |
| T15 | P15 | | | |
| T16 | P16 | | | |

#### Test Summary

- Total tests executed: TBD
- Tests passed: TBD
- Tests failed: TBD

#### JaCoCo Coverage

The following coverage metrics are obtained from the JaCoCo report generated by the CI workflow for `calculateTransferFee`.

| Coverage Metric | Result |
|---|---|
| Instruction Coverage | TBD |
| Line Coverage | TBD |
| Branch Coverage | TBD |

### 3.5 Fault Localization

Failing test cases are analyzed to identify discrepancies between the implemented behaviour and the expected behaviour defined in the specification. Test cases that expose the same fault are grouped together.

| Fault ID | Failed Test Cases | Class | Method | Faulty Statement or Condition | Justification |
|---|---|---|---|---|---|
| | | | | | |

No modifications are made to the original implementation.