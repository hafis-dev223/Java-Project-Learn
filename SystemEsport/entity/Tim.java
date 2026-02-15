package SystemEsport.entity;

import java.util.Set;
import java.util.HashSet;

public class Tim {

    private String Idtim;
    private String namaTim;
    private int PoinKalah;
    private int PoinMenang;

    public Set<player> daftarTim = new HashSet<>();

    public Tim(String idtim, String namaTim, int poinKalah, int poinMenang) {
        this.Idtim = idtim;
        this.namaTim = namaTim;
        this.PoinKalah = poinKalah;
        this.PoinMenang = poinMenang;
    }

    public String getIdtim() {
        return Idtim;
    }

    public void setIdtim(String idtim) {
        Idtim = idtim;
    }

    public String getNamaTim() {
        return namaTim;
    }

    public void setNamaTim(String namaTim) {
        this.namaTim = namaTim;
    }

    public int getPoinKalah() {
        return PoinKalah;
    }

    public void setPoinKalah(int poinKalah) {
        PoinKalah = poinKalah;
    }

    public int getPoinMenang() {
        return PoinMenang;
    }

    public void setPoinMenang(int poinMenang) {
        PoinMenang = poinMenang;
    }

    public int getPoin() {
        return (PoinMenang * 3);
    }

}
