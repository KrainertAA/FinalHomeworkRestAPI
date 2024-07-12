package com.example.WebUsersAccount.services;

import com.example.WebUsersAccount.entities.Users;
import com.example.WebUsersAccount.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {



    @Autowired
    private UsersRepository balanceRepository;


    public Users save(Users users) {
        return balanceRepository.save(users);
    }


    public int getBalance(int id) {
        Users users = balanceRepository.findById(id).orElseThrow();
        return users.getBalance();
    }

    public int putMoney(int id, int amount) {
        Users users = balanceRepository.findById(id).orElseThrow();
        int currentBalance = users.getBalance() + amount;
        if (currentBalance > -1) {
            users.setBalance(currentBalance);
            save(users);
            return 1;
        }
        return 0;
    }

    public int takeMoney(int id, int amount) {
        Users users = balanceRepository.findById(id).orElseThrow();
        int currentBalance = users.getBalance() - amount;
        if (currentBalance > -1) {
            users.setBalance(currentBalance);
            save(users);
            return 1;
        }
        return 0;
    }
}
