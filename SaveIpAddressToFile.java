import java.net.*;
import java.io.*;
import java.nio.file.*;

public class SaveIpAddressToFile {
    public static void main(String[] args) {
        try {
            // Hole die lokale IP-Adresse
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();

            // Teile die IP-Adresse in Oktette
            String[] octets = ipAddress.split("\\.");

            // Bestimme den Pfad zum "Dokumente"-Verzeichnis des Benutzers
            String userHome = System.getProperty("user.home");
            Path documentsPath = Paths.get(userHome, "Documents", "ip_address.txt");

            // Erstelle den Dateinamen (ip_address.txt)
            String fileName = documentsPath.toString();

            // Schreibe die ersten drei Zahlen der IP in eine Datei
            if (octets.length >= 3) {
                String firstThreeOctets = octets[0] + "." + octets[1] + "." + octets[2];

                // Erstelle einen FileWriter und BufferedWriter zum Schreiben in die Datei
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                // Schreibe die ersten drei Oktette der IP-Adresse in die Datei
                writer.write(firstThreeOctets);
                writer.close(); // Schlieﬂe den Writer

                System.out.println("Die IP-Adresse wurde in die Datei '" + fileName + "' gespeichert.");
            } else {
                System.out.println("Die IP-Adresse hat nicht genug Oktette.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Fehler beim Abrufen der IP-Adresse: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }
}

