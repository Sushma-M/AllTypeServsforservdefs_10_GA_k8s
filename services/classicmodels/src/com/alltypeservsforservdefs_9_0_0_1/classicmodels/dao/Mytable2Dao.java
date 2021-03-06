/*Generated by WaveMaker Studio*/
package com.alltypeservsforservdefs_9_0_0_1.classicmodels.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.alltypeservsforservdefs_9_0_0_1.classicmodels.Mytable2;
import com.alltypeservsforservdefs_9_0_0_1.classicmodels.Mytable2Id;

/**
 * Specifies methods used to obtain and modify Mytable2 related information
 * which is stored in the database.
 */
@Repository("classicmodels.Mytable2Dao")
public class Mytable2Dao extends WMGenericDaoImpl<Mytable2, Mytable2Id> {

    @Autowired
    @Qualifier("classicmodelsTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}