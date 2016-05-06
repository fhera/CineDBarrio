package aiss.shared.dominio.tviso;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PricingPlans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3499010050556470225L;
	private Boolean subscription;
	private Boolean payPerView;
	private Boolean free;
	private Boolean freeForRegistered;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public PricingPlans() {
	}

	/**
	 * 
	 * @return The subscription
	 */
	public Boolean getSubscription() {
		return subscription;
	}

	/**
	 * 
	 * @param subscription
	 *            The subscription
	 */
	public void setSubscription(Boolean subscription) {
		this.subscription = subscription;
	}

	/**
	 * 
	 * @return The payPerView
	 */
	public Boolean getPayPerView() {
		return payPerView;
	}

	/**
	 * 
	 * @param payPerView
	 *            The pay_per_view
	 */
	public void setPayPerView(Boolean payPerView) {
		this.payPerView = payPerView;
	}

	/**
	 * 
	 * @return The free
	 */
	public Boolean getFree() {
		return free;
	}

	/**
	 * 
	 * @param free
	 *            The free
	 */
	public void setFree(Boolean free) {
		this.free = free;
	}

	/**
	 * 
	 * @return The freeForRegistered
	 */
	public Boolean getFreeForRegistered() {
		return freeForRegistered;
	}

	/**
	 * 
	 * @param freeForRegistered
	 *            The free_for_registered
	 */
	public void setFreeForRegistered(Boolean freeForRegistered) {
		this.freeForRegistered = freeForRegistered;
	}
}
