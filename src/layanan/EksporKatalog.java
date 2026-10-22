package layanan;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.Koleksi;

/**
 * Soal 6: menulis seluruh koleksi ke berkas katalog.txt dengan kolom sejajar.
 * Aliran ditutup otomatis memakai try-with-resources.
 */
public class EksporKatalog {

    private String namaBerkas;

    public EksporKatalog() {
        this("katalog.txt");
    }

    public EksporKatalog(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void ekspor(KatalogPerpustakaan katalog) {
        // Lebar kolom judul disesuaikan dengan judul terpanjang
        int lebarJudul = "Judul".length();
        for (Koleksi k : katalog.getDaftarKoleksi()) {
            lebarJudul = Math.max(lebarJudul, k.getJudul().length());
        }

        String format = "%-4s %-14s %-8s %-" + lebarJudul + "s %-6s %-14s%n";

        try (PrintWriter out = new PrintWriter(new FileWriter(namaBerkas))) {
            out.printf(format, "No", "Jenis", "Kode", "Judul", "Tahun", "Layak Pinjam");
            out.println("-".repeat(4 + 1 + 14 + 1 + 8 + 1 + lebarJudul + 1 + 6 + 1 + 14));

            int nomor = 1;
            for (Koleksi k : katalog.getDaftarKoleksi()) {
                out.printf(format,
                        nomor,
                        k.getClass().getSimpleName(),
                        k.getKodeKoleksi(),
                        k.getJudul(),
                        k.getTahunTerbit(),
                        k.layakDipinjam() ? "Ya" : "Tidak");
                nomor++;
            }
            System.out.println("Katalog berhasil ditulis ke berkas " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
    }
}
