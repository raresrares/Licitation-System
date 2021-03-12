package clienti;

public interface ClientFactory {
    /**
     * Creaza clientul in functie de tipul se de persoan (fizica sau juridica) cu ajutorul
     * design pattern-ului FACTORY
     * @return clientul creat
     */
    static Client createClient(String tip, int id, String nume, String adresa,
                               int nrParticipari, int nrLicitatiiCastigate,
                               String p1, String p2) {
        if (tip.equals("PF")) {
            return new PersFizica(id, nume, adresa, nrParticipari, nrLicitatiiCastigate, p1);
        } else if (tip.equals("PJ")) {
            return new PersJuridica(id, nume, adresa, nrParticipari, nrLicitatiiCastigate, p1, Double.parseDouble(p2));
        }

        return null;
    }
}
