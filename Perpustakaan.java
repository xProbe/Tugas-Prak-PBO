// 123230169 - Danendra Pandya Reswara

//  Ini interface item perpustakaan
interface ItemPerpustakaan {
    void pinjam();
    void kembalikan();
    void tampilkanInfo();
}

// abstractnya
abstract class Item implements ItemPerpustakaan {
    protected String judul;
    protected String penulis;
    protected boolean sudahDipinjam;

    public Item(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
        this.sudahDipinjam = false;
    }

    @Override
    public void pinjam() {
        if (!sudahDipinjam) {
            sudahDipinjam = true;
            System.out.println(judul + " telah dipinjam.");
        } else {
            System.out.println(judul + " sudah dipinjam.");
        }
    }

    @Override
    public void kembalikan() {
        if (sudahDipinjam) {
            sudahDipinjam = false;
            System.out.println(judul + " telah dikembalikan.");
        } else {
            System.out.println(judul + " tidak sedang dipinjam.");
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Sudah Dipinjam: " + (sudahDipinjam ? "Ya" : "Tidak"));
    }
}

// konkret class
class Buku extends Item {
    private int halaman;

    public Buku(String judul, String penulis, int halaman) {
        super(judul, penulis);
        this.halaman = halaman;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Halaman: " + halaman);
    }
}

// Kelas konkret / konkret class
class Majalah extends Item {
    private int nomorEdisi;

    public Majalah(String judul, String penulis, int nomorEdisi) {
        super(judul, penulis);
        this.nomorEdisi = nomorEdisi;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Nomor Edisi: " + nomorEdisi);
    }
}

// konkret class ebook
class EBook extends Item {
    private String format;

    public EBook(String judul, String penulis, String format) {
        super(judul, penulis);
        this.format = format;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Format: " + format);
    }
}

// main class polimorfisme
public class Perpustakaan {
    public static void main(String[] args) {
        
        // buat Instance 
        Buku buku = new Buku("The Great Gatsby", "F. Scott Fitzgerald", 180);
        Majalah majalah = new Majalah("National Geographic", "Berbagai Penulis", 2023);
        EBook eBook = new EBook("1984", "George Orwell", "PDF");

        // print/output -> menampilkan informasi dan meminjam item
        buku.tampilkanInfo();
        buku.pinjam();
        buku.tampilkanInfo();
        buku.kembalikan();
        buku.tampilkanInfo();

        System.out.println();

        majalah.tampilkanInfo();
        majalah.pinjam();
        majalah.tampilkanInfo();
        majalah.kembalikan();
        majalah.tampilkanInfo();

        System.out.println();

        eBook.tampilkanInfo();
        eBook.pinjam();
        eBook.tampilkanInfo();
        eBook.kembalikan();
        eBook.tampilkanInfo();
    }
}
