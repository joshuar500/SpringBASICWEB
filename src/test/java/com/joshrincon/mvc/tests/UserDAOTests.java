package com.joshrincon.mvc.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("development")
@ContextConfiguration(locations = {"classpath:../webapp/WEB-INF/dao-context.xml",
                                    "classpath:../webapp/WEB-INF/security-context.xml",
                                    "classpath:com/joshrincon/mvc/config/datasource.xml"})
// says how we're gonna run the above context configs
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTests {

    @Test
    public void testCreateUser() {
        Assert.assertEquals("Dummy test", 1, 1);
    }

}
