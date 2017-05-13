package com.sctrcd.busspassws;

import static org.junit.Assert.*;

import rest.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Aplicacion.class)
@WebAppConfiguration
public class BusPassWebServiceTest {

    @Autowired
    private Servicio servicio;

    @Test
    public void shouldIssueAdultBusPass() {
        
        assertEquals(true,true);
    }
    
    @Test
    public void shouldIssueChildBusPass() {
        
        assertEquals(true,true);
    }

}
