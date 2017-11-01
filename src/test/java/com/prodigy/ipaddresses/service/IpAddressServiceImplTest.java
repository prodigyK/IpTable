package com.prodigy.ipaddresses.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class IpAddressServiceImplTest {

    @Autowired
    private IpAddressService service;

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void getByFilter() throws Exception {
    }

}