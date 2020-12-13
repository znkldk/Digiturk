package com.baris.reportTools;

public class Rapor {
    //rapor için gereken degişkenler farklı classlardan alınmaktadır burada ki degişkenleri set ederek saglıklı bir rapor tutulabiliyor
    private static String currentScenarioName;
    private static String date;
    private static String errorMessage="-";
    private static String result;

    public static void setCurrentScenarioName(String currentScnarioName) {
        currentScenarioName = currentScnarioName;
    }

    public static void setErrorMessage(String setErrorMessage) {
        errorMessage = setErrorMessage;
    }

    public static void setResult(String setResult) {
        result = setResult;
    }

    public static void setDate(String setDate) {
        date = setDate;
    }

    public String getCurrentScenarioName() {
        return currentScenarioName;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public String getResult() {
        return result;
    }

    public String getDate() {
        return date;
    }

}
