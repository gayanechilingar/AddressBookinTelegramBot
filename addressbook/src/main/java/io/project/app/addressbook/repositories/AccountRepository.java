/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.addressbook.repositories;

import io.project.app.addressbook.domain.Account;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gayanec
 */

//
@Transactional
@Repository
public interface AccountRepository extends MongoRepository<Account, String>{
    

    Optional<Account> findByChatId(Integer chatId);

//    List<Account> findByPriceLessThan(int price);
//    
//    List<Account> findByPriceBetween(int price1, int price2);

}