\# BAföGBuddy – Meilenstein 3

\## Projektbeschreibung

BAföGBuddy ist eine offline-fähige Android-App, die Studierende bei der Vorbereitung und Verwaltung von BAföG-Anträgen unterstützt.

Die App ersetzt nicht das offizielle BAföG-Portal. Sie hilft dabei, persönliche Daten, benötigte Unterlagen, Nachforderungen und Fristen übersichtlich zu verwalten.

\## Ziel von Meilenstein 3

In Meilenstein 3 wurde die App nach dem API-first-Ansatz vorbereitet.

Die App wurde in Komponenten zerlegt:

\- model

\- controller

\- data

\- service

\- view

Jede wichtige Komponente hat eine klare Aufgabe und erste Schnittstellen/API.

\## Wichtige Komponenten

\- RequirementChecker: prüft fehlende Pflichtunterlagen und berechnet den Fortschritt

\- DocumentController: verwaltet den Status von Unterlagen

\- DeadlineController: berechnet offene und kritische Fristen

\- FollowUpController: verwaltet Nachforderungen vom BAföG-Amt

\- DashboardController: erstellt die Übersicht für das Dashboard

\- BafogRepository: definiert die spätere Schnittstelle zur lokalen Datenhaltung

\## Bereits umgesetzte Tests

Folgende Unit-Tests wurden erfolgreich ausgeführt:

\- RequirementCheckerTest

\- DeadlineControllerTest

\- DashboardControllerTest

\- DocumentControllerTest

\- FollowUpControllerTest

\## Tests ausführen

Im Projektordner kann man alle Unit-Tests mit folgendem Befehl starten:

```powershell

.\\gradlew test





## Zusätzliche Nachweise

Weitere Materialien liegen im Ordner `docs`:

- `docs/MS3_BAfoegBuddy_Konzept.md` – MS3-Konzeptdokumentation
- `docs/images/bafoegbuddy_app_mockup.png` – GUI-Mockup der geplanten App
- `docs/screenshots/ms3_tests_passed.png` – Nachweis erfolgreicher Unit-Tests
- `docs/screenshots/ms3_build_successful.png` – Nachweis erfolgreicher Gradle-Build
```
