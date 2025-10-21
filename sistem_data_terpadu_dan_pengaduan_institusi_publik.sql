-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2025 at 08:30 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_data_terpadu_dan_pengaduan_institusi_publik`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_akun` varchar(16) NOT NULL,
  `peran` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_akun`, `peran`) VALUES
('3171051168101000', 'Pengelola Pengaduan'),
('3171110288102000', 'Pengelola Anggaran'),
('3171160368100000', 'Pengelola Pengaduan'),
('3171280999103000', 'Pengelola Anggaran'),
('3201040488103100', 'Pengelola Anggaran'),
('3201181181100100', 'Pengelola Pengaduan'),
('3201181265101100', 'Pengelola Pengaduan'),
('3201260486102100', 'Pengelola Anggaran'),
('3301011269101200', 'Pengelola Pengaduan'),
('3301011286103200', 'Pengelola Anggaran'),
('3301141097102200', 'Pengelola Anggaran'),
('3301250479100200', 'Pengelola Pengaduan'),
('5101061191100300', 'Pengelola Pengaduan'),
('5101070871101300', 'Pengelola Pengaduan'),
('5101180782102300', 'Pengelola Anggaran'),
('5101240363103300', 'Pengelola Anggaran'),
('5102040664102400', 'Pengelola Anggaran'),
('5102091196101400', 'Pengelola Pengaduan'),
('5102130999100400', 'Pengelola Pengaduan'),
('5102190674103400', 'Pengelola Anggaran'),
('5201041168103800', 'Pengelola Anggaran'),
('5201090780102800', 'Pengelola Anggaran'),
('5201180375100800', 'Pengelola Pengaduan'),
('5201281263101800', 'Pengelola Pengaduan'),
('6101041186101900', 'Pengelola Pengaduan'),
('6101061093102900', 'Pengelola Anggaran'),
('6101110493100900', 'Pengelola Pengaduan'),
('6101260286103900', 'Pengelola Anggaran'),
('6408010483101500', 'Pengelola Pengaduan'),
('6408040172100500', 'Pengelola Pengaduan'),
('6408080491103500', 'Pengelola Anggaran'),
('6408100171102500', 'Pengelola Anggaran'),
('7101020467100600', 'Pengelola Pengaduan'),
('7101040778102600', 'Pengelola Anggaran'),
('7101160775103600', 'Pengelola Anggaran'),
('7101180597101600', 'Pengelola Pengaduan'),
('7102070188101700', 'Pengelola Pengaduan'),
('7102090887103700', 'Pengelola Anggaran'),
('7102131176102700', 'Pengelola Anggaran'),
('7102141184100700', 'Pengelola Pengaduan');

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id_akun` varchar(16) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `kata_sandi` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id_akun`, `nama`, `email`, `no_hp`, `kata_sandi`) VALUES
('3171050288107000', 'Gita', 'gita.lestari@example.com', '08377844771', 'user123'),
('3171051168101000', 'Agus Santoso', 'agus.santoso@instansi.go.id', '08844330626', 'admin123'),
('3171100673104000', 'Anwar Setiawan', 'anwar.setiawan@example.com', '08546541290', 'user123'),
('3171110288102000', 'Citra Dewanti', 'citra.dewanti@instansi.go.id', '08724430983', 'admin123'),
('3171120269106000', 'Winda Safitri', 'winda.safitri@example.com', '08684633799', 'user123'),
('3171160368100000', 'Elmy Fadillah', 'elmy.fadillah@instansi.go.id', '08871030355', 'admin123'),
('3171240161105000', 'Mila Sari', 'mila.sari@example.com', '08334484706', 'user123'),
('3171280999103000', 'Tania Putri', 'tania.putri@instansi.go.id', '08519332977', 'admin123'),
('3201040488103100', 'Heri Kurniawan', 'heri.kurniawan@instansi.go.id', '08841308894', 'admin123'),
('3201150497104100', 'Nisa Amelia', 'nisa.amelia@example.com', '08181367188', 'user123'),
('3201161076107100', 'Haryo Pratama', 'haryo.pratama@example.com', '08368397096', 'user123'),
('3201181181100100', 'Dita Rahmawati', 'dita.rahmawati@instansi.go.id', '08248327339', 'admin123'),
('3201181265101100', 'Siti Aminah', 'siti.aminah@instansi.go.id', '08851904089', 'admin123'),
('3201190772105100', 'Nadia Ilham', 'nadia.ilham@example.com', '08155830335', 'user123'),
('3201250693106100', 'Xavier Gunawan', 'xavier.gunawan@example.com', '08486666813', 'user123'),
('3201260486102100', 'Hafidz Nur', 'hafidz.nur@instansi.go.id', '08464114044', 'admin123'),
('3301011269101200', 'Tony Prasetyo', 'tony.prasetyo@instansi.go.id', '08854330825', 'admin123'),
('3301011286103200', 'Siska Nuraini', 'siska.nuraini@instansi.go.id', '08196634480', 'admin123'),
('3301070176104200', 'Bimo Santoso', 'bimo.santoso@example.com', '08785421917', 'user123'),
('3301110379107200', 'Ika Nuraini', 'ika.nuraini@example.com', '08622404823', 'user123'),
('3301140672106200', 'Yuniarti Dewi', 'yuniarti.dewi@example.com', '08417645257', 'user123'),
('3301141097102200', 'Syifa Hasanah', 'syifa.hasanah@instansi.go.id', '08271905222', 'admin123'),
('3301240287105200', 'Oki Saputra', 'oki.saputra@example.com', '08723055571', 'user123'),
('3301250479100200', 'Ahmad Fauzan', 'ahmad.fauzan@instansi.go.id', '08484412259', 'admin123'),
('5101040689107300', 'Jamaludin', 'jamaludin@example.com', '08308312930', 'user123'),
('5101061191100300', 'Budi Santoso', 'budi.santoso@instansi.go.id', '08830655536', 'admin123'),
('5101070871101300', 'Maya Kusuma', 'maya.kusuma@instansi.go.id', '08343358996', 'admin123'),
('5101161194104300', 'Eka Putri', 'eka.putri@example.com', '08298239548', 'user123'),
('5101180782102300', 'Rama Dwi', 'rama.dwi@instansi.go.id', '08411863135', 'admin123'),
('5101220198106300', 'Zaki Ramadhan', 'zaki.ramadhan@example.com', '08658745067', 'user123'),
('5101221178105300', 'Putra Bayu', 'putra.bayu@example.com', '08729779134', 'user123'),
('5101240363103300', 'Reza Pratama', 'reza.pratama@instansi.go.id', '08850909803', 'admin123'),
('5102040664102400', 'Putri Amelia', 'putri.amelia@instansi.go.id', '08938511665', 'admin123'),
('5102070784104400', 'Gilang Pratama', 'gilang.pratama@example.com', '08496041908', 'user123'),
('5102091196101400', 'Rudi Hartono', 'rudi.hartono@instansi.go.id', '08447221716', 'admin123'),
('5102130999100400', 'Rina Kartika', 'rina.kartika@instansi.go.id', '08783635007', 'admin123'),
('5102141098105400', 'Qoriatul Aisyah', 'qoriatul.aisyah@example.com', '08857330425', 'user123'),
('5102151291107400', 'Kevin Adrian', 'kevin.adrian@example.com', '08905960494', 'user123'),
('5102170968106400', 'Arifin Setya', 'arifin.setya@example.com', '08990419110', 'user123'),
('5102190674103400', 'Rini Anggraini', 'rini.anggraini@instansi.go.id', '08684371011', 'admin123'),
('5201021068106800', 'Erwin Saputra', 'erwin.saputra@example.com', '08773963980', 'user123'),
('5201041168103800', 'Rafa Ananda', 'rafa.ananda@instansi.go.id', '08556803589', 'admin123'),
('5201090780102800', 'Aulia Fitri', 'aulia.fitri@instansi.go.id', '08169408312', 'admin123'),
('5201160262107800', 'Ocha Amelia', 'ocha.amelia@example.com', '08535465539', 'user123'),
('5201160284105800', 'Usman Effendi', 'usman.effendi@example.com', '08528548670', 'user123'),
('5201180375100800', 'Indah Wulandari', 'indah.wulandari@instansi.go.id', '08691343912', 'admin123'),
('5201261283104800', 'Kiki Amelia', 'kiki.amelia@example.com', '08527120393', 'user123'),
('5201281263101800', 'Mega Ayu', 'mega.ayu@instansi.go.id', '08390013014', 'admin123'),
('6101041186101900', 'Doni Saputra', 'doni.saputra@instansi.go.id', '08954795346', 'admin123'),
('6101050799107900', 'Pandu Wijaya', 'pandu.wijaya@example.com', '08317070325', 'user123'),
('6101061093102900', 'Rizky Ramadhan', 'rizky.ramadhan@instansi.go.id', '08548924376', 'admin123'),
('6101100476105900', 'Vina Cahya', 'vina.cahya@example.com', '08402769465', 'user123'),
('6101110493100900', 'Sari Puspita', 'sari.puspita@instansi.go.id', '08467487830', 'admin123'),
('6101220685106900', 'Fadil Hidayat', 'fadil.hidayat@example.com', '08307748059', 'user123'),
('6101260286103900', 'Dea Maharani', 'dea.maharani@instansi.go.id', '08858289087', 'admin123'),
('6101280560104900', 'Lukman Hakim', 'lukman.hakim@example.com', '08489524356', 'user123'),
('6408010483101500', 'Lina Marlina', 'lina.marlina@instansi.go.id', '08425885500', 'admin123'),
('6408040172100500', 'Hendra Wijaya', 'hendra.wijaya@instansi.go.id', '08288332371', 'admin123'),
('6408080491103500', 'Dimas Fadli', 'dimas.fadli@instansi.go.id', '08811131557', 'admin123'),
('6408100171102500', 'Andi Saputra', 'andi.saputra@instansi.go.id', '08748341044', 'admin123'),
('6408110274106500', 'Bella Anggraini', 'bella.anggraini@example.com', '08779143763', 'user123'),
('6408191262107500', 'Lukas Pratama', 'lukas.pratama@example.com', '08559729446', 'user123'),
('6408201264105500', 'Ratna Sari', 'ratna.sari@example.com', '08992345748', 'user123'),
('6408280274104500', 'Hesti Wulandari', 'hesti.wulandari@example.com', '08176493263', 'user123'),
('7101020467100600', 'Dewi Lestari', 'dewi.lestari@instansi.go.id', '08896877527', 'admin123'),
('7101040778102600', 'Laila Ningsih', 'laila.ningsih@instansi.go.id', '08978031712', 'admin123'),
('7101050599106600', 'Cahya Putri', 'cahya.putri@example.com', '08434850796', 'user123'),
('7101160775103600', 'Farah Lestari', 'farah.lestari@instansi.go.id', '08959992832', 'admin123'),
('7101180194107600', 'Mei Lestari', 'mei.lestari@example.com', '08822825564', 'user123'),
('7101180597101600', 'Wahyu Pratama', 'wahyu.pratama@instansi.go.id', '08201736789', 'admin123'),
('7101240477104600', 'Ilham Karim', 'ilham.karim@example.com', '08593473847', 'user123'),
('7101251296105600', 'Sandy Saputra', 'sandy.saputra@example.com', '08604369890', 'user123'),
('7102020995106700', 'Dian Novita', 'dian.novita@example.com', '08882426856', 'user123'),
('7102070188101700', 'Fajar Setiawan', 'fajar.setiawan@instansi.go.id', '08692653923', 'admin123'),
('7102090887103700', 'Bagus Hidayat', 'bagus.hidayat@instansi.go.id', '08296410631', 'admin123'),
('7102131176102700', 'Yusuf Rahman', 'yusuf.rahman@instansi.go.id', '08824851853', 'admin123'),
('7102141184100700', 'Teguh Prasetyo', 'teguh.prasetyo@instansi.go.id', '08320020858', 'admin123'),
('7102160293105700', 'Tri Wulandari', 'tri.wulandari@example.com', '08227658615', 'user123'),
('7102180681107700', 'Nando Prasetyo', 'nando.prasetyo@example.com', '08865867888', 'user123'),
('7102220693104700', 'Joko Widodo', 'joko.widodo@example.com', '08346956981', 'user123');

-- --------------------------------------------------------

--
-- Table structure for table `anggaran`
--

CREATE TABLE `anggaran` (
  `id_anggaran` varchar(6) NOT NULL,
  `tahun` int(11) NOT NULL,
  `nama_program` varchar(150) NOT NULL,
  `total_anggaran` decimal(15,2) NOT NULL,
  `realisasi` decimal(15,2) NOT NULL,
  `keterangan` text NOT NULL,
  `id_instansi` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `anggaran`
--

INSERT INTO `anggaran` (`id_anggaran`, `tahun`, `nama_program`, `total_anggaran`, `realisasi`, `keterangan`, `id_instansi`) VALUES
('A001', 2025, 'Program Peningkatan Fasilitas RSUD Abdul Wahab Sjahranie', 150000000000.00, 140000000000.00, 'Perluasan ruang IGD dan pengadaan alat medis', 'I001'),
('A002', 2025, 'Program Peningkatan Mutu Pendidikan Kota Bandung', 90000000000.00, 88000000000.00, 'Renovasi ruang kelas dan pelatihan guru', 'I012'),
('A003', 2025, 'Program Penanggulangan Gizi Buruk Kota Makassar', 60000000000.00, 55000000000.00, 'Distribusi makanan tambahan anak', 'I023'),
('A004', 2025, 'Program Pemberdayaan Dinas Sosial Kota Balikpapan', 25000000000.00, 24000000000.00, 'Pelatihan dan bantuan sosial masyarakat', 'I021'),
('A005', 2025, 'Program Digitalisasi Sekolah SMA 1 Balikpapan', 12000000000.00, 11800000000.00, 'Pengadaan komputer dan jaringan internet', 'I009'),
('A006', 2025, 'Program Pengembangan Perguruan Tinggi (Unmul)', 75000000000.00, 74000000000.00, 'Peningkatan laboratorium dan riset', 'I008'),
('A007', 2025, 'Program Infrastruktur Dinas PU Samarinda', 90000000000.00, 89000000000.00, 'Peningkatan jalan lingkungan dan drainase', 'I039'),
('A008', 2025, 'Program Kesehatan Masyarakat Kota Yogyakarta', 50000000000.00, 49000000000.00, 'Peningkatan puskesmas dan pelayanan publik', 'I033'),
('A009', 2025, 'Program Koperasi & UMKM Bandung', 15000000000.00, 14000000000.00, 'Modal usaha untuk UMKM daerah', 'I022'),
('A010', 2025, 'Program Pendidikan Tinggi Universitas Hasanuddin', 80000000000.00, 78000000000.00, 'Peningkatan riset dan kerjasama industri', 'I031'),
('A011', 2025, 'Program Transportasi Ramah Lingkungan Denpasar', 45000000000.00, 42000000000.00, 'Pengadaan bus listrik', 'I028'),
('A012', 2025, 'Program Sosial Provinsi Kalimantan Timur', 20000000000.00, 19500000000.00, 'Bantuan warga terdampak banjir', 'I026'),
('A013', 2025, 'Program Kesehatan Kota Surabaya', 100000000000.00, 95000000000.00, 'Renovasi ruang operasi RSUD Surabaya', 'I015'),
('A014', 2025, 'Program Pendidikan Dasar SMP 10 Denpasar', 10000000000.00, 9500000000.00, 'Renovasi laboratorium IPA', 'I016'),
('A015', 2025, 'Program Ekonomi Kreatif Kota Semarang', 25000000000.00, 24000000000.00, 'Dukungan UMKM dan industri lokal', 'I029'),
('A016', 2025, 'Program Pariwisata Kota Palembang', 30000000000.00, 28000000000.00, 'Promosi wisata daerah', 'I030'),
('A017', 2025, 'Program Penataan Lingkungan Surabaya', 35000000000.00, 34000000000.00, 'Peningkatan taman kota dan kebersihan', 'I037'),
('A018', 2025, 'Program Kearsipan dan Digitalisasi Samarinda', 12000000000.00, 11500000000.00, 'Pengelolaan arsip elektronik daerah', 'I039'),
('A019', 2025, 'Program Perikanan Makassar', 40000000000.00, 38000000000.00, 'Bantuan nelayan lokal dan tambak ikan', 'I032'),
('A020', 2025, 'Program Pendidikan SMA 3 Samarinda', 10000000000.00, 9500000000.00, 'Pengadaan alat laboratorium', 'I020'),
('A021', 2025, 'Program Sosial Balikpapan', 18000000000.00, 17500000000.00, 'Rehabilitasi rumah tidak layak huni', 'I021'),
('A022', 2025, 'Program Pendidikan SMK 2 Surabaya', 15000000000.00, 14500000000.00, 'Revitalisasi gedung sekolah', 'I020'),
('A023', 2025, 'Program Pendidikan Universitas Udayana', 85000000000.00, 82000000000.00, 'Riset dan kolaborasi internasional', 'I019'),
('A024', 2025, 'Program Kesehatan Kota Bandung', 95000000000.00, 92000000000.00, 'Peningkatan RSUD Bandung', 'I011'),
('A025', 2025, 'Program Infrastruktur Samarinda', 80000000000.00, 79000000000.00, 'Pemeliharaan jalan utama kota', 'I039'),
('A026', 2025, 'Program Pendidikan Bandung', 88000000000.00, 86000000000.00, 'Pelatihan guru dan kurikulum digital', 'I012'),
('A027', 2025, 'Program Sosial Samarinda', 20000000000.00, 19000000000.00, 'Bantuan lansia dan anak yatim', 'I026'),
('A028', 2025, 'Program Lingkungan Bandung', 23000000000.00, 22500000000.00, 'Penghijauan taman kota', 'I036'),
('A029', 2025, 'Program Pendidikan Denpasar', 90000000000.00, 89000000000.00, 'Infrastruktur sekolah dasar', 'I037'),
('A030', 2025, 'Program Kesehatan Banjarmasin', 75000000000.00, 74000000000.00, 'Peningkatan layanan RSUD Banjarmasin', 'I029'),
('A031', 2025, 'Program Ekonomi Bekasi', 15000000000.00, 14000000000.00, 'Pemberdayaan usaha mikro', 'I033'),
('A032', 2025, 'Program Sosial Yogyakarta', 18000000000.00, 17000000000.00, 'Bantuan masyarakat miskin', 'I034'),
('A033', 2025, 'Program Infrastruktur Bandung', 90000000000.00, 88000000000.00, 'Pembangunan jembatan layang', 'I036'),
('A034', 2025, 'Program Kesehatan Denpasar', 95000000000.00, 94000000000.00, 'Pengadaan ambulans & alat medis', 'I006'),
('A035', 2025, 'Program Pendidikan Makassar', 87000000000.00, 86000000000.00, 'Sekolah digital kota Makassar', 'I024'),
('A036', 2025, 'Program Sosial Medan', 20000000000.00, 19500000000.00, 'Bantuan masyarakat rentan', 'I026'),
('A037', 2025, 'Program Transportasi Bandung', 50000000000.00, 49000000000.00, 'Angkot listrik kota Bandung', 'I036'),
('A038', 2025, 'Program Pendidikan Palembang', 85000000000.00, 83000000000.00, 'Renovasi sekolah dan laboratorium', 'I028'),
('A039', 2025, 'Program Pariwisata Bandung', 40000000000.00, 39000000000.00, 'Festival pariwisata tahunan', 'I040'),
('A040', 2025, 'Program Sosial Denpasar', 20000000000.00, 19000000000.00, 'Bantuan keluarga miskin', 'I038');

-- --------------------------------------------------------

--
-- Table structure for table `instansi`
--

CREATE TABLE `instansi` (
  `id_instansi` varchar(6) NOT NULL,
  `nama_instansi` varchar(150) NOT NULL,
  `jenis_instansi` varchar(150) NOT NULL,
  `sektor` varchar(150) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `wilayah_id_wilayah` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `instansi`
--

INSERT INTO `instansi` (`id_instansi`, `nama_instansi`, `jenis_instansi`, `sektor`, `alamat`, `wilayah_id_wilayah`) VALUES
('I001', 'RSUD Abdul Wahab Sjahranie', 'Rumah Sakit', 'Kesehatan', 'Jl. Palang Merah No.1 Samarinda', 'W002'),
('I002', 'RSUD Kota Balikpapan', 'Rumah Sakit', 'Kesehatan', 'Jl. MT Haryono Balikpapan', 'W003'),
('I003', 'RSUD Kutai Kartanegara', 'Rumah Sakit', 'Kesehatan', 'Jl. Wolter Monginsidi Tenggarong', 'W004'),
('I004', 'RSUD Kota Bontang', 'Rumah Sakit', 'Kesehatan', 'Jl. Bhayangkara Bontang', 'W005'),
('I005', 'RSUD Berau', 'Rumah Sakit', 'Kesehatan', 'Jl. Durian Tanjung Redeb', 'W006'),
('I006', 'Dinas Pendidikan Provinsi Kalimantan Timur', 'Dinas', 'Pendidikan', 'Jl. Basuki Rahmat Samarinda', 'W002'),
('I007', 'Dinas Sosial Provinsi Kalimantan Timur', 'Dinas', 'Sosial', 'Jl. Bhayangkara Samarinda', 'W002'),
('I008', 'Universitas Mulawarman', 'Perguruan Tinggi', 'Pendidikan', 'Jl. Kuaro Samarinda', 'W002'),
('I009', 'SMA Negeri 1 Balikpapan', 'Sekolah', 'Pendidikan', 'Jl. Jend. Sudirman Balikpapan', 'W003'),
('I010', 'SMP Negeri 3 Bontang', 'Sekolah', 'Pendidikan', 'Jl. S Parman Bontang', 'W005'),
('I011', 'RSUD Kota Bandung', 'Rumah Sakit', 'Kesehatan', 'Jl. Ciumbuleuit Bandung', 'W012'),
('I012', 'Dinas Pendidikan Kota Bandung', 'Dinas', 'Pendidikan', 'Jl. Martadinata Bandung', 'W012'),
('I013', 'Dinas Kesehatan Kota Bandung', 'Dinas', 'Kesehatan', 'Jl. Pahlawan Bandung', 'W012'),
('I014', 'Universitas Gadjah Mada', 'Perguruan Tinggi', 'Pendidikan', 'Jl. Bulaksumur Yogyakarta', 'W016'),
('I015', 'RSUD Kota Surabaya', 'Rumah Sakit', 'Kesehatan', 'Jl. Mayjend Sungkono Surabaya', 'W014'),
('I016', 'Dinas Pendidikan Kota Surabaya', 'Dinas', 'Pendidikan', 'Jl. Pemuda No.1 Surabaya', 'W014'),
('I017', 'RSUD Denpasar', 'Rumah Sakit', 'Kesehatan', 'Jl. Pulau Seram Denpasar', 'W017'),
('I018', 'Dinas Kesehatan Denpasar', 'Dinas', 'Kesehatan', 'Jl. Teuku Umar Denpasar', 'W017'),
('I019', 'Universitas Udayana', 'Perguruan Tinggi', 'Pendidikan', 'Jl. Kampus Jimbaran Bali', 'W017'),
('I020', 'SMA Negeri 3 Samarinda', 'Sekolah', 'Pendidikan', 'Jl. Pahlawan Samarinda', 'W002'),
('I021', 'Dinas Perhubungan Kota Samarinda', 'Dinas', 'Transportasi', 'Jl. Bhayangkara Samarinda', 'W002'),
('I022', 'Dinas Koperasi dan UMKM Bandung', 'Dinas', 'Ekonomi', 'Jl. Wastukencana Bandung', 'W012'),
('I023', 'RSUD Kota Makassar', 'Rumah Sakit', 'Kesehatan', 'Jl. Perintis Kemerdekaan Makassar', 'W021'),
('I024', 'Dinas Pendidikan Kota Makassar', 'Dinas', 'Pendidikan', 'Jl. Urip Sumoharjo Makassar', 'W021'),
('I025', 'RSUD Kota Medan', 'Rumah Sakit', 'Kesehatan', 'Jl. Gatot Subroto Medan', 'W019'),
('I026', 'Dinas Sosial Kota Medan', 'Dinas', 'Sosial', 'Jl. Diponegoro Medan', 'W019'),
('I027', 'RSUD Kota Palembang', 'Rumah Sakit', 'Kesehatan', 'Jl. Kol H Burlian Palembang', 'W020'),
('I028', 'Dinas Pendidikan Kota Palembang', 'Dinas', 'Pendidikan', 'Jl. Kapten A Rivai Palembang', 'W020'),
('I029', 'RSUD Kota Banjarmasin', 'Rumah Sakit', 'Kesehatan', 'Jl. Lambung Mangkurat Banjarmasin', 'W023'),
('I030', 'Dinas Kesehatan Kota Banjarmasin', 'Dinas', 'Kesehatan', 'Jl. Veteran Banjarmasin', 'W023'),
('I031', 'Universitas Hasanuddin', 'Perguruan Tinggi', 'Pendidikan', 'Jl. Perintis Kemerdekaan Tamalanrea', 'W021'),
('I032', 'Dinas Perikanan Kota Makassar', 'Dinas', 'Perikanan', 'Jl. Pelabuhan Makassar', 'W021'),
('I033', 'RSUD Kota Yogyakarta', 'Rumah Sakit', 'Kesehatan', 'Jl. Kyai Mojo Yogyakarta', 'W016'),
('I034', 'Dinas Kominfo Yogyakarta', 'Dinas', 'Informasi', 'Jl. Malioboro Yogyakarta', 'W016'),
('I035', 'RSUD Kota Balikpapan Selatan', 'Rumah Sakit', 'Kesehatan', 'Jl. Soekarno Hatta Balikpapan', 'W003'),
('I036', 'Dinas Pariwisata Bandung', 'Dinas', 'Pariwisata', 'Jl. Asia Afrika Bandung', 'W012'),
('I037', 'Dinas Lingkungan Hidup Surabaya', 'Dinas', 'Lingkungan', 'Jl. Raya Darmo Surabaya', 'W014'),
('I038', 'Dinas Pendidikan Denpasar', 'Dinas', 'Pendidikan', 'Jl. Ahmad Yani Denpasar', 'W017'),
('I039', 'Dinas Pekerjaan Umum Samarinda', 'Dinas', 'Infrastruktur', 'Jl. Bhayangkara Samarinda', 'W002'),
('I040', 'Dinas Sosial Denpasar', 'Dinas', 'Sosial', 'Jl. Gunung Agung Denpasar', 'W017');

-- --------------------------------------------------------

--
-- Table structure for table `pengaduan`
--

CREATE TABLE `pengaduan` (
  `id_pengaduan` varchar(6) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `isi_pengaduan` text NOT NULL,
  `tanggal_pengaduan` date NOT NULL,
  `id_instansi` varchar(6) NOT NULL,
  `id_akun` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengaduan`
