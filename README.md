<h1 align="center">DroidMentor</h1>

This repository contains the implementation of the DroidMentor assignment for the PDM(Programação em Dispositivos Móveis) subject in ISEL.

# Index
- [Technologies](#technologies)
- [Group Members](#group-members)
- [Summary](#summary)
- [Application Flowchart](#application-flowchart)
- [Milestones](#milestones)
- [Database](#database)

# Technologies

The list below represents the major technologies used in the development of the project.

[![Android Studio](https://skillicons.dev/icons?i=androidstudio&theme=dark)](https://developer.android.com/studio?hl=en-us)
[![Kotlin](https://skillicons.dev/icons?i=kotlin&theme=dark)](https://kotlinlang.org)
[![Github](https://skillicons.dev/icons?i=github&theme=dark)](https://github.co)
[![Git](https://skillicons.dev/icons?i=git&theme=dark)](https://git-scm.com)
[![SQLite](https://skillicons.dev/icons?i=sqlite&theme=dark)](https://sqlite.org/index.html)

# Group Members
|                  Name                  |Number|
|:---------------------------------------|:----:|
|[Ricardo Martins](a52326@alunos.isel.pt)| 52326|
|[Manuel Abreu](a52487@alunos.isel.pt)   | 52487|
|[Maximus Delorey](a52506@alunos.isel.pt)| 52506|

# Summary

### Screens
- Chat
- All Chats
- Sidebar
- About
- Settings

### External Services
- Gemini API
- (Room / SQLite) Storage
- (DataStore) User Credentials

# Application Flowchart

```mermaid
flowchart LR

A[Screens] --1--> B[Services]
B[Services] --6--> A[Screens] 

subgraph APP["Core"]
    direction LR

    B[Services] --2--> C[Repositories]
    C[Repositories] --5--> B[Services]
end

C[Repositories] --3--> D[External Services]

D[External Services] --4--> C[Repositories]

```

<hr>

### Screens 

```mermaid
flowchart LR

start((" ")) --App Started--> A[Chat]

A[Chat] --Open Sidebar--> E[Sidebar]
E[Sidebar] --Close Sidebar--> A[Chat] 

E[Sidebar] --Open Settings--> C[Settings]
C[Settings] --Back--> E[Sidebar]

E[Sidebar] --Open About--> D[About]
D[About] --Back--> E[Sidebar]

E[Sidebar] --Open All Chats--> B[All Chats]
B[All Chats] --Open Sidebar--> E[Sidebar]
B[All Chats] --Open Chat/New Chat-->  A[Chat]

```

<hr>

### Core

```mermaid
flowchart LR

subgraph Core["Core"]
    direction LR

    A[Chat Services]
    B[Chat Repository]

    C["AI Services (Maybe)"]
    D[AI Repository]

    E[Settings Services]
    F[Settings Repository]

    G[User Services]
    H[User Repository]

    A <--> B
    C <--> D
    E <--> F
    G <--> H
        
end

```

<hr>
### External Services 

```mermaid
flowchart LR

A[Gemini API]
F[HTTP REST]

B[Room]
C[SQLite]
B --> C
C --> E
F --> A

D[Datastore]
E[Filesystem]
D --> E

```

<hr>

# Milestones

### Week 1-2
- Backend Core - Services Framework
Verifications of the data provided by the UI
- Backend Core - Repositories Framework:
    - **DB**
        - Chats
        - Settings
        - User
    - **API**
        - AI
- Database architecturing and concept
- Start of Database development
- Domain and DTO definition
- Researching the GEMINI API

### Week 3-4
- Continuing development of Services Framework and Repositories Framework
- Initial concepts and mocks of all UX/UI
- Begining the development of the UX/UI
- Database development and configuration

### Week 5-6
- Continuing development of Services Framework and Repositories Framework
- Continuing development of the UX/UI
- Continuing Database development and configuration

### Week 7-8
- Continuing development of Services Framework and Repositories Framework
- Continuing development of the UX/UI

### Week 9-10
- Refactoring of needed code
- Continuing development of Services Framework and Repositories Framework
- Continuing development of the UX/UI

### Week 11
- Refinement and polishing final code
- Assignment completion

# Database

**Entities**
- Chats
- Messages
- Users

![DB Diagram](db_diagram.png)
