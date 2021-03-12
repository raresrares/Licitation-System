package clienti;

import angajati.Broker;
import casaLicitatii.CasaLicitatii;
import casaLicitatii.Licitatie;

public class Client implements ClientFactory {
    private static final CasaLicitatii casaLicitatii = CasaLicitatii.instantaUnica();

    private int id;
    private String nume;
    private String adresa;
    private int nrParticipari;
    private int nrLicitatiiCastigate;

    private Broker broker;
    private double pretMaxim;
    private double pretCurent;

    public double getPretCurent() {
        return pretCurent;
    }
    public void setPretCurent(double pretCurent) {
        this.pretCurent = pretCurent;
    }

    public int getNrParticipari() {
        return nrParticipari;
    }
    public void setNrParticipari(int nrParticipari) {
        this.nrParticipari = nrParticipari;
    }

    public Broker getBroker() {
        return broker;
    }
    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public double getPretMaxim() {
        return pretMaxim;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getNrLicitatiiCastigate() {
        return nrLicitatiiCastigate;
    }
    public void setNrLicitatiiCastigate(int nrLicitatiiCastigate) {
        this.nrLicitatiiCastigate = nrLicitatiiCastigate;
    }

    public Client(int id, String nume, String adresa, int nrParticipari, int nrLicitatiiCastigate) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.nrParticipari = nrParticipari;
        this.nrLicitatiiCastigate = nrLicitatiiCastigate;
    }

    /**
     * Solicitarea clientului
     * @param licitatie licitatia curenta
     * @param id id-ul produsului licitat
     * @param pretMaxim pretul maxim pe care clientul este dispus sa il plateasca
     */
    public void solicitare(Licitatie licitatie, int id, double pretMaxim) {
        licitatie.updateLicitatie();
        licitatie.setIdProdus(id);
        licitatie.setId(id);

        this.pretMaxim = pretMaxim;
        this.setNrParticipari(getNrParticipari() + 1);

        casaLicitatii.asociazaBroker(this);
        licitatie.getClienti().add(this);

        licitatie.checkLicitatie();
    }

    @Override
    public String toString() {
        return nume + " de pe strada " +
                adresa + ".";
    }
}