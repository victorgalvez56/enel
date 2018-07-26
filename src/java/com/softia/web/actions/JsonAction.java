package com.softia.web.actions;

import com.opensymphony.xwork2.ActionContext;
import com.softia.beans.CDepartamentos;
import com.softia.beans.CDistritos;
import com.softia.beans.CProvincias;
import com.softia.models.Cliente;
import com.softia.models.Direccion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.softia.models.Distrito;
import com.softia.utils.LibFunc;

public class JsonAction extends BaseAction {

    private Map<String, String> departMap;
    private Map<String, String> provinMap;
    private List<Distrito> distriList;

    private String depart;
    private String provin;
    private String distri;

    @Override
    public String execute() {        
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();        
        CDepartamentos loDep = new CDepartamentos();
        loDep.setUrl(getUrl());
        loDep.setUser(user);
        loDep.setPasswd(pass);
        CProvincias loPro = new CProvincias();
        loPro.setUrl(getUrl());
        loPro.setUser(user);
        loPro.setPasswd(pass);
        CDistritos loDis = new CDistritos();
        loDis.setUrl(getUrl());
        loDis.setUser(user);
        loDis.setPasswd(pass);
        departMap = loDep.getDepartamentos();
        provinMap = new HashMap<>();
        depart="1";
        if (!LibFunc.fxEmpty(depart)) {
            provinMap = loPro.getProvincias(depart);
        } else {
            setError(loDep.getError());
        }        
        distriList = new ArrayList<Distrito>();
        provin="1";
        if (!LibFunc.fxEmpty(depart) && !LibFunc.fxEmpty(provin)) {
            distriList = loDis.getDistritos(provin);
        } else {
            setError(loPro.getError());
        }
        return SUCCESS;
    }

    public String getJSON() {
        return execute();
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String dep) {
        this.depart = dep;
    }

    public String getProvin() {
        return provin;
    }

    public void setProvin(String pro) {
        this.provin = pro;
    }

    public String getDistri() {
        return distri;
    }

    public void setDistri(String dis) {
        this.distri = dis;
    }

    public Map<String, String> getDepartMap() {
        return departMap;
    }

    public Map<String, String> getProvinMap() {
        return provinMap;
    }

    public List<Distrito> getDistriList() {
        return distriList;
    }

    public String index() {
        return "success";
    }


}
