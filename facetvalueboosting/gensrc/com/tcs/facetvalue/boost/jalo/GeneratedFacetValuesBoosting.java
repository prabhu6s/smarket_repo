/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 5, 2016 1:28:29 PM                      ---
 * ----------------------------------------------------------------
 */
package com.tcs.facetvalue.boost.jalo;

import com.tcs.facetvalue.boost.constants.FacetvalueboostingConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.solrfacetsearch.jalo.config.SolrIndexedProperty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link com.tcs.facetvalue.boost.jalo.FacetValuesBoosting FacetValuesBoosting}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedFacetValuesBoosting extends GenericItem
{
	/** Qualifier of the <code>FacetValuesBoosting.facetName</code> attribute **/
	public static final String FACETNAME = "facetName";
	/** Qualifier of the <code>FacetValuesBoosting.supressed</code> attribute **/
	public static final String SUPRESSED = "supressed";
	/** Qualifier of the <code>FacetValuesBoosting.facetValue</code> attribute **/
	public static final String FACETVALUE = "facetValue";
	/** Qualifier of the <code>FacetValuesBoosting.sequence</code> attribute **/
	public static final String SEQUENCE = "sequence";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(FACETNAME, AttributeMode.INITIAL);
		tmp.put(SUPRESSED, AttributeMode.INITIAL);
		tmp.put(FACETVALUE, AttributeMode.INITIAL);
		tmp.put(SEQUENCE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.facetName</code> attribute.
	 * @return the facetName
	 */
	public SolrIndexedProperty getFacetName(final SessionContext ctx)
	{
		return (SolrIndexedProperty)getProperty( ctx, FACETNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.facetName</code> attribute.
	 * @return the facetName
	 */
	public SolrIndexedProperty getFacetName()
	{
		return getFacetName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.facetName</code> attribute. 
	 * @param value the facetName
	 */
	public void setFacetName(final SessionContext ctx, final SolrIndexedProperty value)
	{
		setProperty(ctx, FACETNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.facetName</code> attribute. 
	 * @param value the facetName
	 */
	public void setFacetName(final SolrIndexedProperty value)
	{
		setFacetName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.facetValue</code> attribute.
	 * @return the facetValue
	 */
	public String getFacetValue(final SessionContext ctx)
	{
		return (String)getProperty( ctx, FACETVALUE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.facetValue</code> attribute.
	 * @return the facetValue
	 */
	public String getFacetValue()
	{
		return getFacetValue( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.facetValue</code> attribute. 
	 * @param value the facetValue
	 */
	public void setFacetValue(final SessionContext ctx, final String value)
	{
		setProperty(ctx, FACETVALUE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.facetValue</code> attribute. 
	 * @param value the facetValue
	 */
	public void setFacetValue(final String value)
	{
		setFacetValue( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.sequence</code> attribute.
	 * @return the sequence
	 */
	public Integer getSequence(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, SEQUENCE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.sequence</code> attribute.
	 * @return the sequence
	 */
	public Integer getSequence()
	{
		return getSequence( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.sequence</code> attribute. 
	 * @return the sequence
	 */
	public int getSequenceAsPrimitive(final SessionContext ctx)
	{
		Integer value = getSequence( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.sequence</code> attribute. 
	 * @return the sequence
	 */
	public int getSequenceAsPrimitive()
	{
		return getSequenceAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.sequence</code> attribute. 
	 * @param value the sequence
	 */
	public void setSequence(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, SEQUENCE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.sequence</code> attribute. 
	 * @param value the sequence
	 */
	public void setSequence(final Integer value)
	{
		setSequence( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.sequence</code> attribute. 
	 * @param value the sequence
	 */
	public void setSequence(final SessionContext ctx, final int value)
	{
		setSequence( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.sequence</code> attribute. 
	 * @param value the sequence
	 */
	public void setSequence(final int value)
	{
		setSequence( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.supressed</code> attribute.
	 * @return the supressed
	 */
	public Boolean isSupressed(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, SUPRESSED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.supressed</code> attribute.
	 * @return the supressed
	 */
	public Boolean isSupressed()
	{
		return isSupressed( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.supressed</code> attribute. 
	 * @return the supressed
	 */
	public boolean isSupressedAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isSupressed( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FacetValuesBoosting.supressed</code> attribute. 
	 * @return the supressed
	 */
	public boolean isSupressedAsPrimitive()
	{
		return isSupressedAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.supressed</code> attribute. 
	 * @param value the supressed
	 */
	public void setSupressed(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, SUPRESSED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.supressed</code> attribute. 
	 * @param value the supressed
	 */
	public void setSupressed(final Boolean value)
	{
		setSupressed( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.supressed</code> attribute. 
	 * @param value the supressed
	 */
	public void setSupressed(final SessionContext ctx, final boolean value)
	{
		setSupressed( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FacetValuesBoosting.supressed</code> attribute. 
	 * @param value the supressed
	 */
	public void setSupressed(final boolean value)
	{
		setSupressed( getSession().getSessionContext(), value );
	}
	
}
