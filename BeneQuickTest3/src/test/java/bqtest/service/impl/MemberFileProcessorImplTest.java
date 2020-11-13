/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bqtest.service.impl;

import bqtest.service.Member;
import bqtest.service.MemberImporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class MemberFileProcessorImplTest {
    
    public MemberFileProcessorImplTest() {
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
     * Test of getMemberImporter method, of class MemberFileProcessorImpl.
     */
    @Test
    public void testGetMemberImporter() {
        System.out.println("getMemberImporter");
        MemberFileProcessorImpl instance = new MemberFileProcessorImpl();
        MemberImporter result = instance.getMemberImporter();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNonDuplicateMembers method, of class MemberFileProcessorImpl.
     */
    @Test
    public void testGetNonDuplicateMembers() {
        System.out.println("getNonDuplicateMembers");
        List<Member> membersFromFile = new ArrayList<>();
        MemberFileProcessorImpl instance = new MemberFileProcessorImpl();
        List<Member> expResult = new ArrayList<>();
        
        Member aa= new Member();
        aa.setState("OK");
        aa.setId("1");
        aa.setFirstName("Paul");
        membersFromFile.add(aa);
        
        Member bb= new Member();
        bb.setState("MN");
        bb.setId("2");
        bb.setFirstName("John");
        membersFromFile.add(bb);
        
        Member cc= new Member();
        cc.setState("OK");
        cc.setId("1");
        cc.setFirstName("Paul");
        membersFromFile.add(cc);
        
        Member dd= new Member();
        dd.setState("IL");
        dd.setId("2");
        dd.setFirstName("John");
        membersFromFile.add(dd);
        
        Member ee= new Member();
        ee.setState("MN");
        ee.setId("1");
        ee.setFirstName("Paul");
        membersFromFile.add(ee);
        
        expResult.add(aa);
        expResult.add(bb);
        //expResult.add(cc);
        expResult.add(dd);
        expResult.add(ee);
        
        List<Member> result = instance.getNonDuplicateMembers(membersFromFile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of splitMembersByState method, of class MemberFileProcessorImpl.
     */
    @Test
    public void testSplitMembersByState() {
        System.out.println("splitMembersByState");
        List<Member> validMembers = new ArrayList<>();
        MemberFileProcessorImpl instance = new MemberFileProcessorImpl();
        Map<String, List<Member>> expResult = new HashMap<>();
        
        Member aa= new Member();
        aa.setState("OK");
        aa.setId("1");
        aa.setFirstName("Paul");
        validMembers.add(aa);
        
        Member bb= new Member();
        bb.setState("MN");
        bb.setId("2");
        bb.setFirstName("John");
        validMembers.add(bb);
        
        Member cc= new Member();
        cc.setState("OK");
        cc.setId("3");
        cc.setFirstName("Harry");
        validMembers.add(cc);
        
        Member dd= new Member();
        dd.setState("IL");
        dd.setId("4");
        dd.setFirstName("Eliza");
        validMembers.add(dd);
        
        Member ee= new Member();
        ee.setState("MN");
        ee.setId("5");
        ee.setFirstName("Pauli");
        validMembers.add(ee);
        
        List <Member> ok= new ArrayList<>();
        ok.add(aa);
        ok.add(cc);
        List <Member> il= new ArrayList<>();
        il.add(dd);
        List <Member> mn= new ArrayList<>();
        mn.add(bb);
        mn.add(ee);
        
        expResult.put("OK", ok);
        expResult.put("IL", il);
        expResult.put("MN", mn);
        
        Map<String, List<Member>> result = instance.splitMembersByState(validMembers);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
