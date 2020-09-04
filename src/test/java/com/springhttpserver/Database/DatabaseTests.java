package com.springhttpserver.Database;

import com.springhttpserver.Database.DbConnectionPool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DatabaseTests {
    @Autowired
    private DbConnectionPool DbConnectionPool;



    @Test
    public void Test1()
    {
    }
}
