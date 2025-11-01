# Kelompok 2 | A3B
# Anggota:
### - Dhita Olivia (2409116040)
### - Khairunisa Aprilia (2409116060)
### - Zahra Aurellya Herdiansyah (2409116062)
### - Elmy Fadillah (2409116075)



# Sistem Data Terpadu dan Pengaduan Institusi Publik

# A. Deskripsi Program
Program Sistem Data Terpadu dan Pengaduan Institusi Publik merupakan platform terpadu yang dirancang untuk meningkatkan transparansi dan partisipasi publik dalam pengelolaan institusi pemerintah. Sistem ini berfungsi sebagai pusat informasi yang memuat data publik terkait berbagai anggaran, termasuk rincian alokasi, realisasi, serta penggunaan dana pada setiap instansi.

Selain itu, sistem ini juga menyediakan kanal khusus untuk pengaduan atau keluhan masyarakat, sehingga publik dapat dengan mudah menyampaikan aspirasi, kritik, maupun laporan terkait pelayanan atau kebijakan institusi publik. Melalui program ini, diharapkan tercipta akuntabilitas yang lebih tinggi, pelayanan yang responsif, dan kepercayaan masyarakat terhadap kinerja lembaga publik.


# B. Fitur-fitur Program
##   a. Menu Utama
Pada menu utama, sistem menampilkan halaman awal yang berisi dua opsi utama, yaitu Login dan Registrasi.

### a). Registrasi 
Fitur ini digunakan oleh pengguna baru yang belum memiliki akun.
Pengguna perlu mengisi beberapa data seperti:
- NIK (Nomor Induk Kependudukan)
- Nama lengkap
- Email 
- No Handphone
- Kata Sandi
- Alamat

Setelah data diisi dan disimpan, akun pengguna akan otomatis terdaftar di sistem dan dapat digunakan untuk login ke dalam menu pengguna. Dan juga, menu registasi memiliki tombol Keluar untuk kembali ke halaman awal atau menu utama.

### b) Login 
Fitur ini digunakan untuk masuk ke sistem sesuai peran masing-masing dan diminta untuk mengisi email dan kata sandi.
#### 1. Pengguna: dapat mengakses menu data anggaran dan menu pengaduan.
#### 2. Admin Pengelola Anggaran: dapat mengelola data anggaran.
#### 3. Admin Pengelola Pengaduan: dapat meninjau, menanggapi, dan menindaklanjuti laporan atau keluhan yang dikirim oleh pengguna.
Sistem akan melakukan verifikasi username dan password terhadap data yang tersimpan di database. Jika valid, pengguna langsung diarahkan ke menu sesuai perannya. Selain itu, menu login juga memiliki tombol Keluar untuk kembali ke halaman awal atau menu utama dan menjaga keamanan akun setelah selesai digunakan.

##   b. Menu Pengguna
Menu ini merupakan halaman utama bagi pengguna yang telah berhasil login. Pada menu ini, pengguna dapat mengakses berbagai fitur layanan publik yang berkaitan dengan data anggaran dan pengaduan. Dengan adanya menu pengguna, masyarakat dapat berpartisipasi secara aktif dalam sistem pengawasan publik dan ikut mendukung keterbukaan informasi.
Fitur-fitur yang tersedia pada menu pengguna antara lain:
### a). Melihat Data Publik Anggaran
Pengguna dapat melihat daftar anggaran yang telah disediakan oleh admin, termasuk rincian seperti nama program, jumlah dana, dan tahun pelaksanaan. Tujuannya untuk meningkatkan transparansi dan memberikan akses informasi publik.
### b). Menu Pengaduan atau Keluhan
Pada menu ini pengguna dapat melakukan berbagai hal mengenai pengaduannya, seperti mengirim pengaduan, melihat pengaduan, menghapus pengaduan, dan juga melihat tanggapan dari aadmin mengenai pengaduan yang telah kita layangkan ke institusi publik.

#### 1. Mengirim Pengaduan atau Keluhan 
Melalui formulir pengaduan, pengguna dapat mengajukan laporan terkait pelayanan publik.
Formulir ini biasanya berisi kolom:
- Judul Pengaduan
- Isi atau Deskripsi Keluhan
- Tanggal Pengaduan
- Nama Instansi Tujuan

#### 2. Melihat Pengaduan 
Setelah mengirim aduan, pengguna dapat melihat tabel pengaduannya.

#### 3. Melihat Tanggapan dari Admin
Jika admin pengelola pengaduan telah memberikan tanggapan, pengguna bisa melihat hasil respon atau tindakan lanjutan melalui tabel di menu ini.

##   c. Menu Admin Pengelola Anggaran
Menu ini diperuntukkan bagi admin yang bertanggung jawab mengelola data anggaran publik.  Admin ini memiliki hak akses khusus untuk menambah, memperbarui, dan memverifikasi data yang nantinya dapat diakses oleh pengguna. Menu ini mendukung prinsip transparansi dan akuntabilitas dalam pengelolaan anggaran publik.
Fitur-fitur utama dalam menu admin pengelola anggaran meliputi:

