package ru.gromov.andrey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.gromov.andrey.model.*;

public class AdRepository {
    public static void main(String[] args) {





    }

    public void newPromos() {
        String request = "select distinct prom from Promo prom"
                + "join fetch prom.car car"
                + "join fetch car.drivers"
                + "join fetch car.engine"
                + "join fetch pro.user";

    }

    private Promo sf(String request) {
        Promo rsl = null;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            /*
            User userOne = User.of("Ivan");
            Driver driverOne = Driver.of("Petr");
            Engine engineAudi = Engine.of("AAR");
            Car carAudi = Car.of("Audi best", "Audi", "sedan");
            carAudi.addDriver(driverOne);
            carAudi.setEngine(engineAudi);
            rsl = Promo.of("Продается авто в хорошем состоянии", null);
            rsl.setCar(carAudi);
            rsl.setUser(userOne);

            session.save(userOne);
            session.save(driverOne);
            session.save(engineAudi);
            session.save(carAudi);
            session.save(rsl);
             */

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return rsl;
    }
}
