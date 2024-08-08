-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 08, 2024 at 10:02 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbrumahsakit`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_biayatbh`
--

CREATE TABLE `tbl_biayatbh` (
  `jenis_biaya` varchar(100) NOT NULL,
  `jumlah_biaya` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_biayatbh`
--

INSERT INTO `tbl_biayatbh` (`jenis_biaya`, `jumlah_biaya`) VALUES
('Ibuprofen', 12000),
('Rawat Inap', 250000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_dokter`
--

CREATE TABLE `tbl_dokter` (
  `kode_dokter` varchar(11) NOT NULL,
  `nama_dokter` varchar(100) NOT NULL,
  `no_str` int(20) NOT NULL,
  `no_tlp` int(30) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `alamat_dokter` varchar(100) NOT NULL,
  `kode_poli` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_dokter`
--

INSERT INTO `tbl_dokter` (`kode_dokter`, `nama_dokter`, `no_str`, `no_tlp`, `jenis_kelamin`, `alamat_dokter`, `kode_poli`) VALUES
('D00001', 'Luca', 2233, 62, 'P', 'Jl', 'PO00001'),
('D00002', 'Adre', 64332, 82243, 'L', 'Jl. Sukabumi', 'PO00006');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hitung`
--

CREATE TABLE `tbl_hitung` (
  `id_hitung` int(20) NOT NULL,
  `no_reff` varchar(20) NOT NULL,
  `jenis_biaya` varchar(100) NOT NULL,
  `jumlah_biaya` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE `tbl_login` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_telp` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`username`, `password`, `nama`, `no_telp`) VALUES
('Gis', '123', 'Gisel', 88883),
('Jun', '123', 'Jun', 88899),
('la', '12', 'Lala', 888),
('She', '123', 'Sheryl', 8888888);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pasien`
--

CREATE TABLE `tbl_pasien` (
  `no_rm` varchar(10) NOT NULL,
  `nama_pasien` varchar(100) NOT NULL,
  `umur_pasien` int(2) NOT NULL,
  `alamat_pasien` varchar(100) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `no_tlp` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_pasien`
--

INSERT INTO `tbl_pasien` (`no_rm`, `nama_pasien`, `umur_pasien`, `alamat_pasien`, `tgl_lahir`, `jenis_kelamin`, `no_tlp`) VALUES
('R00001', 'Lula', 2, 'Jl. Permata', '2022-07-30', 'P', 62883),
('R00002', 'Jasmine', 15, 'Jl. Indah', '2008-08-08', 'P', 888883);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_poli`
--

CREATE TABLE `tbl_poli` (
  `kode_poli` varchar(10) NOT NULL,
  `nama_poli` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_poli`
--

INSERT INTO `tbl_poli` (`kode_poli`, `nama_poli`) VALUES
('PO00001', 'Umum'),
('PO00002', 'Bedah'),
('PO00003', 'Anak'),
('PO00004', 'Ortopedi'),
('PO00005', 'Penyakit Dalam'),
('PO00006', 'Gigi'),
('PO00007', 'Gizi');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `no_reff` varchar(10) NOT NULL,
  `no_rm` varchar(10) NOT NULL,
  `nama_pasien` varchar(100) NOT NULL,
  `kode_poli` varchar(10) NOT NULL,
  `nama_poli` varchar(100) NOT NULL,
  `nama_dokter` varchar(100) NOT NULL,
  `jenis_biaya` varchar(100) NOT NULL,
  `jumlah_biaya` int(50) NOT NULL,
  `bayar` int(50) NOT NULL,
  `kembali` int(50) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_transaksi`
--

INSERT INTO `tbl_transaksi` (`no_reff`, `no_rm`, `nama_pasien`, `kode_poli`, `nama_poli`, `nama_dokter`, `jenis_biaya`, `jumlah_biaya`, `bayar`, `kembali`, `tanggal`) VALUES
('T00001', 'R00001', 'Lula', 'PO00001', 'Umum', 'Luca', 'Paracetamol', 6000, 300000, 44000, '2024-08-07'),
('T00001', 'R00001', 'Lula', 'PO00001', 'Umum', 'Luca', 'Rawat Inap', 250000, 300000, 44000, '2024-08-07'),
('T00002', 'R00001', 'Lula', 'PO00001', 'Umum', 'Luca', 'Paracetamol', 6000, 10000, 4000, '2024-08-01'),
('T00003', 'R00001', 'Lula', 'PO00001', 'Umum', 'Luca', 'Paracetamol', 6000, 10000, 4000, '2024-08-01'),
('T00004', 'R00001', 'Lula', 'PO00001', 'Umum', 'Luca', 'Paracetamol', 6000, 20000, 14000, '2024-08-08'),
('T00005', 'R00001', 'Lula', 'PO00006', 'Gigi', 'Adre', 'Rawat Inap', 250000, 700000, 188000, '2024-08-08'),
('T00005', 'R00001', 'Lula', 'PO00006', 'Gigi', 'Adre', 'Paracetamol', 6000, 700000, 188000, '2024-08-08'),
('T00005', 'R00001', 'Lula', 'PO00006', 'Gigi', 'Adre', 'Paracetamol', 6000, 700000, 188000, '2024-08-08'),
('T00005', 'R00001', 'Lula', 'PO00006', 'Gigi', 'Adre', 'Rawat Inap', 250000, 700000, 188000, '2024-08-08'),
('T00006', 'R00002', 'Jasmine', 'PO00001', 'Umum', 'Luca', 'Ibuprofen', 12000, 300000, 38000, '2024-08-08'),
('T00006', 'R00002', 'Jasmine', 'PO00001', 'Umum', 'Luca', 'Rawat Inap', 250000, 300000, 38000, '2024-08-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_biayatbh`
--
ALTER TABLE `tbl_biayatbh`
  ADD PRIMARY KEY (`jenis_biaya`);

--
-- Indexes for table `tbl_dokter`
--
ALTER TABLE `tbl_dokter`
  ADD PRIMARY KEY (`kode_dokter`);

--
-- Indexes for table `tbl_hitung`
--
ALTER TABLE `tbl_hitung`
  ADD PRIMARY KEY (`id_hitung`);

--
-- Indexes for table `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tbl_pasien`
--
ALTER TABLE `tbl_pasien`
  ADD PRIMARY KEY (`no_rm`);

--
-- Indexes for table `tbl_poli`
--
ALTER TABLE `tbl_poli`
  ADD PRIMARY KEY (`kode_poli`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_hitung`
--
ALTER TABLE `tbl_hitung`
  MODIFY `id_hitung` int(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