#### a). Dashboard
Pada menu ini terdapat deskripsi menu admin pengelola anggaran.

#### b). Menambah Data Baru
Admin dapat memasukkan data untuk data anggaran seperti:
- Nama instansi
- Tahun
- Nama program
- Total anggaran
- Realisasi
- Keterangan

#### c). Melihat Tabel Data Anggaran
Sistem menampilkan tabel data anggaran yang terdapat di sistem.

#### d). Memperbarui Data Anggaran
Jika terdapat perubahan, admin dapat mengedit informasi agar tetap akurat dan terkini. Dimana admin diminta untuk memilih **ID data anggaran** yang ingin di perbarui, dan admin bisa memilih kolom yang ingin diperbarui seperti:
- Tahun
- Nama program
- Total anggaran
- Realisasi
- Keterangan

#### e). Menghapus Data Anggaran
Admin dapat menghapus data yang sudah tidak relevan atau tidak valid. Dengan memasukan **ID data anggaran** yang ingin dihapus.

##   d. Menu Admin Pengelola Pengaduan

Menu ini digunakan oleh admin yang bertugas memproses dan menindaklanjuti pengaduan masyarakat. Admin memiliki akses untuk melihat semua aduan yang masuk dan memperbarui statusnya sesuai perkembangan. Melalui menu ini, pengelolaan keluhan masyarakat menjadi lebih cepat, sistematis, dan transparan.
Fitur-fitur utama pada menu admin pengelola pengaduan antara lain:

#### a). Dashboard
Pada menu ini terdapat deskripsi menu admin pengelola tanggapan.

#### b). Menambah Tanggapan 
Admin dapat membalas pengaduan dengan memilih **ID pengaduan** yang ingin diberi tanggapaan dan akan diminta untuk mengisi kolom seperti:
- Keterangan status (diteruskan, ditindaklanjuti, atau diselesaikan).
- Isi Tanggapan mengenai penjelasan penyelesaian, atau langkah tindak lanjut yang telah dilakukan.
- Tanggal tanggapan

#### c). Melihat Tabel Tanggapan
Admin dapat melihat semua tanggapan yang telah ditambahkan.

#### d). Memperbarui Tanggapan
Tanggapan dapat diperbarui dengan admin memilih **ID tanggapan** yang ingin diperbarui status, kolom-kolom yang bisa idperbarui adalah: 
- Keterangan status (diteruskan, ditindaklanjuti, atau diselesaikan).
- Isi tanggapan.
- Tanggal tanggapan

#### e). Menghapus Tanggapan
Jika ada tanggapan ganda atau tidak valid, admin dapat menghapusnya agar data tetap bersih dan relevan.

#### f). Melihat Tabel Pengaduan Masuk
Admin dapat melihat semua pengaduan yang dikirim oleh pengguna, lengkap dengan detail isi dan identitas pengirim.


# C. Penerapan 5 Pilar OOP (Object Oriented Programming)
##   a. Encapsulation
##   b. Abstraction
##   c. Polymorphism 
##   d. Inheritance
##   e. Interface

# D. Struktur Package/Folder Program
Struktur program Sistem Data Terpadu dan Pengaduan Institusi Publik dirancang menggunakan pola Model-View-Controller (MVC) untuk memisahkan logika data, tampilan, dan pengendali proses. Tujuannya agar sistem lebih mudah dikembangkan, diuji, dan dikelola.

<img width="458" height="161" alt="image" src="https://github.com/user-attachments/assets/7d9aab08-b02c-427e-b8c4-1fca5df5d630" />

##   a. Package controller

<img width="210" height="46" alt="image" src="https://github.com/user-attachments/assets/6aa479aa-90bb-4619-a77f-51037c3d6b7f" />

Berfungsi untuk mengatur logika utama aplikasi, seperti autentikasi dan koordinasi antara model dan view.
### a). AuthService.java (class)
Mengatur proses login dan registrasi untuk pengguna maupun admin. File ini melakukan validasi akun dan menghubungkannya dengan database untuk memastikan data login benar.

##   b. Package database

<img width="265" height="50" alt="image" src="https://github.com/user-attachments/assets/439b74df-bf31-4279-b10a-b8045f78dcf9" />

Berfungsi untuk mengatur koneksi antara aplikasi dengan database.
### a). DatabaseConnection.java (class)
Bertugas membuat koneksi ke database MySQL. File ini menyimpan konfigurasi seperti URL database, username, dan password agar semua komponen program bisa melakukan query.

##   c. Package main

<img width="186" height="53" alt="image" src="https://github.com/user-attachments/assets/681243bd-6a7d-4757-8cd8-20a15d658e03" />

Menjadi titik awal (entry point) dari aplikasi ketika dijalankan.
### a). MainApp.java (class)
File utama yang menjalankan sistem. Kelas ini menampilkan menu utama dan mengarahkan pengguna ke halaman login atau registrasi sesuai peran masing-masing.

