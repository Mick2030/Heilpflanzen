//import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/** Es wurde auch eine Datenbank angelegt, welche alle Pflanzen verwaltet, da es sinnvoller ist, bei gößeren Datenmengen
 * mit einer Datenbank zu arbeiten. Da das Feld der Phytopharmaka sehr groß ist (das Buch "Wichtl - Teedrogen und
 * Phytopharmaka" hat über 800 Seiten und ist nicht das einzige Buch zu dem Thema), bildet dieser
 * Code nur einen Ausschnitt eines Programmes, welches ich noch schreiben und als App im Playstore anbieten werde.
 * Dieser Code dient nur zur Überprüfung meines Wissens von Java. Das ist auch der Grund, warum ich hier auf die Daten-
 * bank verzichte. Alle Rechte sind vorbehalten.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heilpflanzenkatalog {

    public static void main(String[] args) {
        List<Heilpflanze> pflanzen = new ArrayList<>();

        // 🌿 Teepflanzen zur Liste hinzufügen
        pflanzen.add(new Anis());
        pflanzen.add(new Arnika());
        pflanzen.add(new Cascara());
        pflanzen.add(new Eibisch());
        pflanzen.add(new Enzian());
        pflanzen.add(new Faulbaum());
        pflanzen.add(new Kamille());
        pflanzen.add(new Kuemmel());
        pflanzen.add(new Lavendel());
        pflanzen.add(new Malve());
        pflanzen.add(new Kamille());
        pflanzen.add(new Melisse());
        pflanzen.add(new Primelblueten());
        pflanzen.add(new Primelwurzel());
        pflanzen.add(new Ringelblume());
        pflanzen.add(new Rosmarin());
        pflanzen.add(new Salbei());
        pflanzen.add(new Tausendgueldenkraut());
        pflanzen.add(new Thymian());

        Scanner scanner = new Scanner(System.in);

        // 📌 Benutzer wählt Leiden aus
        System.out.println("Bitte geben Sie Ihre Leiden an:");
        System.out.println("*****************************************");

        // Liste der Hauptkategorien (Leiden) anzeigen
        for (int i = 0; i < Leiden.leiden.size(); i++) {
            System.out.println((i + 1) + ". " + Leiden.leiden.get(i));
        }

        // Benutzerauswahl erfassen
        int choice0 = getValidInput(scanner, Leiden.leiden.size());
        List<String> selectedList = null;

        // 🎯 Leiden-Kategorie auswählen
        switch (choice0) {
            case 1 -> selectedList = Bauchbeschwerden.bauchbeschwerden;
            case 2 -> selectedList = Nervenleiden.nervenleiden;
            case 3 -> selectedList = Atemwegserkrankungen.atemwegserkankungen;
            case 4 -> selectedList = WundenRheuma.wundenrheuma;
            default -> throw new IllegalStateException("Ungültige Auswahl: " + choice0);
        }

        // 📌 Benutzer wählt spezifische Beschwerden aus
        System.out.println("\nBitte wählen Sie Ihre Beschwerden aus:");
        for (int i = 0; i < selectedList.size(); i++) {
            System.out.println((i + 1) + ". " + selectedList.get(i));
        }

        // Benutzerauswahl erfassen
        int choice1 = getValidInput(scanner, selectedList.size());
        List<String> semiFinalList = null;

        // 🩺 Spezifische Beschwerden auswählen
        if (choice0 == 1) { // Bauchbeschwerden
            switch (choice1) {
                case 1 -> semiFinalList = Blaehungen.blaehungen;
                case 2 -> semiFinalList = Verstopfungen.verstopfungen;
                case 3 -> semiFinalList = Verdauungsbeschwerden.verdaungsbeschwerden;
                case 4 -> semiFinalList = Gastrointestinaleentzuendungen.gastrointestinaleentzuendungen;
                case 5 -> semiFinalList = Appetitlosigkeit.appetitlosigkeit;
            }
        } else if (choice0 == 2) { // Nervenleiden
            switch (choice1) {
                case 1 -> semiFinalList = Unruhezustaende.unruhezustaende;
                case 2 -> semiFinalList = Neuropathien.neuropathien;
            }
        } else if (choice0 == 3) { // Atemwegserkrankungen
            switch (choice1) {
                case 1 -> semiFinalList = Katarrh.katarrh;
                case 2 -> semiFinalList = Krampfhusten.krampfhusten;
                case 3 -> semiFinalList = LockerHusten.lockerhusten;
                case 4 -> semiFinalList = Halsschmerzen.halsschmerzen;
                case 5 -> semiFinalList = RachenentzuendungReizhusten.rachenentzuendungreizhusten;
                case 6 -> semiFinalList = Erkaeltung.erkaeltung;
            }
        } else if (choice0 == 4) { // Wunden/Rheuma
            switch (choice1) {
                case 1 -> semiFinalList = Dermatitis.dermatitis;
                case 2 -> semiFinalList = Rheuma.rheuma;
                case 3 -> semiFinalList = WundenMitSchlechterHeilung.wundenmitschlechterheilung;
            }
        }

        // 🍵 Passenden Tee auswählen
        if (semiFinalList != null && !semiFinalList.isEmpty()) {
            System.out.println("\nBitte wählen Sie den gewünschten Tee:\n");
            System.out.println("****************************************\n");

            // Liste der Heiltees anzeigen
            for (int i = 0; i < semiFinalList.size(); i++) {
                System.out.println((i + 1) + ". " + semiFinalList.get(i));
            }

            // Benutzerauswahl erfassen
            int choice2 = getValidInput(scanner, semiFinalList.size());
            String selectedTea = semiFinalList.get(choice2 - 1);

            System.out.println("\nSie haben " + selectedTea + " gewählt.");

            // 🔍 Passende Pflanze in der Liste suchen
            Heilpflanze gefundenePflanze = null;
            for (Heilpflanze pflanze : pflanzen) {
                if (pflanze.intName.equalsIgnoreCase(selectedTea)) {
                    gefundenePflanze = pflanze;
                    break;
                }
            }

            // ℹ️ Pflanze gefunden oder nicht?
            if (gefundenePflanze != null) {
                gefundenePflanze.printInfo(); // Informationen zur Heilpflanze ausgeben
            } else {
                System.out.println("⚠️ Keine genaue Übereinstimmung für " + selectedTea + " gefunden.");
            }
        }

        scanner.close();
    }

    /**
     * 📌 Methode zur sicheren Eingabeüberprüfung
     * @param scanner Scanner-Objekt
     * @param max Maximale zulässige Auswahl
     * @return Gültige Benutzereingabe
     */
    private static int getValidInput(Scanner scanner, int max) {
        int input;
        while (true) {
            if (scanner.hasNextInt()) { // Prüfen, ob eine Zahl eingegeben wurde
                input = scanner.nextInt();
                if (input >= 1 && input <= max) { // Prüfen, ob Zahl im gültigen Bereich liegt
                    return input;
                }
            } else {
                scanner.next(); // Ungültige Eingabe überspringen
            }
            System.out.print("Ungültige Eingabe! Bitte eine Zahl zwischen 1 und " + max + " eingeben: ");
        }
    }
}
        /*

        // Falls finalList ungültig ist
        if (finalList == null) {
            System.out.println("Fehlerhafte Auswahl. Programm beendet.");
            return;
        }

        System.out.println("\nBitte wählen Sie eine Heilpflanze:");
        for (int i = 0; i < finalList.size(); i++) {
            System.out.println((i + 1) + ". " + finalList.get(i));
        }

        int choice2 = getValidInput(scanner, finalList.size());
        String selectedPlant = finalList.get(choice2 - 1);

        System.out.println("\nSie haben " + selectedPlant + " gewählt.");
        printData(choice2);

        scanner.close();
    }
}

public static void printData(int ID) {
        String query = "SELECT * FROM heilpflanzen WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("\n⚠️ Keine Daten für ID " + ID + " gefunden.");
                return;
            }

            System.out.println("\n--- Heilpflanzenkatalog ---");

            while (resultSet.next()) {
                System.out.println(
                        "Name: " + resultSet.getString("DeutscherName") + "\n" +
                                "Teename: " + resultSet.getString("Teename") + "\n" +
                                "Phytopharmakum: " + resultSet.getString("Phytopharmakum") + "\n" +
                                "Zubereitungsmethode: " + resultSet.getString("Zubereitungsmethode") + "\n" +
                                "Kontraindikation: " + resultSet.getString("Kontraindikation") + "\n" +
                                "Indikation: " + resultSet.getString("Indikation") + "\n" +
                                "Bild: " + resultSet.getString("Bild") + "\n" +
                                "Nebenwirkungen: " + resultSet.getString("Nebenwirkungen") + "\n" +
                                "Stammpflanze: " + resultSet.getString("Stammpflanze") + "\n" +
                                "Pflanzenfamilie: " + resultSet.getString("Pflanzenfamilie") + "\n" +
                                "Rechte am Bild: " + resultSet.getString("RechteAmBild") + "\n" +
                                "--------------------------"
                );
            }
        } catch (Exception e) {
            System.out.println("⚠️ Fehler beim Abrufen der Daten: " + e.getMessage());
        }
    }

    private static int getValidInput(Scanner scanner, int max) {
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 1 && input <= max) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.print("Ungültige Eingabe! Bitte eine Zahl zwischen 1 und " + max + " eingeben: ");
        }
    }
}

 */