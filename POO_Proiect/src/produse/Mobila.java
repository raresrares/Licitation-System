package produse;

public class Mobila extends Produs {
    String tip;
    String material;

    private void setTip(String tip) {
        this.tip = tip;
    }
    private void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Creaza produsul mobila cu ajutorul design pattern-ului BUILDER
     */
    public static class MobilaBuilder{
        public final Mobila mobila = new Mobila();

        protected MobilaBuilder setId(int id) {
            mobila.setId(id);
            return this;
        }
        protected MobilaBuilder setNume(String nume) {
            mobila.setNume(nume);
            return this;
        }
        protected MobilaBuilder setPretMinim(double pretMinim) {
            mobila.setPretMinim(pretMinim);
            return this;
        }
        protected MobilaBuilder setAn(int an) {
            mobila.setAn(an);
            return this;
        }
        protected MobilaBuilder setTip(String tip) {
            mobila.setTip(tip);
            return this;
        }
        protected MobilaBuilder setMaterial(String material) {
            mobila.setMaterial(material);
            return this;
        }

        protected Mobila build() {
            return mobila;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "tip='" + tip + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
