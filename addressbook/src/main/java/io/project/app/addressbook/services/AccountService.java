package io.project.app.addressbook.services;

import io.project.app.addressbook.domain.Account;
import io.project.app.addressbook.repositories.AccountRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gayanec
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public Optional<Account> createAccount(Account account) {

        account.setId(null);
        log.info("chat id " + account.getChatId());
        Optional<Account> existingAccount = accountRepository.findByChatId(account.getChatId());

        if (existingAccount.isPresent()) {
            log.error("User already has this Chat, we can't save new chat");
            return Optional.empty();
        }

//        for (int i = 0; i < 10000; i++) {
//            order.setUserId(i + 5);
//            order.setProductName("Product_" + System.currentTimeMillis());
//            orderRepository.save(order);
//        }
        Account savedAccount = accountRepository.save(account);

        log.info("Chat is saved and chat id is " + savedAccount.getChatId());

        return Optional.ofNullable(savedAccount);

    }

}
