@test05
Feature: API demos Scroll

  Background:  scroll
    Given App yuklensin
    When kullanici ana ekranda
    And kullanici API Demos butununa tikladi
    And kullanici Views butonuna tikladi

  Scenario: Scrolling test
    And kullanici Switches butonun tiklasin

  Scenario: Scrolling test uiscrollable
    And kullanici uiscrollable ile Switches button tiklasin

  Scenario: scroll with reusable method
    And kullanici method ile Switches butununa tikladi