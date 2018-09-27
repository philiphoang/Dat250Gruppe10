import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import entities.Bid;
import entities.Product;
import entities.User;

import javax.ws.rs.Path;

@Path("product")
@Stateless
public class RestService {
	
	@Context
	private UriInfo uriInfo;
	@PersistenceContext(unitName = "auctionApplication")
	private EntityManager em;
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getProducts() {
		TypedQuery<Product> query = em.createNamedQuery("SELECT b FROM Product b", Product.class);
		
		List<Product> products = query.getResultList();
		return Response.ok(products).build();
	}
	

	
}
