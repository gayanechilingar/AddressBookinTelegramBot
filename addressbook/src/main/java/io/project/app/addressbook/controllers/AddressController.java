package io.project.app.addressbook.controllers;

import io.project.app.addressbook.domain.Address;
import io.project.app.addressbook.dto.ChangeRequest;
import io.project.app.addressbook.services.AddressService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gayanec
 */
@RestController
@RequestMapping("/api/v2/address")
@Slf4j
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> post(@RequestBody Address address) {
        log.info("Create address");
        Optional<Address> savedAddress = addressService.createAddress(address);

        if (savedAddress.isPresent()) {
            log.info("Address saved and all is ok!");
            return ResponseEntity.status(HttpStatus.OK).body(savedAddress.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Sorry I can't save this address, please try again!");
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> put(@RequestBody ChangeRequest changeRequest) {
        log.info("Create address");
        Optional<Address> updatedAddress = addressService.updateEmail(changeRequest.getContaciId(),
                changeRequest.getEmail());
        if (updatedAddress == null) {
            System.out.println("ok we are in if ");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("You don't have this contact Id.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedAddress);

    }

    @GetMapping(path = "/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(@RequestParam Integer chatId) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAllByChatId(chatId));
    }

}
