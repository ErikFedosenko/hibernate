package com.java.hibernate;

import com.java.hibernate.dao.AccountDAO;
import com.java.hibernate.entity.Account;
import com.java.hibernate.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class})
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void run(String... args) throws Exception {
        Account account = new Account("Erik", 24);
        List<Bill> bills = new ArrayList<>();
        bills.add(new Bill(16));
        bills.add(new Bill(17));
        bills.add(new Bill(18));
        bills.add(new Bill(19));
        bills.add(new Bill(20));
        account.setBills(bills);
        Account savedAccount = accountDAO.save(account);

        Account accountFromDB = accountDAO.findById(savedAccount.getAccountId());
        System.out.println(accountFromDB);
        System.out.println(accountFromDB.getBills());
    }
}
