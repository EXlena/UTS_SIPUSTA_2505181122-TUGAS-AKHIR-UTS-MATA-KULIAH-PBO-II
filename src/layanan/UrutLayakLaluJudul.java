package layanan;

import java.util.Comparator;
import model.Koleksi;

/**
 * Soal 4: Comparator berlapis.
 * Lapis 1: koleksi layak pinjam tampil lebih dulu.
 * Lapis 2: jika sama, diurutkan berdasarkan judul (A-Z).
 */
public class UrutLayakLaluJudul implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi a, Koleksi b) {
        // Lapis 1: true (layak) harus lebih dulu, jadi dibalik (b dibanding a)
        int hasil = Boolean.compare(b.layakDipinjam(), a.layakDipinjam());
        if (hasil != 0) {
            return hasil;
        }
        // Lapis 2: urut judul tanpa membedakan huruf besar/kecil
        return a.getJudul().compareToIgnoreCase(b.getJudul());
    }
}
