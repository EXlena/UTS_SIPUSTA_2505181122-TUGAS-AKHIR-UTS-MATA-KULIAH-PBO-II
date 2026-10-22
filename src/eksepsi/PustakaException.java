package eksepsi;

/**
 * Soal 5: kelas induk seluruh eksepsi pada sistem SIPUSTA.
 * Dibuat sebagai checked exception agar pemanggil wajib menangani.
 */
public class PustakaException extends Exception {

    public PustakaException(String pesan) {
        super(pesan);
    }
}
