/**
 * 
 */
package com.tcs.facetvalue.boost.search.solrfacetsearch;

import de.hybris.platform.commerceservices.util.AbstractComparator;


/**
 * @author Prabhu Selvaraj
 * 
 */
public class CustomFacetValueComparator extends AbstractComparator<Long>
{
	@Override
	protected int compareInstances(final Long facet1SeqVal, final Long facet2SeqVal)
	{
		return facet1SeqVal.longValue() < facet2SeqVal.longValue() ? 1 : (facet1SeqVal.longValue() > facet2SeqVal.longValue() ? -1
				: 0);
	}
}