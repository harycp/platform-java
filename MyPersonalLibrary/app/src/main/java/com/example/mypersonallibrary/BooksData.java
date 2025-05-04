package com.example.mypersonallibrary;

import java.util.ArrayList;

public class BooksData {
    private static String[] bookTitles = {
            "Animal Farm",
            "Bumi Manusia",
            "Dari Penjara Ke Penjara",
            "Le Petit Prince : Pangeran Cilik",
            "Madilog",
            "Matilda",
            "Orang Asing",
            "Sapiens : Riwayat Singkat Umat Manusia",
            "Semua Anak Bangsa",
            "Tertolak Sebagai Manusia",
            "The Midnight Library"

    };

    private static String[] bookDetails = {
            "George Orwell • Sebuah alegori politik tentang peternakan hewan yang memberontak terhadap manusia. Kisah ini menyindir sistem totaliter dan pengkhianatan terhadap revolusi. Pesannya kuat tentang kekuasaan, manipulasi, dan kesetaraan yang semu.",
            "Pramoedya Ananta Toer • Bercerita tentang Minke, seorang pribumi berpendidikan di masa kolonial. Ia menghadapi ketidakadilan rasial dan perjuangan identitas. Sebuah novel sejarah yang sarat nilai kemanusiaan dan perlawanan.",
            "Tan Malaka • Memoar seorang tokoh revolusioner Indonesia dalam pengasingan dan perburuan. Buku ini mengungkap ideologi, strategi, dan pengalaman pribadinya melawan penjajahan. Ditulis dengan semangat perjuangan dan cita-cita kemerdekaan.",
            "Antoine de Saint-Exupéry • Kisah filosofis tentang seorang pangeran kecil yang menjelajahi berbagai planet. Ia belajar makna cinta, persahabatan, dan kesepian dari perjalanannya. Sebuah dongeng yang menyentuh baik anak-anak maupun orang dewasa.",
            "Tan Malaka • Buku ini memadukan pandangan tentang materialisme, dialektika, dan logika. Ditujukan untuk membangun pola pikir kritis dan ilmiah bagi rakyat Indonesia. Karya ini menjadi dasar penting dalam pemikiran progresif dan pendidikan politik.",
            "Roald Dahl • Matilda adalah anak jenius yang tumbuh dalam keluarga yang tak peduli dan kasar. Di sekolah, ia menghadapi kepala sekolah kejam, tetapi juga menemukan harapan. Kisahnya mengajarkan keberanian, kecerdasan, dan keajaiban masa kecil.",
            "Albert Camus • Meursault adalah pria yang tampak acuh dan tak peduli terhadap dunia. Ia membunuh seseorang secara absurd dan diadili tanpa rasa bersalah. Novel ini mengeksplorasi absurditas hidup dan makna keberadaan manusia.",
            "Yuval Noah Harari • Buku ini menelusuri sejarah manusia dari Homo sapiens awal hingga era modern. Harari membahas topik seperti mitos, agama, sains, dan kapitalisme secara kritis. Disajikan dengan gaya naratif yang mudah dicerna namun penuh wawasan.",
            "Pramoedya Ananta Toer • Mengangkat kisah anak muda di tengah konflik sosial dan politik bangsa. Ia harus menghadapi pengkhianatan, ketidakadilan, dan pergolakan identitas. Novel ini kuat secara emosional dan historis.",
            "Osamu Dazai • Tokoh utama merasa terasing dari masyarakat dan tidak mampu menjadi 'manusia normal'. Ia hidup dalam kebohongan, depresi, dan penyangkalan diri. Sebuah karya yang kelam, jujur, dan menyayat hati tentang penderitaan batin.",
            "Matt Haig • Nora ingin mengakhiri hidupnya, tapi menemukan perpustakaan antar-kehidupan. Ia melihat berbagai versi dirinya di dunia yang berbeda. Kisah ini menyentuh tema pilihan hidup, penyesalan, dan harapan yang selalu ada."
    };


    private static int[] bookImages = {
            R.drawable.animal_farm,
            R.drawable.bumi_manusia,
            R.drawable.dari_penjara_ke_penjara,
            R.drawable.le_petit_prince,
            R.drawable.madilog,
            R.drawable.matilda,
            R.drawable.orang_asing,
            R.drawable.sapiens_riwayat_singkat_umat_manusia,
            R.drawable.semua_anak_bangsa,
            R.drawable.tertolak_sebagai_manusia,
            R.drawable.the_midnight_library
    };

    static ArrayList<Book> getListData() {
        ArrayList<Book> list = new ArrayList<>();
        for (int position = 0; position < bookTitles.length; position++){
            Book book = new Book();
            book.setTitle(bookTitles[position]);
            book.setDetail(bookDetails[position]);
            book.setPhoto(bookImages[position]);
            list.add(book);
        }
        return list;
    }
}
