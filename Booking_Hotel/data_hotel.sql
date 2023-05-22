-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Bulan Mei 2023 pada 06.29
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data_hotel`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_data_hotel`
--

CREATE TABLE `tbl_data_hotel` (
  `id` int(1) NOT NULL,
  `no_kamar` varchar(15) NOT NULL,
  `nm_pelanggan` varchar(15) NOT NULL,
  `no_telp` varchar(255) NOT NULL,
  `lm_tinggal` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_data_hotel`
--

INSERT INTO `tbl_data_hotel` (`id`, `no_kamar`, `nm_pelanggan`, `no_telp`, `lm_tinggal`) VALUES
(1, '015', 'Supardi', '090988121', '10'),
(4, '012', 'Merginal', '091233', '100'),
(5, '1213', 'Arek', '0992838', '90');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_data_hotel`
--
ALTER TABLE `tbl_data_hotel`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_data_hotel`
--
ALTER TABLE `tbl_data_hotel`
  MODIFY `id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
