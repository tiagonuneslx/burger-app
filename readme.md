# burger-app

A shopping app for buying burgers.

The goal of this project is to practice iOS development and Kotlin Multiplatform Mobile. I'm
developing feature by feature on Android, which I'm already experienced with, and then I'm
challenging myself to implement the exact same thing on iOS, and then using KMM.

The app UI design was copied
from [dribble](https://dribbble.com/shots/14952712-Food-Mobile-App-Design/attachments/6670047?mode=media)
by [Ghulam Rasool 🚀](https://dribbble.com/ghulaam-rasool).

- [X] 1. Build the Home page UI natively (on Android and iOS)

2. Create the Burger model:

    - [X] 2.1. Natively

    - [X] 2.2. Using KMM

3. Play with the Burgers data:

   3.1. Natively:

        - [X] 3.1.1. Using static list

        - [X] 3.1.2. Using static database (Android: Room, iOS: CoreData)

        - [ ] 3.1.3. Fetch from network (Android: Ktor Client)

        - [ ] 3.1.4. Fetch from network + Caching in database

   3.2. KMM:

        - [X] 2.3.1. Create static list

        - [ ] 3.2.2. Using static database: SQLDelight

        - [ ] 3.2.3. Fetch from network

        - [ ] 3.2.4. Fetch from network + Caching in database

4. Use a dependency injection framework:

    - [X] 4.1. Android: Hilt

    - [ ] 4.2. iOS?

    - [ ] 4.3. KMM: Koin