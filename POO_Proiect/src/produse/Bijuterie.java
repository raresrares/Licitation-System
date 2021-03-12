package produse;

public class Bijuterie extends Produs {
    String material;
    boolean piatraPretioasa;

    private void setMaterial(String material) {
        this.material = material;
    }
    private void setPiatraPretioasa(boolean piatraPretioasa) {
        this.piatraPretioasa = piatraPretioasa;
    }

    /**
     * Creaza produsul bijuterie cu ajutorul design pattern-ului BUILDER
     */
    public static class BijuterieBuilder{
        public final Bijuterie bijuterie = new Bijuterie();

        public BijuterieBuilder setId(int id) {
            bijuterie.setId(id);
            return this;
        }
        public BijuterieBuilder setNume(String nume) {
            bijuterie.setNume(nume);
            return this;
        }
        public BijuterieBuilder setPretMinim(double pretMinim) {
            bijuterie.setPretMinim(pretMinim);
            return this;
        }
        public BijuterieBuilder setAn(int an) {
            bijuterie.setAn(an);
            return this;
        }
        public BijuterieBuilder setPiatraPretioasa(Boolean piatraPretioasa) {
            bijuterie.setPiatraPretioasa(piatraPretioasa);
            return this;
        }
        public BijuterieBuilder setMaterial(String material) {
            bijuterie.setMaterial(material);
            return this;
        }

        public Bijuterie build(){
            return bijuterie;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", material='" + material + '\'' +
                ", piatraPretioasa=" + piatraPretioasa +
                '}';
    }

}
