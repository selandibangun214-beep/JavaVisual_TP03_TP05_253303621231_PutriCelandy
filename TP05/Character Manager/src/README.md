
## TP5 — Character Manager Sprint #2

### 1. Fitur Baru

Pada tugas TP5 ini, program Character Manager dikembangkan dengan fitur-fitur berikut:

- `addCharacter()` untuk menambahkan karakter dan menolak nama duplikat.
- `findByName()` untuk mencari karakter berdasarkan nama.
- `removeCharacter()` untuk menghapus karakter berdasarkan nama.
- `getTotalCharacters()` untuk menghitung jumlah karakter.
- `getAllCharacters()` untuk mengembalikan salinan daftar karakter.
- `getAverageLevel()` untuk menghitung rata-rata level dan mengembalikan `0.0` jika daftar kosong.
- `findByType()` untuk mencari karakter berdasarkan tipe.
- `countByType()` sebagai fitur analitik tambahan untuk menghitung jumlah karakter berdasarkan tipe.

### 2. Screenshot Output CRUD

Pengujian CRUD dilakukan untuk membuktikan bahwa program dapat menambahkan karakter, mencari karakter, menghapus karakter, dan menolak penambahan nama duplikat.

![Screenshot Output CRUD](screenshots/crud.png)

### 3. Eksperimen Reference dan Defensive Copy

Eksperimen reference menunjukkan bahwa ketika variabel `b` dibuat menggunakan `Character b = a;`, kedua variabel menunjuk objek yang sama. Perubahan level melalui `b` juga memengaruhi nilai yang dibaca melalui `a`, dan ekspresi `a == b` menghasilkan `true`.

Untuk membuat objek independen, dibuat objek baru menggunakan constructor `new Character(...)`. Objek baru memiliki reference berbeda sehingga perubahan levelnya tidak otomatis mengubah objek awal.

Pengujian defensive copy menunjukkan bahwa menghapus isi daftar hasil `getAllCharacters()` tidak menghapus karakter dari daftar internal `CharacterManager`.

![Screenshot Eksperimen Reference]
(<Screenshot 2026-10-15 163346.png>)
(<Screenshot 2026-10-15 163522-1.png>)
(<Screenshot 2026-10-15 163535-1.png>)

### 4. Fitur Analitik Rancangan Sendiri

Fitur tambahan yang dibuat adalah `countByType(CharacterType type)`.

Method ini menghitung jumlah karakter berdasarkan tipe tertentu tanpa mengekspos `ArrayList` internal.

Contoh penggunaan:

```java
manager.countByType(CharacterType.WARRIOR);
```

Jika terdapat dua karakter bertipe `WARRIOR`, method mengembalikan nilai `2`.

Fitur ini memudahkan analisis jumlah karakter berdasarkan tipe. Method dilengkapi Javadoc dan menjaga enkapsulasi karena hanya mengembalikan hasil perhitungan, bukan daftar internal.

### 5. Google Docs — Analisis Bagian D

Analisis Bagian D membahas:
1. Perbedaan reference dan primitive value.
2. Alasan `totalCharacterCreated` menggunakan `static`.
3. Alasan `equals()` perlu di-override untuk memeriksa nama duplikat.
4. Risiko jika `getAllCharacters()` mengembalikan `ArrayList` asli.
5. Hubungan reference dengan defensive copy.

**Link Google Docs:** [Buka Analisis Bagian D](https://docs.google.com/document/d/1SSIexANsS156Lu-YPYz8dWmNxNgLhOr5TXCtoL8DPhk/edit?usp=sharing)