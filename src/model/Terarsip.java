package model;

/**
 * Soal 2: interface untuk koleksi yang memiliki lokasi fisik di rak.
 * Hanya diterapkan pada BukuCetak dan Majalah.
 */
public interface Terarsip {

    String nomorRak();

    String lokasiLantai();

    // default method yang menggabungkan nomorRak dan lokasiLantai
    default String ringkasanArsip() {
        return "Rak " + nomorRak() + ", " + lokasiLantai();
    }
}
