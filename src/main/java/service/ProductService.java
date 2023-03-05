package service;

import com.oracle.svm.core.annotate.Inject;
import model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductService {
    @Inject
    EntityManager em;
    @Transactional
    public Product createProduct(Product product) {
        product.persist();
        return product;
    }

    public List<Product> getProductByMerk(String merk) {
        return Product.list("merk", merk);
    }

    @Transactional
    public Product changeProduct(String id, Product product) {
        Product singleProduct = Product.findById(id);
        if(singleProduct  != null ){
            singleProduct.merk = product.merk;
            singleProduct.model = product.model;
            singleProduct.price = product.price;
            singleProduct.processor = product.processor;
            singleProduct.memory = product.memory;
            singleProduct.storage = product.storage;
        }
        return singleProduct;
    }

    @Transactional
    public Product updateProduct(String id, Product product) {
        Product singleProduct = Product.findById(id);
        if(singleProduct != null) {
            singleProduct.merk = (product.merk == null) ? singleProduct.merk : product.merk;
            singleProduct.model = (product.model == null) ? singleProduct.model : product.model;
            singleProduct.price = (product.price == 0) ? singleProduct.price : product.price;
            singleProduct.processor = (product.processor == null) ? singleProduct.processor : product.processor;
            singleProduct.memory = (product.memory == 0) ? singleProduct.memory : product.memory;
            singleProduct.storage = (product.storage == 0) ? singleProduct.storage : product.storage;
        }
        return singleProduct;
    }

    @Transactional
    public void deleteProduct(String id) {
        Product.deleteById(id);
    }
}
