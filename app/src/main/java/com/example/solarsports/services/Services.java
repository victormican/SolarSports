package com.example.solarsports.services;

import java.io.*;
import java.util.*;

public class Services {

    public static void main(String[] args) {
        List<String[]> registros = readRecordsFromFile("Registros.txt");
        List<String[]> paneles = readRecordsFromFile("Paneles.txt");

        float averageEnergySavings = calculateAverageEnergySavings(registros);
        float averageMoneySavings = calculateAverageMoneySavings(registros);

        Map<String, Float> categorySumMap = calculateSumOfCategories(registros);

        saveDataToFile("promediosData.txt", averageEnergySavings, averageMoneySavings, categorySumMap);

        saveListToFile("panelesList.txt", paneles);
        saveListToFile("gimnasioList.txt", filterByCategory(registros, "gimnasio"));
        saveListToFile("canchasList.txt", filterByCategory(registros, "cancha"));
    }

    public static List<String[]> readRecordsFromFile(String fileName) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                records.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public static float calculateAverageEnergySavings(List<String[]> records) {
        // ...
        // Cálculo del promedio de ahorro de energía
        return 0;
    }

    public static float calculateAverageMoneySavings(List<String[]> records) {
        // ...
        // Cálculo del promedio de ahorro en dinero
        return 0;
    }

    public static Map<String, Float> calculateSumOfCategories(List<String[]> records) {
        // ...
        // Cálculo de la suma por categoría y mes
        return new HashMap<>();
    }

    public static List<String[]> filterByCategory(List<String[]> records, String category) {
        // ...
        // Filtrar registros por categoría
        return new ArrayList<>();
    }

    public static void saveDataToFile(String fileName, float avgEnergy, float avgMoney, Map<String, Float> categorySumMap) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Average Energy Savings: " + avgEnergy);
            writer.println("Average Money Savings: " + avgMoney);
            writer.println("Category Summaries:");
            for (Map.Entry<String, Float> entry : categorySumMap.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveListToFile(String fileName, List<String[]> dataList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String[] data : dataList) {
                writer.println(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
