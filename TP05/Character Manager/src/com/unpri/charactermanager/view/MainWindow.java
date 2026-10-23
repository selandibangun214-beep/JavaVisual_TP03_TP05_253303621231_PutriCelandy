
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private JPanel characterPanel;
    private JLabel totalLabel;
    private JLabel averageLabel;
    private JButton addButton;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - Sprint #3");
        setSize(750, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        refreshData();
    }

    private void initComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Judul aplikasi
        JLabel titleLabel = new JLabel(
                "Daftar Karakter",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel untuk daftar karakter
        characterPanel = new JPanel();

        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        characterPanel.setBackground(new Color(245, 245, 245));

        JScrollPane scrollPane = new JScrollPane(characterPanel);

        scrollPane.setBorder(
                BorderFactory.createLineBorder(Color.GRAY)
        );

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel statistik dan tombol
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(
                new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)
        );

        totalLabel = new JLabel(
                "Total Karakter: 0",
                SwingConstants.CENTER
        );

        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        averageLabel = new JLabel(
                "Rata-rata Level: 0.00",
                SwingConstants.CENTER
        );

        averageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        averageLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        addButton = new JButton("Tambah Karakter");

        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addButton.addActionListener(e -> addCharacter());

        bottomPanel.add(totalLabel);
        bottomPanel.add(Box.createVerticalStrut(8));
        bottomPanel.add(averageLabel);
        bottomPanel.add(Box.createVerticalStrut(12));
        bottomPanel.add(addButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    // Menampilkan data karakter dan statistik
    public void refreshData() {

        characterPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {

            JLabel characterLabel = new JLabel(
                    character.toString()
            );

            characterLabel.setFont(
                    new Font("Arial", Font.PLAIN, 16)
            );

            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(10, 15, 10, 10)
            );

            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            characterPanel.add(characterLabel);
        }

        // Memperbarui total karakter
        totalLabel.setText(
                "Total Karakter: " + manager.getTotalCharacters()
        );

        // Memperbarui rata-rata level
        averageLabel.setText(
                String.format(
                        Locale.US,
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    // Menambahkan karakter melalui tombol
    private void addCharacter() {

        JTextField nameField = new JTextField();
        JTextField levelField = new JTextField();

        JComboBox<CharacterType> typeComboBox =
                new JComboBox<>(CharacterType.values());

        JPanel inputPanel = new JPanel(new GridLayout(0, 1, 5, 5));

        inputPanel.add(new JLabel("Nama Karakter:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Level:"));
        inputPanel.add(levelField);

        inputPanel.add(new JLabel("Tipe Karakter:"));
        inputPanel.add(typeComboBox);

        int result = JOptionPane.showConfirmDialog(
                this,
                inputPanel,
                "Tambah Karakter",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        String name = nameField.getText().trim();
        String levelText = levelField.getText().trim();

        if (name.isEmpty() || levelText.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Nama dan level wajib diisi.",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {

            int level = Integer.parseInt(levelText);

            if (level < 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Level tidak boleh negatif.",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            CharacterType selectedType =
                    (CharacterType) typeComboBox.getSelectedItem();

            Character newCharacter =
                    new Character(name, level, selectedType);

            if (manager.addCharacter(newCharacter)) {

                refreshData();

                JOptionPane.showMessageDialog(
                        this,
                        "Karakter berhasil ditambahkan."
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Nama karakter sudah ada atau tidak valid.",
                        "Gagal Menambahkan",
                        JOptionPane.WARNING_MESSAGE
                );
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Level harus berupa angka bulat.",
                    "Input Tidak Valid",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
