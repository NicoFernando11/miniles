package com.MiniLes.service;




public interface AccountService {

    String getAccountRole(String username);


    Boolean checkExistingUsername(String username);
}
