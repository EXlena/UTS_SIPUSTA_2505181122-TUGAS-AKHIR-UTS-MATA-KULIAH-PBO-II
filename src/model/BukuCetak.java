package model;

/**
 * Buku cetak: layak dipinjam apabila tidak sedang diperbaiki.
 * Memiliki lokasi fisik di rak, sehingga mengimplementasikan Terarsip.
 */
public class BukuCetak extends Koleksi implements Terarsip {

    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit,
                     int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public boolean isSedangDiperbaiki() {
        return sedangDiperbaiki;
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        // Rak berawalan A di lantai 1, B di lantai 2, selain itu lantai 3
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
        return "Buku Cetak   " + super.deskripsi() + " - " + jumlahHalaman + " halaman, "
                + ringkasanArsip();
    }
}
