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
##   a. Model
##   b. Controller
##   c. View

# E. Tutorial Penggunaan Program
##   a. Pengguna
##   b. Admin Pengelola Data Anggaran
##   c. Admin Pengelola Tanggapan Pengaduan