--

INSERT INTO `pengaduan` (`id_pengaduan`, `judul`, `isi_pengaduan`, `tanggal_pengaduan`, `id_instansi`, `id_akun`) VALUES
('P001', 'Pelayanan Lambat di RSUD Samarinda', 'Waktu tunggu pasien terlalu lama di ruang IGD.', '2025-01-12', 'I001', '3171100673104000'),
('P002', 'Kebersihan Sekolah Kurang', 'Sampah di lingkungan SMA 1 Balikpapan menumpuk.', '2025-01-18', 'I009', '3201150497104100'),
('P003', 'Jalan Rusak di Bontang', 'Akses menuju RSUD Bontang rusak parah.', '2025-02-02', 'I004', '3301070176104200'),
('P004', 'Pelayanan Dinas Sosial Tidak Responsif', 'Sulit menghubungi petugas Dinsos Samarinda.', '2025-02-05', 'I007', '5101161194104300'),
('P005', 'Dana BOS Tidak Transparan', 'Orang tua tidak mendapat laporan penggunaan dana BOS.', '2025-02-15', 'I012', '5102070784104400'),
('P006', 'Antrian Obat RSUD Surabaya', 'Pasien harus menunggu lebih dari 3 jam untuk obat.', '2025-03-02', 'I015', '6408280274104500'),
('P007', 'Kurikulum Tidak Diperbarui', 'Sekolah belum menerapkan kurikulum Merdeka Belajar.', '2025-03-05', 'I016', '7101240477104600'),
('P008', 'Harga Parkir Rumah Sakit Mahal', 'Parkir RSUD Denpasar terlalu mahal.', '2025-03-07', 'I017', '7102220693104700'),
('P009', 'Pelayanan Kampus Kurang Ramah', 'Petugas administrasi tidak membantu mahasiswa.', '2025-03-08', 'I019', '5201261283104800'),
('P010', 'Puskesmas Tidak Punya Dokter', 'Di daerah Balikpapan Selatan sering kosong dokter.', '2025-03-09', 'I035', '6101280560104900'),
('P011', 'Data Gizi Tidak Diperbarui', 'Laporan gizi anak belum tersedia di website Dinkes Bandung.', '2025-03-12', 'I013', '3171240161105000'),
('P012', 'Dana Sosial Tidak Tepat Sasaran', 'Bantuan sosial tidak sampai ke warga miskin.', '2025-03-15', 'I026', '3201190772105100'),
('P013', 'Guru Tidak Hadir', 'SMA 3 Samarinda kekurangan tenaga guru aktif.', '2025-03-20', 'I020', '3301240287105200'),
('P014', 'Infrastruktur Jalan Buruk', 'Banyak lubang di sekitar Jalan Basuki Rahmat Samarinda.', '2025-03-25', 'I039', '5101221178105300'),
('P015', 'Pelayanan Kominfo Lambat', 'Laporan gangguan website tidak ditindaklanjuti.', '2025-03-27', 'I034', '5102141098105400'),
('P016', 'Dinas Pendidikan Tidak Merespons', 'Email pengaduan tidak dibalas oleh Disdik Makassar.', '2025-03-29', 'I024', '6408201264105500'),
('P017', 'Air Rumah Sakit Keruh', 'RSUD Makassar butuh perbaikan jaringan air.', '2025-04-02', 'I023', '7101251296105600'),
('P018', 'Parkir di RSUD Banjarmasin Penuh', 'Tidak ada lahan parkir pasien.', '2025-04-10', 'I029', '7102160293105700'),
('P019', 'Dana UMKM Tidak Cair', 'Bantuan UMKM belum diterima warga.', '2025-04-15', 'I022', '5201160284105800'),
('P020', 'Pembangunan Tidak Selesai', 'Proyek PU Samarinda belum selesai.', '2025-04-18', 'I039', '6101100476105900'),
('P021', 'Dana Kesehatan Tidak Jelas', 'RSUD Bandung tidak menampilkan laporan keuangan.', '2025-05-02', 'I011', '3171120269106000'),
('P022', 'Layanan Akademik UGM Lambat', 'Mahasiswa kesulitan akses sistem KRS.', '2025-05-10', 'I014', '3201250693106100'),
('P023', 'Fasilitas Sekolah Rusak', 'SMP 3 Bontang kekurangan kursi dan papan tulis.', '2025-05-18', 'I010', '3301140672106200'),
('P024', 'Pelayanan Publik Tidak Ramah', 'Pegawai Disdukcapil kurang sopan.', '2025-05-20', 'I022', '5101220198106300'),
('P025', 'Dana Sosial Tidak Transparan', 'Belum ada laporan penggunaan dana sosial Denpasar.', '2025-05-21', 'I040', '5102170968106400'),
('P026', 'Website Pendidikan Error', 'Situs pendidikan Bandung sering tidak bisa diakses.', '2025-05-22', 'I012', '6408110274106500'),
('P027', 'Fasilitas RSUD Berau Minim', 'Ruang rawat inap penuh.', '2025-05-23', 'I005', '7101050599106600'),
('P028', 'Guru Tidak Disiplin', 'Beberapa guru sering terlambat datang.', '2025-05-25', 'I018', '7102020995106700'),
('P029', 'Data Pekerjaan Umum Tidak Terbuka', 'Masyarakat sulit mengakses data proyek jalan.', '2025-05-26', 'I039', '5201021068106800'),
('P030', 'Data Dinsos Samarinda Tidak Diperbarui', 'Belum ada update penerima bantuan.', '2025-05-28', 'I007', '6101220685106900'),
('P031', 'Kualitas Air RSUD Bandung Buruk', 'Air berwarna kuning dan berbau.', '2025-06-02', 'I011', '3171050288107000'),
('P032', 'Tenaga Medis Kurang', 'Di RSUD Denpasar kekurangan dokter spesialis.', '2025-06-10', 'I017', '3201161076107100'),
('P033', 'Dana Riset Tidak Jelas', 'Mahasiswa tidak tahu laporan dana riset.', '2025-06-15', 'I019', '3301110379107200'),
('P034', 'Fasilitas Jalan Tidak Layak', 'Jalan menuju RSUD Palembang berlubang.', '2025-06-17', 'I027', '5101040689107300'),
('P035', 'Pengaduan Tidak Ditanggapi', 'Sudah kirim ke Dinas Pendidikan tapi belum dijawab.', '2025-06-20', 'I006', '5102151291107400'),
('P036', 'Dana Gizi Tidak Transparan', 'Data gizi anak belum dipublikasikan.', '2025-06-25', 'I013', '6408191262107500'),
('P037', 'Akses Website RSUD Error', 'Tidak bisa buka hasil laboratorium online.', '2025-07-01', 'I001', '7101180194107600'),
('P038', 'Dana Anggaran Terlambat Diumumkan', 'Anggaran 2025 belum dipublikasikan ke publik.', '2025-07-05', 'I026', '7102180681107700'),
('P039', 'Fasilitas Transportasi Samarinda Kurang', 'Bus umum hanya sedikit beroperasi.', '2025-07-10', 'I021', '5201160262107800'),
('P040', 'Dana Pendidikan Tidak Sesuai', 'Anggaran Disdik Makassar tidak transparan.', '2025-07-15', 'I024', '6101050799107900');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_akun` varchar(16) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_akun`, `alamat`) VALUES
('3171050288107000', 'Jl. Merdeka No.20 Kupang'),
('3171100673104000', 'Jl. Pahlawan No.10 Samarinda'),
('3171120269106000', 'Jl. Perintis Kemerdekaan No.8 Makassar'),
('3171240161105000', 'Jl. Pahlawan No.10 Medan'),
('3201150497104100', 'Jl. Soekarno Hatta No.5 Balikpapan'),
('3201161076107100', 'Jl. Sultan Hasanuddin No.22 Makassar'),
('3201190772105100', 'Jl. Malioboro No.6 Yogyakarta'),
('3201250693106100', 'Jl. Panglima Sudirman No.9 Surabaya'),
('3301070176104200', 'Jl. Ahmad Yani No.8 Bontang'),
('3301110379107200', 'Jl. Proklamasi No.9 Jayapura'),
('3301140672106200', 'Jl. Imam Bonjol No.10 Denpasar'),
('3301240287105200', 'Jl. Jend. Sudirman No.12 Bandung'),
('5101040689107300', 'Jl. Pattimura No.11 Ambon'),
('5101161194104300', 'Jl. Cendana No.2 Tenggarong'),
('5101220198106300', 'Jl. Dahlia No.11 Samarinda'),
('5101221178105300', 'Jl. Gatot Subroto No.18 Jakarta'),
('5102070784104400', 'Jl. Basuki Rahmat No.3 Bandung'),
('5102141098105400', 'Jl. S Parman No.22 Balikpapan'),
('5102151291107400', 'Jl. Sultan Serdang No.7 Kendari'),
('5102170968106400', 'Jl. Gunung Agung No.12 Denpasar'),
('5201021068106800', 'Jl. Jenderal Sudirman No.16 Bogor'),
('5201160262107800', 'Jl. Margonda Raya No.7 Depok'),
('5201160284105800', 'Jl. Pemuda No.6 Semarang'),
('5201261283104800', 'Jl. Urip Sumoharjo No.7 Makassar'),
('6101050799107900', 'Jl. Jend. Sudirman No.8 Bekasi'),
('6101100476105900', 'Jl. Basuki Rahmat No.7 Surabaya'),
('6101220685106900', 'Jl. Basuki Rahmat No.17 Malang'),
('6101280560104900', 'Jl. Kol. H. Burlian No.9 Palembang'),
('6408110274106500', 'Jl. Veteran No.13 Bandung'),
('6408191262107500', 'Jl. Ahmad Yani No.3 Palangkaraya'),
('6408201264105500', 'Jl. Ahmad Yani No.3 Samarinda'),
('6408280274104500', 'Jl. Veteran No.9 Surabaya'),
('7101050599106600', 'Jl. Wahid Hasyim No.14 Balikpapan'),
('7101180194107600', 'Jl. Sultan Ternate No.5 Ternate'),
('7101240477104600', 'Jl. Diponegoro No.11 Yogyakarta'),
('7101251296105600', 'Jl. Bhayangkara No.4 Banjarmasin'),
('7102020995106700', 'Jl. Gajah Mada No.15 Pontianak'),
('7102160293105700', 'Jl. MT Haryono No.5 Bandung'),
('7102180681107700', 'Jl. Cilegon Raya No.6 Cilegon'),
('7102220693104700', 'Jl. Teuku Umar No.15 Denpasar');

