@test02
Feature: API Demos Switches

  Background: Switch screen test
    Given App yuklensin
    When kullanici ana ekranda
    And kullanici API Demos butununa tikladi
    And kullanici Preference butununa tikladi
    And kullanici Switches butununa tikladi

  @test02a
  Scenario: Switch test
    And kullanici check box tikladi
    And kulanici switch butonuna tikladi
    Then screenshot al
    And kullanici app kapatsin

  @test02b
  Scenario: Switch button checks
    And check box secili olmali
    And ilk switch butonu kapali
    And ikici switch butonu acik
    Then screenshot al
    And kullanici app kapatsin