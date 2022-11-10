Feature: API Demos expandable list
  @test07
  Scenario: Expandable list test
    Given App yuklensin
    And kullanici ana ekranda
    And kullanici "API Demos" butununa tikladi
    And kullanici "Views" butununa tikladi
    And kullanici "Expandable Lists" butununa tikladi
    And kullanici "1. Custom Adapter" butununa tikladi
    And kullanici "People Names" butununa tikladi
    And "3" saniye bekle
    And kullanici "Chuck" butununa uzun basti
    And "5" saniye bekle
    Then kullanici popup ekranin ciktigini dogrular