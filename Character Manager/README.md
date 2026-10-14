## Character Manager — TP3 (Java Visual SIH-6406)
Deskripsi

Character Manager adalah project Java sederhana untuk mengelola karakter permainan menggunakan konsep Object-Oriented Programming (OOP). Project ini menerapkan enum, encapsulation, constructor, getter dan setter, serta fitur tambahan berupa mana dan pemeriksaan status hidup karakter.

## Fitur Utama
Menggunakan empat konstanta tipe karakter melalui CharacterType.
Memiliki dua constructor pada class Character.
Menggunakan atribut private dan getter/setter.
Melakukan level up untuk memperbarui HP dan attack.
Memiliki atribut mana bertipe int.
Memvalidasi mana agar tidak bernilai negatif.
Menggunakan method isAlive() untuk memeriksa status hidup karakter.
Memperbarui toString() agar menampilkan mana.
## Screenshot Output Terminal

Screenshot berikut menunjukkan hasil program Character Manager, termasuk tiga karakter, demo level up, mana, dan hasil pemeriksaan isAlive().
![alt text](<Screenshot 2026-10-14 133423.png>)

!Output Terminal Character Manager

## Struktur Folder Project
javavisual-tp03-[NIM]/
├── CharacterManager/
│   └── src/
│       └── com/
│           └── unpri/
│               └── charactermanager/
│                   ├── Main.java
│                   └── model/
│                       ├── Character.java
│                       └── CharacterType.java
├── screenshots/
│   └── output-terminal.png
└── README.md

## Persyaratan
JDK 17
IDE Java atau terminal
Git dan akun GitHub
Cara Menjalankan Program

Buka terminal pada folder CharacterManager, kemudian jalankan perintah berikut:

javac -d out -sourcepath src src/com/unpri/charactermanager/Main.java
java -cp out com.unpri.charactermanager.Main


Pastikan program berhasil dikompilasi dan menampilkan tiga karakter, demo level up, nilai mana, serta hasil isAlive().

## Identitas Mahasiswa
Nama Lengkap: [Nama Lengkap Anda]
NIM: [NIM Anda]
Kelas: [Kelas Anda]
Mata Kuliah: Java Visual SIH-6406
Dokumentasi Analisis Desain — Bagian D

## Dokumen analisis desain dan ekosistem Java dapat diakses melalui Google Docs berikut:
(https://docs.google.com/document/d/1wnjRXWNB-9vI4KjvTXYaVQT45Kb0EKWw70TZYFe8FpE/edit?usp=sharing)