package App;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Domain.Entity.Administrateur;
import Domain.Util.HibernateUtil;

public class MyApp {

	public static void main(String[] args) {
		Administrateur adminastrateur1 =new Administrateur("Ben Abdallah","Fayruz","Tunis",new Date(10/01/1998),22222222,11);
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.save(adminastrateur1);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

	}
}
