package com.MiniLes.service;


import com.MiniLes.ApplicationUserDetails;
import com.MiniLes.entity.Account;
import com.MiniLes.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;



    @Override
    public String getAccountRole(String username) {

        Optional<Account> accountOptional = accountRepository.findById(username);

        Account tempAccount = null;
        if(accountOptional.isPresent()){
            tempAccount = accountOptional.get();
            return tempAccount.getRole();
        }

        return "Account not found";
    }



    @Override
    public Boolean checkExistingUsername(String username) {
        Long totalUsername = accountRepository.countExistingUsername(username);
        return totalUsername > 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findById(username);

        Account tempAccount = null;
        if(optionalAccount.isPresent()){
            tempAccount = optionalAccount.get();
        }

        if(tempAccount == null){
            throw new UsernameNotFoundException("Username not found");
        }

        return new ApplicationUserDetails(tempAccount);
    }
}
