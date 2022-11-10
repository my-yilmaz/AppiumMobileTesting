Feature: Hazir method

  Scenario Outline: Reusable Methods
    Given App yuklensin
    When kullanici ana ekranda
    And kullanici "API Demos" butununa tikladi
    And kullanici "Preference" butununa tikladi
    And kullanici "3. Preference dependencies" butununa tikladi
    And kullanici WiFi check box secmis olacak
    And kullanici "WiFi settings" butununa tikladi
    Then WiFi setting popup geldi
    And kullanici "<text>" yazdi
    And kullanci ok butonuna tikladi
    And kullanici app kapatsin
    Examples:
      | text  |
      | text2 |