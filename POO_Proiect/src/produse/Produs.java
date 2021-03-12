package produse;

public class Produs implements ProdusFactory {
    private int id;
    private String nume;
    private double pretVanzare;
    private double pretMinim;
    private int an;

    protected void setId(int id) {
        this.id = id;
    }
    protected void setNume(String nume) {
        this.nume = nume;
    }
    public void setPretVanzare(double pretVanzare) {
        this.pretVanzare = pretVanzare;
    }
    protected void setPretMinim(double pretMinim) {
        this.pretMinim = pretMinim;
    }
    protected void setAn(int an) {
        this.an = an;
    }

    protected Produs() {
    }

    public int getID() {
        return id;
    }
    public double getPretMinim() {
        return pretMinim;
    }

    @Override
    public String toString() {
        return "produse.Produs{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pretVanzare=" + pretVanzare +
                ", pretMinim=" + pretMinim +
                ", an=" + an;
    }
}
