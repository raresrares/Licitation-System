package casaLicitatii;

import angajati.Broker;
import clienti.Client;
import clienti.PersFizica;
import clienti.PersJuridica;
import produse.Produs;

import java.util.ArrayList;

/**
 * CasaLicitatii contine metode care incep licitatia, asociaza broker clientului si invers, calculeaza comisionul
 * si alte 2 metode ajutatoare.
 */
public class CasaLicitatii {
    private ArrayList<Produs> produseVanzare;
    private ArrayList<Client> clienti;
    private ArrayList<Licitatie> licitatiiActive;
    private Licitatie licitatieActiva;
    private ArrayList<Broker> brokeri;
    private double sumaMaxima;

    public ArrayList<Client> getClienti() {
        return clienti;
    }
    public void setClienti(ArrayList<Client> clienti) {
        this.clienti = clienti;
    }

    public ArrayList<Produs> getProduseVanzare() {
        return produseVanzare;
    }
    public void setProduseVanzare(ArrayList<Produs> produseVanzare) {
        this.produseVanzare = produseVanzare;
    }

    public ArrayList<Licitatie> getLicitatiiActive() {
        return licitatiiActive;
    }
    public void setLicitatiiActive(ArrayList<Licitatie> licitatiiActive) {
        this.licitatiiActive = licitatiiActive;
    }

    public Licitatie getLicitatieActiva() {
        return licitatieActiva;
    }
    public void setLicitatieActiva(Licitatie licitatieActiva) {
        this.licitatieActiva = licitatieActiva;
    }

    public ArrayList<Broker> getBrokeri() {
        return brokeri;
    }
    public void setBrokeri(ArrayList<Broker> brokeri) {
        this.brokeri = brokeri;
    }

    private static CasaLicitatii casaLicitatii;

    /**
     * Metoda care se asigura ca exista doar o SINGURA instanta a casei de licitatii
     * Design pattern - SINGLETON
     * @return instanta unica a casei de licitatii
     */
    public static CasaLicitatii instantaUnica() {
        if (casaLicitatii == null)
            casaLicitatii = new CasaLicitatii();

        return casaLicitatii;
    }

    /**
     * Asociaza un broker clientului si invers.
     * @param client clientul curent
     */
    public void asociazaBroker(Client client) {
        if (client.getBroker() == null) {
            Broker broker = new Broker();

            int index = (int) (Math.random() * brokeri.size());

            brokeri.get(index).addClient(client);   /* Asociaza BROKER -> CLIENT */
            client.setBroker(broker);               /* Asociaza CLIENT -> BROKER */
        }
    }

    /**
     * Fiecare broker isi intreaba clientii care participa la licitatie
     * @param licitatie licitatia curenta
     */
    public void startLicitatie(Licitatie licitatie) {
        for (int i = 0; i < licitatie.getNrPasiMaxim(); i++) {
            for (Broker broker : casaLicitatii.brokeri) {
                for (Client client : broker.getClientiActivi()) {
                    if (i == 0)
                        broker.askClient(client, 0);
                    else
                        broker.askClient(client, sumaMaxima);
                }
            }
            checkMaxim();
        }

        Client winner = checkSfarsit();
        if (winner != null) {
            winner.setNrLicitatiiCastigate(winner.getNrLicitatiiCastigate() + 1);
            calculeazaComision(winner);

            winner.getBroker().stergeProdus(casaLicitatii, licitatie.getId());// strrge produsul

            System.out.println("Licitatia pentru produsul cu ID-ul " + licitatie.getId() +
                    " a fost castigata de clientul " + winner);
        } else {
            System.out.println("Nimeni nu a castigat licitatia!");
        }


    }

    /**
     * Calculeaza comisionul castigatorului in functie de tipul de persoana
     * @param winner castigatorul licitatiei
     */
    private void calculeazaComision(Client winner) {
        double comision = 0;

        if (winner instanceof PersJuridica) {
            if (winner.getNrLicitatiiCastigate() <= 25)
                comision = winner.getPretCurent() / 4;
            else
                comision = winner.getPretCurent() / 10;
        } else if (winner instanceof PersFizica) {
            if (winner.getNrLicitatiiCastigate() <= 5)
                comision = winner.getPretCurent() / 4;
            else
                comision = winner.getPretCurent() / 6.66;
        }

        winner.getBroker().setComision(winner.getBroker().getComision() + comision);
    }

    /**
     * Cauta pretul maxim
     */
    private void checkMaxim() {
        Produs produsActiv = null;
        double maxim = 0;

        for (Produs p : casaLicitatii.produseVanzare) {
            if (casaLicitatii.licitatieActiva.getId() == p.getID())
                produsActiv = p;
        }

        if (produsActiv != null) {
            for (Broker broker : casaLicitatii.brokeri) {
                for (Client client : broker.getClientiActivi()) {
                    if (client.getPretCurent() >= maxim) {
                        maxim = client.getPretCurent();
                    }
                }
            }
        }

        sumaMaxima = maxim;
    }

    /**
     * Verifica daca licitatia se termina sau nu
     * @return returneaza Clienul castigator
     */
    private Client checkSfarsit() {
        Client winner = new Client(0,"WINNER", null,0, 0);

        winner.setPretCurent(0);

        Produs produsActiv = null;
        for (Produs p : casaLicitatii.produseVanzare) {
            if (casaLicitatii.licitatieActiva.getId() == p.getID())
                produsActiv = p;
        }

        /* Daca produsul cu ID-ul respectiv nu exista return null */
        if (produsActiv == null)
            return null;

        for (Broker broker : casaLicitatii.brokeri) {
            for (Client client : broker.getClientiActivi()) {
                if (client.getPretCurent() > winner.getPretCurent()) {
                    winner = client;
                } else if (client.getPretCurent() == winner.getPretCurent()) {
                    if (client.getNrLicitatiiCastigate() >= winner.getNrLicitatiiCastigate())
                        winner = client;
                }
            }
        }

        if ((winner.getPretCurent() >= produsActiv.getPretMinim())) {
            produsActiv.setPretVanzare(winner.getPretCurent());
            return winner;
        }
        return null;
    }
}
