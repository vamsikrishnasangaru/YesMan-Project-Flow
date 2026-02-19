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

## Run locally in Android Studio (step-by-step)

1. **Install Android Studio**
   - Use latest stable Android Studio (Koala or newer recommended).
2. **Open project**
   - Android Studio → **Open** → select this folder: `YesMan-Project-Flow`.
3. **Use correct JDK**
   - Go to **File → Settings → Build, Execution, Deployment → Build Tools → Gradle**.
   - Set **Gradle JDK** to **Embedded JDK (17)** (or any JDK 17/21 supported by current AGP).
4. **Sync Gradle**
   - Click **Sync Now** when prompted.
5. **Create emulator (if needed)**
   - **Tools → Device Manager → Create Device**.
   - Pick any phone profile and Android 10+ image.
6. **Run app**
   - Choose `app` configuration.
   - Click ▶ **Run** to launch on emulator or connected device.

### If build fails

- Error mentions unsupported Java version (for example Java 25): switch Gradle JDK back to Embedded JDK 17.
- If dependencies fail to download: check internet/proxy settings in Android Studio.
- If cache issue: **File → Invalidate Caches / Restart**.

## Run from terminal (optional)

If you have JDK 17 installed and Android SDK configured, you can run:

```bash
gradle assembleDebug
```

## Next steps to make it production-ready

- Integrate Google Maps SDK for live pickup/drop map rendering.
- Replace mock repository with backend APIs and authentication.
- Add real-time location and ride tracking using sockets.
- Add payments, SOS features, and notification handling.
- Add unit/UI tests and CI build pipeline.
