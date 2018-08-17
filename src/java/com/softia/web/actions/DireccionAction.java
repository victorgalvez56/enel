package com.softia.web.actions;

import com.opensymphony.xwork2.ActionContext;
import com.softia.beans.CClientes;
import com.softia.models.Cliente;
import java.sql.SQLException;
import java.text.ParseException;

public class DireccionAction extends BaseAction {
    private static final long serialVersionUID = -3827439829486925185L;
    Cliente cliente;
    private String suministro;
    
    @Override
    public String execute() {
        setSession(ActionContext.getContext().getSession());
        String user = getSession().get("user").toString();
        String pass = getSession().get("pass").toString();
        
        Cliente sumi = new Cliente();
        sumi.setSumini(getSuministro());
        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"+getSuministro());
        
        CClientes loClientes = new CClientes();
        loClientes.setCliente(sumi);
        loClientes.setUrl(getUrl());
        loClientes.setUser(user);
        loClientes.setPasswd(pass);
        try {
            boolean llOk = loClientes.mxConsultaSuministro();
            if (!llOk) {
                setError(loClientes.getError());
            } else {
                //setCliente(loClientes.getCliente());
            }
        } catch (SQLException | ParseException loErr) {
            setError(loErr.getMessage());
        }
        return "DIRECCION";
    }
    
    public String getJSON() {
        return execute();
    }
    
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the credito to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getSuministro() {
        return suministro;
    }

    public void setSuministro(String suministro) {
        this.suministro = suministro;
    }
}
