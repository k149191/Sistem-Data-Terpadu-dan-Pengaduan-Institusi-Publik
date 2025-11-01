<img width="317" height="179" alt="image" src="https://github.com/user-attachments/assets/82a9ff7e-fe54-4131-b68d-e98362f233db" /># Kelompok 2 | A3B
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
File utama yang menjalankan sistem. Kelas ini menampilkan menu utama.

## d. Package model

<img width="236" height="251" alt="image" src="https://github.com/user-attachments/assets/20f52a1e-db1f-4d02-93ee-4bde90c8bebe" />

Berisi kumpulan kelas yang merepresentasikan data (entitas) dalam sistem.
Setiap file biasanya berhubungan langsung dengan tabel pada database.
### a).Admin.java (class)
Menyimpan data admin (pengelola anggaran dan pengelola pengaduan). Dan terdapat data/atribut dari superclassnya yaitu akun dan atribut peran. Ini merupakan sub class dari akun.
### b). Akun.java (class) 
Menyimpan data akun seperti idAkun, nama, email, noHp, kataSandi. Ini merupakan super class.
### c). Anggaran.java (class) 
Mewakili data anggaran publik yang dikelola oleh admin. Seperti idAnggaran, namaAnggaran, totalAnggaran, realisasi, dan keterangan. 
### d). Instansi.java (class) 
Menyimpan informasi instansi publik yang terdaftar. Atribut-atributnya adalah idInstansi, nama, jenis, sektor, dan alamat
### e). Laporan.java (interface) 
Menyediakan kerangka dasar untuk pembuatan laporan dalam sistem. Terdapar method formatLaporan().
### f). Pengaduan.java (class) 
Menampung data pengaduan atau keluhan masyarakat. Atribut-atributnya adalah idPengaduan, idPengguna, idInstansi, judul, isi, dan tanggal.
### g). Pengguna.java (class) 
Mewakili data pengguna publik yang dapat mengirim pengaduan, dan melihat data anggaran. Dan terdapat data/atribut dari superclassnya yaitu akun dan atribut alamat. Ini merupakan sub class dari akun.
### h). Tanggapan.java (class) 
Menyimpan data tanggapan admin terhadap pengaduan pengguna. Atribut-atributnya adalah idTanggapan, idAdmin, idPengaduan, status, isi, tanggal.
### i). Validatable.java (interface) 
Digunakan untuk memastikan validasi data input agar sesuai format dan aturan tertentu. Terdapat method validate()
### j). Wilayah.java (class) 
Mewakili data wilayah (provinsi, kabupaten, atau kota) terkait instansi publik. Atribut-atributnya adalah idWilayah, nama, dan tingkat.

## e. Package view
Berisi seluruh komponen tampilan (user interface) dari aplikasi, baik untuk pengguna umum maupun admin.
Tiap file Java di sini berfungsi menampilkan form atau menu tertentu.

<img width="436" height="628" alt="image" src="https://github.com/user-attachments/assets/859286c5-1ffc-4f8b-8b6c-40753bd022ce" />

### a). Tampilan Admin Pengelola Anggaran
1. AdminPengelolaAnggaran.java (class): Menu utama/dashboard admin pengelola anggaran. 
2. AdminPengelolaAnggaran_melihat.java (class): Menampilkan daftar data anggaran.
3. AdminPengelolaAnggaran_menambah.java (class): Form untuk menambahkan data anggaran baru.
4. AdminPengelolaAnggaran_memperbarui.java (class): Form untuk memperbarui data anggaran.
5. AdminPengelolaAnggaran_menghapus.java (class) – Form untuk menghapus data anggaran.

### b). Tampilan Admin Pengelola Pengaduan
1. AdminPengelolaPengaduan.java (class): Menu utama/dashboard admin pengelola tanggapan pengaduan.
2. AdminPengelolaPengaduan_melihat.java (class): Menampilkan daftar tanggapan pengaduan.
3. AdminPengelolaPengaduan_menambah.java (class): Form untuk menambahkan data pengaduan baru.
4. AdminPengelolaPengaduan_memperbarui.java (class) – Form untuk memperbarui tanggapan.
5. AdminPengelolaPengaduan_menghapus.java (class) – Form untuk menghapus tanggapan.
6. AdminPengelolaPengaduan_pengaduan.java (class) – Menampilkan daftar pengaduan masyarakat.

