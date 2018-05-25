## Halls
| Id | Name        | RentPrice | BuyPrice | LocationId | StateId |
|----|-------------|-----------|----------|------------|---------|
| 1  | Universiada | 120.00    | 1250.00  | 1          | 1       |
| 2  | JUMBO       | 30.99     | 3000.00  | 2          | 2       |
| 3  | METRO       | 9.49      | 5555.99  | 2          | 2       |
| 4  | HallOfHalls | 0.01      | 10000.00 | 3          | 3       |
| 5  | WC          | 1.00      | 100.00   | 4          | 1       |
| 6  | Taekwondo   | 29.99     | 3485.49  | 5          | 3       |

## Location
| Id | Name        | 
|----|-------------|
| 1  | Serdika     |
| 2  | Mladost     |
| 3  | Kokalyne    |
| 4  | Suatina     |
| 5  | GM Dimitrov |

## State
| Id | Name   |
|----|--------|
| 1  | Free   |
| 2  | Rented |
| 3  | Bought |

## HallUser
| Id | HallId | UserId |
|----|--------|--------|
| 1  | 2      | 12     |
| 2  | 3      | 19     |
| 3  | 3      | 24     |
| 4  | 4      | 24     |
| 5  | 6      | 12     |

## User
| Id | FirstName | LastName |
|----|-----------|----------|
| 12 | Karina    | Kozarova |
| 19 | Momchil   | Todorov  |
| 24 | Stefan    | Angelov  |

## Rented
| HallId | From       | Until      |
|--------|------------|------------|
| 2      | 2018-01-01 | 2018-12-25 |
| 3      | 2016-07-09 | 2018-05-31 |
