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

import com.alltypeservsforservdefs_9_0_0_1.classicmodels.IdentityTest;

/**
 * Service object for domain model class {@link IdentityTest}.
 */
public interface IdentityTestService {

    /**
     * Creates a new IdentityTest. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on IdentityTest if any.
     *
     * @param identityTest Details of the IdentityTest to be created; value cannot be null.
     * @return The newly created IdentityTest.
     */
    IdentityTest create(@Valid IdentityTest identityTest);


	/**
     * Returns IdentityTest by given id if exists.
     *
     * @param identitytestId The id of the IdentityTest to get; value cannot be null.
     * @return IdentityTest associated with the given identitytestId.
	 * @throws EntityNotFoundException If no IdentityTest is found.
     */
    IdentityTest getById(String identitytestId);

    /**
     * Find and return the IdentityTest by given id if exists, returns null otherwise.
     *
     * @param identitytestId The id of the IdentityTest to get; value cannot be null.
     * @return IdentityTest associated with the given identitytestId.
     */
    IdentityTest findById(String identitytestId);

	/**
     * Find and return the list of IdentityTests by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param identitytestIds The id's of the IdentityTest to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return IdentityTests associated with the given identitytestIds.
     */
    List<IdentityTest> findByMultipleIds(List<String> identitytestIds, boolean orderedReturn);


    /**
     * Updates the details of an existing IdentityTest. It replaces all fields of the existing IdentityTest with the given identityTest.
     *
     * This method overrides the input field values using Server side or database managed properties defined on IdentityTest if any.
     *
     * @param identityTest The details of the IdentityTest to be updated; value cannot be null.
     * @return The updated IdentityTest.
     * @throws EntityNotFoundException if no IdentityTest is found with given input.
     */
    IdentityTest update(@Valid IdentityTest identityTest);

    /**
     * Deletes an existing IdentityTest with the given id.
     *
     * @param identitytestId The id of the IdentityTest to be deleted; value cannot be null.
     * @return The deleted IdentityTest.
     * @throws EntityNotFoundException if no IdentityTest found with the given id.
     */
    IdentityTest delete(String identitytestId);

    /**
     * Deletes an existing IdentityTest with the given object.
     *
     * @param identityTest The instance of the IdentityTest to be deleted; value cannot be null.
     */
    void delete(IdentityTest identityTest);

    /**
     * Find all IdentityTests matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching IdentityTests.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<IdentityTest> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all IdentityTests matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching IdentityTests.
     *
     * @see Pageable
     * @see Page
     */
    Page<IdentityTest> findAll(String query, Pageable pageable);

    /**
     * Exports all IdentityTests matching the given input query to the given exportType format.
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
     * Exports all IdentityTests matching the given input query to the given exportType format.
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
     * Retrieve the count of the IdentityTests in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the IdentityTest.
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