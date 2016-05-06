package aiss.shared.dominio.tviso;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Source implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7388534003657830774L;
	private String id;
    private MinPrice minPrice;
    private String name;
    private PricingPlans pricingPlans;
    private String signupUrl;
    private String type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }


    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The minPrice
     */
    public MinPrice getMinPrice() {
        return minPrice;
    }

    /**
     * 
     * @param minPrice
     *     The min_price
     */
    public void setMinPrice(MinPrice minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The pricingPlans
     */
    public PricingPlans getPricingPlans() {
        return pricingPlans;
    }

    /**
     * 
     * @param pricingPlans
     *     The pricing_plans
     */
    public void setPricingPlans(PricingPlans pricingPlans) {
        this.pricingPlans = pricingPlans;
    }

    /**
     * 
     * @return
     *     The signupUrl
     */
    public String getSignupUrl() {
        return signupUrl;
    }

    /**
     * 
     * @param signupUrl
     *     The signup_url
     */
    public void setSignupUrl(String signupUrl) {
        this.signupUrl = signupUrl;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }
}
