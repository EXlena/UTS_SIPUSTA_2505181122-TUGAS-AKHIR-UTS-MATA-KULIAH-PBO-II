package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;

/**
 * Soal 3, 4, dan 5: layanan katalog perpustakaan.
 * Daftar koleksi bertipe kelas induk (Koleksi) sehingga bisa diproses polimorfik.
 */
public class KatalogPerpustakaan {

    private List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return Collections.unmodifiableList(daftarKoleksi);
    }

    /**
     * Soal 3: memproses seluruh koleksi secara polimorfik, tanpa instanceof.
     * Setiap objek memanggil deskripsi() dan layakDipinjam() miliknya sendiri.
     */
    public void cetakStatus() {
        int nomor = 1;
        for (Koleksi k : daftarKoleksi) {
            String status = k.layakDipinjam() ? "LAYAK DIPINJAM" : "TIDAK LAYAK";
            String pinjam = k.isSedangDipinjam() ? " | sedang dipinjam" : "";
            System.out.println(nomor + ". " + k.deskripsi());
            System.out.println("   Status: " + status + pinjam);
            nomor++;
        }
    }

    /**
     * Soal 4: aturan pengurutan dapat diganti dari luar lewat Comparator.
     */
    public void urut(Comparator<Koleksi> pembanding) {
        daftarKoleksi.sort(pembanding);
    }

    /**
     * Soal 5: meminjam koleksi berdasarkan kode.
     */
    public void pinjam(String kodeKoleksi) throws PustakaException {
        Koleksi ditemukan = null;
        for (Koleksi k : daftarKoleksi) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
                ditemukan = k;
                break;
            }
        }

        if (ditemukan == null) {
            throw new PustakaException("Koleksi dengan kode " + kodeKoleksi
                    + " tidak ditemukan di katalog.");
        }
        if (ditemukan.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(ditemukan.getJudul());
        }
        if (!ditemukan.layakDipinjam()) {
            throw new KoleksiTidakLayakException(ditemukan.getJudul());
        }

        ditemukan.setSedangDipinjam(true);
        System.out.println("Berhasil: \"" + ditemukan.getJudul() + "\" sekarang Anda pinjam.");
    }
}
