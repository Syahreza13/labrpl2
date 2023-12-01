/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.springHibernate.dao;

import com.labti.springHibernate.model.Barang;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BarangDAOImpl implements BarangDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Barang barang) {
	sessionFactory.getCurrentSession().save(barang);
    }
    
    @Override
    public void update(Barang barang) {
	sessionFactory.getCurrentSession().update(barang);
    }
    
    @Override
    public void delete(Barang barang) {
	sessionFactory.getCurrentSession().delete(barang);
    }
    
    @Override
    public Barang getBarang(String npm) {
	return (Barang) sessionFactory.getCurrentSession().get(Barang.class, npm);
    }
    
    @Override
    public List<Barang> getBarangs() {
	return sessionFactory.getCurrentSession().createCriteria(Barang.class).list();
    }

}
