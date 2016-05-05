/**
 * 
 */
package com.tcs.facetvalue.boost.util;

import de.hybris.platform.solrfacetsearch.config.FacetSortProvider;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.search.FacetValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tcs.facetvalue.boost.model.FacetValuesBoostingModel;
import com.tcs.facetvalue.boost.search.solrfacetsearch.CustomFacetValue;
import com.tcs.facetvalue.boost.service.impl.DefaultFacetValueBoostingService;


/**
 * @author Prabhu Selvaraj
 * 
 */
public class FacetValueBoostingHelper
{
	private DefaultFacetValueBoostingService facetValueBoostingService;

	public List<FacetValue> getFacetValueBoostingFacets(final IndexedProperty indexedProperty, final List<FacetValue> facetValues,
			final FacetSortProvider sortProvider)
	{
		System.out.println("FacetSortProvider is : " + sortProvider);
		final IndexedType indexedType = null;
		final Comparator<FacetValue> comparator = sortProvider.getComparatorForTypeAndProperty(indexedType, indexedProperty);
		final List<CustomFacetValue> updatedFacetValues = suppressFacetValues(indexedProperty, facetValues);
		Collections.sort(updatedFacetValues, comparator);
		final List<FacetValue> sortedFacetValues = new ArrayList<FacetValue>();
		for (final CustomFacetValue mitre10FacetValue : updatedFacetValues)
		{
			sortedFacetValues.add(mitre10FacetValue.getFacetValue());
		}
		return sortedFacetValues;
	}

	public List<CustomFacetValue> suppressFacetValues(final IndexedProperty indexedProperty, final List<FacetValue> facetValues)
	{
		System.out.println("in suppressFacetValues");
		final List<CustomFacetValue> updatedFacetValues = new ArrayList<CustomFacetValue>();
		System.out.println("FAcet Name : " + indexedProperty.getName());
		final List<FacetValuesBoostingModel> facetValuesList = facetValueBoostingService.getFacetValuesBoosting(indexedProperty
				.getName());
		System.out.println("facetValuesList size : " + facetValuesList.size());
		for (final FacetValue facetValue : facetValues)
		{
			boolean suppress = false;
			int sequenceValue = 0;
			final FacetValuesBoostingModel facetValuesBoostingModel = findFacetValueBoostingModel(facetValuesList,
					facetValue.getName(), facetValue.getDisplayName());
			if (null != facetValue.getDisplayName() && null != facetValuesBoostingModel)
			{
				if (!facetValuesBoostingModel.getSupressed().booleanValue())
				{

					sequenceValue = (facetValuesBoostingModel.getSequence() != null) ? facetValuesBoostingModel.getSequence()
							.intValue() : 0;
					System.out.println("Sequence Value :" + sequenceValue);
				}
				else
				{
					System.out.println("Suppress!!!");
					suppress = true;
				}
			}
			if (!suppress)
			{
				//Sequence value assigned here
				updatedFacetValues.add(new CustomFacetValue(Long.valueOf(sequenceValue), facetValue));
			}
		}
		return updatedFacetValues;
	}

	public FacetValuesBoostingModel findFacetValueBoostingModel(final List<FacetValuesBoostingModel> facetValuesList,
			final String attributeName, final String attributeDisplayName)
	{
		System.out.println("findFacetValueBoostingModel method ... attr:" + attributeName + ",attrdispname:" + attributeName);
		if (null != facetValuesList)
		{
			for (final FacetValuesBoostingModel facetValuesBoostingModel : facetValuesList)
			{
				System.out.println("my attr:" + facetValuesBoostingModel.getFacetValue());
				//Check facetValue(sequence) attribute match with facet name/displayName
				if (attributeName.equalsIgnoreCase(facetValuesBoostingModel.getFacetValue())
						|| attributeDisplayName.equalsIgnoreCase(facetValuesBoostingModel.getFacetValue()))
				{
					System.out.println("Matched!!!");
					return facetValuesBoostingModel;
				}
			}
		}

		return null;
	}

	/**
	 * @return the facetValueBoostingService
	 */
	public DefaultFacetValueBoostingService getFacetValueBoostingService()
	{
		return facetValueBoostingService;
	}

	/**
	 * @param facetValueBoostingService
	 *           the facetValueBoostingService to set
	 */
	public void setFacetValueBoostingService(final DefaultFacetValueBoostingService facetValueBoostingService)
	{
		this.facetValueBoostingService = facetValueBoostingService;
	}
}
