package model;

/**
 * Kelas induk (abstract) untuk seluruh jenis koleksi perpustakaan.
 * Soal 1: kelas abstract + method abstract aturan kelayakan pinjam
 * + method deskripsi yang akan diperluas oleh turunan memakai super.
 */
public abstract class Koleksi {

    private String kodeKoleksi;
    private String judul;
    private int tahunTerbit;
    private boolean sedangDipinjam; // dipakai pada proses peminjaman (Soal 5)

    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    // ===== Getter dan Setter =====
    public String getKodeKoleksi() {
        return kodeKoleksi;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }

    /**
     * Aturan kelayakan pinjam. Setiap turunan wajib mengisinya
     * sesuai aturannya masing-masing.
     */
    public abstract boolean layakDipinjam();

    /**
     * Deskripsi dasar koleksi. Turunan memperluasnya dengan super.deskripsi().
     */
    public String deskripsi() {
        return "[" + kodeKoleksi + "] " + judul + " (" + tahunTerbit + ")";
    }
}
