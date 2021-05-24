package io.project.app.addressbook.controllers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotController extends TelegramLongPollingBot {

    ReadProperty prop = new ReadProperty();
    

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Long chat_id = update.getMessage().getChatId();

        if (update.hasMessage()) {

            //we save the message in new Message object
            Message message = update.getMessage();
            
            
            

            //we check that the text is not empty
            if (message != null && message.hasText()) {
                
                
//                String[] result = message.split(" ");

                //we take the text, and convert it to lower case, so even if the user typed "/HELLO" it should work
                String msg = message.getText().toLowerCase();

                //now we tell the bot to respond to specific cases:
                if (msg.equals("/start")) {
                    SendMsg(message, "You can use /contact create , /contact all , "
                            + "/contact update (use for email and zoomId), /contact delete and /contact search commands!");
                    
                } else if (msg.startsWith("/contact create")) {
                    SendMsg(message, "Hello World!");
                } else if (msg.equals("/contact all")) {
                    SendMsg(message, "Ok! let's get the party started 😀");
                    SendMsg(message, "What is your name?");
//                    message = update.getMessage();
                } else if (msg.startsWith("/contact update")) { // 2 variant email and zoomId
                    SendMsg(message, "Good");

                }
                 else if (msg.startsWith("/contact delete")) {
                    SendMsg(message, "Good Morning!");

                }
                
                else if (msg.startsWith("/contact search")) {
                    SendMsg(message, "Good Morning!");
                }


            }
        }
    }

    @SneakyThrows
    public synchronized void sendMsg(String s, Long chat_id) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id + "print chat id");
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(null);
        execute(sendMessage);
    }

    public String getBotUsername() {
        return "AddressBook123_bot";
    }

    public String getBotToken() {
        return "1776112211:AAHORZcgtbHdWDFuXab0IgDAYvAlP-xCbjw";
    }

    protected boolean filter(Message message) {
        return false;
    }

    public void Messages(Update update) {
        Long chat_id = update.getMessage().getChatId();
        String message = update.getMessage().getText();
        sendMsg("Your name is short. Please write again. ", chat_id);
        message = update.getMessage().getText();
        sendMsg("What is your name? ", chat_id);
    }

    
    public void SendMsg(Message message, String s) {
        SendMessage sendMessage = new SendMessage();

        //set the destination, and the text we want to send
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(s);

        //try to send it:
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private static class ReadProperty {

        public ReadProperty() {
        }
    }

}
