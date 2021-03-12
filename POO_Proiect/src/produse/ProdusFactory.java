package produse;

public interface ProdusFactory {
    /**
     * Creaza produsul cu ajutorul design pattern-ului FACTORY
     * @return produsul creat in functie de tipul sau
     */
    static Produs createProdus(String tip, String id, String nume,
                               String pretMinim, String an,
                               String p1, String p2) {
        if (tip.equals("mobila")) {
            return new Mobila.MobilaBuilder()
                    .setId(Integer.parseInt(id))
                    .setNume(nume)
                    .setPretMinim(Double.parseDouble(pretMinim))
                    .setAn(Integer.parseInt(an))
                    .setTip(p1)
                    .setMaterial(p2)
                    .build();

        } else if (tip.equals("tablou")) {
            Culori culori = null;
            if (p2.equals("ACRILIC")) {
                culori = Culori.ACRILIC;
            } else if (p2.equals("TEMPERA")) {
                culori = Culori.TEMPERA;
            } else if (p2.equals("ULEI")) {
                culori = Culori.ULEI;
            }

            return new Tablou.TablouBuilder()
                    .setId(Integer.parseInt(id))
                    .setNume(nume)
                    .setPretMinim(Double.parseDouble(pretMinim))
                    .setAn(Integer.parseInt(an))
                    .setNumePictor(p1)
                    .setCulori(culori)
                    .build();

        } else if (tip.equals("bijuterie")) {
            return new Bijuterie.BijuterieBuilder()
                    .setId(Integer.parseInt(id))
                    .setNume(nume)
                    .setPretMinim(Double.parseDouble(pretMinim))
                    .setAn(Integer.parseInt(an))
                    .setMaterial(p1)
                    .setPiatraPretioasa(Boolean.parseBoolean(p2))
                    .build();
        }

        return null;
    }

}
