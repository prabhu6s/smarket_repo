/**
 * 
 */
package com.tcs.facetvalue.boost.converters.populator;

import de.hybris.platform.solrfacetsearch.config.FacetSortProvider;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.config.ValueRange;
import de.hybris.platform.solrfacetsearch.search.FacetValue;
import de.hybris.platform.solrfacetsearch.search.SearchQuery;
import de.hybris.platform.solrfacetsearch.search.impl.populators.FacetSearchResultFacetsPopulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tcs.facetvalue.boost.search.solrfacetsearch.impl.DefaultCustomFacetSortProvider;
import com.tcs.facetvalue.boost.util.FacetValueBoostingHelper;



/**
 * @author Prabhu Selvaraj
 * 
 */
public class CustomFacetSearchResultFacetsPopulator extends FacetSearchResultFacetsPopulator
{


	private FacetValueBoostingHelper facetValueBoostingHelper;


	@Override
	protected List<FacetValue> sortFacetValues(final SearchQuery searchQuery, final IndexedType indexedType,
			final IndexedProperty indexedProperty, final List<FacetValue> facetValues)
	{
		if (isRanged(indexedProperty))
		{
			final List<ValueRange> valueRanges = getValueRanges(indexedProperty,
					indexedProperty.isCurrency() ? searchQuery.getCurrency() : null);
			final List<FacetValue> sortedFacetValues = new ArrayList(facetValues.size());
			for (final ValueRange valueRange : valueRanges)
			{
				final FacetValue facetValue = findFacetValue(facetValues, valueRange.getName());
				if (facetValue != null)
				{
					sortedFacetValues.add(facetValue);
				}
			}
			return sortedFacetValues;
		}
		final FacetSortProvider sortProvider = getFacetSortProvider(indexedProperty);
		if (sortProvider != null)
		{

			// Sort facet values based on custom sequence order
			if (sortProvider instanceof DefaultCustomFacetSortProvider)
			{
				return facetValueBoostingHelper.getFacetValueBoostingFacets(indexedProperty, facetValues, sortProvider);
			}
			//Sort based on OOB way
			else
			{
				final Comparator<FacetValue> comparator = sortProvider.getComparatorForTypeAndProperty(indexedType, indexedProperty);
				Collections.sort(facetValues, comparator);
			}

		}
		return facetValues;
	}


	/**
	 * @return the facetValueBoostingHelper
	 */
	public FacetValueBoostingHelper getFacetValueBoostingHelper()
	{
		return facetValueBoostingHelper;
	}

	/**
	 * @param facetValueBoostingHelper
	 *           the facetValueBoostingHelper to set
	 */
	public void setFacetValueBoostingHelper(final FacetValueBoostingHelper facetValueBoostingHelper)
	{
		this.facetValueBoostingHelper = facetValueBoostingHelper;
	}

}