package com.jihs.models;

import com.jihs.util.Mysql;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 8/11/16.
 */
public class ClientTest {
    @Before
    public void setUp() throws Exception {
        Session session = Mysql.getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 0").executeUpdate();
        session.createNativeQuery("truncate table clients").executeUpdate();
        session.createNativeQuery("truncate table vehicles").executeUpdate();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 1").executeUpdate();
        transaction.commit();
        session.close();
    }

    @After
    public void after() throws Exception {

    }

    @Test
    public void createClient() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Client c = new Client("Jenny123");
        session.save(c);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, c.getId());

    }

    @Test
    public void createFourNewVehicliesForJoe() throws Exception {
//        Session session = Mysql.getSession();
//        session.beginTransaction();
//        Client c = session.get(Client.class, 1);
//        c.getVehicles().add( new Vehicle("Ford", "Mustang", 2017, c) );
//        c.getVehicles().add( new Vehicle("Toyota", "Prius C ", 2017, c) );
//        c.getVehicles().add( new Vehicle("Toytoa", "Avalon", 2017, c) );
//        c.getVehicles().add( new Vehicle("Volvo", "C750", 2017, c) );
//
//        //session.save(c);
//        session.getTransaction().commit();
//        session.close();
//       // assertEquals(2017, c.getVehicles().get(0).getYear() );

    }



}