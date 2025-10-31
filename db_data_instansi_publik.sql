-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 31, 2025 at 02:48 AM
-- Server version: 8.4.3
-- PHP Version: 8.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_data_instansi_publik`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_akun` varchar(16) NOT NULL,
  `peran` enum('Pengelola Pengaduan','Pengelola Anggaran') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_akun`, `peran`) VALUES
('APA0001', 'Pengelola Anggaran'),
('APA0002', 'Pengelola Anggaran'),
('APA0003', 'Pengelola Anggaran'),
('APA0004', 'Pengelola Anggaran'),
('APA0005', 'Pengelola Anggaran'),
('APA0006', 'Pengelola Anggaran'),
('APA0007', 'Pengelola Anggaran'),
('APA0008', 'Pengelola Anggaran'),
('APA0009', 'Pengelola Anggaran'),
('APA0010', 'Pengelola Anggaran'),
('APA0011', 'Pengelola Anggaran'),
('APA0012', 'Pengelola Anggaran'),
('APA0013', 'Pengelola Anggaran'),
('APA0014', 'Pengelola Anggaran'),
('APA0015', 'Pengelola Anggaran'),
('APA0016', 'Pengelola Anggaran'),
('APA0017', 'Pengelola Anggaran'),
('APA0018', 'Pengelola Anggaran'),
('APA0019', 'Pengelola Anggaran'),
('APA0020', 'Pengelola Anggaran'),
('APP0001', 'Pengelola Pengaduan'),
('APP0002', 'Pengelola Pengaduan'),
('APP0003', 'Pengelola Pengaduan'),
('APP0004', 'Pengelola Pengaduan'),
('APP0005', 'Pengelola Pengaduan'),
('APP0006', 'Pengelola Pengaduan'),
('APP0007', 'Pengelola Pengaduan'),
('APP0008', 'Pengelola Pengaduan'),
('APP0009', 'Pengelola Pengaduan'),
('APP0010', 'Pengelola Pengaduan'),
('APP0011', 'Pengelola Pengaduan'),
('APP0012', 'Pengelola Pengaduan'),
('APP0013', 'Pengelola Pengaduan'),
('APP0014', 'Pengelola Pengaduan'),
('APP0015', 'Pengelola Pengaduan'),
('APP0016', 'Pengelola Pengaduan'),
('APP0017', 'Pengelola Pengaduan'),
('APP0018', 'Pengelola Pengaduan'),
('APP0019', 'Pengelola Pengaduan'),
('APP0020', 'Pengelola Pengaduan');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id_akun`, `nama`, `email`, `no_hp`, `kata_sandi`) VALUES
('3171050288107000', 'Andi Pratama', 'andi.pratama07@gmail.com', '081328476512', 'AnPr@2025!xF'),
('3171100673104000', 'Siti Nurhayati', 'siti.nurhayati85@gmail.com', '082187395041', 'SiNur#9q7$'),
('3171120269106000', 'Budi Santoso', 'budi.santoso.tn@gmail.com', '085712934560', 'BuSan!34Lp'),
('3171240161105000', 'Rina Marlina', 'rina.marlina1987@gmail.com', '081299347611', 'RiM@88_gH'),
('3201150497104100', 'Dewi Lestari', 'dewi.lestari.design@gmail.com', '082312947200', 'DeLe*2021z'),
('3201161076107100', 'Hendra Wijaya', 'hendra.wijaya.wk@gmail.com', '081556203987', 'HeWi^5pL'),
('3201190772105100', 'Fitriani', 'fitri.fitriani@gmail.com', '085398271045', 'FtRi#72!m'),
('3201250693106100', 'Rizky Prasetyo', 'rizky.prasetyo94@gmail.com', '081723905612', 'RzPr@0x9'),
('3301070176104200', 'Martha Kristina', 'martha.kristina77@gmail.com', '082145307890', 'MaKr*11Z'),
('3301100379107200', 'Yusuf Iskandar', 'yusuf.iskandar21@gmail.com', '085612907134', 'YuIs#202!'),
('3301140672106200', 'Wawan Kurniawan', 'wawan.kurniawan@gmail.com', '081234908177', 'WaKu@7pL'),
('3301240287105200', 'Nina Kartika', 'nina.kartika90@gmail.com', '082398117205', 'NiKa%44s'),
('5101040689107300', 'Eko Susilo', 'eko.susilo53@gmail.com', '085223677801', 'EkSu!5z2'),
('5101161194104300', 'Intan Permata', 'intan.permata33@gmail.com', '081447290366', 'InPe#88x'),
('5101220198106300', 'Teguh Hidayat', 'teguh.hidayat99@gmail.com', '082198334579', 'TeHi@3kL'),
('5101221178105300', 'Lina Marlina', 'lina.marlina.pd@gmail.com', '085712490233', 'LiMa*0p9'),
('5102070841044000', 'Agus Salim', 'agus.salim47@gmail.com', '081998273645', 'AgSa#77!'),
('5102141098105400', 'Saraswati', 'saraswati.art@gmail.com', '082776543210', 'SaWa@12z'),
('5102151291107400', 'Rendy Adi', 'rendy.adi10@gmail.com', '085199307412', 'ReAd!5mN'),
('5102170968106400', 'Dian Pertiwi', 'dian.pertiwi88@gmail.com', '081355902674', 'DiPe#3x8'),
('5201021068106800', 'Fajar Nugroho', 'fajar.nugroho@gmail.com', '082334119876', 'FaNu@992'),
('5201160262107800', 'Maya Sari', 'maya.sari.office@gmail.com', '085647213908', 'MaSa!47z'),
('5201160284105800', 'Harianto', 'harianto89@gmail.com', '081789234501', 'HaAn#2kL'),
('5201261283104800', 'Lestari Putri', 'lestari.putri12@gmail.com', '082145678309', 'LePu@6v8'),
('6101050991079000', 'Rizal Maulana', 'rizal.maulana05@gmail.com', '085321097654', 'RiMa!90p'),
('6101100476105900', 'Nadya Salsabila', 'nadya.salsabila@gmail.com', '081912345678', 'NaSa#04r'),
('6101220685106900', 'Iwan Setiawan', 'iwan.setiawan77@gmail.com', '082134567901', 'IwSe@77X'),
('6101285060104900', 'Siti Aisyah', 'siti.aisyah07@gmail.com', '085701234890', 'SiAi!3d9'),
('6408110274106500', 'Bambang Sutrisno', 'bambang.sutrisno@gmail.com', '081567908321', 'BaSu#51z'),
('6408191262107500', 'Yulia Dewi', 'yulia.dewi.official@gmail.com', '082390175642', 'YuDe@22x'),
('6408280126410500', 'Rian Pratama', 'rian.pratama22@gmail.com', '085233019487', 'RiPr!6h2'),
('6408280274104500', 'Novi Handayani', 'novi.handayani84@gmail.com', '081998112233', 'NoHa#88m'),
('7101050599106600', 'Halimatussadiyah', 'halima.sadiyah@gmail.com', '082345671289', 'HaSa@202!'),
('7101108194107600', 'Muhammad Arif', 'muhammad.arif89@gmail.com', '085412390876', 'MuAr#01p'),
('7101240477104600', 'Sri Wahyuni', 'sri.wahyuni65@gmail.com', '081334556677', 'SrWa!9k8'),
('7101251296105600', 'Hendra Gunawan', 'hendra.gunawan@gmail.com', '082767890123', 'HeGu#44v'),
('7102160293105700', 'Deddy Pratama', 'deddy.pratama33@gmail.com', '081299887766', 'DePr!8z1'),
('7102180681107700', 'Laila Fitri', 'laila.fitri34@gmail.com', '082178903456', 'LaFi#5n2'),
('7102200995106700', 'Putri Anggraini', 'putri.anggraini@gmail.com', '085987123450', 'PuAn@6t4'),
('7102220693104700', 'Aditya Nugraha', 'aditya.nugraha@gmail.com', '085100234567', 'AdNu@3q7'),
('APA0001', 'Andi Wijaya', 'andi.wijaya.apa@gmail.com', '085123409876', 'AnWj#2k9'),
('APA0002', 'Lilis Suryani', 'lilis.suryani.apa@gmail.com', '081278634509', 'LiSu!7m1'),
('APA0003', 'Hadi Susanto', 'hadi.susanto.apa@gmail.com', '082399112233', 'HaSu@5r8'),
('APA0004', 'Nina Marlina', 'nina.marlina.apa@gmail.com', '085678901234', 'NiMa#4t2'),
('APA0005', 'Budi Hartono', 'budi.hartono.apa@gmail.com', '081299331122', 'BuHa!3p7'),
('APA0006', 'Tia Rahma', 'tia.rahma.apa@gmail.com', '082188990011', 'TiRa@6v5'),
('APA0007', 'Agus Priyanto', 'agus.priyanto.apa@gmail.com', '085412233445', 'AgPr#0n6'),
('APA0008', 'Rini Oktaviani', 'rini.oktaviani.apa@gmail.com', '081267345900', 'RiOk!8b2'),
('APA0009', 'Kurniawan', 'kurniawan.apa@gmail.com', '082301234567', 'KuWa@1f9'),
('APA0010', 'Sulastri', 'sulastri.apa@gmail.com', '085278901345', 'SuLa#7m3'),
('APA0011', 'Fikri Maulana', 'fikri.maulana.apa@gmail.com', '081355667788', 'FiMa!2z6'),
('APA0012', 'Yosef', 'yosef.apa@gmail.com', '082344556677', 'YoSe@4n1'),
('APA0013', 'Indah Permata', 'indah.permata.apa@gmail.com', '085199334455', 'InPe#9q2'),
('APA0014', 'Tri Setiawan', 'tri.setiawan.apa@gmail.com', '081298776655', 'TrSe!5r4'),
('APA0015', 'Melati', 'melati.apa@gmail.com', '082123908776', 'MeLa@3t8'),
('APA0016', 'Dedi Kurnia', 'dedi.kurnia.apa@gmail.com', '085667123900', 'DeKu#6w1'),
('APA0017', 'Nurfadillah', 'nurfadillah.apa@gmail.com', '081377990011', 'NuFa!0p3'),
('APA0018', 'Sigit', 'sigit.apa@gmail.com', '082189007766', 'SiGi@2v5'),
('APA0019', 'Wulan', 'wulan.apa@gmail.com', '085400776655', 'WuLa#8n0'),
('APA0020', 'Ferry', 'ferry.apa@gmail.com', '081233445566', 'FeRy!1k2'),
('APP0001', 'Andreas Putra', 'andreas.putra.app@gmail.com', '081298374655', 'AndPr#7u2!'),
('APP0002', 'Lutfiah Rahma', 'lutfiah.rahma.app@gmail.com', '082134098765', 'LuRa@9t3'),
('APP0003', 'Slamet Riyadi', 'slamet.riyadi.app@gmail.com', '085199876543', 'SlRi!2v8'),
('APP0004', 'Kartika Sari', 'kartika.sari.app@gmail.com', '081267890123', 'KaSa#5p1'),
('APP0005', 'Donny Prasetyo', 'donny.prasetyo.app@gmail.com', '082378901245', 'DoPr@1m4'),
('APP0006', 'Widianto', 'widianto.app@gmail.com', '085312409876', 'WiAn#3h6'),
('APP0007', 'Mira Adriani', 'mira.adriani.app@gmail.com', '081334445566', 'MiAd!8k2'),
('APP0008', 'Fachri Hidayat', 'fachri.hidayat.app@gmail.com', '082178234599', 'FaHi@0n7'),
('APP0009', 'Nadia Putri', 'nadia.putri.app@gmail.com', '085667788900', 'NaPu#6z4'),
('APP0010', 'Baskoro', 'baskoro.app@gmail.com', '081256709834', 'BaSk!5q9'),
('APP0011', 'Erlina', 'erlina.app@gmail.com', '082499001237', 'ErLi@2c3'),
('APP0012', 'Halim', 'halim.app@gmail.com', '085345670912', 'HaLi#7p0'),
('APP0013', 'Nurhalimah', 'nurhalimah.app@gmail.com', '081278903214', 'NuHa!4r5'),
('APP0014', 'Teguh Prabowo', 'teguh.prabowo.app@gmail.com', '082156709881', 'TePr@6s2'),
('APP0015', 'Sari Melati', 'sari.melati.app@gmail.com', '085210987654', 'SaMe#1v8'),
('APP0016', 'Rizki Hidayat', 'rizki.hidayat.app@gmail.com', '081377665544', 'RiHi!9t0'),
('APP0017', 'Yenny Kurnia', 'yenny.kurnia.app@gmail.com', '082188776655', 'YeKu@3p6'),
('APP0018', 'Gilang', 'gilang.app@gmail.com', '085412378900', 'GiLa#2m7'),
('APP0019', 'Miftah', 'miftah.app@gmail.com', '081299445566', 'MiFt!5x1'),
('APP0020', 'Dewi Kartini', 'dewi.kartini.app@gmail.com', '082300119988', 'DeKa@8r4');

