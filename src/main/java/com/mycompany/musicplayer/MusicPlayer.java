package com.mycompany.musicplayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

final class Song {

    private final String name;
    private final String mood;
    private final String url;

    Song(String name, String mood, String url) {
        this.name = name;
        this.mood = mood;
        this.url = url;
    }

    String getName() {
        return name;
    }

    String getMood() {
        return mood;
    }

    String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return name;
    }
}

final class RecommendationEngine {

    private final List<Song> songs = new ArrayList<>();

    RecommendationEngine() {
        loadSongs();
    }

    private void loadSongs() {
        addSongs("HAPPY",
                new Song("Happy Pop-Tunes", "HAPPY", "https://youtu.be/uXJ62nB3-ZQ?si=yNjn7-XS09YCTKkX"),
                new Song("Radiant Happiness", "HAPPY", "https://youtu.be/sYsusQGag9o?si=8eQRujqozxDl2mfj"),
                new Song("Warm Hug", "HAPPY", "https://youtu.be/zUa5NhwmZf0?si=uYsTa4uSISeBaPHC"),
                new Song("Aesthetic Happy Pop", "HAPPY", "https://youtu.be/wWPQfzvSStE?si=wSJFYqEQ3f-xa3gB"),
                new Song("Good Time", "HAPPY", "https://youtu.be/cmLSizwDGj4?si=HIeND_K1mniv_s12"),
                new Song("Blue", "HAPPY", "https://youtu.be/4adZ7AguVcw?si=fgTkljPTP4qDesAC"),
                new Song("Projapotita", "HAPPY", "https://youtu.be/Zol-JKZL5x0?si=pmBKdJw1sXcqn8bz"),
                new Song("The Best Day", "HAPPY", "https://youtu.be/n0cde-Km05o?si=COlZ0FTXqzqnt1cI"));

        addSongs("SAD",
                new Song("When I'm Gone", "SAD", "https://youtu.be/pWcFqsZe2ws?si=UPUaz2izt2htzlS6"),
                new Song("Older", "SAD", "https://youtu.be/b1MJVZH3f8w?si=PYqO1X9eSY8TIvfX"),
                new Song("Currents Of Life", "SAD", "https://youtu.be/-jpPIoWh3l0?si=H6i7u-aAH3VVTlYz"),
                new Song("I Miss The Old Me", "SAD", "https://youtu.be/htv8jTzyI74?si=-906jgKpuYs0Lub-"),
                new Song("Dancing With Your Ghost", "SAD", "https://youtu.be/Qzc_aX8c8g4?si=5_SyANLPg5AVpOHW"),
                new Song("500 Miles", "SAD", "https://youtu.be/znLGPp2LabU?si=1xNcoU3zzqtbRGe5"),
                new Song("Ahare Shoishob", "SAD", "https://youtu.be/3EVTSc42fhM?si=jNCXxnKlW1kV0Okw"),
                new Song("Woh Din", "SAD", "https://youtu.be/6Vbgeiu9AIU?si=zkYlSrUt9HO3PBEB"));

        addSongs("INSPIRATIONAL",
                new Song("Everything Has Beauty", "INSPIRATIONAL", "https://youtu.be/5zaSqWfBA8s?si=294jD982E-GHau3o"),
                new Song("Sia - Unstoppable", "INSPIRATIONAL", "https://youtu.be/h3h035Eyz5A?si=htUZpyg303KJdMPc"),
                new Song("Ziddi Dil", "INSPIRATIONAL", "https://youtu.be/puKD3nkB1h4?si=dUkCKJb7nSoHvIzx"),
                new Song("Labour", "INSPIRATIONAL", "https://youtu.be/a6NrnPzFkI0?si=Y9tvTZFrloW8F90d"),
                new Song("Badal Pe Paon Hain", "INSPIRATIONAL", "https://youtu.be/m0wYJnCq-4M?si=O9RmYXCNegLYtDT6"),
                new Song("Who Says", "INSPIRATIONAL", "https://youtu.be/J5gVq9C--zg?si=oMFaEu5Du7GqRKJc"),
                new Song("Ek Zindagi", "INSPIRATIONAL", "https://youtu.be/9MH9gKM_LEE?si=XZo3F4MdnBFI6Kbg"));

        addSongs("STUDY MOOD",
                new Song("Night Study Mode", "STUDY MOOD", "https://www.youtube.com/watch?v=7wtfhZwyrcc"),
                new Song("Lofi Study Session", "STUDY MOOD", "https://youtu.be/lTRiuFIWV54?si=q9h9K_jbu9L-wXpQ"),
                new Song("Exam Study Music", "STUDY MOOD", "https://youtu.be/qQzf-xzZO7M?si=NSAg9bMt6nkrsrqn"),
                new Song("Intense Study-Gamma Beats", "STUDY MOOD", "https://youtu.be/lkkGlVWvkLk?si=L1nrjM_UhI_4GVhS"),
                new Song("Alpha Waves", "STUDY MOOD", "https://youtu.be/lecITZkWqzg?si=c5gesifPztd8kBTg"),
                new Song("Give Me Some Sunshine", "STUDY MOOD", "https://youtu.be/RKFsnDsazeU?si=4y3ZQuSQsg3nJouS"));
    }

    private void addSongs(String mood, Song... songsToAdd) {
        for (Song song : songsToAdd) {
            songs.add(song);
        }
    }

    List<Song> getSongsByMood(String mood) {
        List<Song> matchingSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getMood().equalsIgnoreCase(mood)) {
                matchingSongs.add(song);
            }
        }
        return matchingSongs;
    }
}

