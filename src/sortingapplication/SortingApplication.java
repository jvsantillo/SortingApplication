/*
 * 
 *  Class: Algorithms: Sorting and Searching
 *
 */
/**
 * @author Wanderley de Souza Alencar
 */
package sortingapplication;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SortingApplication {

    public static void selectionSort(Table paramTable, int paramNumberOfElements) {
        for (int i = 0, len = paramTable.getNumberOfRecords(); i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (paramTable.compareRecordKey(i, j) == 1) {
                    paramTable.exchangeRecords(i, j);
                }
            }
        }
    }

    public static void heapSort(Table paramTable, int paramNumberOfElements) {
        System.out.println("To be implemented");
    }

    public static void beadSort(Table paramTable, int paramNumberOfElements) {
        System.out.println("To be implemented");
    }

    public static void mergeSort(Table paramTable, int paramNumberOfElements) {
        System.out.println("To be implemented");
    }

    public static void main(String[] args) {
        //
        // The main application should be inserted here..
        //
        int i,
                numberOfRecordsDesired, // Number of record that... you want to generate
                numberOfRecordsGenerated, // effectively generated to the .csv file
                numberOfRecordsLoaded, // recovered from the .csv file
                numberOfRecordsPrinted; // printed (for checking) from the table

        long start,
                elapsed;

        String applicationPath,
                auxiliaryString;

        Random randomNumber;               // an auxiliary variable to random generation...

        IdentificationDocument applicationDocument;

        PersonalRecord applicationRecord;

        Table applicationTable;

        Date birthDay;

        //
        // The path of the application... set up for your use
        //
        applicationPath = "C:\\Users\\jv_sa\\Documents\\NetBeansProjects";
        applicationTable = new Table();
        applicationRecord = new PersonalRecord();
        applicationDocument = new IdentificationDocument();
        birthDay = new Date();
        randomNumber = new Random();

        numberOfRecordsDesired = 1000;
        System.out.println("Generating <" + numberOfRecordsDesired + "> randomly records to form the table.");
        numberOfRecordsGenerated = applicationTable.randomGenerateToCSV(applicationPath + "Table.csv", numberOfRecordsDesired);
        if (numberOfRecordsGenerated != 0) {
            System.out.println("Loading the stored record from  <" + "Table.csv" + "> to the table.");
            numberOfRecordsLoaded = (int) applicationTable.loadFromCSV(applicationPath + "Table.csv", 0, (numberOfRecordsGenerated - 1));
            if (numberOfRecordsLoaded == numberOfRecordsGenerated) {
                System.out.println("Printing records from the table.");
                numberOfRecordsPrinted = applicationTable.print(0, (numberOfRecordsGenerated - 1));
                if (numberOfRecordsPrinted == numberOfRecordsLoaded) {
                    System.out.println("All <" + numberOfRecordsPrinted + "> records were printed.");
                    auxiliaryString = (applicationTable.isSorted()) ? "YES" : "NO";
                    System.out.println("The records are in order by primary key?: " + auxiliaryString);
                    if (auxiliaryString.contains("NO")) {
                        do {
                            System.out.println("\nPlease, choose a sorting method:\n");
                            System.out.println("1 - Selection Sort");
                            System.out.println("2 - Heap Sort");
                            System.out.println("3 - Bead Sort");
                            System.out.println("4 - Merge Sort\n");

                            Scanner leitor = new Scanner(System.in);
                            i = leitor.nextInt();

                            switch (i) {
                                case 1:
                                    start = System.currentTimeMillis();
                                    selectionSort(applicationTable, applicationTable.getNumberOfRecords());
                                    elapsed = System.currentTimeMillis() - start;
                                    System.out.println("\nTime elapsed: " + elapsed + "s");
                                    auxiliaryString = (applicationTable.isSorted()) ? "YES" : "NO";

                                    if (auxiliaryString.contains("YES")) {
                                        System.out.println("The sort by primary key was successful");
                                    } else {
                                        System.out.println("The sort by primary key was not successful");
                                    }
                                    break;

                                case 2:
                                    start = System.currentTimeMillis();
                                    heapSort(applicationTable, applicationTable.getNumberOfRecords());
                                    elapsed = System.currentTimeMillis() - start;
                                    System.out.println("\nTime elapsed: " + elapsed + "s");
                                    auxiliaryString = (applicationTable.isSorted()) ? "YES" : "NO";

                                    if (auxiliaryString.contains("YES")) {
                                        System.out.println("The sort by primary key was successful");
                                    } else {
                                        System.out.println("The sort by primary key was not successful");
                                    }
                                    break;

                                case 3:
                                    start = System.currentTimeMillis();
                                    beadSort(applicationTable, applicationTable.getNumberOfRecords());
                                    elapsed = System.currentTimeMillis() - start;
                                    System.out.println("\nTime elapsed: " + elapsed + "s");
                                    auxiliaryString = (applicationTable.isSorted()) ? "YES" : "NO";

                                    if (auxiliaryString.contains("YES")) {
                                        System.out.println("The sort by primary key was successful");
                                    } else {
                                        System.out.println("The sort by primary key was not successful");
                                    }
                                    break;

                                case 4:
                                    start = System.currentTimeMillis();
                                    mergeSort(applicationTable, applicationTable.getNumberOfRecords());
                                    elapsed = System.currentTimeMillis() - start;
                                    System.out.println("\nTime elapsed: " + elapsed + "s");
                                    auxiliaryString = (applicationTable.isSorted()) ? "YES" : "NO";

                                    if (auxiliaryString.contains("YES")) {
                                        System.out.println("The sort by primary key was successful");
                                    } else {
                                        System.out.println("The sort by primary key was not successful");
                                    }
                                    break;

                            }
                        } while (i > 4 && i < 1);

                    }

                } else {
                    System.out.println("Unfortunately, there are records that have not been printed.");
                    System.out.println("Please check the parameters entered for the priting process.");
                }
            } else {
                System.out.println("Unfortunately there are records that have not been uploaded to the table (from .csv file).");
                System.out.println("Please check the parameters entered for the loading process.");
            }
        } else {
            System.out.println("Unfortunately no record can be generated.");
            System.out.println("Please check the parameters entered for the generation process.");
        }

        applicationTable.print(0,59);

    }

}
