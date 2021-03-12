import angajati.Administrator;
import angajati.Broker;
import casaLicitatii.CasaLicitatii;
import casaLicitatii.Licitatie;
import clienti.Client;

import java.util.ArrayList;

import static casaLicitatii.CasaLicitatii.instantaUnica;

/**
 * Clasa Main realizeaza efeciv licitatia.
 * Adminul citeste la inceput clientii si produsele din fisierele de intrare si
 * ii introduce in listele aferente.
 * Se adauga brokerii, iar apoi incep licitatiile si solicitarile clientilor.
 */
class Main {
    private static CasaLicitatii casaLicitatii;

    private static CasaLicitatii casaLicitatiiStart(CasaLicitatii casaLicitatii) {
        casaLicitatii.setClienti(new ArrayList<Client>());
        casaLicitatii.setProduseVanzare(new ArrayList<>());
        casaLicitatii.setLicitatiiActive(new ArrayList<>());
        casaLicitatii.setBrokeri(new ArrayList<>());

        return casaLicitatii;
    }

    private static void addBroker() {
        Broker broker = new Broker();

        casaLicitatii.getBrokeri().add(broker);
    }

    public static void main(String[] args) {
        casaLicitatii = instantaUnica();
        casaLicitatiiStart(casaLicitatii);

        Administrator admin = new Administrator();
        admin.citireClienti("clienti.in");
        admin.citireProduse("produse.in");
        
        /* --- Testul 1 --- */
        addBroker();
        addBroker();
        addBroker();
        addBroker();

        Licitatie licitatie = new Licitatie(5,2);
        casaLicitatii.getClienti().get(0).solicitare(licitatie,1,94);
        casaLicitatii.getClienti().get(1).solicitare(licitatie,1,32);
        casaLicitatii.getClienti().get(2).solicitare(licitatie,1,79);
        casaLicitatii.getClienti().get(3).solicitare(licitatie,1,83);
        casaLicitatii.getClienti().get(4).solicitare(licitatie,1,91);

        Licitatie licitatie2 = new Licitatie(5,6);
        casaLicitatii.getClienti().get(0).solicitare(licitatie2,2,11);
        casaLicitatii.getClienti().get(1).solicitare(licitatie2,2,10);
        casaLicitatii.getClienti().get(5).solicitare(licitatie2,2,100);
        casaLicitatii.getClienti().get(3).solicitare(licitatie2,2,10);
        casaLicitatii.getClienti().get(4).solicitare(licitatie2,2,10);

        Licitatie licitatie3 = new Licitatie(2,7);
        casaLicitatii.getClienti().get(5).solicitare(licitatie3,0,112);
        casaLicitatii.getClienti().get(1).solicitare(licitatie3,0,112);

        Licitatie licitatie4 = new Licitatie(7,10);
        casaLicitatii.getClienti().get(0).solicitare(licitatie4,4,13);
        casaLicitatii.getClienti().get(1).solicitare(licitatie4,4,13);
        casaLicitatii.getClienti().get(2).solicitare(licitatie4,4,23);
        casaLicitatii.getClienti().get(3).solicitare(licitatie4,4,21);
        casaLicitatii.getClienti().get(4).solicitare(licitatie4,4,23);
        casaLicitatii.getClienti().get(5).solicitare(licitatie4,4,46);
        casaLicitatii.getClienti().get(6).solicitare(licitatie4,4,32);

        Licitatie licitatie5 = new Licitatie(10,10);
        casaLicitatii.getClienti().get(0).solicitare(licitatie5,12,130);
        casaLicitatii.getClienti().get(1).solicitare(licitatie5,12,13);
        casaLicitatii.getClienti().get(2).solicitare(licitatie5,12,23);
        casaLicitatii.getClienti().get(3).solicitare(licitatie5,12,21);
        casaLicitatii.getClienti().get(4).solicitare(licitatie5,12,23);
        casaLicitatii.getClienti().get(5).solicitare(licitatie5,12,96);
        casaLicitatii.getClienti().get(6).solicitare(licitatie5,12,32);
        casaLicitatii.getClienti().get(7).solicitare(licitatie5,12,133);
        casaLicitatii.getClienti().get(8).solicitare(licitatie5,12,10);
        casaLicitatii.getClienti().get(9).solicitare(licitatie5,12,123);
        /* ---------------- */

    }
}
