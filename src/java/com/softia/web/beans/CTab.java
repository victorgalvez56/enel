package com.softia.web.beans;

import com.softia.web.models.Tab;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class CTab {
    private List<Tab> lstVerificacion;

    public List<Tab> getLstVerificacion() {
        Tab verifi1 = new Tab();
        verifi1.setCodigo("1");
        verifi1.setDescripcion("SI");
        Tab verifi2 = new Tab();
        verifi2.setCodigo("2");
        verifi2.setDescripcion("NO");
        
        lstVerificacion = new ArrayList<>();
        lstVerificacion.add(verifi1);
        lstVerificacion.add(verifi2);
        return lstVerificacion;
    }

    public void setLstVerificacion(List<Tab> lstVerificacion) {
        this.lstVerificacion = lstVerificacion;
    }
}
