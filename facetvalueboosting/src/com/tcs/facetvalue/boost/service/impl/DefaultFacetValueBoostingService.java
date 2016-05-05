/**
 * 
 */
package com.tcs.facetvalue.boost.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.tcs.facetvalue.boost.dao.FacetValueBoostingDao;
import com.tcs.facetvalue.boost.model.FacetValuesBoostingModel;
import com.tcs.facetvalue.boost.service.FacetValueBoostingService;


/**
 * @author Prabhu Selvaraj
 * 
 */
public class DefaultFacetValueBoostingService implements FacetValueBoostingService
{

	@Resource(name = "facetValueBoostingDao")
	private FacetValueBoostingDao facetValueBoostingDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tcs.facetvalue.boost.service.FacetValueBoostingService#getFacetValuesBoosting(java.lang.String)
	 */
	@Override
	public List<FacetValuesBoostingModel> getFacetValuesBoosting(final String facetName)
	{
		final List<FacetValuesBoostingModel> facetValuesConfigList = facetValueBoostingDao.getFacetValueBoosting(facetName);

		return facetValuesConfigList;
	}

	/**
	 * @return the facetValueBoostingDao
	 */
	public FacetValueBoostingDao getFacetValueBoostingDao()
	{
		return facetValueBoostingDao;
	}

	/**
	 * @param facetValueBoostingDao
	 *           the facetValueBoostingDao to set
	 */
	public void setFacetValueBoostingDao(final FacetValueBoostingDao facetValueBoostingDao)
	{
		this.facetValueBoostingDao = facetValueBoostingDao;
	}

}
