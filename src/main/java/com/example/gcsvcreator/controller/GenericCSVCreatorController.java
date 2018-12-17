package com.example.gcsvcreator.controller;

import com.example.gcsvcreator.csvtestdtos.TestDto;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/csv")
public class GenericCSVCreatorController {
    public final String FOLDER_PATH_TO_SAVE_CSV = "/home/YOUR_USERNAME/";

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testCSVCreator(){

        System.out.println("Testing csv creator");

        List<TestDto> testDtos = Arrays.asList(new TestDto("a1","b1",1),
                new TestDto("a2","b2",2),
                new TestDto("a3","b3",3),
                new TestDto("a4","b4",4));

                try{

            String csvFilePath = FOLDER_PATH_TO_SAVE_CSV + "test.csv";

            beanToCsv(csvFilePath, testDtos);

            System.out.println("csv file created");
            return "Csv file created, Please check your file into "+FOLDER_PATH_TO_SAVE_CSV + " directory.";

        }catch (Exception e){
            System.out.println("csv creator : error");
            e.printStackTrace();
            return "ERROR : "+ e.getMessage();
        }


    }



    public static <E> void beanToCsv(String filePathToWrite, List<E> dtos) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = Files.newBufferedWriter(Paths.get(filePathToWrite));

        StatefulBeanToCsv<E> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        beanToCsv.write(dtos);
        writer.close();
        System.out.printf("CSV generated.");
    }


}
