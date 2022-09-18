package ru.zavar.itmo.dls;

import ru.zavar.itmo.Node;

public class DlsTest {
    public static void main(String[] args) {
        Node<String> odessa = new Node<>("Одесса");
        Node<String> kiev = new Node<>("Киев");
        Node<String> simferopl = new Node<>("Симферополь");
        Node<String> harkov = new Node<>("Харьков");
        Node<String> doneck = new Node<>("Донецк");
        Node<String> kishinev = new Node<>("Кишинёв");
        Node<String> jitomir = new Node<>("Житомир");
        Node<String> volgograd = new Node<>("Волгоград");
        Node<String> voronez = new Node<>("Воронеж");
        Node<String> vitebsk = new Node<>("Витебск");
        Node<String> brest = new Node<>("Брест");
        Node<String> kaliningrad = new Node<>("Калининград");
        Node<String> vilnus = new Node<>("Вильнюс");
        Node<String> daugavpils = new Node<>("Даугавпилс");
        Node<String> kaunas = new Node<>("Каунас");
        Node<String> tallin = new Node<>("Таллин");
        Node<String> riga = new Node<>("Рига");
        Node<String> spb = new Node<>("С. Петербург");
        Node<String> yaroslavl = new Node<>("Ярославль");
        Node<String> orel = new Node<>("Орёл");
        Node<String> novgorod = new Node<>("Ниж. Новгород");
        Node<String> moscow = new Node<>("Москва");
        Node<String> kazan = new Node<>("Казань");
        Node<String> minsk = new Node<>("Минск");
        Node<String> ufa = new Node<>("Уфа");
        Node<String> murmansk = new Node<>("Мурманск");
        Node<String> samara = new Node<>("Самара");

        odessa.connect(kiev);
        simferopl.connect(harkov);
        harkov.connect(kiev);
        kishinev.connect(kiev);
        kishinev.connect(doneck);
        doneck.connect(jitomir);
        jitomir.connect(kiev);
        kiev.connect(vilnus);
        doneck.connect(orel);
        doneck.connect(moscow);
        jitomir.connect(volgograd);
        volgograd.connect(voronez);
        volgograd.connect(vitebsk);
        voronez.connect(vitebsk);
        voronez.connect(yaroslavl);
        vitebsk.connect(brest);
        vitebsk.connect(vilnus);
        vitebsk.connect(orel);
        vitebsk.connect(novgorod);
        vitebsk.connect(spb);
        orel.connect(moscow);
        novgorod.connect(moscow);
        moscow.connect(kazan);
        spb.connect(moscow);
        minsk.connect(moscow);
        minsk.connect(murmansk);
        minsk.connect(yaroslavl);
        murmansk.connect(spb);
        kazan.connect(ufa);
        ufa.connect(samara);
        spb.connect(kaliningrad);
        spb.connect(riga);
        riga.connect(tallin);
        kaunas.connect(riga);
        kaunas.connect(vilnus);
        daugavpils.connect(vilnus);
        vilnus.connect(kaliningrad);
        brest.connect(vilnus);

        DepthLimitedSearchAlgorithm.search(riga, odessa, 12);
    }
}
