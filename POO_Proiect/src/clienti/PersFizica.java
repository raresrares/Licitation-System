package clienti;

public class PersFizica extends Client {
    String dataNastere;

    public PersFizica(int id, String nume, String adresa,
                      int nrParticipari, int nrLicitatiiCastigate, String dataNastere) {

        super(id, nume, adresa, nrParticipari, nrLicitatiiCastigate);
        this.dataNastere = dataNastere;
    }

}
