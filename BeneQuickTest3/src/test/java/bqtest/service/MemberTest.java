/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bqtest.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author chapa
 */
public class MemberTest {
    
    public MemberTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Member.
     */
    @Test
    public void testGetterSetter(){
        //It is not highly recommended to test Getter Setter methods. It is redundant to test them individually too.
        //Here I tested getter setter in a single method to assert all getter and setter methods are working fine.
        
        String id,address,city,fname,lname,state,zip;
        id="001";
        address="my address";
        city="city1";
        fname="First name";
        lname="Last name";
        state="My State";
        zip="My Zip";
        
        Member aa = new Member();
        aa.setId(id);
        aa.setAddress(address);
        aa.setCity(city);
        aa.setFirstName(fname);
        aa.setLastName(lname);
        aa.setState(state);
        aa.setZip(zip);
        
        assertEquals(id, aa.getId());
        assertEquals(address, aa.getAddress());
        assertEquals(city, aa.getCity());
        assertEquals(fname, aa.getFirstName());
        assertEquals(lname, aa.getLastName());
        assertEquals(state, aa.getState());
        assertEquals(zip, aa.getZip());
    }
    
}
