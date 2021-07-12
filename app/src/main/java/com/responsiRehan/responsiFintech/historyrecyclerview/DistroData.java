package com.responsiRehan.responsiFintech.historyrecyclerview;


import java.util.ArrayList;
import java.util.List;

public class DistroData {
    private static String[] names = {
            "2021-07-15",
            "2022-07-14",
            "2021-01-13",
            "2021-01-12",
            "2021-01-11",
            "2021-01-10",
            "2021-01-09",
            "2021-01-08",
            "2021-01-07",
            "2021-01-06",
            "2021-01-05",
    };
    private static String[] infos = {
            "Credit Card Bill",
            "PLN Bill",
            "Kartu Halo Bill",
            "Kartu Tri Bill",
            "Kartu Simpati Bill",
            "Kartu XL Bill",
            "Kartu Indosat Bill",
            "WIFI Bill",
            "Apartment Bill",
            "Insurance Bill",
            "Internet Bill",
    };
    private static String[] logos = {
            "Succes",
            "Succes",
            "Succes",
            "Failed",
            "Succes",
            "Succes",
            "Succes",
            "Failed",
            "Succes",
            "Succes",
            "Succes",
    };
    public static List<Distro> getDatas() {
        ArrayList<Distro> distros = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Distro distro = new Distro(names[i], infos[i], logos[i]);
            distros.add(distro);
        }
        return distros;
    }
}