# AutoRaid Android App

AutoRaid is a starter Android app for booking auto-rickshaw rides with a user experience inspired by apps like Rapido.

## What is included

- Jetpack Compose UI with bottom navigation.
- Home screen with promotions and popular routes.
- Book Ride screen with pickup/drop inputs and ride option selection.
- Ride Status screen with captain details, OTP, and route summary.
- Profile screen with rider details and wallet snapshot.
- Mock repository for ride options and active booking.

## Tech stack

- Kotlin
- Jetpack Compose (Material 3)
- Navigation Compose
- Android Gradle Plugin + Kotlin DSL

## Project structure

- `app/src/main/java/com/yesman/autoride/ui` - App shell and navigation.
- `app/src/main/java/com/yesman/autoride/ui/screens` - Individual screens.
- `app/src/main/java/com/yesman/autoride/data` - Mock data repository.
- `app/src/main/java/com/yesman/autoride/model` - Data models.

## Run locally

1. Open this folder in Android Studio (latest stable).
2. Let Gradle sync.
3. Run on an Android emulator/device (minSdk 24).

## Next steps to make it production-ready

- Integrate Google Maps SDK for live pickup/drop map rendering.
- Replace mock repository with backend APIs and authentication.
- Add real-time location and ride tracking using sockets.
- Add payments, SOS features, and notification handling.
- Add unit/UI tests and CI build pipeline.
