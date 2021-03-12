package casaLicitatii;

import clienti.Client;

import java.util.ArrayList;

public class Licitatie extends CasaLicitatii{
    private final CasaLicitatii casaLicitatii = CasaLicitatii.instantaUnica();
    private int id;
    private int nrParticipanti;
    private int idProdus;
    private int nrPasiMaxim;
    private int nrParticipantiActivi;
    private ArrayList<Client> clienti;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public int getNrPasiMaxim() {
        return nrPasiMaxim;
    }

    public ArrayList<Client> getClienti() {
        return clienti;
    }

    public Licitatie(int nrParticipanti, int nrPasiMaxim){
        this.clienti = new ArrayList<>();
        this.nrParticipanti = nrParticipanti;
        this.nrPasiMaxim = nrPasiMaxim;
        this.nrParticipantiActivi = 0;
    }

    public void updateLicitatie() {
        this.nrParticipantiActivi++;
    }

    /**
     * Verifica daca nrParticipanti este egal cu nrParticipantiActivi si face modificarile necesare daca este
     * indeplinita aceasta conditie: start licitatie si adauga clientii participanti la licitatie in lista
     * de clientiActivi ai brokerului.
     */
    public void checkLicitatie() {
        if (this.nrParticipanti == this.nrParticipantiActivi) {
            casaLicitatii.getLicitatiiActive().add(this);
            casaLicitatii.setLicitatieActiva(this);

            // Pentru fiecare broker
            for (int i = 0; i < casaLicitatii.getBrokeri().size(); i++) {
                // Pentru fiecare client al sau
                for (int j = 0; j < casaLicitatii.getBrokeri().get(i).getClient().size(); j++) {
                    // Pentru fiecare participant la licitatie
                    for (int k = 0; k < casaLicitatii.getLicitatieActiva().getClienti().size(); k++) {
                        if (casaLicitatii.getBrokeri().get(i).getClient().get(j) ==
                                casaLicitatii.getLicitatieActiva().getClienti().get(k)) {
                            /* Adauga clientii participanti la licitatie in lista de clientiActivi ai brokerului */
                            casaLicitatii.getBrokeri().get(i).addClientActivi
                                    (casaLicitatii.getLicitatieActiva().getClienti().get(k));
                        }
                    }
                }
            }
            startLicitatie(this);
        }
    }
}