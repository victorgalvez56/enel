package com.softia.web.beans;


import com.softia.web.models.Tabla;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class CTabla {
    private List<Tabla> lstVerificacion;

    public List<Tabla> getLstVerificacion() {
        Tabla verifi1 = new Tabla();
        verifi1.setCodigo("1");
        verifi1.setDescripcion("SI");
        Tabla verifi2 = new Tabla();
        verifi2.setCodigo("2");
        verifi2.setDescripcion("NO");
        
        lstVerificacion = new ArrayList<>();
        lstVerificacion.add(verifi1);
        lstVerificacion.add(verifi2);
        return lstVerificacion;
    }

    public void setLstVerificacion(List<Tabla> lstVerificacion) {
        this.lstVerificacion = lstVerificacion;
    }
}
