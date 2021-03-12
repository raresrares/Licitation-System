package angajati;

import casaLicitatii.CasaLicitatii;
import clienti.Client;

import java.util.ArrayList;

/**
 * Clasa Broker care implementeaza interfata Angajat. Campul client retine lista care contine
 * clientii brokerului, iar clientiActivi clientii care se afla in licitatia curenta.
 */
public class Broker implements Angajat {
    private ArrayList<Client> client;
    private ArrayList<Client> clientiActivi;
    private double comision;

    public ArrayList<Client> getClient() {
        return client;
    }

    public ArrayList<Client> getClientiActivi() {
        return clientiActivi;
    }

    public double getComision() {
        return comision;
    }
    public void setComision(double comision) {
        this.comision = comision;
    }

    public Broker() {
        this.client = new ArrayList<>();
        this.clientiActivi = new ArrayList<>();
    }

    public void stergeProdus(CasaLicitatii casaLicitatii, int id) {
        for (int i = 0; i < casaLicitatii.getProduseVanzare().size(); i++)
            if (id == casaLicitatii.getProduseVanzare().get(i).getID()) {
                casaLicitatii.getProduseVanzare().remove(i);
                break;
            }
    }

    public void addClient(Client client) {
        this.getClient().add(client);
    }

    public void addClientActivi(Client client) {
        this.getClientiActivi().add(client);
    }

    /**
     * Se seteaza pretulCurent al clientului
     * @param client clientul
     * @param maxim maximul
     */
    public void askClient(Client client, double maxim) {
        double pret;

        pret = maxim + Math.random() * client.getPretMaxim();
        client.setPretCurent(pret);

        if (client.getPretCurent() >= client.getPretMaxim())
            client.setPretCurent(client.getPretMaxim());
    }

    @Override
    public String toString() {
        return "Broker{" +
                "client=" + client +
                ", clientiActivi=" + clientiActivi +
                '}';
    }
}
