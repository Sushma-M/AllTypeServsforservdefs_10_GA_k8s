/*Generated by WaveMaker Studio*/
package com.alltypeservsforservdefs_9_0_0_1.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.alltypeservsforservdefs_9_0_0_1.classicmodels.Orderdetails;
import com.alltypeservsforservdefs_9_0_0_1.classicmodels.OrderdetailsId;

/**
 * Service object for domain model class {@link Orderdetails}.
 */
public interface OrderdetailsService {

    /**
     * Creates a new Orderdetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Orderdetails if any.
     *
     * @param orderdetails Details of the Orderdetails to be created; value cannot be null.
     * @return The newly created Orderdetails.
     */
    Orderdetails create(@Valid Orderdetails orderdetails);


	/**
     * Returns Orderdetails by given id if exists.
     *
     * @param orderdetailsId The id of the Orderdetails to get; value cannot be null.
     * @return Orderdetails associated with the given orderdetailsId.
	 * @throws EntityNotFoundException If no Orderdetails is found.
     */
    Orderdetails getById(OrderdetailsId orderdetailsId);

    /**
     * Find and return the Orderdetails by given id if exists, returns null otherwise.
     *
     * @param orderdetailsId The id of the Orderdetails to get; value cannot be null.
     * @return Orderdetails associated with the given orderdetailsId.
     */
    Orderdetails findById(OrderdetailsId orderdetailsId);

	/**
     * Find and return the list of Orderdetails by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param orderdetailsIds The id's of the Orderdetails to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Orderdetails associated with the given orderdetailsIds.
     */
    List<Orderdetails> findByMultipleIds(List<OrderdetailsId> orderdetailsIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Orderdetails. It replaces all fields of the existing Orderdetails with the given orderdetails.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Orderdetails if any.
     *
     * @param orderdetails The details of the Orderdetails to be updated; value cannot be null.
     * @return The updated Orderdetails.
     * @throws EntityNotFoundException if no Orderdetails is found with given input.
     */
    Orderdetails update(@Valid Orderdetails orderdetails);

    /**
     * Deletes an existing Orderdetails with the given id.
     *
     * @param orderdetailsId The id of the Orderdetails to be deleted; value cannot be null.
     * @return The deleted Orderdetails.
     * @throws EntityNotFoundException if no Orderdetails found with the given id.
     */
    Orderdetails delete(OrderdetailsId orderdetailsId);

    /**
     * Deletes an existing Orderdetails with the given object.
     *
     * @param orderdetails The instance of the Orderdetails to be deleted; value cannot be null.
     */
    void delete(Orderdetails orderdetails);

    /**
     * Find all Orderdetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Orderdetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Orderdetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Orderdetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Orderdetails.
     *
     * @see Pageable
     * @see Page
     */
    Page<Orderdetails> findAll(String query, Pageable pageable);

    /**
     * Exports all Orderdetails matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all Orderdetails matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the Orderdetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Orderdetails.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}