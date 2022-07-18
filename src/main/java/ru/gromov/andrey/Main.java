package ru.gromov.andrey;

import ru.gromov.andrey.model.Promo;
import ru.gromov.andrey.repository.AdRepository;
import ru.gromov.andrey.repository.AddRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        AddRepository addRepository = new AddRepository();
        addRepository.addData();
         */
        AdRepository adRepository = new AdRepository();
        List<Promo> list = adRepository.findPromosByLastDay();
        System.out.println(list.size());
        for (Promo promo : list) {
            System.out.println(promo);
        }
    }
}
