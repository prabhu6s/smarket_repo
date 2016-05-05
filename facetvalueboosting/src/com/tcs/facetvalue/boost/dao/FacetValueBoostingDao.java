/**
 * 
 */
package com.tcs.facetvalue.boost.dao;

import java.util.List;

import com.tcs.facetvalue.boost.model.FacetValuesBoostingModel;



/**
 * {@link FacetValuesBoostingModel} oriented Data Access Object.
 */
public interface FacetValueBoostingDao
{

	// Dao method to take facet value boostings
	public List<FacetValuesBoostingModel> getFacetValueBoosting(String facetName);

}
