package com.cbam.demo.aop;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2016/10/24
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void getUser(int id) {
        userDao.getUser(id);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
