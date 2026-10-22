package eksepsi;

/**
 * Dilempar ketika koleksi yang akan dipinjam sedang dipinjam orang lain.
 */
public class KoleksiSedangDipinjamException extends PustakaException {

    public KoleksiSedangDipinjamException(String judul) {
        super("Maaf, \"" + judul + "\" sedang dipinjam oleh anggota lain. "
                + "Silakan coba lagi setelah koleksi dikembalikan.");
    }
}
