# AirAware – Technical Overview

AirAware is an open-source, cross-platform air quality monitoring application built using Kotlin Multiplatform (KMP). It provides real-time Air Quality Index (AQI) data by fetching information from aqicn.com and displays it alongside weather details such as temperature and atmospheric pressure.

## Platforms & Architecture:

- Supported Platforms: Android, iOS, Windows, macOS, and Linux
- Core Logic: Written in Kotlin Multiplatform (KMP) to share business logic across all platforms.
- Networking & Data Handling: Uses Ktor for API requests and Serialization for data parsing.
- Location Services: Retrieves the user's location via platform-specific implementations to
  determine the nearest air quality sensor.

## UI Frameworks:

- Android & Desktop (Windows/macOS/Linux): Jetpack Compose (Compose Multiplatform)
- iOS: SwiftUI with Kotlin/Native integration

## Key Features:

- Real-Time AQI Data: Pulls air quality data from aqicn.com based on the user’s location.
- Color-Coded AQI Indicators: Visual representation of AQI severity.
- Basic Weather Information: Displays temperature and atmospheric pressure.
- 7-Day Air Quality Forecast: Provides a week-long prediction of AQI trends.
- Cross-Platform Synchronization: Ensures consistent data retrieval and UI experience across
  devices.