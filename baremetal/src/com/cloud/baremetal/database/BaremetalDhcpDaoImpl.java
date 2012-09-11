package com.cloud.baremetal.database;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.naming.ConfigurationException;

import com.cloud.utils.db.DB;
import com.cloud.utils.db.Filter;
import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.GenericSearchBuilder;
import com.cloud.utils.db.SearchBuilder;
import com.cloud.utils.db.SearchCriteria;
import com.cloud.utils.db.SearchCriteria2;

@Local(value=BaremetalDhcpDao.class)
@DB(txn=false)
public class BaremetalDhcpDaoImpl extends GenericDaoBase<BaremetalDhcpVO, Long> implements BaremetalDhcpDao {

    public BaremetalDhcpDaoImpl() {
    }
    
}