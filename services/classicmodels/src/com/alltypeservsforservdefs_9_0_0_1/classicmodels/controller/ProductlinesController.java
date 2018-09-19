/*Generated by WaveMaker Studio*/
package com.alltypeservsforservdefs_9_0_0_1.classicmodels.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.alltypeservsforservdefs_9_0_0_1.classicmodels.Productlines;
import com.alltypeservsforservdefs_9_0_0_1.classicmodels.Products;
import com.alltypeservsforservdefs_9_0_0_1.classicmodels.service.ProductlinesService;


/**
 * Controller object for domain model class Productlines.
 * @see Productlines
 */
@RestController("classicmodels.ProductlinesController")
@Api(value = "ProductlinesController", description = "Exposes APIs to work with Productlines resource.")
@RequestMapping("/classicmodels/Productlines")
public class ProductlinesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductlinesController.class);

    @Autowired
	@Qualifier("classicmodels.ProductlinesService")
	private ProductlinesService productlinesService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Productlines instance.")
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Productlines createProductlines(@RequestPart("wm_data_json") Productlines productlines, @RequestPart(value = "image", required = false) MultipartFile _image) {
		LOGGER.debug("Create Productlines with information: {}" , productlines);

    productlines.setImage(WMMultipartUtils.toByteArray(_image));
		productlines = productlinesService.create(productlines);
		LOGGER.debug("Created Productlines with information: {}" , productlines);

	    return productlines;
	}

    @ApiOperation(value = "Returns the Productlines instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Productlines getProductlines(@PathVariable("id") String id) {
        LOGGER.debug("Getting Productlines with id: {}" , id);

        Productlines foundProductlines = productlinesService.getById(id);
        LOGGER.debug("Productlines details with id: {}" , foundProductlines);

        return foundProductlines;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in Productlines instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getProductlinesBLOBContent(@PathVariable("id") String id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in Productlines instance" , fieldName);

        if(!WMRuntimeUtils.isLob(Productlines.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        Productlines productlines = productlinesService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(productlines, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the Productlines instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Productlines editProductlines(@PathVariable("id") String id, @RequestBody Productlines productlines) {
        LOGGER.debug("Editing Productlines with id: {}" , productlines.getProductLine());

        productlines.setProductLine(id);
        productlines = productlinesService.update(productlines);
        LOGGER.debug("Productlines details with id: {}" , productlines);

        return productlines;
    }

    @ApiOperation(value = "Updates the Productlines instance associated with the given id.This API should be used when Productlines instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Productlines editProductlines(@PathVariable("id") String id, MultipartHttpServletRequest multipartHttpServletRequest) {
        Productlines newProductlines = WMMultipartUtils.toObject(multipartHttpServletRequest, Productlines.class, "classicmodels");
        newProductlines.setProductLine(id);

        Productlines oldProductlines = productlinesService.getById(id);
        WMMultipartUtils.updateLobsContent(oldProductlines, newProductlines);
        LOGGER.debug("Updating Productlines with information: {}" , newProductlines);

        return productlinesService.update(newProductlines);
    }

    @ApiOperation(value = "Deletes the Productlines instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteProductlines(@PathVariable("id") String id) {
        LOGGER.debug("Deleting Productlines with id: {}" , id);

        Productlines deletedProductlines = productlinesService.delete(id);

        return deletedProductlines != null;
    }

    /**
     * @deprecated Use {@link #findProductlines(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Productlines instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<Productlines> searchProductlinesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Productlines list by query filter:{}", (Object) queryFilters);
        return productlinesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Productlines instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Productlines> findProductlines(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Productlines list by filter:", query);
        return productlinesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Productlines instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<Productlines> filterProductlines(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Productlines list by filter", query);
        return productlinesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportProductlines(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return productlinesService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportProductlinesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Productlines.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> productlinesService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Productlines instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countProductlines( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Productlines");
		return productlinesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getProductlinesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return productlinesService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/productses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the productses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Products> findAssociatedProductses(@PathVariable("id") String id, Pageable pageable) {

        LOGGER.debug("Fetching all associated productses");
        return productlinesService.findAssociatedProductses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProductlinesService instance
	 */
	protected void setProductlinesService(ProductlinesService service) {
		this.productlinesService = service;
	}

}