package com.joshrincon.mvc.test.tests;

import com.joshrincon.mvc.dao.User;
import com.joshrincon.mvc.dao.UsersDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

@ActiveProfiles("development")
// change this from file to classpath when you can figure it out bro
@ContextConfiguration(locations = {"file:D:\\workspace\\SpringBASICWEB\\src\\main\\webapp\\resources\\spring\\dao-context.xml",
                                    "file:D:\\workspace\\SpringBASICWEB\\src\\main\\webapp\\resources\\spring\\security-context.xml",
                                    "file:D:\\workspace\\SpringBASICWEB\\src\\test\\java\\com\\joshrincon\\mvc\\test\\config\\datasource.xml"})
// says how we're gonna run the above context configs
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTests {

    // these are red because classpath doesn't work for some stupid reason
    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private DataSource dataSource;

    // run this before my tests
    @Before
    public void init() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.execute("delete from users");
        jdbc.execute("delete from authorities");
    }

    @Test
    public void testCreateUser() {
        User user = new User("testuser", "passwordtest", "testuser@tester.com", true, "user");
        assertTrue(usersDAO.create(user));
    }

}
