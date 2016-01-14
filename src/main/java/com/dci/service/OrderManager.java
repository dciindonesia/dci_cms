package com.dci.service;

import com.dci.model.Users;


public interface OrderManager {

	void sendMail(String to, String subject, String body) ;
    void sendPreConfiguredMail(Users users);
}