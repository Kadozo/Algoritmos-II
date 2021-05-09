/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Thiago Cardozo
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({model.GrafoTest.class,util.ListTest.class})
public class AllTests {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    
}
