/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.addressbook.repositories;

import io.project.app.addressbook.domain.Address;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gayanec
 */
@Transactional
@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

    Optional<Address> findByChatId(Integer chatId);

    List<Address> findAllByChatId(Integer chatId);

    Optional<Address> findByContactId(Long contactId);

    Optional<Address> findByContactIdAndEmail(Long contactId, String email);

    List<Address> findByContactName(String contactName);

    public void deleteByContactId(Long contactId);
}