### c). Tampilan Pengguna
1. MenuPengguna.java (class) – Menu utama pengguna setelah login.
2. Pengaduan_menambah.java (class) – Form untuk mengajukan pengaduan baru.
3. Pengaduan_pengadu.java (class) – Menu utama/dashboard pengguna pengaduan.
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
2. gedung.png (gambar) – Ilustrasi gedung.
3. instansi.png (gambar) – Ikon instansi publik.
4. logo.png (gambar) – Logo utama aplikasi.
5. orang.png (gambar) – Ikon pengguna.
6. oranglagi.png (gambar) – Ikon tambahan untuk tampilan pengguna.
7. reqis.png (gambar) – Ikon yang digunakan di halaman registrasi.

# E. Tutorial Penggunaan Program
##   a. Pengguna
Langkah-langkah penggunaan program bagi pengguna umum adalah sebagai berikut:

### a). Buka Program
Jalankan aplikasi Sistem Data Terpadu dan Pengaduan Institusi Publik.

<img width="896" height="500" alt="image" src="https://github.com/user-attachments/assets/07c43bf1-78a9-4ba8-b768-4e12906f7b88" />

Nantinya akan tertampil menu utama, pada menu utama terdapat dua pilihan yaitu registrasi (jika belum memilki akun) dan login.

### b). Registrasi Akun Baru (Jika Belum Memiliki Akun)
Klik tombol **“Registrasi”** pada halaman utama. Dan akan tertampil seperti dibawah, kita akan diminta untuk mengisi beberapa data. Dan juga terdapat button **X** untuk keluar dari menu registrasi dan kembali ke menu utama jika tidak jadi untuk melakukan registrasi.

<img width="901" height="530" alt="image" src="https://github.com/user-attachments/assets/85b7a3ff-0fcd-48f5-adbc-5c3abc42dc6e" />

Isi data seperti **NIK, nama lengkap, email, No Hp, kata sandi dan alamat.**

<img width="903" height="536" alt="image" src="https://github.com/user-attachments/assets/7a2c56ac-c8e3-405a-8158-5b531df49a59" />

Klik **“Registrasi”** untuk menyimpan akun ke dalam sistem. Jika berhasil registrasi akan tertampil pesan **"Registrasi Berhasil!"**. Dan bisa klik **OK** untuk kembali ke menu utama.

<img width="322" height="179" alt="image" src="https://github.com/user-attachments/assets/98f317fc-d5a0-4e45-87da-81edf4484318" />

Jika terjadi kesalahan dalam memasukan data, akan tertampil pesan pada bagian yang salah. Seperti:
1. Jika NIK tidak sesuai
   
<img width="315" height="183" alt="image" src="https://github.com/user-attachments/assets/7992e0e9-10ea-485a-aaac-c4534e174700" />

2. Jika NIK sudah terdaftar

<img width="321" height="180" alt="image" src="https://github.com/user-attachments/assets/c3b89f08-1358-4cdd-af59-acf7dc49d8c2" />

3. Jika email tidak sesuai

<img width="321" height="180" alt="image" src="https://github.com/user-attachments/assets/e5017999-8a62-43fe-b75e-f84ed79c60e8" />

4. Jika email sudah terdaftar

<img width="323" height="180" alt="image" src="https://github.com/user-attachments/assets/633edda6-e1d8-48e2-bbb1-c56cc199bba7" />
   
5. Jika NO HP tidak sesuai

<img width="321" height="178" alt="image" src="https://github.com/user-attachments/assets/c957bd3d-618e-4786-b29c-0bfc44167ab7" />

6. Jika kata sandi tidak sesuai

<img width="325" height="180" alt="image" src="https://github.com/user-attachments/assets/ba0ecc59-80d3-4f07-bec0-cc7addafa4f3" />

7. Jika terdapat field/kolom yang kosong

<img width="320" height="180" alt="image" src="https://github.com/user-attachments/assets/7b477b30-40ab-4068-a17c-d6dda7279f98" />

### c). Login ke Sistem
Klik tombol **“Login”** pada halaman utama. Dan akan tertampil seperti dibawah, kita akan diminta untuk mengisi email dan kata sandi untuk login. Dan juga terdapat button **X** untuk keluar dari menu login dan kembali ke menu utama jika tidak jadi untuk melakukan login.

<img width="902" height="520" alt="image" src="https://github.com/user-attachments/assets/b50a94b4-4bcb-4a89-b152-3740f9294ad0" />

Masukkan **email dan password** yang sudah terdaftar.

<img width="908" height="533" alt="image" src="https://github.com/user-attachments/assets/9438d87c-4c61-4ec9-a528-f447da609cd8" />

