package com.example.recyclerwisata;

import java.util.ArrayList;

public class WisataData {
    private static String[] wisataNames = {
            "Zermatt & Matterhorn – Swiss",
            "Edinburgh Castle – Skotlandia",
            "Colosseum – Roma, Italia",
            "Acropolis – Athena, Yunani",
            "Machu Picchu – Peru",
            "Petra – Yordania",
            "Kyoto – Jepang",
            "Bruges – Belgia",
            "Istanbul – Turki",
            "Angkor Wat – Kamboja",
    };
    private static String[] wisataDetails = {
            "Zermatt adalah sebuah desa indah di kaki Gunung Matterhorn, salah satu puncak paling ikonik di Pegunungan Alpen. Keindahan alamnya sangat memukau, terutama saat musim salju tiba, menjadikannya destinasi favorit untuk bermain ski dan hiking. Desa ini juga terhubung dengan Glacier Express, jalur kereta legendaris yang melewati lembah dan pegunungan dengan panorama spektakuler. Selain itu, terdapat museum Zermatlantis yang memperlihatkan sejarah pendakian Matterhorn dan kehidupan masyarakat setempat.",
            "Kastil Edinburgh berdiri megah di atas Castle Rock, bukit batu vulkanik di tengah kota Edinburgh. Kastil ini merupakan simbol sejarah Skotlandia dan pernah menjadi kediaman raja-raja Skotlandia sejak abad ke-12. Di dalamnya, pengunjung bisa melihat Stone of Destiny, mahkota kerajaan, dan meriam besar bernama Mons Meg. Dari atas kastil, terbentang pemandangan kota tua Edinburgh yang klasik dan penuh cerita masa lampau.",
            "Colosseum adalah amfiteater kuno terbesar di dunia yang dibangun pada masa Kekaisaran Romawi, sekitar tahun 72 Masehi. Terletak di pusat kota Roma, bangunan oval raksasa ini dahulu menjadi tempat pertarungan gladiator, pertunjukan hewan buas, dan acara publik lainnya. Dengan kapasitas mencapai 50.000 penonton, Colosseum menunjukkan kemegahan arsitektur dan teknik sipil Romawi. Struktur lorong bawah tanah serta sistem angkat untuk hewan dan pejuang membuatnya sangat maju untuk zamannya.",
            "Acropolis merupakan bukit batu bersejarah yang menjulang di pusat Athena dan menjadi pusat kekuatan spiritual serta politik Yunani kuno. Di atasnya berdiri Parthenon, kuil megah untuk Dewi Athena, bersama dengan bangunan lain seperti Erechtheion dan Propylaea. Dibangun pada abad ke-5 SM, situs ini menggambarkan kejayaan peradaban Yunani klasik. Acropolis juga diakui sebagai Warisan Dunia UNESCO dan menjadi simbol demokrasi dan filsafat barat.",
            "Machu Picchu adalah kota kuno peninggalan suku Inca yang tersembunyi di Pegunungan Andes, sekitar 2.400 meter di atas permukaan laut. Tempat ini diperkirakan dibangun sebagai tempat peristirahatan bangsawan atau situs spiritual. Ditemukan kembali oleh Hiram Bingham pada tahun 1911, Machu Picchu menarik perhatian dunia karena letaknya yang terpencil dan konstruksi batunya yang sangat presisi tanpa perekat. Terasering pertanian dan lanskap sekitarnya memperkuat kesan magis dan harmonis dengan alam.",
            "Petra adalah kota kuno yang dipahat di dinding batu pasir merah muda di gurun selatan Yordania. Dibangun sekitar tahun 300 SM oleh bangsa Nabatea, Petra menjadi pusat perdagangan penting yang menghubungkan Timur dan Barat. Bangunan paling ikonik di sini adalah Al-Khazneh (The Treasury), yang terlihat seperti kuil megah dari film Indiana Jones. Petra sempat \"hilang\" dari dunia Barat hingga ditemukan kembali oleh penjelajah Swiss Johann Burckhardt pada tahun 1812.",
            "Kyoto adalah kota klasik Jepang yang merupakan pusat budaya, spiritualitas, dan sejarah selama lebih dari seribu tahun. Kota ini pernah menjadi ibu kota kekaisaran dari tahun 794 hingga 1868. Kyoto dikenal karena ribuan kuil Buddha dan Shinto, seperti Kinkaku-ji (Paviliun Emas), Fushimi Inari Taisha dengan ribuan gerbang torii merah, dan Kastil Nijo. Selain itu, Kyoto merupakan tempat berkembangnya seni tradisional Jepang seperti upacara minum teh, ikebana, dan kehidupan geisha.",
            "Bruges adalah kota kecil di Belgia yang sangat terawat dan menyimpan nuansa abad pertengahan yang kuat. Dijuluki “Venesia dari Utara,” kota ini dipenuhi kanal-kanal yang indah dan bangunan gotik yang menawan. Di pusat kotanya terdapat Markt Square, Basilika Darah Kudus, serta Belfry Tower yang menjulang tinggi. Seluruh kawasan kota tua Bruges diakui sebagai Warisan Dunia UNESCO karena keotentikan dan nilai sejarahnya yang tinggi.",
            "Istanbul adalah kota unik yang terletak di dua benua—Asia dan Eropa—dan menyimpan jejak tiga kekaisaran besar: Romawi, Bizantium, dan Ottoman. Salah satu bangunan paling ikonik di sini adalah Hagia Sophia, yang pernah menjadi gereja, masjid, lalu museum, dan kini kembali menjadi masjid. Selain itu, Istanbul juga memiliki Masjid Biru, Istana Topkapi, dan Grand Bazaar yang legendaris. Kota ini mencerminkan perpaduan budaya Timur dan Barat yang kental.",
            "Angkor Wat adalah kompleks candi terbesar di dunia yang terletak di Siem Reap, Kamboja. Dibangun pada awal abad ke-12 oleh Raja Suryavarman II sebagai kuil Hindu untuk Dewa Wisnu, kompleks ini kemudian menjadi pusat keagamaan Buddha. Dengan luas lebih dari 160 hektar, Angkor Wat memiliki ribuan ukiran dan relief yang menggambarkan cerita epik seperti Ramayana dan Mahabharata. Matahari terbit di balik siluet candi menjadi daya tarik utama para wisatawan dari seluruh dunia.",
    };
    private static int[] wisataImages = {
            R.drawable.swiss,
            R.drawable.skotlandia,
            R.drawable.italia,
            R.drawable.yunani,
            R.drawable.peru,
            R.drawable.yordania,
            R.drawable.jepang,
            R.drawable.belgia,
            R.drawable.turki,
            R.drawable.kamboja
    };

    static ArrayList<Wisata> getListData() {
        ArrayList<Wisata> list = new ArrayList<>();
        for (int position = 0; position < wisataNames.length; position++){
            Wisata wisata = new Wisata();
            wisata.setName(wisataNames[position]);
            wisata.setDetail(wisataDetails[position]);
            wisata.setPhoto(wisataImages[position]);
            list.add(wisata);
        }
        return list;
    }
}
