package com.example.MidtermJavaFramework.Interface;

import com.example.MidtermJavaFramework.entity.Account;
import com.example.MidtermJavaFramework.entity.Product;

public interface Shop {
    void putProduct(Product p, Account a);

    void takeProduct(Product p, Account a);

    void soldOut(Product p, Account a);
    void getIn(Account a);
}