-- --------------------------------------------------------

--
-- Table structure for table `anggaran`
--

CREATE TABLE `anggaran` (
  `id_anggaran` varchar(6) NOT NULL,
  `tahun` int NOT NULL,
  `nama_program` varchar(150) NOT NULL,
  `total_anggaran` decimal(15,2) NOT NULL,
  `realisasi` decimal(15,2) NOT NULL,
  `keterangan` text NOT NULL,
  `id_instansi` varchar(6) NOT NULL,
  `id_akun` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `anggaran`
--

INSERT INTO `anggaran` (`id_anggaran`, `tahun`, `nama_program`, `total_anggaran`, `realisasi`, `keterangan`, `id_instansi`, `id_akun`) VALUES
('ANG001', 2024, 'Pengadaan Alat Medis', 4820000000.00, 4698000000.00, 'Program selesai 100%', 'INS001', 'APA0004'),
('ANG002', 2024, 'Renovasi Bangsal Rawat Inap', 3950000000.00, 3625000000.00, 'Dalam tahap penyelesaian akhir', 'INS002', 'APA0011'),
('ANG003', 2025, 'Digitalisasi Rekam Medis', 1280000000.00, 1185000000.00, 'Program berjalan sesuai rencana', 'INS003', 'APA0008'),
('ANG004', 2024, 'Perbaikan Fasilitas IGD', 2330000000.00, 2237000000.00, 'Realisasi sedikit terhambat', 'INS004', 'APA0013'),
('ANG005', 2023, 'Pelatihan Tenaga Kesehatan', 955000000.00, 930000000.00, 'Program selesai 100%', 'INS005', 'APA0006'),
('ANG006', 2025, 'Peningkatan Transportasi Publik', 4600000000.00, 4220000000.00, 'Program berjalan sesuai rencana', 'INS006', 'APA0010'),
('ANG007', 2024, 'Pembangunan Taman Kota', 2400000000.00, 1890000000.00, 'Realisasi sedikit terhambat', 'INS007', 'APA0018'),
('ANG008', 2025, 'Promosi Pariwisata Daerah', 3210000000.00, 3000000000.00, 'Program berjalan sesuai rencana', 'INS008', 'APA0007'),
('ANG009', 2023, 'Rehabilitasi Jalan dan Jembatan', 4910000000.00, 4780000000.00, 'Program selesai 100%', 'INS009', 'APA0012'),
('ANG010', 2025, 'Pemeliharaan Kapal Patroli', 2170000000.00, 2100000000.00, 'Program berjalan sesuai rencana', 'INS010', 'APA0009'),
('ANG011', 2024, 'Pelatihan Guru dan Staf', 1780000000.00, 1700000000.00, 'Program selesai 100%', 'INS011', 'APA0015'),
('ANG012', 2025, 'Pembangunan Balai Sosial', 1530000000.00, 1360000000.00, 'Dalam tahap penyelesaian akhir', 'INS012', 'APA0002'),
('ANG013', 2023, 'Modernisasi Sistem Informasi Publik', 2670000000.00, 2500000000.00, 'Program berjalan sesuai rencana', 'INS013', 'APA0017'),
('ANG014', 2024, 'Pengembangan UMKM Lokal', 1920000000.00, 1750000000.00, 'Realisasi sedikit terhambat', 'INS014', 'APA0019'),
('ANG015', 2023, 'Peningkatan Pasar Rakyat', 2570000000.00, 2460000000.00, 'Program berjalan sesuai rencana', 'INS015', 'APA0005'),
('ANG016', 2025, 'Peningkatan Fasilitas Puskesmas', 1820000000.00, 1640000000.00, 'Dalam tahap penyelesaian akhir', 'INS016', 'APA0008'),
('ANG017', 2024, 'Peremajaan Armada Transportasi', 3460000000.00, 3100000000.00, 'Program berjalan sesuai rencana', 'INS017', 'APA0014'),
('ANG018', 2023, 'Rehabilitasi Tambak Ikan', 1680000000.00, 1550000000.00, 'Program selesai 100%', 'INS018', 'APA0010'),
('ANG019', 2024, 'Kampanye Lingkungan Bersih', 820000000.00, 750000000.00, 'Realisasi sedikit terhambat', 'INS019', 'APA0016'),
('ANG020', 2025, 'Revitalisasi Obyek Wisata Pantai', 4100000000.00, 3880000000.00, 'Program berjalan sesuai rencana', 'INS020', 'APA0003'),
('ANG021', 2023, 'Pembangunan Gedung Fakultas', 3260000000.00, 3100000000.00, 'Program berjalan sesuai rencana', 'INS021', 'APA0007'),
('ANG022', 2024, 'Pengembangan Laboratorium', 2420000000.00, 2350000000.00, 'Program selesai 100%', 'INS022', 'APA0015'),
('ANG023', 2025, 'Peningkatan Kualitas Akademik', 1550000000.00, 1400000000.00, 'Dalam tahap penyelesaian akhir', 'INS023', 'APA0011'),
('ANG024', 2023, 'Pembangunan Gedung Baru', 2180000000.00, 2110000000.00, 'Program selesai 100%', 'INS024', 'APA0009'),
('ANG025', 2024, 'Digitalisasi Arsip Akademik', 1010000000.00, 970000000.00, 'Program berjalan sesuai rencana', 'INS025', 'APA0014'),
('ANG026', 2023, 'Perbaikan Fasilitas Sekolah', 1370000000.00, 1290000000.00, 'Program selesai 100%', 'INS026', 'APA0006'),
('ANG027', 2024, 'Renovasi Ruang Kelas', 960000000.00, 880000000.00, 'Realisasi sedikit terhambat', 'INS027', 'APA0018'),
('ANG028', 2025, 'Peningkatan Kompetensi Guru', 1120000000.00, 1080000000.00, 'Program berjalan sesuai rencana', 'INS028', 'APA0003'),
('ANG029', 2024, 'Digitalisasi Absensi Sekolah', 670000000.00, 650000000.00, 'Program selesai 100%', 'INS029', 'APA0010'),
('ANG030', 2023, 'Perawatan Sarana Sekolah', 710000000.00, 690000000.00, 'Program berjalan sesuai rencana', 'INS030', 'APA0005'),
('ANG031', 2023, 'Modernisasi Sistem Data Statistik', 1520000000.00, 1450000000.00, 'Dalam tahap penyelesaian akhir', 'INS031', 'APA0013'),
('ANG032', 2024, 'Pembangunan Shelter Darurat', 2050000000.00, 1960000000.00, 'Program berjalan sesuai rencana', 'INS032', 'APA0008'),
('ANG033', 2025, 'Peningkatan Pelayanan Publik', 1980000000.00, 1900000000.00, 'Program selesai 100%', 'INS033', 'APA0001'),
('ANG034', 2024, 'Digitalisasi Dokumen Keimigrasian', 2450000000.00, 2200000000.00, 'Realisasi sedikit terhambat', 'INS034', 'APA0012'),
('ANG035', 2023, 'Peremajaan Gedung Pelayanan', 1810000000.00, 1650000000.00, 'Dalam tahap penyelesaian akhir', 'INS035', 'APA0019'),
('ANG036', 2025, 'Pengadaan Alat Medis Baru', 2750000000.00, 2550000000.00, 'Program berjalan sesuai rencana', 'INS036', 'APA0004'),
('ANG037', 2024, 'Renovasi Gedung Utama', 3200000000.00, 3000000000.00, 'Program selesai 100%', 'INS037', 'APA0010'),
('ANG038', 2023, 'Pengadaan Peralatan Kesehatan', 1350000000.00, 1200000000.00, 'Dalam tahap penyelesaian akhir', 'INS038', 'APA0017'),
('ANG039', 2025, 'Pemeliharaan Fasilitas Rumah Sakit', 950000000.00, 890000000.00, 'Realisasi sedikit terhambat', 'INS039', 'APA0002'),
('ANG040', 2023, 'Renovasi Gedung Radiologi', 1890000000.00, 1820000000.00, 'Program berjalan sesuai rencana', 'INS040', 'APA0016'),
('ANG041', 2024, 'Pemberdayaan Petani Lokal', 910000000.00, 870000000.00, 'Program selesai 100%', 'INS041', 'APA0006'),
('ANG042', 2023, 'Pengadaan Armada Transportasi Laut', 2890000000.00, 2650000000.00, 'Dalam tahap penyelesaian akhir', 'INS042', 'APA0007'),
('ANG043', 2025, 'Pembangunan Pusat Data Kota', 3150000000.00, 3000000000.00, 'Program berjalan sesuai rencana', 'INS043', 'APA0018'),
('ANG044', 2023, 'Peningkatan Infrastruktur Perdagangan', 3550000000.00, 3440000000.00, 'Program selesai 100%', 'INS044', 'APA0015'),
('ANG045', 2024, 'Pembangunan Gedung Sosial', 1440000000.00, 1360000000.00, 'Realisasi sedikit terhambat', 'INS045', 'APA0010'),
('ANG046', 2025, 'Kampanye Wisata Daerah', 1650000000.00, 1500000000.00, 'Program berjalan sesuai rencana', 'INS046', 'APA0009'),
('ANG047', 2024, 'Peningkatan Program Daur Ulang', 720000000.00, 690000000.00, 'Dalam tahap penyelesaian akhir', 'INS047', 'APA0014'),
('ANG048', 2025, 'Pembangunan Jalan Desa', 2490000000.00, 2200000000.00, 'Program berjalan sesuai rencana', 'INS048', 'APA0003'),
('ANG049', 2023, 'Peningkatan Transparansi Keuangan', 1880000000.00, 1770000000.00, 'Program selesai 100%', 'INS049', 'APA0011');

--
-- Triggers `anggaran`
--
DELIMITER $$
CREATE TRIGGER `trg_anggaran_id` BEFORE INSERT ON `anggaran` FOR EACH ROW BEGIN
  DECLARE new_id VARCHAR(6);
  DECLARE last_num INT;

  SELECT IFNULL(MAX(CAST(SUBSTRING(Id_Anggaran, 4) AS UNSIGNED)), 0) + 1 INTO last_num FROM anggaran;
  SET new_id = CONCAT('ANG', LPAD(last_num, 3, '0'));
  SET NEW.Id_Anggaran = new_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `instansi`
--

CREATE TABLE `instansi` (
  `id_instansi` varchar(6) NOT NULL,
  `nama_instansi` varchar(150) NOT NULL,
  `jenis_instansi` enum('Rumah Sakit','Sekolah','Perguruan Tinggi','Dinas') NOT NULL,
  `sektor` enum('Kesehatan','Pendidikan','Sosial','Ekonomi','Transportasi','Informasi','Perikanan','Lingkungan','Pariwisata','Infrastruktur') NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `wilayah_id_wilayah` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `instansi`
--

INSERT INTO `instansi` (`id_instansi`, `nama_instansi`, `jenis_instansi`, `sektor`, `alamat`, `wilayah_id_wilayah`) VALUES
('INS001', 'RSUD Banda Aceh', 'Rumah Sakit', 'Kesehatan', 'Jl. Teuku Umar No.12', 'W039'),
('INS002', 'RSUD Medan Sejahtera', 'Rumah Sakit', 'Kesehatan', 'Jl. Gatot Subroto No.22', 'W040'),
('INS003', 'RSUP Dr. M. Djamil Padang', 'Rumah Sakit', 'Kesehatan', 'Jl. Ahmad Yani No.45', 'W041'),
('INS004', 'RSUD Pekanbaru Mandiri', 'Rumah Sakit', 'Kesehatan', 'Jl. Diponegoro No.9', 'W042'),
('INS005', 'RSUP Jambi Raya', 'Rumah Sakit', 'Kesehatan', 'Jl. Soekarno Hatta No.13', 'W044'),
('INS006', 'Dinas Perhubungan Palembang', 'Dinas', 'Transportasi', 'Jl. Veteran No.10', 'W046'),
('INS007', 'Dinas Lingkungan Hidup Bandung', 'Dinas', 'Lingkungan', 'Jl. Ahmad Yani No.25', 'W051'),
('INS008', 'Dinas Pariwisata Denpasar', 'Dinas', 'Pariwisata', 'Jl. Imam Bonjol No.17', 'W055'),
('INS009', 'Dinas Pekerjaan Umum Surabaya', 'Dinas', 'Infrastruktur', 'Jl. Diponegoro No.8', 'W054'),
('INS010', 'Dinas Perikanan Makassar', 'Dinas', 'Perikanan', 'Jl. Urip Sumoharjo No.20', 'W067'),
('INS011', 'Dinas Pendidikan Balikpapan', 'Dinas', 'Pendidikan', 'Jl. S Parman No.9', 'W061'),
('INS012', 'Dinas Sosial Yogyakarta', 'Dinas', 'Sosial', 'Jl. Malioboro No.15', 'W015'),
('INS013', 'Dinas Komunikasi dan Informatika Jakarta Selatan', 'Dinas', 'Informasi', 'Jl. Sudirman No.30', 'W050'),
('INS014', 'Dinas Ekonomi Kota Manado', 'Dinas', 'Ekonomi', 'Jl. Sam Ratulangi No.12', 'W063'),
('INS015', 'Dinas Perdagangan Pontianak', 'Dinas', 'Ekonomi', 'Jl. Gajah Mada No.22', 'W058'),
('INS016', 'Dinas Kesehatan Ambon', 'Dinas', 'Kesehatan', 'Jl. Pattimura No.10', 'W069'),
('INS017', 'Dinas Perhubungan Ternate', 'Dinas', 'Transportasi', 'Jl. Sultan Ternate No.11', 'W070'),
('INS018', 'Dinas Perikanan Banjarmasin', 'Dinas', 'Perikanan', 'Jl. Bhayangkara No.19', 'W060'),
('INS019', 'Dinas Lingkungan Hidup Jayapura', 'Dinas', 'Lingkungan', 'Jl. Proklamasi No.3', 'W071'),
('INS020', 'Dinas Pariwisata Mataram', 'Dinas', 'Pariwisata', 'Jl. Pejanggik No.10', 'W056'),
('INS021', 'Universitas Negeri Surabaya', 'Perguruan Tinggi', 'Pendidikan', 'Jl. Ketintang No.5', 'W054'),
('INS022', 'Universitas Negeri Yogyakarta', 'Perguruan Tinggi', 'Pendidikan', 'Jl. Colombo No.1', 'W015'),
('INS023', 'Universitas Hasanuddin Makassar', 'Perguruan Tinggi', 'Pendidikan', 'Jl. Perintis Kemerdekaan No.10', 'W067'),
('INS024', 'Politeknik Negeri Bandung', 'Perguruan Tinggi', 'Pendidikan', 'Jl. Gegerkalong Hilir No.8', 'W051'),
('INS025', 'Universitas Udayana Denpasar', 'Perguruan Tinggi', 'Pendidikan', 'Jl. Sudirman No.15', 'W055'),
('INS026', 'SMK Negeri 1 Balikpapan', 'Sekolah', 'Pendidikan', 'Jl. Soekarno Hatta No.9', 'W061'),
('INS027', 'SMA Negeri 3 Denpasar', 'Sekolah', 'Pendidikan', 'Jl. Gunung Agung No.4', 'W055'),
('INS028', 'SMK Swasta Pekanbaru', 'Sekolah', 'Pendidikan', 'Jl. Hang Tuah No.11', 'W042'),
('INS029', 'SMA Negeri 2 Bandung', 'Sekolah', 'Pendidikan', 'Jl. Diponegoro No.3', 'W051'),
('INS030', 'SMK Negeri 4 Surabaya', 'Sekolah', 'Pendidikan', 'Jl. Jagir Wonokromo No.12', 'W054'),
('INS031', 'Badan Statistik Kota Medan', 'Dinas', 'Informasi', 'Jl. Balai Kota No.1', 'W040'),
('INS032', 'Badan Penanggulangan Bencana Lampung', 'Dinas', 'Sosial', 'Jl. Gatot Subroto No.18', 'W048'),
('INS033', 'Kantor Pajak Bandung', 'Dinas', 'Ekonomi', 'Jl. Merdeka No.25', 'W051'),
('INS034', 'Kantor Imigrasi Surabaya', 'Dinas', 'Informasi', 'Jl. Raya Darmo No.27', 'W054'),
('INS035', 'Kantor Pelayanan Publik Yogyakarta', 'Dinas', 'Sosial', 'Jl. Magelang No.6', 'W015'),
('INS036', 'RSUD Pontianak', 'Rumah Sakit', 'Kesehatan', 'Jl. Ahmad Yani No.15', 'W058'),
('INS037', 'RSUD Tarakan', 'Rumah Sakit', 'Kesehatan', 'Jl. Mulawarman No.11', 'W062'),
('INS038', 'RSUD Kendari', 'Rumah Sakit', 'Kesehatan', 'Jl. Syech Yusuf No.8', 'W068'),
('INS039', 'RSUD Manokwari', 'Rumah Sakit', 'Kesehatan', 'Jl. Pahlawan No.10', 'W072'),
('INS040', 'RSUD Sorong', 'Rumah Sakit', 'Kesehatan', 'Jl. Basuki Rahmat No.5', 'W073'),
('INS041', 'Dinas Pertanian Gorontalo', 'Dinas', 'Ekonomi', 'Jl. Cokroaminoto No.17', 'W064'),
('INS042', 'Dinas Perhubungan Tarakan', 'Dinas', 'Transportasi', 'Jl. Jenderal Sudirman No.6', 'W062'),
('INS043', 'Dinas Komunikasi dan Informatika Medan', 'Dinas', 'Informasi', 'Jl. Balai Kota No.20', 'W040'),
('INS044', 'Dinas Perdagangan Samarinda', 'Dinas', 'Ekonomi', 'Jl. Pahlawan No.13', 'W061'),
('INS045', 'Dinas Sosial Kupang', 'Dinas', 'Sosial', 'Jl. Frans Seda No.5', 'W057'),
('INS046', 'Dinas Pariwisata Manado', 'Dinas', 'Pariwisata', 'Jl. Piere Tendean No.22', 'W063'),
('INS047', 'Dinas Lingkungan Hidup Denpasar', 'Dinas', 'Lingkungan', 'Jl. Teuku Umar No.7', 'W055'),
('INS048', 'Dinas Pekerjaan Umum Mamuju', 'Dinas', 'Infrastruktur', 'Jl. Jenderal Sudirman No.9', 'W066'),
('INS049', 'Badan Pengelolaan Keuangan Daerah Banjarmasin', 'Dinas', 'Ekonomi', 'Jl. A. Yani No.18', 'W060'),
('INS050', 'Dinas Kelautan dan Perikanan Ambon', 'Dinas', 'Perikanan', 'Jl. Pattimura No.3', 'W069'),
('INS051', 'RSUD Dr. Zainoel Abidin', 'Rumah Sakit', 'Kesehatan', 'Jl. Moh Daud No.108', 'W039');

--
-- Triggers `instansi`
--
DELIMITER $$
CREATE TRIGGER `trg_instansi_id` BEFORE INSERT ON `instansi` FOR EACH ROW BEGIN
  DECLARE new_id VARCHAR(6);
  DECLARE last_num INT;

  SELECT IFNULL(MAX(CAST(SUBSTRING(Id_Instansi, 4) AS UNSIGNED)), 0) + 1 INTO last_num FROM instansi;
  SET new_id = CONCAT('INS', LPAD(last_num, 3, '0'));
  SET NEW.Id_Instansi = new_id;
END
$$
DELIMITER ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pengaduan`
--

INSERT INTO `pengaduan` (`id_pengaduan`, `judul`, `isi_pengaduan`, `tanggal_pengaduan`, `id_instansi`, `id_akun`) VALUES
('PNG001', 'Pelayanan lambat di RS', 'Pasien mengeluhkan waktu tunggu yang lama di ruang IGD RSUD Banda Aceh.', '2024-02-18', 'INS001', '3171050288107000'),
('PNG002', 'Kebersihan rumah sakit kurang', 'Area ruang tunggu RSUD Medan Sejahtera perlu perawatan kebersihan lebih rutin.', '2024-04-10', 'INS002', '3201250693106100'),
('PNG003', 'Alat medis tidak berfungsi', 'Beberapa alat laboratorium di RSUP Dr. M. Djamil Padang dilaporkan rusak.', '2025-01-22', 'INS003', '5201160284105800'),
('PNG004', 'Kurangnya tenaga medis', 'Pasien sering menunggu lama karena jumlah dokter di IGD Pekanbaru terbatas.', '2025-03-14', 'INS004', '6101285060104900'),
('PNG005', 'Antrian panjang di pendaftaran', 'Pendaftaran pasien di RSUP Jambi Raya sering memakan waktu lama.', '2024-09-05', 'INS005', '6408280126410500'),
('PNG006', 'Lampu jalan mati', 'Beberapa lampu jalan di kawasan Palembang belum diperbaiki meski sudah dilaporkan.', '2025-07-01', 'INS006', '5201021068106800'),
('PNG007', 'Sampah menumpuk di taman kota', 'Warga Bandung mengeluhkan penumpukan sampah di sekitar Taman Kota.', '2024-08-15', 'INS007', '3301100379107200'),
('PNG008', 'Kurangnya promosi pariwisata', 'Potensi wisata lokal di Denpasar masih kurang dikenal masyarakat luas.', '2024-12-10', 'INS008', '7101108194107600'),
('PNG009', 'Jalan rusak parah', 'Beberapa ruas jalan utama Surabaya mengalami kerusakan dan berlubang.', '2025-02-05', 'INS009', '6101100476105900'),
('PNG010', 'Kapal patroli tidak aktif', 'Nelayan melaporkan kurangnya patroli laut di wilayah Makassar.', '2024-06-28', 'INS010', '7101251296105600'),
('PNG011', 'Guru sering tidak hadir', 'Beberapa siswa melaporkan guru sering tidak hadir tanpa pemberitahuan.', '2024-09-22', 'INS011', '3201190772105100'),
('PNG012', 'Kurangnya bantuan sosial', 'Masyarakat miskin belum seluruhnya menerima bantuan sosial di Yogyakarta.', '2025-03-07', 'INS012', '6408191262107500'),
('PNG013', 'Website pemerintah sering error', 'Portal pelayanan publik Jakarta Selatan sering tidak dapat diakses.', '2024-11-01', 'INS013', '5101220198106300'),
('PNG014', 'Program UMKM belum merata', 'Banyak pelaku usaha kecil belum mendapat akses bantuan dari Dinas Ekonomi Manado.', '2025-04-02', 'INS014', '6101220685106900'),
('PNG015', 'Harga pasar melonjak', 'Pedagang di Pontianak melaporkan harga bahan pokok naik tanpa pengawasan.', '2024-10-16', 'INS015', '5201261283104800'),
('PNG016', 'Puskesmas kekurangan obat', 'Beberapa Puskesmas di Ambon dilaporkan kehabisan stok obat penting.', '2025-01-12', 'INS016', '6408110274106500'),
('PNG017', 'Kemacetan di pelabuhan', 'Kendaraan menumpuk di area pelabuhan Ternate karena kurangnya petugas.', '2024-12-25', 'INS017', '3301140672106200'),
('PNG018', 'Tambak ikan tercemar', 'Air di area tambak ikan Banjarmasin dilaporkan tercemar limbah industri.', '2024-05-17', 'INS018', '3171100673104000'),
('PNG019', 'Sampah menumpuk di sungai', 'Warga Jayapura melaporkan sampah di sungai belum dibersihkan.', '2025-08-03', 'INS019', '5102141098105400'),
('PNG020', 'Objek wisata tidak terawat', 'Warga Mataram menilai fasilitas wisata belum mendapat perhatian rutin.', '2024-07-19', 'INS020', '7102200995106700'),
('PNG021', 'Fasilitas kampus rusak', 'Beberapa gedung di Universitas Negeri Surabaya perlu perbaikan segera.', '2025-02-11', 'INS021', '5101040689107300'),
('PNG022', 'Kegiatan akademik terganggu', 'Beberapa kelas di Universitas Negeri Yogyakarta dibatalkan karena listrik padam.', '2024-08-03', 'INS022', '3201161076107100'),
('PNG023', 'Sarana penelitian rusak', 'Laboratorium Universitas Hasanuddin membutuhkan alat baru.', '2025-05-05', 'INS023', '3301240287105200'),
('PNG024', 'Ruang kuliah sempit', 'Mahasiswa Politeknik Negeri Bandung meminta tambahan ruang belajar.', '2024-11-22', 'INS024', '5101221178105300'),
('PNG025', 'Server akademik down', 'Mahasiswa Udayana sulit mengakses sistem KRS online.', '2025-03-15', 'INS025', '5201160262107800'),
('PNG026', 'WC sekolah kotor', 'Fasilitas WC di SMK Negeri 1 Balikpapan kurang perawatan.', '2025-04-25', 'INS026', '6101050991079000'),
('PNG027', 'Guru tidak disiplin', 'Guru SMA Negeri 3 Denpasar sering datang terlambat.', '2024-09-30', 'INS027', '7101050599106600'),
('PNG028', 'Fasilitas rusak', 'Peralatan komputer di SMK Swasta Pekanbaru sering rusak.', '2025-01-28', 'INS028', '3171240161105000'),
('PNG029', 'Kebersihan sekolah buruk', 'Siswa SMA Negeri 2 Bandung mengeluhkan kondisi kelas yang kotor.', '2024-07-09', 'INS029', '3201150497104100'),
('PNG030', 'Air tidak mengalir di sekolah', 'Air di kamar mandi SMK Negeri 4 Surabaya tidak mengalir selama seminggu.', '2025-05-10', 'INS030', '5201160284105800'),
('PNG031', 'Data statistik belum diperbarui', 'Laporan data ekonomi Kota Medan belum diperbarui sejak tahun lalu.', '2024-06-20', 'INS031', '7101240477104600'),
('PNG032', 'Bantuan bencana terlambat', 'Warga Bandar Lampung belum menerima bantuan pasca banjir.', '2024-12-18', 'INS032', '6101100476105900'),
('PNG033', 'Pelayanan lambat di kantor pajak', 'Masyarakat mengeluhkan antrean panjang di Kantor Pajak Bandung.', '2025-03-05', 'INS033', '3201250693106100'),
('PNG034', 'Layanan paspor online error', 'Sistem pendaftaran paspor online sering tidak bisa diakses.', '2024-09-14', 'INS034', '5102070841044000'),
('PNG035', 'Pelayanan publik tidak ramah', 'Petugas di Kantor Pelayanan Publik Yogyakarta dinilai kurang sopan.', '2025-02-27', 'INS035', '5201160284105800'),
('PNG036', 'Obat kosong di rumah sakit', 'RSUD Pontianak dilaporkan kehabisan obat antibiotik.', '2024-05-02', 'INS036', '7102220693104700'),
('PNG037', 'Fasilitas rusak', 'Lift RSUD Tarakan tidak berfungsi sejak dua minggu lalu.', '2025-06-11', 'INS037', '6408280274104500'),
('PNG038', 'Pelayanan pasien lambat', 'Warga Kendari mengeluhkan waktu tunggu lama di RSUD Kendari.', '2024-03-30', 'INS038', '5201021068106800'),
('PNG039', 'Kebersihan ruang inap buruk', 'RSUD Manokwari perlu peningkatan layanan kebersihan ruang pasien.', '2025-04-15', 'INS039', '6408191262107500'),
('PNG040', 'Fasilitas rusak di radiologi', 'Peralatan radiologi RSUD Sorong tidak berfungsi dengan baik.', '2024-08-28', 'INS040', '3301070176104200'),
('PNG041', 'Harga pupuk naik', 'Petani Gorontalo kesulitan membeli pupuk karena harga melonjak.', '2025-02-19', 'INS041', '5102141098105400'),
('PNG042', 'Keterlambatan kapal feri', 'Penumpang mengeluhkan keterlambatan keberangkatan kapal di Tarakan.', '2024-10-06', 'INS042', '3201150497104100'),
('PNG043', 'Website pemerintah error', 'Portal pelayanan publik Medan sering tidak bisa diakses.', '2024-11-12', 'INS043', '3171120269106000'),
('PNG044', 'Harga bahan pokok naik', 'Pedagang di Samarinda melaporkan lonjakan harga tanpa pengawasan.', '2025-06-07', 'INS044', '7101251296105600'),
('PNG045', 'Bantuan sosial tidak merata', 'Warga Kupang banyak yang belum menerima bantuan sosial.', '2024-04-01', 'INS045', '5102170968106400'),
('PNG046', 'Objek wisata kotor', 'Objek wisata di Manado terlihat kotor dan tidak terurus.', '2024-05-28', 'INS046', '6101285060104900'),
('PNG047', 'Sampah di pantai menumpuk', 'Pantai Denpasar penuh sampah setiap akhir pekan.', '2025-07-20', 'INS047', '3171050288107000'),
('PNG048', 'Jalan desa rusak', 'Warga Mamuju mengeluhkan jalan desa yang belum diperbaiki.', '2025-01-17', 'INS048', '3301240287105200'),
('PNG049', 'Laporan keuangan belum diumumkan', 'Masyarakat belum dapat mengakses laporan keuangan Banjarmasin.', '2024-03-21', 'INS049', '6408280274104500'),
('PNG050', 'Penangkapan ikan berlebih', 'Nelayan Ambon mengeluhkan praktik penangkapan ikan ilegal.', '2025-05-09', 'INS050', '7102160293105700');

--
-- Triggers `pengaduan`
--
DELIMITER $$
CREATE TRIGGER `trg_pengaduan_id` BEFORE INSERT ON `pengaduan` FOR EACH ROW BEGIN
  DECLARE new_id VARCHAR(6);
  DECLARE last_num INT;

  SELECT IFNULL(MAX(CAST(SUBSTRING(Id_Pengaduan, 4) AS UNSIGNED)), 0) + 1 INTO last_num FROM pengaduan;
  SET new_id = CONCAT('PNG', LPAD(last_num, 3, '0'));
  SET NEW.Id_Pengaduan = new_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_akun` varchar(16) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
('3301100379107200', 'Jl. Proklamasi No.9 Jayapura'),
('3301140672106200', 'Jl. Imam Bonjol No.10 Denpasar'),
('3301240287105200', 'Jl. Jend. Sudirman No.12 Bandung'),
('5101040689107300', 'Jl. Pattimura No.11 Ambon'),
('5101161194104300', 'Jl. Cendana No.2 Tenggarong'),
('5101220198106300', 'Jl. Dahlia No.11 Samarinda'),
('5101221178105300', 'Jl. Gatot Subroto No.18 Jakarta'),
('5102070841044000', 'Jl. Basuki Rahmat No.3 Bandung'),
('5102141098105400', 'Jl. S Parman No.22 Balikpapan'),
('5102151291107400', 'Jl. Sultan Serdang No.7 Kendari'),
('5102170968106400', 'Jl. Gunung Agung No.12 Denpasar'),
('5201021068106800', 'Jl. Jenderal Sudirman No.16 Bogor'),
('5201160262107800', 'Jl. Margonda Raya No.7 Depok'),
('5201160284105800', 'Jl. Pemuda No.6 Semarang'),
('5201261283104800', 'Jl. Urip Sumoharjo No.7 Makassar'),
('6101050991079000', 'Jl. Jend. Sudirman No.8 Bekasi'),
('6101100476105900', 'Jl. Basuki Rahmat No.7 Surabaya'),
('6101220685106900', 'Jl. Basuki Rahmat No.17 Malang'),
('6101285060104900', 'Jl. Kol. H. Burlian No.9 Palembang'),
('6408110274106500', 'Jl. Veteran No.13 Bandung'),
('6408191262107500', 'Jl. Ahmad Yani No.3 Palangkaraya'),
('6408280126410500', 'Jl. Ahmad Yani No.3 Samarinda'),
('6408280274104500', 'Jl. Veteran No.9 Surabaya'),
('7101050599106600', 'Jl. Wahid Hasyim No.14 Balikpapan'),
('7101108194107600', 'Jl. Sultan Ternate No.5 Ternate'),
('7101240477104600', 'Jl. Diponegoro No.11 Yogyakarta'),
('7101251296105600', 'Jl. Bhayangkara No.4 Banjarmasin'),
('7102160293105700', 'Jl. MT Haryono No.5 Bandung'),
('7102180681107700', 'Jl. Cilegon Raya No.6 Cilegon'),
('7102200995106700', 'Jl. Gajah Mada No.15 Pontianak'),
('7102220693104700', 'Jl. Teuku Umar No.15 Denpasar');

-- --------------------------------------------------------

--
-- Table structure for table `tanggapan`
--

CREATE TABLE `tanggapan` (
  `id_tanggapan` varchar(6) NOT NULL,
  `status_keluhan` enum('Diteruskan','Ditindaklanjuti','Diselesaikan') NOT NULL,
  `isi_tanggapan` text NOT NULL,
  `tanggal_tanggapan` date NOT NULL,
  `id_pengaduan` varchar(6) NOT NULL,
  `id_akun` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tanggapan`
--

INSERT INTO `tanggapan` (`id_tanggapan`, `status_keluhan`, `isi_tanggapan`, `tanggal_tanggapan`, `id_pengaduan`, `id_akun`) VALUES
('TGP001', 'Ditindaklanjuti', 'Laporan sudah diterima dan sedang kami proses bersama tim medis.', '2024-02-21', 'PNG001', 'APP0004'),
('TGP002', 'Diselesaikan', 'Kebersihan telah ditingkatkan dan petugas kebersihan ditambah.', '2024-04-14', 'PNG002', 'APP0009'),
('TGP003', 'Diteruskan', 'Masalah alat medis sudah diteruskan ke bagian pengadaan.', '2025-01-25', 'PNG003', 'APP0011'),
('TGP004', 'Ditindaklanjuti', 'Permintaan penambahan dokter telah disampaikan ke kepala RS.', '2025-03-17', 'PNG004', 'APP0002'),
('TGP005', 'Diselesaikan', 'Sistem pendaftaran telah diperbaiki dan kini lebih cepat.', '2024-09-08', 'PNG005', 'APP0008'),
('TGP006', 'Diteruskan', 'Laporan sudah diteruskan ke bagian penerangan jalan umum.', '2025-07-05', 'PNG006', 'APP0016'),
('TGP007', 'Ditindaklanjuti', 'Tim kebersihan sudah dikirim ke lokasi taman kota.', '2024-08-18', 'PNG007', 'APP0014'),
('TGP008', 'Diselesaikan', 'Program promosi wisata sudah dilaksanakan kembali.', '2024-12-14', 'PNG008', 'APP0007'),
('TGP009', 'Ditindaklanjuti', 'Perbaikan jalan sedang dikerjakan oleh kontraktor.', '2025-02-10', 'PNG009', 'APP0010'),
('TGP010', 'Diteruskan', 'Permintaan patroli laut sudah diteruskan ke kepala dinas.', '2024-07-02', 'PNG010', 'APP0003'),
('TGP011', 'Diselesaikan', 'Guru yang tidak hadir telah mendapat teguran resmi.', '2024-09-26', 'PNG011', 'APP0005'),
('TGP012', 'Ditindaklanjuti', 'Distribusi bantuan sosial sedang diverifikasi ulang.', '2025-03-12', 'PNG012', 'APP0015'),
('TGP013', 'Diselesaikan', 'Website pemerintah sudah diperbaiki dan kembali aktif.', '2024-11-04', 'PNG013', 'APP0018'),
('TGP014', 'Ditindaklanjuti', 'Program UMKM tahap dua sedang dijalankan.', '2025-04-06', 'PNG014', 'APP0009'),
('TGP015', 'Diteruskan', 'Masalah harga pasar sudah dilaporkan ke bagian ekonomi.', '2024-10-20', 'PNG015', 'APP0017'),
('TGP016', 'Diselesaikan', 'Stok obat sudah dikirim ke seluruh Puskesmas Ambon.', '2025-01-16', 'PNG016', 'APP0006'),
('TGP017', 'Ditindaklanjuti', 'Koordinasi dilakukan dengan pelabuhan setempat.', '2024-12-29', 'PNG017', 'APP0013'),
('TGP018', 'Diteruskan', 'Masalah tambak sudah disampaikan ke bagian lingkungan.', '2024-05-21', 'PNG018', 'APP0001'),
('TGP019', 'Ditindaklanjuti', 'Tim kebersihan dikirim untuk membersihkan area sungai.', '2025-08-08', 'PNG019', 'APP0010'),
('TGP020', 'Diselesaikan', 'Objek wisata sudah dibersihkan dan fasilitas diperbaiki.', '2024-07-23', 'PNG020', 'APP0002'),
('TGP021', 'Ditindaklanjuti', 'Perbaikan fasilitas kampus sedang berlangsung.', '2025-02-14', 'PNG021', 'APP0011'),
('TGP022', 'Diselesaikan', 'Permasalahan listrik telah diselesaikan bersama PLN.', '2024-08-06', 'PNG022', 'APP0012'),
('TGP023', 'Ditindaklanjuti', 'Permintaan alat penelitian baru sedang diajukan.', '2025-05-09', 'PNG023', 'APP0019'),
('TGP024', 'Diteruskan', 'Usulan ruang tambahan sudah diteruskan ke direktur.', '2024-11-26', 'PNG024', 'APP0008'),
('TGP025', 'Diselesaikan', 'Server akademik sudah kembali berfungsi normal.', '2025-03-19', 'PNG025', 'APP0013'),
('TGP026', 'Ditindaklanjuti', 'Petugas kebersihan telah melakukan perbaikan fasilitas.', '2025-04-28', 'PNG026', 'APP0009'),
('TGP027', 'Diselesaikan', 'Guru terkait sudah diperingatkan secara resmi.', '2024-10-04', 'PNG027', 'APP0014'),
('TGP028', 'Diteruskan', 'Permintaan perbaikan alat sudah dikirim ke kepala sekolah.', '2025-02-01', 'PNG028', 'APP0016'),
('TGP029', 'Diselesaikan', 'Petugas kebersihan sudah membersihkan seluruh area sekolah.', '2024-07-12', 'PNG029', 'APP0005'),
('TGP030', 'Ditindaklanjuti', 'Masalah air sedang ditangani oleh dinas terkait.', '2025-05-14', 'PNG030', 'APP0010'),
('TGP031', 'Diteruskan', 'Data ekonomi sedang diperbarui oleh bagian statistik.', '2024-06-25', 'PNG031', 'APP0018'),
('TGP032', 'Ditindaklanjuti', 'Bantuan sudah dikirim ke lokasi terdampak banjir.', '2024-12-21', 'PNG032', 'APP0003'),
('TGP033', 'Diselesaikan', 'Kapasitas pelayanan pajak telah ditingkatkan.', '2025-03-09', 'PNG033', 'APP0015'),
('TGP034', 'Ditindaklanjuti', 'Server pendaftaran paspor sedang diperbarui.', '2024-09-17', 'PNG034', 'APP0012'),
('TGP035', 'Diselesaikan', 'Petugas telah diberi pelatihan etika pelayanan.', '2025-03-02', 'PNG035', 'APP0007'),
('TGP036', 'Diteruskan', 'Laporan kekurangan obat diteruskan ke bagian logistik.', '2024-05-05', 'PNG036', 'APP0004'),
('TGP037', 'Diselesaikan', 'Lift sudah diperbaiki dan kembali beroperasi.', '2025-06-15', 'PNG037', 'APP0019'),
('TGP038', 'Ditindaklanjuti', 'Prosedur layanan pasien sedang dievaluasi.', '2024-04-03', 'PNG038', 'APP0010'),
('TGP039', 'Diselesaikan', 'Kebersihan ruang pasien sudah diperbaiki.', '2025-04-19', 'PNG039', 'APP0006'),
('TGP040', 'Ditindaklanjuti', 'Teknisi telah memperbaiki peralatan radiologi.', '2024-09-01', 'PNG040', 'APP0014'),
('TGP041', 'Diselesaikan', 'Harga pupuk sudah distabilkan oleh pemerintah daerah.', '2025-02-23', 'PNG041', 'APP0005'),
('TGP042', 'Ditindaklanjuti', 'Penjadwalan kapal feri sudah diperbaiki.', '2024-10-10', 'PNG042', 'APP0016'),
('TGP043', 'Diteruskan', 'Permasalahan website diteruskan ke tim IT pusat.', '2024-11-15', 'PNG043', 'APP0018'),
('TGP044', 'Diselesaikan', 'Harga bahan pokok kini sudah diawasi rutin.', '2025-06-11', 'PNG044', 'APP0013'),
('TGP045', 'Ditindaklanjuti', 'Verifikasi data penerima bantuan sedang dilakukan.', '2024-04-04', 'PNG045', 'APP0002'),
('TGP046', 'Diselesaikan', 'Objek wisata sudah dibersihkan dan dijaga.', '2024-06-01', 'PNG046', 'APP0010'),
('TGP047', 'Ditindaklanjuti', 'Pembersihan pantai dilakukan setiap akhir pekan.', '2025-07-25', 'PNG047', 'APP0011'),
('TGP048', 'Diteruskan', 'Laporan sudah diteruskan ke bidang infrastruktur.', '2025-01-21', 'PNG048', 'APP0009'),
('TGP049', 'Ditindaklanjuti', 'Laporan keuangan sedang diunggah ke situs resmi.', '2024-03-25', 'PNG049', 'APP0015'),
('TGP050', 'Diselesaikan', 'Nelayan ilegal telah ditindak oleh aparat setempat.', '2025-05-12', 'PNG050', 'APP0017');

--
-- Triggers `tanggapan`
--
DELIMITER $$
CREATE TRIGGER `trg_tanggapan_id` BEFORE INSERT ON `tanggapan` FOR EACH ROW BEGIN
  DECLARE new_id VARCHAR(6);
  DECLARE last_num INT;

  SELECT IFNULL(MAX(CAST(SUBSTRING(Id_Tanggapan, 4) AS UNSIGNED)), 0) + 1 INTO last_num FROM tanggapan;
  SET new_id = CONCAT('TPG', LPAD(last_num, 3, '0'));
  SET NEW.Id_Tanggapan = new_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `wilayah`
--

CREATE TABLE `wilayah` (
  `id_wilayah` varchar(6) NOT NULL,
  `nama_wilayah` varchar(100) NOT NULL,
  `tingkat` enum('Provinsi','Kabupaten/Kota') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `wilayah`
--

INSERT INTO `wilayah` (`id_wilayah`, `nama_wilayah`, `tingkat`) VALUES
('W001', 'Provinsi Aceh', 'Provinsi'),
('W002', 'Provinsi Sumatera Utara', 'Provinsi'),
('W003', 'Provinsi Sumatera Barat', 'Provinsi'),
('W004', 'Provinsi Riau', 'Provinsi'),
('W005', 'Provinsi Kepulauan Riau', 'Provinsi'),
('W006', 'Provinsi Jambi', 'Provinsi'),
('W007', 'Provinsi Bengkulu', 'Provinsi'),
('W008', 'Provinsi Sumatera Selatan', 'Provinsi'),
('W009', 'Provinsi Bangka Belitung', 'Provinsi'),
('W010', 'Provinsi Lampung', 'Provinsi'),
('W011', 'Provinsi Banten', 'Provinsi'),
('W012', 'Provinsi DKI Jakarta', 'Provinsi'),
('W013', 'Provinsi Jawa Barat', 'Provinsi'),
('W014', 'Provinsi Jawa Tengah', 'Provinsi'),
('W015', 'Provinsi DI Yogyakarta', 'Provinsi'),
('W016', 'Provinsi Jawa Timur', 'Provinsi'),
('W017', 'Provinsi Bali', 'Provinsi'),
('W018', 'Provinsi Nusa Tenggara Barat', 'Provinsi'),
('W019', 'Provinsi Nusa Tenggara Timur', 'Provinsi'),
('W020', 'Provinsi Kalimantan Barat', 'Provinsi'),
('W021', 'Provinsi Kalimantan Tengah', 'Provinsi'),
('W022', 'Provinsi Kalimantan Selatan', 'Provinsi'),
('W023', 'Provinsi Kalimantan Timur', 'Provinsi'),
('W024', 'Provinsi Kalimantan Utara', 'Provinsi'),
('W025', 'Provinsi Sulawesi Utara', 'Provinsi'),
('W026', 'Provinsi Gorontalo', 'Provinsi'),
('W027', 'Provinsi Sulawesi Tengah', 'Provinsi'),
('W028', 'Provinsi Sulawesi Barat', 'Provinsi'),
('W029', 'Provinsi Sulawesi Selatan', 'Provinsi'),
('W030', 'Provinsi Sulawesi Tenggara', 'Provinsi'),
('W031', 'Provinsi Maluku', 'Provinsi'),
('W032', 'Provinsi Maluku Utara', 'Provinsi'),
('W033', 'Provinsi Papua', 'Provinsi'),
('W034', 'Provinsi Papua Barat', 'Provinsi'),
('W035', 'Provinsi Papua Barat Daya', 'Provinsi'),
('W036', 'Provinsi Papua Pegunungan', 'Provinsi'),
('W037', 'Provinsi Papua Tengah', 'Provinsi'),
('W038', 'Provinsi Papua Selatan', 'Provinsi'),
('W039', 'Kota Banda Aceh', 'Kabupaten/Kota'),
('W040', 'Kota Medan', 'Kabupaten/Kota'),
('W041', 'Kota Padang', 'Kabupaten/Kota'),
('W042', 'Kota Pekanbaru', 'Kabupaten/Kota'),
('W043', 'Kota Tanjungpinang', 'Kabupaten/Kota'),
('W044', 'Kota Jambi', 'Kabupaten/Kota'),
('W045', 'Kota Bengkulu', 'Kabupaten/Kota'),
('W046', 'Kota Palembang', 'Kabupaten/Kota'),
('W047', 'Kota Pangkalpinang', 'Kabupaten/Kota'),
('W048', 'Kota Bandar Lampung', 'Kabupaten/Kota'),
('W049', 'Kota Serang', 'Kabupaten/Kota'),
('W050', 'Kota Jakarta Selatan', 'Kabupaten/Kota'),
('W051', 'Kota Bandung', 'Kabupaten/Kota'),
('W052', 'Kota Semarang', 'Kabupaten/Kota'),
('W053', 'Kabupaten Sleman', 'Kabupaten/Kota'),
('W054', 'Kota Surabaya', 'Kabupaten/Kota'),
('W055', 'Kota Denpasar', 'Kabupaten/Kota'),
('W056', 'Kota Mataram', 'Kabupaten/Kota'),
('W057', 'Kota Kupang', 'Kabupaten/Kota'),
('W058', 'Kota Pontianak', 'Kabupaten/Kota'),
('W059', 'Kota Palangkaraya', 'Kabupaten/Kota'),
('W060', 'Kota Banjarmasin', 'Kabupaten/Kota'),
('W061', 'Kota Balikpapan', 'Kabupaten/Kota'),
('W062', 'Kota Tarakan', 'Kabupaten/Kota'),
('W063', 'Kota Manado', 'Kabupaten/Kota'),
('W064', 'Kota Gorontalo', 'Kabupaten/Kota'),
('W065', 'Kota Palu', 'Kabupaten/Kota'),
('W066', 'Kota Mamuju', 'Kabupaten/Kota'),
('W067', 'Kota Makassar', 'Kabupaten/Kota'),
('W068', 'Kota Kendari', 'Kabupaten/Kota'),
('W069', 'Kota Ambon', 'Kabupaten/Kota'),
('W070', 'Kota Ternate', 'Kabupaten/Kota'),
('W071', 'Kota Jayapura', 'Kabupaten/Kota'),
('W072', 'Kota Manokwari', 'Kabupaten/Kota'),
('W073', 'Kota Sorong', 'Kabupaten/Kota'),
('W074', 'Kabupaten Jayawijaya', 'Kabupaten/Kota'),
('W075', 'Kota Nabire', 'Kabupaten/Kota'),
('W076', 'Kota Merauke', 'Kabupaten/Kota');

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
  ADD KEY `id_instansi` (`id_instansi`),
  ADD KEY `fk_anggaran_akun` (`id_akun`);

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
  ADD KEY `id_akun` (`id_akun`);

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
  ADD KEY `id_akun` (`id_akun`);

--
-- Indexes for table `wilayah`
--
ALTER TABLE `wilayah`
  ADD PRIMARY KEY (`id_wilayah`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `anggaran`
--
ALTER TABLE `anggaran`
  ADD CONSTRAINT `anggaran_ibfk_1` FOREIGN KEY (`id_instansi`) REFERENCES `instansi` (`id_instansi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_anggaran_akun` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`);

--
-- Constraints for table `instansi`
--
ALTER TABLE `instansi`
  ADD CONSTRAINT `instansi_ibfk_1` FOREIGN KEY (`wilayah_id_wilayah`) REFERENCES `wilayah` (`id_wilayah`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD CONSTRAINT `pengaduan_ibfk_1` FOREIGN KEY (`id_instansi`) REFERENCES `instansi` (`id_instansi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pengaduan_ibfk_2` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `pengguna_ibfk_1` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tanggapan`
--
ALTER TABLE `tanggapan`
  ADD CONSTRAINT `tanggapan_ibfk_1` FOREIGN KEY (`id_pengaduan`) REFERENCES `pengaduan` (`id_pengaduan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tanggapan_ibfk_2` FOREIGN KEY (`id_akun`) REFERENCES `akun` (`id_akun`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
