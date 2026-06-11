# BAföGBuddy

## Projektbeschreibung

BAföGBuddy ist eine offline-fähige Android-App, die Studierende bei der Vorbereitung und Verwaltung von BAföG-Anträgen unterstützt.

Die App ersetzt nicht das offizielle BAföG-Portal. Sie hilft dabei, persönliche Daten, benötigte Unterlagen, Nachforderungen und Fristen übersichtlich zu verwalten.

## Ziel des Projekts

Ziel des Projekts ist die Entwicklung eines Android-Prototyps mit API-first Ansatz, Komponentenstruktur und Qualitätssicherung durch automatisierte Tests.

## Funktionen

* Verwaltung von BAföG-Anträgen
* Dokumentenverwaltung
* Fristenübersicht
* Nachforderungen verwalten
* Statusübersicht
* Offline nutzbarer Prototyp

## Architektur

Das Projekt verwendet eine MVC-orientierte Struktur:

* Model
* View
* Controller

Wichtige Klassen:

* BafogApplication
* DocumentItem
* Deadline
* FollowUpRequest

## API-first Konzept

Die Anwendung wurde API-first geplant.

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

* DocumentItem
* Deadline
* FollowUpRequest
* Dashboard

Alle Tests wurden erfolgreich ausgeführt.

## Dokumentation

Zusätzliche Nachweise befinden sich im Ordner docs.

* Konzeptdokument
* Screenshots
* Testnachweise
* PDF-Dokumentation

## Projektstatus

Finaler Prototyp für Meilenstein 3.
