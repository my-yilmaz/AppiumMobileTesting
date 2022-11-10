Feature: API Demos test
  @test08
  Scenario: spenner dropdown list
    Given App yuklensin
    And kullanici ana ekranda
    And kullanici "API Demos" butununa tikladi
    And kullanici "Views" butununa tikladi
    And kullanici "Spinner" butununa tikladi
    And kullanici color menusunden "blue" secer
    Then blue sectigini dogrular
    And kullanici planet menusunden "Saturn" secer
    Then toast mesaji dogrular
    Then Saturn sectigini dogrular
    And kullanici app kapatsin