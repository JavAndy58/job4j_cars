package ru.gromov.andrey.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.gromov.andrey.model.Promo;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class AdRepository {

    private final Date currentDate = new Date(System.currentTimeMillis());
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    private final String queryPromoFetch = "select distinct p from Promo p "
            + "join fetch p.car c "
            + "join fetch p.user "
            + "join fetch c.drivers "
            + "join fetch c.engine ";

    public List<Promo> findPromosByLastDay() {
        return tx(session -> session.createQuery(
                queryPromoFetch
                + "where p.created >= :current_date", Promo.class

        ).setParameter("current_date", currentDate).list());
    }

    public List<Promo> findPromosWithPhoto() {
        return tx(session -> session.createQuery(
                queryPromoFetch
                + "where p.photo.size > 0 ", Promo.class
        ).list());
    }

    public List<Promo> findPromosByBrand(String brand) {
        return tx(session -> session.createQuery(
                queryPromoFetch
                + "where c.carBrand = :brand", Promo.class
        ).setParameter("brand", brand).list());
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            transaction.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
