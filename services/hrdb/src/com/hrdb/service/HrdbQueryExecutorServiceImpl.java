/*Generated by WaveMaker Studio*/
package com.hrdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportOptions;
import com.wavemaker.runtime.data.model.QueryProcedureInput;

import com.hrdb.models.query.*;

@Service
public class HrdbQueryExecutorServiceImpl implements HrdbQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HrdbQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("hrdbWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(value = "hrdbTransactionManager", readOnly = true)
    @Override
    public Page<QueryvarResponse> executeQueryvar(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("queryvar", params, QueryvarResponse.class, pageable);
    }

    @Transactional(value = "hrdbTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportQueryvar(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput<QueryvarResponse> queryInput = new QueryProcedureInput<>("queryvar", params, QueryvarResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

}