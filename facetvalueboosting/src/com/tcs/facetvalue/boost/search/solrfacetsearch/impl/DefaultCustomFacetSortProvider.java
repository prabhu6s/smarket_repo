/**
 * 
 */
package com.tcs.facetvalue.boost.search.solrfacetsearch.impl;

import de.hybris.platform.solrfacetsearch.config.FacetSortProvider;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.IndexedType;
import de.hybris.platform.solrfacetsearch.search.FacetValue;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.collections.ComparatorUtils;
import org.apache.log4j.Logger;


/**
 * @author Prabhu Selvaraj
 *
 */

public class DefaultCustomFacetSortProvider implements FacetSortProvider, Serializable
{
	private static final Logger LOG = Logger.getLogger(DefaultCustomFacetSortProvider.class);
	private boolean descending;
	private Comparator<FacetValue> comparator;

	public boolean isDescending()
	{
		return this.descending;
	}

	public void setDescending(final boolean descending)
	{
		this.descending = descending;
	}

	@Override
	public Comparator<FacetValue> getComparatorForTypeAndProperty(final IndexedType indexedType,
			final IndexedProperty indexedProperty)
	{
		if (LOG.isDebugEnabled())
		{
			LOG.debug("Resolved comparator for facet " + indexedProperty.getName() + " sorting : (reversed=" + isDescending() + ") "
					+ this.comparator.getClass());
		}
		return isDescending() ? ComparatorUtils.reversedComparator(this.comparator) : this.comparator;
	}

	public void setComparator(final Comparator<FacetValue> comparator)
	{
		this.comparator = comparator;
	}
}