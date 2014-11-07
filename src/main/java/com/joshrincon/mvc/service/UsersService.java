package com.joshrincon.mvc.service;

import com.joshrincon.mvc.dao.User;
import com.joshrincon.mvc.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersService {

    private UsersDAO usersDAO;

    @Autowired
    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public void create(User user) {
        usersDAO.create(user);
    }

}
