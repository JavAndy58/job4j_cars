package ru.gromov.andrey;

import ru.gromov.andrey.model.Promo;
import ru.gromov.andrey.repository.AdRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AdRepository adRepository = new AdRepository();

        List<Promo> list = adRepository.findPromosWithPhoto();

        for (Promo promo : list) {
            System.out.println(promo);
        }

    }
}
