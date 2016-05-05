/**
 * 
 */
package com.tcs.facetvalue.boost.search.solrfacetsearch;

import de.hybris.platform.solrfacetsearch.search.FacetValue;


/**
 * @author Prabhu Selvaraj
 *
 */
public class CustomFacetValue extends FacetValue
{
	private Long sequenceValue;
	private FacetValue facetValue;

	public CustomFacetValue(final Long sequenceValue, final FacetValue facetValue)
	{
		super(facetValue.getName(), facetValue.getDisplayName(), facetValue.getCount(), facetValue.isSelected());

		this.sequenceValue = sequenceValue;
		this.facetValue = facetValue;
	}

	/**
	 * @return the sequenceValue
	 */
	public Long getSequenceValue()
	{
		return sequenceValue;
	}

	/**
	 * @param sequenceValue
	 *           the sequenceValue to set
	 */
	public void setSequenceValue(final Long sequenceValue)
	{
		this.sequenceValue = sequenceValue;
	}

	/**
	 * @return the facetValue
	 */
	public FacetValue getFacetValue()
	{
		return facetValue;
	}

	/**
	 * @param facetValue
	 *           the facetValue to set
	 */
	public void setFacetValue(final FacetValue facetValue)
	{
		this.facetValue = facetValue;
	}

}