Klik tombol **“Login”** untuk masuk ke menu pengguna. Dan jika berhasil login sebagi pengguna akan langsung masuk ke menu pengguna.

<img width="909" height="495" alt="image" src="https://github.com/user-attachments/assets/f336b709-b437-4ea0-b085-8badba307490" />

Jika terjadi kesalahan dalam memasukan data, akan tertampil pesan seperti:

<img width="320" height="185" alt="image" src="https://github.com/user-attachments/assets/0646730e-6ebe-44d4-9098-a47f8dfab600" />


### d). Menu Data Anggaran = Melihat Data Publik Anggaran
Pada menu pengguna, pilih menu **“Data Anggaran”**. 

<img width="909" height="498" alt="image" src="https://github.com/user-attachments/assets/512ac796-3691-455f-bff6-64ffad4eb315" />

Sistem akan menampilkan daftar anggaran publik yang telah dikelola oleh admin. Terdapat button **X** untuk keluar dari menu data anggaran dan akan kembali ke menu pengguna.

### e). Menu Pengaduan

Pada menu pengguna, pilih menu **“Pengaduan”**. Terdapat button **X** untuk keluar dari menu data anggaran dan akan kembali ke menu pengguna. Dan pada menu pengaduan terdapat side bar yang terdapat **dashboard, tambah pengaduan, lihat tabel pengaduan, dan lihat tabel tanggapaan.** 

<img width="929" height="520" alt="image" src="https://github.com/user-attachments/assets/5189a4c5-4f16-4493-966f-c40fa9abde57" />


1. Dashboard

Saat masuk ke menu pengaduan, halaman yang pertama kali terbuka adalah **dashboard**. Pada dashboard terdapat deskripsi atau penjelasan mengenai sistem seperti tujuan dan juga deskripsi halaman pengaduan.

<img width="933" height="523" alt="image" src="https://github.com/user-attachments/assets/56060552-9551-445a-ba13-a1577358d47b" />

2. Tambah Pengaduan

Pada menu **“Pengaduan”**, klik **“Tambah Pengaduan”.**

<img width="1033" height="684" alt="image" src="https://github.com/user-attachments/assets/2c6b5734-ffd8-4da8-ab6e-4dea193a8dc2" />

Isi kolom seperti **Judul Pengaduan, Isi Aduan, Tanggal, dan Nama Instansi.**

<img width="1040" height="686" alt="image" src="https://github.com/user-attachments/assets/69a6d21f-ceb0-488a-a64b-fd9b64b4a9a1" />

Klik **“Tambah”** untuk mengajukan laporan. Jika pengaduan berhasil ditambahkan akan tertampil pesan **"Pengaduan Berhasil dikirim!"**.

<img width="331" height="178" alt="image" src="https://github.com/user-attachments/assets/bdadf87c-48da-40ed-a111-d450d8aca3f3" />

Jika terjadi kesalahan dalam memasukan data, akan tertampil pesan seperti:

<img width="400" height="180" alt="image" src="https://github.com/user-attachments/assets/e2a92cc1-4308-4877-8af0-acbc4272bf25" />

3. Lihat Tabel Pengaduan

Pilih menu **“Lihat Tabel Pengaduan”** untuk melihat tabel pengaduan yang telah kita tambahkan di sistem.

<img width="917" height="526" alt="image" src="https://github.com/user-attachments/assets/4e3cb8b8-6647-4d6d-a00f-8df7a979d105" />

4. Lihat Tabel Tanggapan

Pilih menu **“Lihat Tabel Tanggapan”** untuk melihat tabel tanggapan jika admin sudah menanggapi, pengguna dapat melihat balasan atau tindak lanjut dari pengaduan tersebut.

<img width="938" height="499" alt="image" src="https://github.com/user-attachments/assets/e6536a76-1bbb-47fe-93db-33e6564b770d" />

### f). Keluar dari Menu Pengguna

Setelah selesai, klik tombol **“X”** pada menu pengguna untuk keluar dengan aman dari menu pengguna. Jika mengklik tombol X akan tertampil pesan seperti digambar, klik **Yes** jika ingin keluar dan klik **No** jika masih ingin di menu pengguna. Jika mengklik Yes pengguna akan kembali ke menu utama.

<img width="428" height="176" alt="image" src="https://github.com/user-attachments/assets/1c98e9f4-e810-4a36-8601-2338038b36c6" />

### g). Keluar dari sistem/aplikasi
Setelah keluar dari menu pengguna, pengguna akan kembali ke menu utama.

<img width="902" height="491" alt="image" src="https://github.com/user-attachments/assets/c3606319-444d-425b-9ce4-35ac4571ae2c" />

