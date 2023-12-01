/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.springHibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblbarang")

public class Barang {
    @Id
    @Column(name = "IdBrg", length = 8)
    private String IdBrg;

    @Column(name = "NamaBrg", length = 50)
    private String NamaBrg;

    @Column(name = "HrgBrg", length = 50)
    private String HrgBrg;

    @Column(name = "JmlBrg", length = 50)
    private String JmlBrg;

    public String getIdBrg() { 
        return IdBrg; 
    }
    public void setIdBrg(String IdBrg) { 
        this.IdBrg = IdBrg; 
    }

    public String getNamaBrg() { 
        return NamaBrg; 
    }
    public void setNamaBrg(String NamaBrg) { 
        this.NamaBrg = NamaBrg; 
    }

    public String getHrgBrg() { 
        return HrgBrg; 
    }
    public void setHrgBrg(String HrgBrg) { 
        this.HrgBrg = HrgBrg; 
    }

    public String getJmlBrg() { 
        return JmlBrg; 
    }
    public void setJmlBrg(String JmlBrg) { 
        this.JmlBrg = JmlBrg; 
    }

}
