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
|Name|Number|
|:---|:----:|
|[Ricardo Martins](a52326@alunos.isel.pt)|52326|
|[Manuel Abreu](a52487@alunos.isel.pt)|52487|
|[Maximus Delorey](a52506@alunos.isel.pt)|52506|


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

    C[AI Services]
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

### Week 1
- UI Framework Shell

### Week 2
- Backend Core - Services Framework

### Week 3
- Backend Core - Repositories Framework


# Database

Entities
- Chats
- Messages
- Users
- UI Settings
- Settings