klik tombol **“X”** pada menu utama untuk keluar dengan aman dari menu utama. Jika mengklik tombol X akan tertampil pesan seperti digambar, klik **Yes** jika ingin keluar dan klik **No** jika masih ingin mengakses sistem. Jika mengklik Yes pengguna akan keluar dari sistem.

<img width="398" height="180" alt="image" src="https://github.com/user-attachments/assets/94d56e13-9b08-44b6-96fd-065d7fb23bef" />


##   b. Admin Pengelola Data Anggaran

Langkah-langkah penggunaan bagi admin yang mengelola data anggaran adalah sebagai berikut:

### a). Buka Program
Jalankan aplikasi Sistem Data Terpadu dan Pengaduan Institusi Publik.

<img width="896" height="500" alt="image" src="https://github.com/user-attachments/assets/07c43bf1-78a9-4ba8-b768-4e12906f7b88" />

Nantinya akan tertampil menu utama, pada menu utama terdapat dua pilihan yaitu registrasi (admin tidak bisa membuat akun sendiri) dan login.

### b). Login sebagai Admin Pengelola Anggaran

Klik tombol **“Login”** pada halaman utama. Dan akan tertampil seperti dibawah, kita akan diminta untuk mengisi email dan kata sandi untuk login. Dan juga terdapat button **X** untuk keluar dari menu login dan kembali ke menu utama jika tidak jadi untuk melakukan login.

<img width="902" height="520" alt="image" src="https://github.com/user-attachments/assets/b50a94b4-4bcb-4a89-b152-3740f9294ad0" />

Masukkan **email dan password** yang sudah terdaftar.

<img width="909" height="528" alt="image" src="https://github.com/user-attachments/assets/52eb2589-5efa-4bbf-80c0-a165cd00d60d" />

Klik tombol **“Login”** untuk masuk ke menu admin pengelola anggaran. Dan jika berhasil login sebagi pengguna akan langsung masuk ke menu admin pengelola anggara.

<img width="891" height="536" alt="image" src="https://github.com/user-attachments/assets/0bf445c6-0648-47ce-b4f6-bba9ac7d27c9" />

Jika terjadi kesalahan dalam memasukan data, akan tertampil pesan seperti:

<img width="320" height="185" alt="image" src="https://github.com/user-attachments/assets/0646730e-6ebe-44d4-9098-a47f8dfab600" />

### c). Menu Admin - Pengelola Data Anggaran

Pada menu admin pengelola anggaran, terdapat button **X** untuk keluar dari menu admin pengelola anggaran dan akan kembali ke menu utama. Dan pada menu admin pengelola anggaran terdapat side bar yang terdapat **dashboard, menambah data, melihat data, memperbarui data, dan menghapus data.** 

<img width="888" height="534" alt="image" src="https://github.com/user-attachments/assets/7a48c7b5-9360-4162-aca3-fc9cf72a0015" />

1. Dashboard

Saat masuk ke menu admin pengelola anggaran, halaman yang pertama kali terbuka adalah **dashboard**. Pada dashboard terdapat deskripsi halaman admin pengelola anggaran dan hal-hal yang bisa dilakukan oleh admin.

<img width="888" height="534" alt="image" src="https://github.com/user-attachments/assets/7a48c7b5-9360-4162-aca3-fc9cf72a0015" />

2. Menambah data
   
Pada menu **“admin pengelola anggaran”**, klik **“Menambah data”.**

<img width="884" height="519" alt="image" src="https://github.com/user-attachments/assets/f721f915-003a-46ca-a976-a243023351b4" />

Isi kolom seperti **Nama Instansi, Tahun, Nama Program, Total Anggaran, Realisasi, dan Keterangan.**

<img width="882" height="518" alt="image" src="https://github.com/user-attachments/assets/94805709-a816-40bb-ba14-5bfddce664e9" />

Klik **“Tambah”** untuk menambahkan data anggaran. Jika data berhasil ditambahkan akan tertampil pesan **"Data anggaran Berhasil ditambahkan!"**.

<img width="358" height="180" alt="image" src="https://github.com/user-attachments/assets/c32d144b-4679-40fc-92ca-f7f730c7faf4" />

Jika terjadi kesalahan dalam memasukan data, akan tertampil pesan seperti:
- Jika instansi belum dipilih
<img width="344" height="181" alt="image" src="https://github.com/user-attachments/assets/af88643f-cd81-4279-81db-c27d43972c45" />
- Jika terdapat field/kolom yang belum diisi
<img width="316" height="184" alt="image" src="https://github.com/user-attachments/assets/8e6495bf-c022-42ed-a2c7-acf7f7a995f3" />

