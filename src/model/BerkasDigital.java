package model;

/**
 * Berkas digital: selalu layak dipinjam.
 * Tidak memiliki lokasi fisik di rak, sehingga TIDAK mengimplementasikan Terarsip.
 */
public class BerkasDigital extends Koleksi {

    private int ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit,
                         int ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    public int getUkuranMB() {
        return ukuranMB;
    }

    public String getTautanUnduh() {
        return tautanUnduh;
    }

    @Override
    public boolean layakDipinjam() {
        return true;
    }

    @Override
    public String deskripsi() {
        return "Berkas Digital " + super.deskripsi() + " - " + ukuranMB + " MB, " + tautanUnduh;
    }
}
