package ru.ifmo.se.pult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.ifmo.se.musicians.MusicBand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FileManager {
    public FileManager() {
    }

    public static LinkedHashSet<MusicBand> readFile(File file) {
        StringBuilder xml = new StringBuilder();
        Scanner scanner = null;
        boolean flag = true;
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Not correct address");
            flag = false;
        }
        assert scanner != null;
        while (flag && scanner.hasNextLine()) {
            xml.append(scanner.nextLine());
        }
        LinkedHashSet<MusicBand> musicBands = new LinkedHashSet<>();
        try {
            Collections.addAll(musicBands, mapper.readValue(xml.toString(), MusicBand[].class));
        } catch (IOException e) {
            System.out.println(e);
        }
        return musicBands;
    }

    public static void saveFile(LinkedHashSet musicBands) {
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        String serialized = null;
        try {
            serialized = mapper.writeValueAsString(musicBands);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(Reader.getStartFile());
            assert serialized != null;
            fileOutputStream.write(serialized.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
