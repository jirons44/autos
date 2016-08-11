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
public class VehicleTest {
    @Before
    public void setUp() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 0").executeUpdate();
        session.createNativeQuery("truncate table clients").executeUpdate();
        session.createNativeQuery("truncate table vehicles").executeUpdate();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 1").executeUpdate();
        Client c = new Client("Joe Irons");
        Vehicle v = new Vehicle("toy", "model", 2000, c);
  
        session.save(c);
        session.getTransaction().commit();
        session.close();
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test(expected = org.hibernate.PropertyValueException.class)
    public void CannotCreateNewVehiclenNClient() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Vehicle v = new Vehicle();
        session.save(v);
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void createNewVehicle() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Client c = session.get(Client.class, 1);
        Vehicle v = new Vehicle("toy", "model", 2000, c);
        session.save(v);
        session.getTransaction().commit();
        session.refresh(v);
        session.close();
        assertEquals(1, v.getId());

    }


}