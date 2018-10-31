package com.softia.web.beans;

import com.softia.web.models.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class CProduct {
    private List<Product> lstProducts;
    
    public List<Product> getLstProducts() {
        Product producto1 = new Product();
        producto1.setCod(1);
        producto1.setCodigo("001");
        producto1.setProducto("COCINAS");
        producto1.setPorcentaje(100.0);
        Product producto2 = new Product();
        producto2.setCod(2);
        producto2.setCodigo("002");
        producto2.setProducto("RAPIDUCHAS");
        producto2.setPorcentaje(0.05);
        Product producto3 = new Product();
        producto3.setCod(3);
        producto3.setCodigo("003");
        producto3.setProducto("PEDS");
        producto3.setPorcentaje(1.0);
        Product producto4 = new Product();
        producto4.setCod(4);
        producto4.setCodigo("004");
        producto4.setProducto("BICICLETAS");
        producto4.setPorcentaje(45.0);
        
        lstProducts = new ArrayList<>();
        lstProducts.add(producto1);
        lstProducts.add(producto2);
        lstProducts.add(producto3);
        lstProducts.add(producto4);
        return lstProducts;
    }
    
    public void setLstProducts(List<Product> lstProducts) {
        this.lstProducts = lstProducts;
    }
}
