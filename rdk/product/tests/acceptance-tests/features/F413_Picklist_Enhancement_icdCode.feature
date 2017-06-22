@Diagnostic_pick_lists @US12008 @F413

Feature:F413 - Enter, Store, Edit Encounter Form Data

@Diagnostic_pick_lists1 @US12008
Scenario: Searching icdCode with preferredText (Eclampsia in Labor)
  When the client requests picklist with the parameters for "progress-notes-titles-icd-10" with the user "9E7A;PW    "
      | paramter name | value                          |
      | searchString  | Eclampsia in Labor|

  Then a successful response is returned
  And the picklist result contains
      |field      | value |
      | preferredText |Eclampsia in Labor|
      |icdCodingSystem|ICD-10-CM|
      |icdCode|O15.1|
      |diagnosisIen|518186|
      |ien|5016177|

@Diagnostic_pick_lists2 @US12008
Scenario: Searching icdCode with icdCode (Z96.21)
  When the client requests picklist with the parameters for "progress-notes-titles-icd-10" with the user "9E7A;PW    "
      | paramter name | value                          |
      | searchString  | Z96.21|

  Then a successful response is returned
  And the picklist result contains
      |field      | value |
      | preferredText |Cochlear Implant Status|
      |icdCodingSystem|ICD-10-CM|
      |icdCode|Z96.21|
      |diagnosisIen|569756|
      |ien|5063684|

@Diagnostic_pick_lists3 @US12008
Scenario: Searching icdCode with invalid preferredText (KKLM)
  When the client requests picklist with the parameters for "progress-notes-titles-icd-10" with the user "9E7A;PW    "
      | paramter name | value                          |
      | searchString  | KKLM|

      Then a successful response is returned


