package com.step_definitions;

import com.Utilities.DataBaseUtilities;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Hook {

    @BeforeClass
    public static void setUp(){

        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "password";

        DataBaseUtilities.CreateConnection(url,username,password);
    }

    @AfterClass
    public static void tearDown(){
        DataBaseUtilities.destroy();
    }
}
