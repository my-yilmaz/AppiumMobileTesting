Feature: Make a Popup

  @test09
  Scenario: Make a Popup test
    Given App yuklensin
    And kullanici ana ekranda
    And kullanici "API Demos" butununa tikladi
    And kullanici "Views" butununa tikladi
    And kullanici "Popup Menu" butununa tikladi
    And kullanici Make A Popup butonuna tiklasin
    Then panelin ciktigini dogrulasin
    And kullanici "Add" butununa tikladi
    Then Toast mesajda Add gectigini dogrular
    And kullanici app kapatsin

