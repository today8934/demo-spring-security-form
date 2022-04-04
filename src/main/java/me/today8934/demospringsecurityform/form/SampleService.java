package me.today8934.demospringsecurityform.form;

import me.today8934.demospringsecurityform.account.Account;
import me.today8934.demospringsecurityform.account.AccountContext;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public void dashboard() {
        Account account = AccountContext.getAccount();
        System.out.println("====================");
        System.out.println("account.getUsername() = " + account.getUsername());
    }
}