## d. Package model

<img width="236" height="251" alt="image" src="https://github.com/user-attachments/assets/20f52a1e-db1f-4d02-93ee-4bde90c8bebe" />

Berisi kumpulan kelas yang merepresentasikan data (entitas) dalam sistem.
Setiap file biasanya berhubungan langsung dengan tabel pada database.
### a).Admin.java (class)
Menyimpan data admin (pengelola anggaran dan pengelola pengaduan).
### b). Akun.java (class) 
Menyimpan data akun seperti username, password, dan peran pengguna.
### c). Anggaran.java (class) 
Mewakili data anggaran publik yang dikelola oleh admin.
### d). Instansi.java (class) 
Menyimpan informasi instansi publik yang terdaftar.
### e). Laporan.java (interface) 
Menyediakan kerangka dasar untuk pembuatan laporan dalam sistem.
### f). Pengaduan.java (class) 
Menampung data pengaduan atau keluhan masyarakat.
### g). Pengguna.java (class) 
Mewakili data pengguna publik yang dapat melakukan login, mengirim pengaduan, dan melihat data anggaran.
### h). Tanggapan.java (class) 
Menyimpan data tanggapan admin terhadap pengaduan pengguna.
### i). Validatable.java (interface) 
Digunakan untuk memastikan validasi data input agar sesuai format dan aturan tertentu.
### j). Wilayah.java (class) 
Mewakili data wilayah (provinsi, kabupaten, atau kota) terkait instansi publik.

## e. Package view
Berisi seluruh komponen tampilan (user interface) dari aplikasi, baik untuk pengguna umum maupun admin.
Tiap file Java di sini berfungsi menampilkan form atau menu tertentu.

### a). Tampilan Admin Pengelola Anggaran
1. AdminPengelolaAnggaran.java (class) – Menu utama admin pengelola anggaran.
2. AdminPengelolaAnggaran_melihat.java (class) – Menampilkan daftar data anggaran.
3. AdminPengelolaAnggaran_menambah.java (class) – Form untuk menambahkan data anggaran baru.
4. AdminPengelolaAnggaran_memperbarui.java (class) – Form untuk memperbarui data anggaran.
5. AdminPengelolaAnggaran_menghapus.java (class) – Form untuk menghapus data anggaran.

### b). Tampilan Admin Pengelola Pengaduan
1. AdminPengelolaPengaduan.java (class) – Menu utama admin pengelola pengaduan.
2. AdminPengelolaPengaduan_melihat.java (class) – Menampilkan daftar pengaduan masyarakat.
3. AdminPengelolaPengaduan_menambah.java (class) – Form untuk menambahkan data pengaduan baru.
4. AdminPengelolaPengaduan_memperbarui.java (class) – Form untuk memperbarui pengaduan.
5. AdminPengelolaPengaduan_menghapus.java (class) – Form untuk menghapus pengaduan.
6. AdminPengelolaPengaduan_pengaduan.java (class) – Menampilkan daftar pengaduan dan status tanggapannya.

### c). Tampilan Pengguna
1. MenuPengguna.java (class) – Menu utama pengguna setelah login.
2. Pengaduan_menambah.java (class) – Form untuk mengajukan pengaduan baru.
3. Pengaduan_pengadu.java (class) – Menampilkan daftar pengaduan milik pengguna.
4. Pengaduan_tabelPengaduan.java (class) – Menampilkan data pengaduan dalam bentuk tabel.
5. Pengaduan_tabelTanggapan.java (class) – Menampilkan tanggapan dari admin terhadap pengaduan.
6. Pengguna_dataAnggaran.java (class) – Menampilkan data anggaran publik yang dapat dilihat pengguna.

### d). Tampilan Umum (Menu Awal)
1. menuLogin.java (class) – Tampilan halaman login awal.
2. menuRegistrasi.java (class) – Tampilan halaman registrasi pengguna baru.
3. menuUtama.java (class) – Tampilan menu utama saat program dijalankan pertama kali.

### e). File Pendukung (Gambar)
File-file berikut digunakan sebagai elemen visual untuk mempercantik tampilan antarmuka:
1. GEDUNGBARU.png (gambar) – Gambar dekoratif di halaman utama.
2. gedung.png (gambar) – Ilustrasi gedung pada tampilan admin.
3. instansi.png (gambar) – Ikon instansi publik.
4. logo.png (gambar) – Logo utama aplikasi.
5. orang.png (gambar) – Ikon pengguna.
6. oranglagi.png (gambar) – Ikon tambahan untuk tampilan pengguna.
7. reqis.png (gambar) – Ikon yang digunakan di halaman registrasi.

# E. Tutorial Penggunaan Program
##   a. Pengguna
##   b. Admin Pengelola Data Anggaran
##   c. Admin Pengelola Tanggapan Pengaduan


