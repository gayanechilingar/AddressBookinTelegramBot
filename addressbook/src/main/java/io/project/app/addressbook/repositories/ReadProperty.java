/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.addressbook.repositories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import lombok.SneakyThrows;

/**
 *
 * @author gayanec
 */
public class ReadProperty {
    
    @SneakyThrows
    public static String getProp(String proper) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        Properties prop = new Properties();
        prop.put("BOT.MASTER.NAME", "GayaneSpeaker_bot");
        prop.put("BOT.MASTER.TOKEN", "1898172709:AAHiTX6I8eRK37BouPTWyiKU4VyloJqY2SI");
        //prop.load(fis);
        return prop.getProperty(proper);
    }
    
}
