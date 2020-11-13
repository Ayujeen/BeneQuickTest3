/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bqtest.service.impl;

import bqtest.service.Member;
import java.io.File;
import java.util.List;
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
public class MemberImporterImplTest {
    
    public MemberImporterImplTest() {
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
     * Test of importMembers method, of class MemberImporterImpl.
     */
    @Test
    public void testImportMembers() throws Exception {
        System.out.println("importMembers");
        File inputFile = new File("Members.txt");
        MemberImporterImpl instance = new MemberImporterImpl();
        List<Member> result = instance.importMembers(inputFile);
        assertNotNull(result); //Here I just tested Not Null because we are not specifying any file type and exact pattern as in json to look for attributes.
        //Since we are looking just for text file with some data so if some data is imported we can assume this method working fine
        
        assertNotNull(result.get(0).getId()); // To further validate setting value inside importMembers() method, i checked if the id of first value is null or not
        
        String firstMemberId="101396885";
        
        assertEquals(firstMemberId, result.get(0).getId().trim());
        // To further validate setting value inside importMembers() method, i checked if the id of first value is same as in textfile given in string
        
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
