/*
package com.example.MidtermJavaFramework;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.stop();
        context.close();
        AccountDao accountDao = context.getBean("AccountDao", AccountDao.class);
        Account account = new Account();
        account.setId(1);
        account.setName("Yershat Abibulla");        accountDao.create(account);
        AccountController accountController = context.getBean("accountController", AccountController.class);
        System.out.println(accountController.getAll().getContent());
    }
}
*/