package produse;

public class Tablou extends Produs {
    String numePictor;
    Culori culori;

    public void setNumePictor(String numePictor) {
        this.numePictor = numePictor;
    }
    public void setCulori(Culori culori) {
        this.culori = culori;
    }

    /**
     * Creaza produsul tablou cu ajutorul design pattern-ului BUILDER
     */
    public static class TablouBuilder{
        public final Tablou tablou = new Tablou();

        protected TablouBuilder setId(int id) {
            tablou.setId(id);
            return this;
        }
        protected TablouBuilder setNume(String nume) {
            tablou.setNume(nume);
            return this;
        }
        protected TablouBuilder setPretMinim(double pretMinim) {
            tablou.setPretMinim(pretMinim);
            return this;
        }
        protected TablouBuilder setAn(int an) {
            tablou.setAn(an);
            return this;
        }
        protected TablouBuilder setNumePictor(String numePictor) {
            tablou.setNumePictor(numePictor);
            return this;
        }
        protected TablouBuilder setCulori(Culori culori) {
            tablou.setCulori(culori);
            return this;
        }

        protected Tablou build() {
            return tablou;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "numePictor='" + numePictor + '\'' +
                ", culori=" + culori +
                '}';
    }
}
