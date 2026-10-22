package eksepsi;

/**
 * Dilempar ketika koleksi tidak memenuhi aturan layak pinjam.
 */
public class KoleksiTidakLayakException extends PustakaException {

    public KoleksiTidakLayakException(String judul) {
        super("Maaf, \"" + judul + "\" belum bisa dipinjam saat ini "
                + "karena tidak memenuhi syarat peminjaman.");
    }
}
