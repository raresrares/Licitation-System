package angajati;

import casaLicitatii.CasaLicitatii;
import clienti.Client;
import clienti.ClientFactory;
import produse.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clasa Administrator are metodele de citire a produselor si a clientilor.
 * In plus mai contine si metoda de adaugaClient si
 *
 */
public class Administrator implements Angajat {
    private final CasaLicitatii casaLicitatii = CasaLicitatii.instantaUnica();

    /**
     * Adauga Clientul la lista de clienti din casa de licitatii
     * @param casaLicitatii casa de licitatii
     * @param client client de adaugat
     */
    private void adaugaClient(CasaLicitatii casaLicitatii, Client client) {
        casaLicitatii.getClienti().add(client);
    }

    /**
     * Citeste clientii din fisierul de intrare si ii creaza cu ajutorul Factory-ului
     * @param filename numele fisierului
     */
    public void citireClienti(String filename) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(true) {
            assert scanner != null;
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine();
            String[] input = line.split(",");

            Client client;

            if (input[0].equals("PF"))
                client = ClientFactory.createClient(input[0], Integer.parseInt(input[1]), input[2], input[3],
                        0,0, input[4], "");
            else
                client = ClientFactory.createClient(input[0], Integer.parseInt(input[1]), input[2], input[3],
                        0,0, input[4], input[5]);

            adaugaClient(casaLicitatii, client);
        }

        scanner.close();
    }

    /**
     * Citeste produsele din fisierul de intrare si ii creaza cu ajutorul Factory-ului
     * @param filename numele fisierului
     */
    public void citireProduse(String filename) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(true) {
            assert scanner != null;
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine();
            String[] input = line.split(",");

            Produs produs = ProdusFactory.createProdus(input[0], input[1], input[2],
                    input[3], input[4], input[5], input[6]);

            adaugaProdus(casaLicitatii, produs);
        }

        scanner.close();
    }

    /**
     * Adauga Clientul la lista de clienti din casa de licitatii
     * @param casaLicitatii casa de licitatii
     * @param produs produs de adaugat
     */
    public void adaugaProdus(CasaLicitatii casaLicitatii, Produs produs) {
        casaLicitatii.getProduseVanzare().add(produs);
    }
}
