/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bqtest.service;

import bqtest.service.impl.MemberFileProcessorImpl;
import java.io.File;
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
public class MemberFileProcessorTest {
    
    public MemberFileProcessorTest() {
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
     * Test of processFile method, of class MemberFileProcessor.
     */
    @Test
    public void testProcessFile() throws Exception {
        System.out.println("processFile");
        File inputMemberFile = new File("Members.txt");
        MemberFileProcessor instance = new MemberFileProcessorImpl();
        //Map<String, List<Member>> expResult = null;
        Map<String, List<Member>> result = instance.processFile(inputMemberFile);
        assertNotNull(result); //Every Methods called inside processFile() are tested. So the return value from this method is just tested to be 
                               // Not Null. This result contains large result to check for expected result. We can make a smaller file to test result
                               // with expected value but since all methods called are already tested, this is not mandatory.
        
        int stated_expected_number=5;
        assertEquals(stated_expected_number,result.keySet().size()); //we can also test by checking the number of states(keys) expected.
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
