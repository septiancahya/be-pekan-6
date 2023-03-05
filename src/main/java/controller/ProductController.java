package controller;

import model.Product;
import service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {
    @Inject
    ProductService productService;
    @GET
    public List<Product> listProduct() {
        return Product.listAll();
    }

    @GET
    @Path("/{merk}")
    public List<Product> getProductByMerk(@PathParam("merk") String merk) {
        return productService.getProductByMerk(merk);
    }

    @POST
    public Product addProduct(Product product) {
        return productService.createProduct(product);
    }

    @PUT
    @Path("/{id}")
    public Product changeProduct(@PathParam("id") String id, Product product) {
        return productService.changeProduct(id, product);
    }

    @PATCH
    @Path("/{id}")
    public Product updateProduct(@PathParam("id") String id, Product product) {
        return productService.updateProduct(id, product);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") String id) {
        productService.deleteProduct(id);
    }

}
