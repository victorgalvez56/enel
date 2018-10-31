package com.softia.web.beans;

import com.softia.web.models.Rango;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class CRango {
    private List<Rango> lstRangosCB;
    private List<Rango> lstRangosCNB;
    
    public List<Rango> getLstRangosCB() {
        Rango perfil1 = new Rango();
        perfil1.setCodigo(1);
        perfil1.setNombre("PERFIL A");
        Rango perfil2 = new Rango();
        perfil2.setCodigo(2);
        perfil2.setNombre("PERFIL B");
        
        lstRangosCB = new ArrayList<>();
        lstRangosCB.add(perfil1);
        lstRangosCB.add(perfil2);
        return lstRangosCB;
    }
    
    public void setLstRangos(List<Rango> lstRangosCB) {
        this.lstRangosCB = lstRangosCB;
    }
    
    public List<Rango> getLstRangosCNB() {
        Rango perfil1 = new Rango();
        perfil1.setCodigo(1);
        perfil1.setNombre("PERFIL A");
        Rango perfil2 = new Rango();
        perfil2.setCodigo(2);
        perfil2.setNombre("PERFIL B");
        
        lstRangosCNB = new ArrayList<>();
        lstRangosCNB.add(perfil1);
        lstRangosCNB.add(perfil2);
        return lstRangosCNB;
    }
    public void setLstRangosCNB(List<Rango> lstRangosCNB) {
        this.lstRangosCNB = lstRangosCNB;
    }
}
