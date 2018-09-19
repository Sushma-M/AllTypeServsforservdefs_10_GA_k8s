/*Generated by WaveMaker Studio*/
package com.alltypeservsforservdefs_9_0_0_1.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.alltypeservsforservdefs_9_0_0_1.classicmodels.Customers;
import com.alltypeservsforservdefs_9_0_0_1.classicmodels.Orders;
import com.alltypeservsforservdefs_9_0_0_1.classicmodels.Payments;


/**
 * ServiceImpl object for domain model class Customers.
 *
 * @see Customers
 */
@Service("classicmodels.CustomersService")
@Validated
public class CustomersServiceImpl implements CustomersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomersServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("classicmodels.PaymentsService")
	private PaymentsService paymentsService;

    @Lazy
    @Autowired
	@Qualifier("classicmodels.OrdersService")
	private OrdersService ordersService;

    @Autowired
    @Qualifier("classicmodels.CustomersDao")
    private WMGenericDao<Customers, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Customers, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
	public Customers create(Customers customers) {
        LOGGER.debug("Creating a new Customers with information: {}", customers);
        Customers customersCreated = this.wmGenericDao.create(customers);
        if(customersCreated.getOrdersesForCustomerNumber() != null) {
            for(Orders ordersesForCustomerNumber : customersCreated.getOrdersesForCustomerNumber()) {
                ordersesForCustomerNumber.setCustomersByCustomerNumber(customersCreated);
                LOGGER.debug("Creating a new child Orders with information: {}", ordersesForCustomerNumber);
                ordersService.create(ordersesForCustomerNumber);
            }
        }

        if(customersCreated.getOrdersesForCustomerNumberRelation() != null) {
            for(Orders ordersesForCustomerNumberRelation : customersCreated.getOrdersesForCustomerNumberRelation()) {
                ordersesForCustomerNumberRelation.setCustomersByCustomerNumberRelation(customersCreated);
                LOGGER.debug("Creating a new child Orders with information: {}", ordersesForCustomerNumberRelation);
                ordersService.create(ordersesForCustomerNumberRelation);
            }
        }

        if(customersCreated.getPaymentsesForCustomerNumber() != null) {
            for(Payments paymentsesForCustomerNumber : customersCreated.getPaymentsesForCustomerNumber()) {
                paymentsesForCustomerNumber.setCustomersByCustomerNumber(customersCreated);
                LOGGER.debug("Creating a new child Payments with information: {}", paymentsesForCustomerNumber);
                paymentsService.create(paymentsesForCustomerNumber);
            }
        }

        if(customersCreated.getPaymentsesForCustomerNumberRelation() != null) {
            for(Payments paymentsesForCustomerNumberRelation : customersCreated.getPaymentsesForCustomerNumberRelation()) {
                paymentsesForCustomerNumberRelation.setCustomersByCustomerNumberRelation(customersCreated);
                LOGGER.debug("Creating a new child Payments with information: {}", paymentsesForCustomerNumberRelation);
                paymentsService.create(paymentsesForCustomerNumberRelation);
            }
        }
        return customersCreated;
    }

	@Transactional(readOnly = true, value = "classicmodelsTransactionManager")
	@Override
	public Customers getById(Integer customersId) throws EntityNotFoundException {
        LOGGER.debug("Finding Customers by id: {}", customersId);
        Customers customers = this.wmGenericDao.findById(customersId);
        if (customers == null){
            LOGGER.debug("No Customers found with id: {}", customersId);
            throw new EntityNotFoundException(String.valueOf(customersId));
        }
        return customers;
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
	@Override
	public Customers findById(Integer customersId) {
        LOGGER.debug("Finding Customers by id: {}", customersId);
        return this.wmGenericDao.findById(customersId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
	@Override
	public Customers update(Customers customers) throws EntityNotFoundException {
        LOGGER.debug("Updating Customers with information: {}", customers);
        this.wmGenericDao.update(customers);

        Integer customersId = customers.getCustomerNumber();

        return this.wmGenericDao.findById(customersId);
    }

    @Transactional(value = "classicmodelsTransactionManager")
	@Override
	public Customers delete(Integer customersId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Customers with id: {}", customersId);
        Customers deleted = this.wmGenericDao.findById(customersId);
        if (deleted == null) {
            LOGGER.debug("No Customers found with id: {}", customersId);
            throw new EntityNotFoundException(String.valueOf(customersId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "classicmodelsTransactionManager")
	@Override
	public Page<Customers> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Customers");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Customers> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Customers");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service classicmodels for table Customers to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
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

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Orders> findAssociatedOrdersesForCustomerNumber(Integer customerNumber, Pageable pageable) {
        LOGGER.debug("Fetching all associated ordersesForCustomerNumber");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("customersByCustomerNumber.customerNumber = '" + customerNumber + "'");

        return ordersService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Orders> findAssociatedOrdersesForCustomerNumberRelation(Integer customerNumber, Pageable pageable) {
        LOGGER.debug("Fetching all associated ordersesForCustomerNumberRelation");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("customersByCustomerNumberRelation.customerNumber = '" + customerNumber + "'");

        return ordersService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Payments> findAssociatedPaymentsesForCustomerNumber(Integer customerNumber, Pageable pageable) {
        LOGGER.debug("Fetching all associated paymentsesForCustomerNumber");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("customersByCustomerNumber.customerNumber = '" + customerNumber + "'");

        return paymentsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Payments> findAssociatedPaymentsesForCustomerNumberRelation(Integer customerNumber, Pageable pageable) {
        LOGGER.debug("Fetching all associated paymentsesForCustomerNumberRelation");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("customersByCustomerNumberRelation.customerNumber = '" + customerNumber + "'");

        return paymentsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PaymentsService instance
	 */
	protected void setPaymentsService(PaymentsService service) {
        this.paymentsService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OrdersService instance
	 */
	protected void setOrdersService(OrdersService service) {
        this.ordersService = service;
    }

}

