package entities;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@NamedQueries({
    @NamedQuery(name = "Bid.findAll", query = "SELECT b From Bid b")
})
@Table(name = "bid")
public class Bid {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    
    private int bidAmount; 
    
   
    private Product product;
    
    //@OneToOne
    //private Account account; 
    
    public Bid() {}
    public Bid(Product product, int bid) {
    	this.bidAmount=bid;
    	this.product=product;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id=id;
    }
    
    public int getBidAmount() {
        return bidAmount;
    }
    
    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }
   /* public int getAccountId() {
        return account.getId();
    }*/
    public Product getProduct() {
    	return product;
    }
    public void setProduct(Product product) {
    	this.product=product;
    }
    
}