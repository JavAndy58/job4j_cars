package ru.gromov.andrey.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.gromov.andrey.model.*;

public class AddRepository {
    public void addData() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            User userOne = User.of("Ivan");
            User userTwo = User.of("Petr");
            User userThree = User.of("Olga");
            Driver driverOne = Driver.of("Petr");
            Engine engineAudi = Engine.of("AAR");
            Engine engineReno = Engine.of("AAS");
            Engine engineVw = Engine.of("AAD");
            Car carAudi = Car.of("Audi best", "Audi", "sedan");
            Car carReno = Car.of("Logan", "Reno", "sedan");
            Car carVag = Car.of("Golf", "Vag", "sedan");
            carAudi.addDriver(driverOne);
            carAudi.setEngine(engineAudi);
            carReno.addDriver(driverOne);
            carReno.setEngine(engineReno);
            carVag.addDriver(driverOne);
            carVag.setEngine(engineVw);
            Promo promoOne = Promo.of("Продается авто в хорошем состоянии", null);
            Promo promoTwo = Promo.of("Продается авто в хорошем состоянии", null);
            Promo promoThree = Promo.of("Продается авто в хорошем состоянии", null);
            promoOne.setCar(carAudi);
            promoOne.setUser(userOne);
            promoTwo.setCar(carReno);
            promoTwo.setUser(userTwo);
            promoThree.setCar(carVag);
            promoThree.setUser(userThree);
            session.save(userOne);
            session.save(userTwo);
            session.save(userThree);
            session.save(driverOne);
            session.save(engineAudi);
            session.save(engineReno);
            session.save(engineVw);
            session.save(carAudi);
            session.save(carReno);
            session.save(carVag);
            session.save(promoOne);
            session.save(promoTwo);
            session.save(promoThree);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
