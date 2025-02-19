package in.pwskill.deepesh.response;

public class Cart {

	private Integer id;
	private String ProductName;
	private Float ProductPrice;
	private Float ProductRating;

	public Cart(Integer id, String productName, Float productPrice, Float productRating) {
		super();
		this.id = id;
		ProductName = productName;
		ProductPrice = productPrice;
		ProductRating = productRating;
	}

	public Cart() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Float getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(Float productPrice) {
		ProductPrice = productPrice;
	}

	public Float getProductRating() {
		return ProductRating;
	}

	public void setProductRating(Float productRating) {
		ProductRating = productRating;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", ProductName=" + ProductName + ", ProductPrice=" + ProductPrice + ", ProductRating="
				+ ProductRating + "]";
	}

}
