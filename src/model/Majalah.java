package model;

/**
 * Majalah: layak dipinjam apabila BUKAN edisi terbaru.
 * Memiliki lokasi fisik di rak, sehingga mengimplementasikan Terarsip.
 */
public class Majalah extends Koleksi implements Terarsip {

    private int edisi;
    private String bulanTerbit;
    private boolean edisiTerbaru;
    private String nomorRak;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit,
                   int edisi, String bulanTerbit, boolean edisiTerbaru, String nomorRak) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
        this.nomorRak = nomorRak;
    }

    public int getEdisi() {
        return edisi;
    }

    public String getBulanTerbit() {
        return bulanTerbit;
    }

    public boolean isEdisiTerbaru() {
        return edisiTerbaru;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        char blok = nomorRak.charAt(0);
        switch (blok) {
            case 'A':
                return "Lantai 1";
            case 'B':
                return "Lantai 2";
            default:
                return "Lantai 3";
        }
    }

    @Override
    public String deskripsi() {
        return "Majalah      " + super.deskripsi() + " - edisi " + edisi + " (" + bulanTerbit + "), "
                + ringkasanArsip();
    }
}
