package com.example.myrecyclerview;

import java.util.ArrayList;

public class HeroesData {
    private static  String[] heroNames = {
            "Bagus Tri Handoko",
            "Elvira Zaretti",
            "Hary Capri",
            "Iqbal Fardhani Pohan",
            "Muhammad Hunaify Mu’izzy",
    };

    private static String[] heroDetails = {
            "Nama saya Bagus Tri Handoko, lahir di Jakarta, 15 Agustus 2004, anak ke-3 dari 3 bersaudara. Saya tinggal di CIbinong, Bogor. Hobi saya adalah berolahraga seperti joging dan bermain bulu tangkis. Harapan saya dapat bekerja dibidang Data science atau Data analyst.",
            "Lahir di Jakarta, 9 mei 2005. Anak ke-2 dari 3 bersaudara. Tinggal di Tangerang Selatan. Mempunyai hobi berbelanja dan mengoleksi mainan lucu. Sedang berkuliah di prodi S1 Informatika dan bercita-cita menjadi data scientist atau data analyst.",
            "Lahir di Bekasi, 22 April 2004. Anak ke-3 dari 3 bersaudara. Tinggal di Kab Bekasi. Memiliki hobi membaca buku dan bernyanyi. Sedang menempuh dan bertekad untuk bekerja pada bidang Software Developer salah satu fokusnya adalah Fullstack Developer.",
            "Lahir di Jakarta, 3 Juni 2005. Anak tunggal. Tinggal di Depok. Suka bermain video game dan membaca novel. Sedang berkuliah di prodi S1 Informatika dan memiliki impian bekerja sebagai Front-End Web Developer atau Game Developer.",
            "Lahir di Jakarta, 26 Juni 2003. Anak ke-3. Tinggal di Jakarta Pusat. Suka bermain game. Ingin bekerja di bidang yang berkaitan dengan pemrograman dan visual seperti game development, dsb.",
    };

    private static int[] heroesImages = {
            R.drawable.bagus_tri_handoko,
            R.drawable.elvira_zaretti,
            R.drawable.hary_capri,
            R.drawable.iqbal_fardhani_pohan,
            R.drawable.muhammad_hunaify_muizzy,
    };

    static ArrayList<Hero> getListData() {
        ArrayList<Hero> list = new ArrayList<>();
        for (int position = 0; position < heroNames.length; position++){
            Hero hero = new Hero();
            hero.setName(heroNames[position]);
            hero.setDetail(heroDetails[position]);
            hero.setPhoto(heroesImages[position]);
            list.add(hero);
        }
        return list;
    }
}
