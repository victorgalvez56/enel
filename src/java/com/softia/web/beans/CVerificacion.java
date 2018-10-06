package com.softia.web.beans;

import com.softia.web.models.Verificacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class CVerificacion {
    private List<Verificacion> lstVerifiPerfCB;
    private List<Verificacion> lstVerifiPerfCNB;
    private List<Verificacion> lstLineaCreCB;
    private List<Verificacion> lstLineaCreCNB;
 
    public List<Verificacion> getLstVerifiPerfCB() {
        Verificacion perfilV1 = new Verificacion();
        perfilV1.setCodigo("1");
        perfilV1.setPerfil("PERFIL A");
        Verificacion perfilV2 = new Verificacion();
        perfilV2.setCodigo("2");
        perfilV2.setPerfil("PERFIL B");
        
        lstVerifiPerfCB = new ArrayList<>();
        lstVerifiPerfCB.add(perfilV1);
        lstVerifiPerfCB.add(perfilV2);
        return lstVerifiPerfCB;
    }

    public void setLstVerifiPerfCB(List<Verificacion> lstVerifiPerfCB) {
        this.lstVerifiPerfCB = lstVerifiPerfCB;
    }
    
    public List<Verificacion> getLstVerifiPerfCNB() {
        Verificacion perfilV1 = new Verificacion();
        perfilV1.setCodigo("1");
        perfilV1.setPerfil("PERFIL A");
        Verificacion perfilV2 = new Verificacion();
        perfilV2.setCodigo("2");
        perfilV2.setPerfil("PERFIL B");
        
        lstVerifiPerfCNB = new ArrayList<>();
        lstVerifiPerfCNB.add(perfilV1);
        lstVerifiPerfCNB.add(perfilV2);
        return lstVerifiPerfCNB;
    }

    public void setLstVerifiPerfCNB(List<Verificacion> lstVerifiPerfCNB) {
        this.lstVerifiPerfCNB = lstVerifiPerfCNB;
    }
    
    public List<Verificacion> getLstLineaCreCB() {
        Verificacion perfilV1 = new Verificacion();
        perfilV1.setCodigo("1");
        perfilV1.setPerfil("PERFIL A");
        Verificacion perfilV2 = new Verificacion();
        perfilV2.setCodigo("2");
        perfilV2.setPerfil("PERFIL B");
        
        lstLineaCreCB = new ArrayList<>();
        lstLineaCreCB.add(perfilV1);
        lstLineaCreCB.add(perfilV2);
        return lstLineaCreCB;
    }

    public void setLstLineaCreCB(List<Verificacion> lstLineaCreCB) {
        this.lstLineaCreCB = lstLineaCreCB;
    }

    public List<Verificacion> getLstLineaCreCNB() {
        Verificacion perfilV1 = new Verificacion();
        perfilV1.setCodigo("1");
        perfilV1.setPerfil("PERFIL A");
        Verificacion perfilV2 = new Verificacion();
        perfilV2.setCodigo("2");
        perfilV2.setPerfil("PERFIL B");
        
        lstLineaCreCNB = new ArrayList<>();
        lstLineaCreCNB.add(perfilV1);
        lstLineaCreCNB.add(perfilV2);
        return lstLineaCreCNB;
    }

    public void setLstLineaCreCNB(List<Verificacion> lstLineaCreCNB) {
        this.lstLineaCreCNB = lstLineaCreCNB;
    }
}