public class MusicPlayer extends JFrame {

    private static final String[] MOODS = {
        "HAPPY", "SAD", "INSPIRATIONAL", "STUDY MOOD"
    };

    private final RecommendationEngine recommendationEngine = new RecommendationEngine();
    private final JComboBox<String> moodBox = new JComboBox<>(MOODS);
    private final DefaultListModel<Song> listModel = new DefaultListModel<>();
    private final JList<Song> songList = new JList<>(listModel);
    private final JPanel topPanel = new JPanel();
    private final JPanel bottomPanel = new JPanel();
    private final JPanel welcomePanel = new JPanel();
    private final JButton playButton = new JButton("Play");
    private JScrollPane songScroll;

    public MusicPlayer() {
        setTitle("Mood Music Player");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        createTopPanel();
        createSongList();
        createBottomPanel();
        createWelcomePanel();

        add(welcomePanel, BorderLayout.CENTER);
    }

    private void createTopPanel() {
        topPanel.setBackground(new Color(245, 247, 250));
        topPanel.setBorder(new EmptyBorder(8, 12, 8, 12));
        topPanel.add(new JLabel("Select Mood:"));
        topPanel.add(moodBox);

        JButton findButton = new JButton("Find Mood Songs");
        findButton.setBackground(new Color(42, 157, 143));
        findButton.setForeground(Color.WHITE);
        findButton.setFocusPainted(false);
        findButton.addActionListener(event -> showMoodSongs());
        topPanel.add(findButton);
    }

    private void createSongList() {
        songList.setFont(new Font("Arial", Font.BOLD, 16));
        songList.setBackground(Color.WHITE);
        songList.setSelectionBackground(new Color(42, 157, 143));
        songList.setSelectionForeground(Color.WHITE);
        songScroll = new JScrollPane(songList);
        songScroll.getViewport().setBackground(Color.WHITE);
    }

    private void createBottomPanel() {
        bottomPanel.setLayout(new GridLayout(1, 1));
        bottomPanel.setBackground(new Color(245, 247, 250));
        bottomPanel.setBorder(new EmptyBorder(8, 16, 16, 16));
        playButton.setFont(new Font("Arial", Font.BOLD, 20));
        playButton.setBackground(new Color(42, 157, 143));
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);
        playButton.addActionListener(event -> playSelectedSong());
        bottomPanel.add(playButton);
    }

    private void createWelcomePanel() {
        welcomePanel.setLayout(new BorderLayout(16, 24));
        welcomePanel.setBorder(new EmptyBorder(100, 40, 110, 40));
        welcomePanel.setBackground(new Color(225, 242, 252));

        JLabel welcomeLabel = new JLabel(
                "Welcome to Mood Music Player!",
                JLabel.CENTER
        );
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(28, 74, 104));

        JButton selectMoodButton = new JButton(
                "Click to select songs based on your mood"
        );
        selectMoodButton.setFont(new Font("Arial", Font.BOLD, 16));
        selectMoodButton.setBackground(new Color(42, 157, 143));
        selectMoodButton.setForeground(Color.WHITE);
        selectMoodButton.setFocusPainted(false);
        selectMoodButton.addActionListener(event -> showMoodSelection());

        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        welcomePanel.add(selectMoodButton, BorderLayout.SOUTH);
    }

    private void showMoodSelection() {
        getContentPane().remove(welcomePanel);
        add(topPanel, BorderLayout.NORTH);
        add(songScroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        revalidate();
        repaint();
        moodBox.requestFocusInWindow();
    }

    private void showMoodSongs() {
        String selectedMood = (String) moodBox.getSelectedItem();
        listModel.clear();

        for (Song song : recommendationEngine.getSongsByMood(selectedMood)) {
            listModel.addElement(song);
        }

        changeColorForMood(selectedMood);
    }

    private void changeColorForMood(String mood) {
        Color backgroundColor;
        Color buttonColor;

        switch (mood) {
            case "HAPPY":
                backgroundColor = new Color(255, 244, 230);
                buttonColor = new Color(230, 126, 34);
                break;
            case "SAD":
                backgroundColor = new Color(239, 242, 245);
                buttonColor = new Color(82, 96, 105);
                break;
            case "INSPIRATIONAL":
                backgroundColor = new Color(232, 247, 241);
                buttonColor = new Color(38, 133, 91);
                break;
            case "STUDY MOOD":
                backgroundColor = new Color(232, 243, 250);
                buttonColor = new Color(38, 116, 166);
                break;
            default:
                backgroundColor = Color.WHITE;
                buttonColor = Color.GRAY;
        }

        applyColors(backgroundColor, buttonColor);
    }

    private void applyColors(Color backgroundColor, Color buttonColor) {
        getContentPane().setBackground(backgroundColor);
        topPanel.setBackground(backgroundColor);
        songList.setBackground(backgroundColor);
        songList.getParent().setBackground(backgroundColor);
        bottomPanel.setBackground(backgroundColor);
        playButton.setBackground(buttonColor);
        playButton.setForeground(Color.WHITE);
    }

    private void playSelectedSong() {
        Song selectedSong = songList.getSelectedValue();
        if (selectedSong == null) {
            JOptionPane.showMessageDialog(this, "Select a song first!");
            return;
        }

        if (!Desktop.isDesktopSupported()) {
            JOptionPane.showMessageDialog(this, "Opening a browser is not supported on this computer.");
            return;
        }

        try {
            Desktop.getDesktop().browse(new URI(selectedSong.getUrl()));
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Could not open the song link.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusicPlayer musicPlayer = new MusicPlayer();
            musicPlayer.setVisible(true);
        });
    }
}