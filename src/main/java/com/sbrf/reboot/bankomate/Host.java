package com.sbrf.reboot.bankomate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Data
public class Host {
    private Message message;

    public void deserializeMessageFromXml() {
        try {
            XmlMapper xmlMapper = new XmlMapper();

            String xmlString = new String(Files.readAllBytes(Paths.get("serialized.xml")));
            this.message = xmlMapper.readValue(xmlString, Message.class);

            System.out.println("Внутри HOST deserializeMessageFromXml " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeMessageFromJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            String jsonString = new String(Files.readAllBytes(Paths.get("serialized.json")));
            this.message = mapper.readValue(jsonString, Message.class);

            System.out.println("Внутри HOST deserializeMessageFromJson " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
