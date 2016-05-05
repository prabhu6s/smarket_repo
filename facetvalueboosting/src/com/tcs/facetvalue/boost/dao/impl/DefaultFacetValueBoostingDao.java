/**
 * 
 */
package com.tcs.facetvalue.boost.dao.impl;


import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.tcs.facetvalue.boost.dao.FacetValueBoostingDao;
import com.tcs.facetvalue.boost.model.FacetValuesBoostingModel;


/**
 * @author Prabhu Selvaraj
 * 
 */
public class DefaultFacetValueBoostingDao implements FacetValueBoostingDao
{

	@Resource
	private FlexibleSearchService flexibleSearchService;
	@Resource
	private ModelService modelService;
	/** Setting up Logger for the class to log the messages. */
	private static final Logger LOG = Logger.getLogger(DefaultFacetValueBoostingDao.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tcs.facetvalue.boost.dao.FacetValueBoostingDao#getFacetValueBoosting(java.lang.String)
	 */
	@Override
	public List<FacetValuesBoostingModel> getFacetValueBoosting(final String facetName)
	{
		final String FACET_VALUES_CONFIG_QUERY = "select {fvc.pk} from {FacetValuesBoosting as fvc} where {fvc.facetName} IN ({{select {sip.pk} from {SolrIndexedProperty as sip} where {sip.name} = '"
				+ facetName + "'}})";
		System.out.println("Query :" + FACET_VALUES_CONFIG_QUERY);
		final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(FACET_VALUES_CONFIG_QUERY);

		final SearchResult<FacetValuesBoostingModel> searchResult = getFlexibleSearchService().search(fQuery);
		System.out.println("searchResult :" + searchResult);
		System.out.println("searchResult.size :" + searchResult.getCount());
		return searchResult.getResult();
	}

	/**
	 * @return the flexibleSearchService
	 */
	public FlexibleSearchService getFlexibleSearchService()
	{
		return flexibleSearchService;
	}

	/**
	 * @param flexibleSearchService
	 *           the flexibleSearchService to set
	 */
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

}
