package entities;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int productId;
  
  @Column(name="productName")
  private String productName;
  @Column(name="description")
  private String description; //Description
  @Column(name="productRating")
  private double productRating;
  
  @ManyToOne
  @JoinTable(name="products", joinColumns = @JoinColumn(name="productId"), inverseJoinColumns = @JoinColumn(name="accountId"))
  private Account account;
  
  
  /*@Temporal(TemporalType.TIMESTAMP)
  private Date endTime; //java.util.Date || java.util.Calendar

  private Boolean published;*/

  public Product() {}
  
  public Product(String name, Account account, String description, double rating) {
	  this.productName=name;
	  setAccount(account);
	  this.description=description;
	  this.productRating=rating;
  }
  

  public String getProductName() {
    return productName;
  }

  public void setProductName(String name) {
    this.productName = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  private double getProductRating() {
    return productRating;
  }

  public void setProductRating(double productRating) {
    this.productRating = productRating;
  }
  
  /*public Boolean isPublished() {
	  return published;
  }
  
  public void setPublish(Boolean publish) {
	  this.published = publish; 
  }
  
  public void setFeedback(Feedback feedback) {
	  this.feedback = feedback;
  }
  
  public Feedback getFeedback() {
	  return feedback;
  }*/


public void setAccount(Account account) {
	//linking them is the problem
	this.account=account;
	if(!account.getProducts().contains(this))
		account.addProduct(this);
}


public Account getAccount() {
	return account;
}
  
}
