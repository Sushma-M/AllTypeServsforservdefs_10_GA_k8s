/*Generated by WaveMaker Studio*/
package com.alltypeservsforservdefs_9_0_0_1.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.alltypeservsforservdefs_9_0_0_1.classicmodels.Payments;
import com.alltypeservsforservdefs_9_0_0_1.classicmodels.PaymentsId;


/**
 * ServiceImpl object for domain model class Payments.
 *
 * @see Payments
 */
@Service("classicmodels.PaymentsService")
@Validated
public class PaymentsServiceImpl implements PaymentsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentsServiceImpl.class);


    @Autowired
    @Qualifier("classicmodels.PaymentsDao")
    private WMGenericDao<Payments, PaymentsId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Payments, PaymentsId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public Payments create(Payments payments) {
        LOGGER.debug("Creating a new Payments with information: {}", payments);

        Payments paymentsCreated = this.wmGenericDao.create(payments);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(paymentsCreated);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Payments getById(PaymentsId paymentsId) {
        LOGGER.debug("Finding Payments by id: {}", paymentsId);
        return this.wmGenericDao.findById(paymentsId);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Payments findById(PaymentsId paymentsId) {
        LOGGER.debug("Finding Payments by id: {}", paymentsId);
        try {
            return this.wmGenericDao.findById(paymentsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Payments found with id: {}", paymentsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public List<Payments> findByMultipleIds(List<PaymentsId> paymentsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Payments by ids: {}", paymentsIds);

        return this.wmGenericDao.findByMultipleIds(paymentsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public Payments update(Payments payments) {
        LOGGER.debug("Updating Payments with information: {}", payments);

        this.wmGenericDao.update(payments);
        this.wmGenericDao.refresh(payments);

        return payments;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public Payments delete(PaymentsId paymentsId) {
        LOGGER.debug("Deleting Payments with id: {}", paymentsId);
        Payments deleted = this.wmGenericDao.findById(paymentsId);
        if (deleted == null) {
            LOGGER.debug("No Payments found with id: {}", paymentsId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Payments.class.getSimpleName(), paymentsId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public void delete(Payments payments) {
        LOGGER.debug("Deleting Payments with {}", payments);
        this.wmGenericDao.delete(payments);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Payments> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Payments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Payments> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Payments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service classicmodels for table Payments to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service classicmodels for table Payments to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}