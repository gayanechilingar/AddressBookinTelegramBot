package io.project.app.addressbook.services;

import io.project.app.addressbook.domain.Address;
import io.project.app.addressbook.repositories.AddressRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public Optional<Address> createAddress(Address address) {

        address.setId(null);
        log.info("chat id " + address.getChatId());
        Optional<Address> existingAddress = addressRepository.findByChatId(address.getChatId());

//        existingOrder
        if (existingAddress.isPresent()) {
            log.error("User already has this Chat, we can't save new chat");
            return Optional.empty();
        }

        Address savedAddress = addressRepository.save(address);

        log.info("Chat is saved and chat id is " + savedAddress.getChatId());

        return Optional.ofNullable(savedAddress);

    }

    public List<Address> findAllByChatId(Integer chatId) {
        return addressRepository.findAllByChatId(chatId);
    }

    public Optional<Address> findByContactId(Long contactId) {
        return addressRepository.findByContactId(contactId);
    }

    public Optional<Address> updateEmail(Long contactId, String email) {

        Optional<Address> updatedEmail = this.findByContactId(contactId);

        if (!updatedEmail.isPresent()) {
            log.error("We can't update email, because you don't have chat");
            return Optional.empty();
        }

        Address existingAddress = updatedEmail.get();
        existingAddress.setEmail(email);
        Address updatedEmail1 = addressRepository.save(existingAddress);
        return Optional.of(updatedEmail1);

    }

//          public List<Address> findByContactName(String contactName) {
//        return addressRepository.findByContactName(contactName);
//    }
}
