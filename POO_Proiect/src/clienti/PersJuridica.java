package clienti;

public class PersJuridica extends Client {
    Companie companie;
    double capitalSocial;

    public PersJuridica(int id, String nume, String adresa,
                        int nrParticipari, int nrLicitatiiCastigate, String companie, double capitalSocial) {

        super(id, nume, adresa, nrParticipari, nrLicitatiiCastigate);

        if (companie.equals("SRL"))
            this.companie = Companie.SRL;
        else if (companie.equals("SA"))
            this.companie = Companie.SA;

        this.capitalSocial = capitalSocial;
    }

    @Override
    public String toString() {
        return super.toString() + " care este o persJuridica la " +
                " compania " + companie +
                ", capitalSocial " + capitalSocial + ".";
    }
}
