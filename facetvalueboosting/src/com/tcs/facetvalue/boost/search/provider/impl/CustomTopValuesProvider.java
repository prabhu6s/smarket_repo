/**
 * 
 */
package com.tcs.facetvalue.boost.search.provider.impl;

import de.hybris.platform.commerceservices.search.solrfacetsearch.provider.impl.DefaultTopValuesProvider;
import de.hybris.platform.solrfacetsearch.config.FacetSortProvider;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.search.FacetValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import com.tcs.facetvalue.boost.search.solrfacetsearch.impl.DefaultCustomFacetSortProvider;
import com.tcs.facetvalue.boost.util.FacetValueBoostingHelper;



/**
 * @author Prabhu Selvaraj
 * 
 */
public class CustomTopValuesProvider extends DefaultTopValuesProvider implements BeanFactoryAware
{

	private BeanFactory beanFactory;
	private FacetValueBoostingHelper facetValueBoostingHelper;

	@Override
	public List<FacetValue> getTopValues(final IndexedProperty indexedProperty, final List<FacetValue> facets)
	{

		// Sort facet values based on custom sequence order
		final FacetSortProvider sortProvider = getFacetSortProvider(indexedProperty);
		if (sortProvider != null && sortProvider instanceof DefaultCustomFacetSortProvider)
		{
			return facetValueBoostingHelper.getFacetValueBoostingFacets(indexedProperty, facets, sortProvider);
		}

		// Sort facet values based on OOB topvalueprovider way

		// Sort the facet values by Count in descending order
		Collections.sort(facets, FacetValueCountComparator.INSTANCE);

		final List<FacetValue> topFacetValues = new ArrayList<FacetValue>();

		if (facets != null)
		{
			for (final FacetValue facetValue : facets)
			{
				if (facetValue != null && (topFacetValues.size() < getTopFacetCount() || facetValue.isSelected()))
				{
					topFacetValues.add(facetValue);
				}
			}

			if (topFacetValues.size() >= facets.size())
			{
				return Collections.emptyList();
			}
		}

		return topFacetValues;
	}

	protected FacetSortProvider getFacetSortProvider(final IndexedProperty indexedProperty)
	{
		final String name = indexedProperty.getFacetSortProvider();
		return name == null ? null : (FacetSortProvider) this.beanFactory.getBean(name, FacetSortProvider.class);
	}

	/**
	 * @return the beanFactory
	 */
	public BeanFactory getBeanFactory()
	{
		return beanFactory;
	}

	/**
	 * @param beanFactory
	 *           the beanFactory to set
	 */
	public void setBeanFactory(final BeanFactory beanFactory)
	{
		this.beanFactory = beanFactory;
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
