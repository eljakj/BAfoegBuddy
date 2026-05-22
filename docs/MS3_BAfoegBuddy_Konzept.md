# BAföGBuddy – Meilenstein 3: API-first und Komponenten

## 1. Projektidee

BAföGBuddy ist eine offline-fähige Android-App, die Studierende bei der Vorbereitung und Verwaltung von BAföG-Anträgen unterstützt.

Die App ersetzt nicht das offizielle BAföG-Portal. Sie hilft dabei, persönliche Daten, benötigte Unterlagen, Nachforderungen und Fristen übersichtlich zu verwalten. Ziel ist es, fehlende Dokumente frühzeitig zu erkennen und Folgeanträge einfacher vorzubereiten.

---

## 2. Ziel von Meilenstein 3

In Meilenstein 3 wird die App nach dem API-first-Ansatz geplant.

Das bedeutet:

- Die App wird in Komponenten zerlegt.
- Jede Komponente bekommt eine klare Aufgabe.
- Jede Komponente bietet eine definierte Schnittstelle/API.
- Die Komponenten werden so geplant, dass sie automatisiert testbar sind.

---

## 3. Architekturidee: MVC

BAföGBuddy wird grob nach MVC strukturiert.

### Model

Das Model beschreibt die Daten der App.

Beispiele:

- User
- BafogApplication
- DocumentItem
- Deadline
- FollowUpRequest

### View

Die View beschreibt die Benutzeroberfläche.

Beispiele:

- LoginScreen
- DashboardScreen
- DocumentsScreen
- DeadlinesScreen

### Controller

Die Controller enthalten die Fachlogik.

Beispiele:

- RequirementChecker
- DocumentController
- DeadlineController
- DashboardController
- FollowUpController

---

## 4. Komponentenübersicht

| Komponente          | Paket      | Aufgabe                                                        |
| ------------------- | ---------- | -------------------------------------------------------------- |
| User                | model      | Speichert einfache Nutzerdaten                                 |
| BafogApplication    | model      | Beschreibt einen BAföG-Antrag                                  |
| DocumentItem        | model      | Beschreibt eine benötigte Unterlage                            |
| Deadline            | model      | Beschreibt eine Frist                                          |
| FollowUpRequest     | model      | Beschreibt eine Nachforderung vom BAföG-Amt                    |
| RequirementChecker  | controller | Prüft fehlende Pflichtunterlagen und berechnet den Fortschritt |
| DocumentController  | controller | Ändert den Status von Unterlagen                               |
| DeadlineController  | controller | Berechnet offene und kritische Fristen                         |
| FollowUpController  | controller | Verwaltet Nachforderungen                                      |
| DashboardController | controller | Erstellt die Übersicht für das Dashboard                       |
| BafogRepository     | data       | Definiert die Schnittstelle zur späteren lokalen Datenbank     |
| ReminderService     | service    | Prüft, ob eine Erinnerung ausgelöst werden soll                |
| NotificationService | service    | Erstellt Texte für spätere Benachrichtigungen                  |

---

## 5. Komponentendiagramm

```text
Views / Screens
    |
    v
Controller
    |
    v
Model

Controller <--> Repository / LocalDatabase
Service --> Controller
```

Ausführlicher:

```text
LoginScreen
DashboardScreen
DocumentsScreen
DeadlinesScreen
        |
        v
DashboardController
DocumentController
DeadlineController
FollowUpController
RequirementChecker
        |
        v
User
BafogApplication
DocumentItem
Deadline
FollowUpRequest
        |
        v
BafogRepository / spätere Room-Datenbank
```

---

## 6. API-first: geplante Schnittstellen

### RequirementChecker

Aufgabe: Prüft, ob ein BAföG-Antrag vollständig ist.

API:

```kotlin
getMissingRequiredDocuments(documents)
calculateCompletionPercentage(documents)
isApplicationComplete(documents)
```

Testidee:

- Fehlende Pflichtunterlagen werden korrekt erkannt.
- Optionale fehlende Dokumente zählen nicht als Problem.
- Der Fortschritt wird korrekt berechnet.

---

### DocumentController

Aufgabe: Verwaltet den Status von Unterlagen.

API:

```kotlin
markAsAvailable(document)
markAsUploaded(document)
markAsMissing(document)
markAsInReview(document)
```

Testidee:

- Ein Dokument kann von „fehlt“ zu „hochgeladen“ wechseln.
- Der Status wird korrekt geändert.

---

### DeadlineController

Aufgabe: Verwaltet Fristen.

API:

```kotlin
getOpenDeadlines(deadlines)
calculateDaysLeft(deadline, today)
isDeadlineCritical(deadline, today)
```

Testidee:

- Erledigte Fristen werden nicht als offen angezeigt.
- Die verbleibenden Tage werden korrekt berechnet.
- Eine Frist wird als kritisch erkannt, wenn nur noch wenige Tage bleiben.

---

### FollowUpController

Aufgabe: Verwaltet Nachforderungen vom BAföG-Amt.

API:

```kotlin
getOpenFollowUps(followUps)
markAsDone(followUp)
markAsInProgress(followUp)
```

Testidee:

- Offene Nachforderungen werden korrekt angezeigt.
- Nachforderungen können als erledigt markiert werden.

---

### DashboardController

Aufgabe: Erstellt die Übersicht für die Startseite.

API:

```kotlin
buildSummary(documents, deadlines, followUps)
```

Testidee:

- Fortschritt, fehlende Unterlagen, offene Fristen und offene Nachforderungen werden korrekt zusammengefasst.

---

## 7. Bereits umgesetzte Tests

Folgende Unit-Tests wurden bereits erstellt und erfolgreich ausgeführt:

| Testklasse              | Getestete Komponente | Zweck                                      |
| ----------------------- | -------------------- | ------------------------------------------ |
| RequirementCheckerTest  | RequirementChecker   | Fehlende Unterlagen und Fortschritt prüfen |
| DeadlineControllerTest  | DeadlineController   | Fristen und kritische Fristen prüfen       |
| DashboardControllerTest | DashboardController  | Dashboard-Zusammenfassung prüfen           |
| DocumentControllerTest  | DocumentController   | Dokumentstatus ändern und prüfen           |
| FollowUpControllerTest  | FollowUpController   | Nachforderungen filtern und Status ändern  |

---

## 8. Erklärung der aktuellen Projektstruktur

Die App ist aktuell in folgende Pakete aufgeteilt:

```text
model       = Daten der App
controller  = Fachlogik der App
data        = spätere Speicherung / Datenbank
service     = Erinnerungen und Benachrichtigungen
view        = geplante Oberflächen
```

Diese Struktur hilft dabei, die App testbar und wartbar zu machen.

---

## 9. Nächste technische Schritte

Als nächstes werden folgende Schritte geplant:

1. Weitere Unit-Tests für DocumentController und FollowUpController.
2. Eine einfache lokale Datenquelle oder ein MockRepository.
3. Später Integration einer Room-Datenbank.
4. Aufbau erster echter Views für Login, Dashboard, Dokumente und Fristen.
5. Später GUI-Tests für zentrale Nutzeraktionen.

---

## 10. Technischer Schwerpunkt

Der technische Schwerpunkt von BAföGBuddy liegt auf:

- lokaler Datenhaltung
- offline nutzbarer Dokumenten- und Fristenverwaltung
- testbarer Fachlogik
- Vorbereitung einer späteren Datenbankanbindung

Die App arbeitet zunächst mit klar definierten Modellen und Controllern. Dadurch kann die Logik unabhängig von der Android-Oberfläche getestet werden.
