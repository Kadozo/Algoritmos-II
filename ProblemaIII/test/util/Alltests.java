/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Thiago Cardozo
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    util.ArvoreTest.class,
    model.ImagemTest.class, 
    model.SystemTest.class, 
    model.ComputadorTest.class,
    model.RegistroTest.class 
})
public class Alltests {
    
}
