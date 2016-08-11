package com.jihs.models;

import com.jihs.util.Mysql;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 8/11/16.
 */
public class VehicleTest {
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
    public void tearDown() throws Exception {

    }

}