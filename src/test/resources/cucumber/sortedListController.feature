Feature: SortedList

  Scenario: Empty List is inputted
    When Invalid List
    | |
    Then expect exception

  Scenario: Unsorted List is inputted
    When Invalid List
      |10|5|8|3|5|4|
    Then expect exception

  Scenario: Sorted and Unsorted Lists added
    When a list is added
      |1|2|3|4|
    And Invalid List
      |7|6|5|
    Then expect exception

  Scenario: Large Lists added
    When a list is added
      | 8 |9 |10 |11|12|13|14|15|
    And Multiple lists
      | 8 |9|15|17|18|19|20 |21 |
      |22 |23|24|25|26|27|28|29 |
    Then return a sorted list
     |8| 8 |9|9|10 |11|12|13|14|15|15|17|18|19|20 |21|22 |23|24|25|26|27|28|29 |