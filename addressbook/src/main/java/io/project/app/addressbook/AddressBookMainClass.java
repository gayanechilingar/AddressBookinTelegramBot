package io.project.app.addressbook;

import io.project.app.addressbook.controllers.TelegramBotController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
@EnableMongoRepositories("io.project.app.addressbook.repositories")
@ComponentScan("io.project.app.addressbook")
@EntityScan("io.project.app.addressbook.domain")
public class AddressBookMainClass {

    public static void main(String[] args) {

        SpringApplication.run(AddressBookMainClass.class, args);
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramBotController());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
//
    }
}
