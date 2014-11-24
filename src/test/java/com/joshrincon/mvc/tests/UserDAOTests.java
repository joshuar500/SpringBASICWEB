package com.joshrincon.mvc.tests;

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
@ContextConfiguration(locations = {"classpath:com/joshrincon/mvc/config/datasource.xml",
                                    "classpath:../webapp/WEB-INF/dao-context.xml",
                                    "classpath:../webapp/WEB-INF/security-context.xml"})
// says how we're gonna run the above context configs
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTests {

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
