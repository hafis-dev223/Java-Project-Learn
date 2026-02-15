package Banking.entity;

import Banking.entity.Exception.Positiveangka;
import Banking.entity.Exception.transferlimit;

/**
 * transaksiBankingInterface
 */
public interface transaksiBankingInterface {

    void lihatsaldo();
     void Tariktunai(String pin) ;
     void  Setortunai() throws Positiveangka;
     void  transfer() throws transferlimit;
}