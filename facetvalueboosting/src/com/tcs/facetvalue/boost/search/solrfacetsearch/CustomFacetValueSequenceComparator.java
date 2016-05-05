/**
 * 
 */
package com.tcs.facetvalue.boost.search.solrfacetsearch;

import java.util.Comparator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;


/**
 * @author Prabhu Selvaraj
 *
 */

/**
 * CustomFacetValue name comparator. Uses an injected name comparator.
 */
public class CustomFacetValueSequenceComparator implements Comparator<CustomFacetValue>
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(CustomFacetValueSequenceComparator.class);

	private Comparator<Long> comparator;

	@Override
	public int compare(final CustomFacetValue value1, final CustomFacetValue value2)
	{
		if (value1 == null || value2 == null)
		{
			return 0;
		}
		return getComparator().compare(value1.getSequenceValue(), value2.getSequenceValue());
	}

	protected Comparator<Long> getComparator()
	{
		return comparator;
	}

	@Required
	public void setComparator(final Comparator<Long> comparator)
	{
		this.comparator = comparator;
	}
}