Feature: Storage

  Scenario: Adding List to storage
    Given Storage contains a list
      |1|2|3|
    And a list is added
      |4|5|6|
    Then return a sorted list
      |1|2|3|4|5|6|

  Scenario: Dealing with multiple lists
    When Multiple lists
      |17|15|78|
      |42|18|12|
      |100|23|2|
    Then return a sorted list
      |2|12|15|17|18|23|42|78|100|

  Scenario: Storage Unsorted
    Given Storage contains a list
      | |
    When select sort method
      |10|5|9|3|4|8|
    Then return a sorted list
      |3|4|5|8|9|10|

