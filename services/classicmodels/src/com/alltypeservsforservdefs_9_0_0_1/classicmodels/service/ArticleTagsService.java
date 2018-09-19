/*Generated by WaveMaker Studio*/
package com.alltypeservsforservdefs_9_0_0_1.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.alltypeservsforservdefs_9_0_0_1.classicmodels.ArticleTags;
import com.alltypeservsforservdefs_9_0_0_1.classicmodels.ArticleTagsId;

/**
 * Service object for domain model class {@link ArticleTags}.
 */
public interface ArticleTagsService {

    /**
     * Creates a new ArticleTags. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ArticleTags if any.
     *
     * @param articleTags Details of the ArticleTags to be created; value cannot be null.
     * @return The newly created ArticleTags.
     */
	ArticleTags create(@Valid ArticleTags articleTags);


	/**
	 * Returns ArticleTags by given id if exists.
	 *
	 * @param articletagsId The id of the ArticleTags to get; value cannot be null.
	 * @return ArticleTags associated with the given articletagsId.
     * @throws EntityNotFoundException If no ArticleTags is found.
	 */
	ArticleTags getById(ArticleTagsId articletagsId) throws EntityNotFoundException;

    /**
	 * Find and return the ArticleTags by given id if exists, returns null otherwise.
	 *
	 * @param articletagsId The id of the ArticleTags to get; value cannot be null.
	 * @return ArticleTags associated with the given articletagsId.
	 */
	ArticleTags findById(ArticleTagsId articletagsId);


	/**
	 * Updates the details of an existing ArticleTags. It replaces all fields of the existing ArticleTags with the given articleTags.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on ArticleTags if any.
     *
	 * @param articleTags The details of the ArticleTags to be updated; value cannot be null.
	 * @return The updated ArticleTags.
	 * @throws EntityNotFoundException if no ArticleTags is found with given input.
	 */
	ArticleTags update(@Valid ArticleTags articleTags) throws EntityNotFoundException;

    /**
	 * Deletes an existing ArticleTags with the given id.
	 *
	 * @param articletagsId The id of the ArticleTags to be deleted; value cannot be null.
	 * @return The deleted ArticleTags.
	 * @throws EntityNotFoundException if no ArticleTags found with the given id.
	 */
	ArticleTags delete(ArticleTagsId articletagsId) throws EntityNotFoundException;

	/**
	 * Find all ArticleTags matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ArticleTags.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<ArticleTags> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all ArticleTags matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ArticleTags.
     *
     * @see Pageable
     * @see Page
	 */
    Page<ArticleTags> findAll(String query, Pageable pageable);

    /**
	 * Exports all ArticleTags matching the given input query to the given exportType format.
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
	 * Retrieve the count of the ArticleTags in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the ArticleTags.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