-- --------------------------------------------------------

--
-- Table structure for table `tanggapan`
--

CREATE TABLE `tanggapan` (
  `id_tanggapan` varchar(6) NOT NULL,
  `status_keluhan` varchar(50) NOT NULL,
  `isi_tanggapan` text NOT NULL,
  `tanggal_tanggapan` date NOT NULL,
  `id_pengaduan` varchar(6) NOT NULL,
  `id_akun` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tanggapan`
--

INSERT INTO `tanggapan` (`id_tanggapan`, `status_keluhan`, `isi_tanggapan`, `tanggal_tanggapan`, `id_pengaduan`, `id_akun`) VALUES
('T001', 'Diproses', 'Kami sedang melakukan perbaikan sistem antrian.', '2025-02-01', 'P001', '3171160368100000'),
('T002', 'Selesai', 'Kebersihan sudah ditingkatkan dan petugas ditambah.', '2025-02-10', 'P002', '3201181181100100'),
('T003', 'Selesai', 'Jalan menuju RSUD sudah diperbaiki.', '2025-02-20', 'P003', '3301250479100200'),
('T004', 'Diproses', 'Akan kami tindaklanjuti dengan Dinsos.', '2025-02-22', 'P004', '5101061191100300'),
('T005', 'Selesai', 'Laporan BOS kini sudah tersedia di website sekolah.', '2025-02-25', 'P005', '5102130999100400'),
('T006', 'Diproses', 'Farmasi sedang melakukan perbaikan sistem antrean.', '2025-03-05', 'P006', '6408040172100500'),
('T007', 'Selesai', 'Guru sudah mengikuti pelatihan kurikulum baru.', '2025-03-08', 'P007', '7101020467100600'),
('T008', 'Selesai', 'Biaya parkir sudah diturunkan.', '2025-03-10', 'P008', '7102141184100700'),
('T009', 'Diproses', 'Kami sedang evaluasi pelayanan akademik.', '2025-03-11', 'P009', '5201180375100800'),
('T010', 'Selesai', 'Sudah dilakukan perbaikan jaringan air.', '2025-03-13', 'P010', '6101110493100900'),
('T011', 'Selesai', 'Data gizi telah diperbarui di laman resmi.', '2025-03-15', 'P011', '3171051168101000'),
('T012', 'Diproses', 'Sedang audit internal penyaluran bantuan.', '2025-03-17', 'P012', '3201181265101100'),
('T013', 'Selesai', 'Guru pengganti sudah ditempatkan.', '2025-03-22', 'P013', '3301011269101200'),
('T014', 'Diproses', 'Laporan telah disampaikan ke Dinas PU.', '2025-03-27', 'P014', '5101070871101300'),
('T015', 'Selesai', 'Waktu tanggapan sudah dipercepat.', '2025-03-30', 'P015', '5102091196101400'),
('T016', 'Diproses', 'Disdik Makassar akan memperbaiki sistem surat.', '2025-04-01', 'P016', '6408010483101500'),
('T017', 'Selesai', 'Jaringan air sudah diperbaiki.', '2025-04-03', 'P017', '7101180597101600'),
('T018', 'Selesai', 'Telah ditambah lahan parkir pasien.', '2025-04-12', 'P018', '7102070188101700'),
('T019', 'Diproses', 'Sedang proses pencairan tahap II.', '2025-04-18', 'P019', '5201281263101800'),
('T020', 'Diproses', 'Pekerjaan akan diselesaikan minggu depan.', '2025-04-22', 'P020', '6101041186101900'),
('T021', 'Selesai', 'Laporan keuangan RSUD telah dipublikasikan.', '2025-05-05', 'P021', '3171110288102000'),
('T022', 'Selesai', 'Sistem KRS sudah diperbaiki.', '2025-05-12', 'P022', '3201260486102100'),
('T023', 'Diproses', 'Sudah dikoordinasikan ke kepala sekolah.', '2025-05-20', 'P023', '3301141097102200'),
('T024', 'Selesai', 'Pegawai sudah mendapat pelatihan pelayanan publik.', '2025-05-21', 'P024', '5101180782102300'),
('T025', 'Diproses', 'Audit internal anggaran sedang berlangsung.', '2025-05-25', 'P025', '5102040664102400'),
('T026', 'Selesai', 'Website Disdik sudah dapat diakses kembali.', '2025-05-28', 'P026', '6408100171102500'),
('T027', 'Diproses', 'Kapasitas ruang rawat inap akan ditambah.', '2025-06-02', 'P027', '7101040778102600'),
('T028', 'Selesai', 'Guru diberi teguran dan jadwal baru.', '2025-06-05', 'P028', '7102131176102700'),
('T029', 'Diproses', 'Data proyek PU sedang diperbarui.', '2025-06-10', 'P029', '5201090780102800'),
('T030', 'Selesai', 'Data penerima bantuan telah diunggah.', '2025-06-12', 'P030', '6101061093102900'),
('T031', 'Selesai', 'Air telah diuji dan dinyatakan aman.', '2025-06-15', 'P031', '3171280999103000'),
('T032', 'Diproses', 'Penambahan dokter sedang direkrut.', '2025-06-20', 'P032', '3201040488103100'),
('T033', 'Selesai', 'Dana riset telah diumumkan di portal kampus.', '2025-06-25', 'P033', '3301011286103200'),
('T034', 'Selesai', 'Jalan menuju RSUD diperbaiki.', '2025-06-28', 'P034', '5101240363103300'),
('T035', 'Diproses', 'Sudah disampaikan ke kepala dinas pendidikan.', '2025-07-02', 'P035', '5102190674103400'),
('T036', 'Selesai', 'Data gizi kini dapat diakses publik.', '2025-07-04', 'P036', '6408080491103500'),
('T037', 'Diproses', 'Server website sedang diperbaiki.', '2025-07-05', 'P037', '7101160775103600'),
('T038', 'Selesai', 'Laporan anggaran 2025 sudah diumumkan.', '2025-07-07', 'P038', '7102090887103700'),
('T039', 'Selesai', 'Penambahan bus sudah dijalankan.', '2025-07-12', 'P039', '5201041168103800'),
('T040', 'Diproses', 'Disdik sedang audit laporan dana.', '2025-07-15', 'P040', '6101260286103900');

-- --------------------------------------------------------

--
-- Table structure for table `wilayah`
--

CREATE TABLE `wilayah` (
  `Id_Wilayah` varchar(6) NOT NULL,
  `nama_wilayah` varchar(100) NOT NULL,
  `tingkat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `wilayah`
--

INSERT INTO `wilayah` (`Id_Wilayah`, `nama_wilayah`, `tingkat`) VALUES
('W001', 'Kalimantan Timur', 'Provinsi'),
('W002', 'Samarinda', 'Kota'),
('W003', 'Balikpapan', 'Kota'),
('W004', 'Kutai Kartanegara', 'Kabupaten'),
('W005', 'Bontang', 'Kota'),
('W006', 'Berau', 'Kabupaten'),
('W007', 'Kutai Timur', 'Kabupaten'),
('W008', 'Penajam Paser Utara', 'Kabupaten'),
('W009', 'Paser', 'Kabupaten'),
('W010', 'Mahakam Ulu', 'Kabupaten'),
('W011', 'DKI Jakarta', 'Provinsi'),
('W012', 'Bandung', 'Kota'),
('W013', 'Bogor', 'Kabupaten'),
('W014', 'Surabaya', 'Kota'),
('W015', 'Malang', 'Kabupaten'),
('W016', 'Yogyakarta', 'Kota'),
('W017', 'Denpasar', 'Kota'),
('W018', 'Semarang', 'Kota'),
('W019', 'Medan', 'Kota'),
('W020', 'Palembang', 'Kota'),
('W021', 'Makassar', 'Kota'),
('W022', 'Manado', 'Kota'),
('W023', 'Banjarmasin', 'Kota'),
('W024', 'Pontianak', 'Kota'),
('W025', 'Padang', 'Kota'),
('W026', 'Pekanbaru', 'Kota'),
('W027', 'Serang', 'Kota'),
('W028', 'Banda Aceh', 'Kota'),
('W029', 'Kupang', 'Kota'),
('W030', 'Mataram', 'Kota'),
('W031', 'Jayapura', 'Kota'),
('W032', 'Ambon', 'Kota'),
('W033', 'Kendari', 'Kota'),
('W034', 'Palangkaraya', 'Kota'),
('W035', 'Ternate', 'Kota'),
('W036', 'Cilegon', 'Kota'),
('W037', 'Depok', 'Kota'),
('W038', 'Bekasi', 'Kota'),
('W039', 'Tenggarong', 'Kabupaten'),
('W040', 'Sleman', 'Kabupaten');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_akun`);

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id_akun`);

