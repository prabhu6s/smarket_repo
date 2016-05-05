/**
 * 
 */
package com.tcs.facetvalue.boost.service;

import java.util.List;

import com.tcs.facetvalue.boost.model.FacetValuesBoostingModel;


/**
 * @author Prabhu Selvaraj
 * 
 */
public interface FacetValueBoostingService
{


	public List<FacetValuesBoostingModel> getFacetValuesBoosting(final String facetName);

}
