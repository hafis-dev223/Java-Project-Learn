package SystemEsport.main;

import SystemEsport.entity.Tim;

public class match {

    private String idMatch;
    private Tim TeamA;
    private Tim TeamnB;
    private Tim pemenang;

    public match(String idMatch, Tim teamA, Tim teamnB, Tim pemenang) {
        this.idMatch = idMatch;
        this.TeamA = teamA;
        this.TeamnB = TeamnB;
        this.pemenang = pemenang;
    }

    public String getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(String idMatch) {
        this.idMatch = idMatch;
    }

    public Tim getTeamA() {
        return TeamA;
    }

    public void setTeamA(Tim teamA) {
        TeamA = teamA;
    }

    public Tim getTeamn() {
        return TeamnB;
    }

    public void setTeamn(Tim teamn) {
        TeamnB = teamn;
    }

    public Tim getTeamnB() {
        return TeamnB;
    }

    public void setTeamnB(Tim teamnB) {
        TeamnB = teamnB;
    }

    public Tim getPemenang() {
        return pemenang;
    }

    public void setPemenang(Tim pemenang) {
        this.pemenang = pemenang;
    }

}