--
-- Indexes for table `anggaran`
--
ALTER TABLE `anggaran`
  ADD PRIMARY KEY (`id_anggaran`),
  ADD KEY `instansi_id_instansi` (`id_instansi`);

--
-- Indexes for table `instansi`
--
ALTER TABLE `instansi`
  ADD PRIMARY KEY (`id_instansi`),
  ADD KEY `wilayah_id_wilayah` (`wilayah_id_wilayah`);

--
-- Indexes for table `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD PRIMARY KEY (`id_pengaduan`),
  ADD KEY `id_instansi` (`id_instansi`),
  ADD KEY `pengaduan_ibfk_2` (`id_akun`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_akun`);

--
-- Indexes for table `tanggapan`
--
ALTER TABLE `tanggapan`
  ADD PRIMARY KEY (`id_tanggapan`),
  ADD KEY `id_pengaduan` (`id_pengaduan`),
  ADD KEY `tanggapan_ibfk_2` (`id_akun`);

--
-- Indexes for table `wilayah`
--
ALTER TABLE `wilayah`
  ADD PRIMARY KEY (`Id_Wilayah`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`);

--
-- Constraints for table `instansi`
--
ALTER TABLE `instansi`
  ADD CONSTRAINT `instansi_ibfk_1` FOREIGN KEY (`wilayah_id_wilayah`) REFERENCES `wilayah` (`Id_Wilayah`);

--
-- Constraints for table `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD CONSTRAINT `pengaduan_ibfk_1` FOREIGN KEY (`id_instansi`) REFERENCES `instansi` (`id_instansi`),
  ADD CONSTRAINT `pengaduan_ibfk_2` FOREIGN KEY (`id_akun`) REFERENCES `pengguna` (`id_akun`);

--
-- Constraints for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `pengguna_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`);

--
-- Constraints for table `tanggapan`
--
ALTER TABLE `tanggapan`
  ADD CONSTRAINT `tanggapan_ibfk_1` FOREIGN KEY (`id_pengaduan`) REFERENCES `pengaduan` (`id_pengaduan`),
  ADD CONSTRAINT `tanggapan_ibfk_2` FOREIGN KEY (`id_akun`) REFERENCES `admin` (`id_akun`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
