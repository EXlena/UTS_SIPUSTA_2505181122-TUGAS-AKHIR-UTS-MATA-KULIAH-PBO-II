package uts_sipusta_nim;

import eksepsi.PustakaException;
import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Majalah;

public class Main {

    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // ===== Data uji wajib (6 koleksi) =====
        BukuCetak bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false);
        BukuCetak bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true);
        // Nomor rak majalah tidak ada di data uji, jadi ditentukan sendiri
        Majalah mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", true, "C-01");
        Majalah mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", false, "C-02");
        BerkasDigital bd1 = new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15,
                "unduh.polmed.ac.id/bd001");
        BerkasDigital bd2 = new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8,
                "unduh.polmed.ac.id/bd002");

        katalog.tambah(bk1);
        katalog.tambah(bk2);
        katalog.tambah(mj1);
        katalog.tambah(mj2);
        katalog.tambah(bd1);
        katalog.tambah(bd2);

        // ===== Soal 2: interface Terarsip (hanya BukuCetak dan Majalah) =====
        System.out.println("=== Ringkasan Arsip (Terarsip) ===");
        System.out.println(bk1.getJudul() + " -> " + bk1.ringkasanArsip());
        System.out.println(bk2.getJudul() + " -> " + bk2.ringkasanArsip());
        System.out.println(mj1.getJudul() + " -> " + mj1.ringkasanArsip());
        System.out.println(mj2.getJudul() + " -> " + mj2.ringkasanArsip());

        // ===== Soal 3: cetakStatus polimorfik =====
        System.out.println("\n=== Status Seluruh Koleksi ===");
        katalog.cetakStatus();

        // ===== Soal 4: pengurutan dengan Comparator =====
        System.out.println("\n=== Setelah Diurutkan (Layak dulu, lalu Judul) ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // Contoh aturan lain dari luar: urut berdasarkan tahun terbit (lambda)
        System.out.println("\n=== Diurutkan Berdasarkan Tahun Terbit ===");
        katalog.urut((a, b) -> Integer.compare(a.getTahunTerbit(), b.getTahunTerbit()));
        katalog.cetakStatus();

        // ===== Soal 5: peminjaman dan eksepsi =====
        System.out.println("\n=== Uji Peminjaman ===");
        String[] kodeUji = {"BK-001", "BK-001", "BK-002", "MJ-001", "MJ-002", "BD-001", "XX-999"};
        for (String kode : kodeUji) {
            System.out.println("Meminjam " + kode + ":");
            try {
                katalog.pinjam(kode);
            } catch (PustakaException e) {
                System.out.println("Gagal: " + e.getMessage());
            }
        }

        // ===== Soal 6: ekspor ke katalog.txt =====
        System.out.println("\n=== Ekspor Katalog ===");
        katalog.urut(new UrutLayakLaluJudul());
        new EksporKatalog().ekspor(katalog);
    }
}
