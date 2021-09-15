package com.sbrf.reboot.bankomate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;

@Data
public class ATM {
    private Message message;

    public ATM(Message message){
        this.message = message;
    }

    public void serializeMessageToXml() {
        try {
            XmlMapper xmlMapper = new XmlMapper();

            String xmlString = xmlMapper.writeValueAsString(message);

            //System.out.println(xmlString);

            File xmlOutput = new File("serialized.xml");
            FileWriter fileWriter = new FileWriter(xmlOutput);
            fileWriter.write(xmlString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeMessageToJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            String jsonString = mapper.writeValueAsString(message);

            //System.out.println(jsonString);

            File jsonOutput = new File("serialized.json");
            FileWriter fileWriter = new FileWriter(jsonOutput);
            fileWriter.write(jsonString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
