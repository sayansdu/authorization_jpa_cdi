package kz.sayan.service;

import kz.sayan.config.MD5;
import kz.sayan.config.annotation.NumberOfDigits;
import kz.sayan.config.annotation.ThirteenDigits;
import kz.sayan.config.generator.NumberGenerator;
import kz.sayan.entity.Task;
import kz.sayan.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.*;

/**
 * User: Sayan.Zhumashev
 * Date: 7/16/14
 * Time: 5:36 PM
 */
@ApplicationScoped
public class Service {

//    To use injection this class must be bean or component
    @PersistenceUnit(unitName = "persistenceUnit")
    private EntityManagerFactory entityManagerFactory;

//    You can choose realization of NumberGenerator interface
//    by Qualifiers, Alternatives (to use Alternatives, activate it in beans.xml)
    @Inject @NumberOfDigits(value = NumberOfDigits.Digits.THIRTEEN, odd = false)
    private NumberGenerator numberGenerator;

//    public Service(){
//        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
//    }

    public User saveUser(User user){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{

            entityManager.getTransaction().begin();
            user.setIin(numberGenerator.generateNumber());
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.err.println("User save is failed");
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return user;
    }

    public int checkEmail(String email){
        int count = 0;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Long result = (Long) entityManager.createNamedQuery("getUserByEmail").setParameter("email", email).getSingleResult();
            if(result!=0)
                count = 1;

            entityManager.getTransaction().commit();

        } catch(Exception e){
            System.err.println("User check email failed");
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return count;
    }

    public User signIn(String email, String password){
        User user = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            user = (User) entityManager.createQuery("from User u where u.email = :email and u.password = :password").setParameter("email", email).setParameter("password", MD5.hash(password)).getSingleResult();
            entityManager.getTransaction().commit();

        } catch (Exception e){
            System.err.println("User sign in failed");
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return user;
    }
}
