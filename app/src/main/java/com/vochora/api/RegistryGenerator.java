package com.vochora.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RegistryGenerator {
    private final Date data = new Date();

    private String year(){
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String year = yearFormat.format(data);
        return year;
    }

    private String semester(){
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        String month = monthFormat.format(data);
        String semester;

        switch (month){
            case "January":
            case "February":
            case "March":
            case "April":
            case "May":
            case "June":
                semester = "1";
                break;
            default:
                semester = "2";
                break;
        }

        return semester;
    }

    private String randomNumber(int lenghtRegistry){
        Random random = new Random();
        String randomNumber = "";
        String number;
        while (randomNumber.length() < lenghtRegistry){
            number = Integer.toString(random.nextInt(9));
            randomNumber += number;
        }
        return randomNumber;
    }

    public String registry(int lenghtRegistry){
        String registry = year() + semester() + randomNumber(lenghtRegistry);
        return registry;
    }
}