3. Melihat data

Pilih menu **“Melihat data”** untuk melihat tabel data anggaran yang telah kita tambahkan di sistem.

<img width="900" height="524" alt="image" src="https://github.com/user-attachments/assets/651c6842-4361-4300-86c4-7602d802f837" />

4. Memperbarui data

Pilih menu **“Memperbarui data”** untuk memperbarui data anggaran yang kemungkinan ada salah input. Pertama, admin akan diminta untuk memilih **id anggaran** yang ingin diperbarui. Setelah memilih id anggaran, data anggaran dari id akan muncul dan dapat kita perbarui datanya

<img width="894" height="541" alt="image" src="https://github.com/user-attachments/assets/58957e62-c47d-4f67-9e79-024c13f6560f" />

Misalnya admin ingin memperbarui realisasi pada data anggaran ini yang awalnya 180000000 menjadi 190000000.

<img width="901" height="542" alt="image" src="https://github.com/user-attachments/assets/54ea4965-b666-4eec-9156-f3e8cc436645" />

Jika data anggaran berhasil di perbarui akan muncul pesan seperti **"Data anggaran berhasil diperbarui!"**. Dan klik **OK** untuk menyelesaikan pembaruan data.

<img width="332" height="182" alt="image" src="https://github.com/user-attachments/assets/d21778c0-6ffd-4a92-b091-d27c7821e74f" />

4. Menghapus data

Pilih menu **“Menghapus data”** untuk menghapus data anggaran. Pertama, admin akan diminta untuk memilih **id anggaran** yang ingin dihapus. Setelah memilih id anggaran, data anggaran dari id akan muncul dan admin bisa melihat data-data dari data anggaran. 

<img width="930" height="538" alt="image" src="https://github.com/user-attachments/assets/fba0bef0-7246-466d-a417-0a2736f2df9d" />

Misalnya admin ingin menghapus data anggaran dengan ID ANG048, akan muncul data anggaran tersebut. 

<img width="925" height="532" alt="image" src="https://github.com/user-attachments/assets/d6a2ee14-ae89-4e78-bb18-e229f05e0bf1" />

Klik **"Hapus"** untuk mengapus data anggaran. Jika mengklik hapus, akan keluar pesan konfirmasi, apakah **"Yakin hapus data ID: (ID yang ingin dihapus)?"**. Jika pilih Yes maka data anggaran akan terhapus dan jika pilih No maka data anggaran tidak akan terhapus.

<img width="317" height="179" alt="image" src="https://github.com/user-attachments/assets/8ec0243d-584b-4139-828d-cc465270ae51" />

Jika data anggaran berhasil di hapus akan muncul pesan seperti **"Data anggaran berhasil dihapus!"**. Dan klik **OK** untuk menyelesaikan penghapusan data.

<img width="319" height="182" alt="image" src="https://github.com/user-attachments/assets/f4c31582-096e-480d-8358-1b40560344e7" />

### d). Keluar dari menu Admin - Pengelola Data Anggaran

Setelah selesai, klik tombol **“X”** pada menu admin pengelola anggaran untuk keluar dengan aman dari menu admin pengelola anggaran. Jika mengklik tombol X akan tertampil pesan seperti digambar, klik **Yes** jika ingin keluar dan klik **No** jika masih ingin di menu admin pengelola anggaran. Jika mengklik Yes admin pengelola anggaran akan kembali ke menu utama.

<img width="431" height="180" alt="image" src="https://github.com/user-attachments/assets/fed7aaa1-76b0-4c5e-8078-55f1c68c7b03" />

### d). Keluar dari sistem/aplikasi
Setelah keluar dari menu admin pengelola anggaran, admin pengelola anggaran akan kembali ke menu utama.

<img width="902" height="491" alt="image" src="https://github.com/user-attachments/assets/c3606319-444d-425b-9ce4-35ac4571ae2c" />

klik tombol **“X”** pada menu utama untuk keluar dengan aman dari menu utama. Jika mengklik tombol X akan tertampil pesan seperti digambar, klik **Yes** jika ingin keluar dan klik **No** jika masih ingin mengakses sistem. Jika mengklik Yes pengguna akan keluar dari sistem.

<img width="398" height="180" alt="image" src="https://github.com/user-attachments/assets/94d56e13-9b08-44b6-96fd-065d7fb23bef" />

##   c. Admin Pengelola Tanggapan Pengaduan
