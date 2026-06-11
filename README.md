# BAföGBuddy

## Projektbeschreibung

BAföGBuddy ist eine offline-fähige Android-App, die Studierende bei der Vorbereitung und Verwaltung von BAföG-Anträgen unterstützt.

Die App ersetzt nicht das offizielle BAföG-Portal. Sie hilft dabei, persönliche Daten, benötigte Unterlagen, Nachforderungen und Fristen übersichtlich zu verwalten.

## Ziel des Projekts

Ziel des Projekts ist die Entwicklung eines Android-Prototyps mit API-first Ansatz, Komponentenstruktur und Qualitätssicherung durch automatisierte Tests.

## Funktionen

- Verwaltung von BAföG-Anträgen
- Dokumentenverwaltung
- Fristenübersicht
- Nachforderungen verwalten
- Statusübersicht
- Offline nutzbarer Prototyp
- Release-Demo für die Projektpräsentation

## Architektur

Das Projekt verwendet eine MVC-orientierte Struktur:

- Model
- View
- Controller

Wichtige Klassen:

- BafogApplication
- DocumentItem
- Deadline
- FollowUpRequest

## API-first Konzept

Die Anwendung wurde API-first geplant und vorbereitet.

Beispielhafte Endpunkte:

GET /applications

POST /applications

GET /documents

POST /documents

GET /deadlines

POST /deadlines

GET /followups

POST /followups

## Komponenten

| Komponente  | Aufgabe              |
| ----------- | -------------------- |
| Dashboard   | Übersicht            |
| Document    | Dokumentenverwaltung |
| Deadline    | Fristenverwaltung    |
| FollowUp    | Nachforderungen      |
| Application | BAföG-Anträge        |

## Qualitätssicherung

Für das Projekt wurden Unit Tests erstellt.

Getestete Bereiche:

- RequirementChecker
- DocumentController
- DeadlineController
- DashboardController
- FollowUpController

Alle Tests wurden erfolgreich ausgeführt. Zusätzlich wurde der Android-Prototyp erfolgreich im Emulator gestartet.

## Dokumentation

Zusätzliche Nachweise befinden sich im Ordner docs.

- Konzeptdokument
- Screenshots
- Testnachweise
- PDF-Dokumentation

## Projektstatus

Release-Kandidat für Meilenstein 4 (Release + Projektpräsentation).

Der Android-Prototyp enthält die wichtigsten Funktionen der geplanten Anwendung und ist für die Präsentation vorbereitet.

## Meilenstein 4 – Release und Projektpräsentation

Für Meilenstein 4 wurde BAföGBuddy zu einem lauffähigen Android-Prototyp erweitert.

Die Demo enthält folgende Screens:

- Login / Startscreen
- Dashboard / Übersicht
- Antrag
- Dokumente
- Fristen
- Nachforderungen

Der Prototyp zeigt die wichtigsten Funktionen der geplanten App:

- Verwaltung von BAföG-Antragsdaten
- Übersicht über fehlende Unterlagen
- Dokumentenstatus
- Fristenübersicht
- Nachforderungen vom BAföG-Amt
- lokale/offline nutzbare Struktur

Die App ist als Release-Demo für die Projektpräsentation vorbereitet.

## Screens des Prototyps

- Login / Startscreen
- Dashboard / Übersicht
- Antrag
- Dokumente
- Fristen
- Nachforderungen
