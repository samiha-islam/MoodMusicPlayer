# Mood Music Player

Mood Music Player is a Java Swing desktop application that helps users find songs based on their mood. Users can choose a mood, view recommended songs, and open a selected song directly on YouTube.

## Features

- Welcome screen with mood selection
- Mood-based song recommendations
- Happy, Sad, Inspirational, and Study Mood categories
- Simple and clean desktop interface
- Mood-specific colors
- Opens selected songs in the default web browser

## Technologies Used

- Java
- Java Swing
- AWT
- Object-Oriented Programming (OOP)

## How to Run

Make sure Java JDK is installed, then run these commands from the project folder:

```powershell
javac -d out src\main\java\com\mycompany\musicplayer\MusicPlayer.java
java -cp out com.mycompany.musicplayer.MusicPlayer
```

## Project Structure

```text
MoodMusicPlayer/
└── src/
    └── main/
        └── java/
            └── com/mycompany/musicplayer/
                └── MusicPlayer.java
```

## Note

This application opens the selected song's YouTube link in the default browser. It does not download or play audio inside the application.