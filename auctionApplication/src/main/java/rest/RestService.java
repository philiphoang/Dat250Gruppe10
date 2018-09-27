package rest;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

import entities.Account;
import entities.Bid;
import entities.Product;
import entities.User;

import javax.ws.rs.Path;

@Path("/auction")
@Stateless
public class RestService {
	
	@Context
	private UriInfo uriInfo;
	//@PersistenceContext(unitName = "auctionApplication")
	//private EntityManager em;
	
	@GET
	@Path("/hei")
	public Response hei() {
		return Response.ok().build();
	}
	@GET
	@Path("/accounts")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getAccounts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("auctionApplication");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Account> query = em.createNamedQuery("SELECT * FROM Account", Account.class);
		
		List<Account> accounts = query.getResultList();
		return Response.ok(accounts).build();
	}
}
