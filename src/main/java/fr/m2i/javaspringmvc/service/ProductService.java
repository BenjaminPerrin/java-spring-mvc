package fr.m2i.javaspringmvc.service;

import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.model.User;
import fr.m2i.javaspringmvc.repository.ProductRepository;
import fr.m2i.javaspringmvc.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final UserService userService;

    @Autowired
    public ProductService(ProductRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }
    
    // lister les produits
    
    public List<Product> findAll() {
        return repo.findAll();
    }
    
    public Product findById(Long id) throws Exception {
        Product product = repo.findById(id).orElseThrow(() -> new Exception()); // Todo throw a custom exception called NotFoundException
        return product;
    }
    
   public void addProduct(Product product) throws Exception {
        repo.save(product);
    }
    
    // acheter un produit
    // -> Est ce que j'ai assez de crédit ?
    // -> Est ce que le produit existe ? il reste du stock ?
//   public void buyProduct(Product product) throws Exception {
//       
//       User user = UserRepository.  findById(1L).orElseThrow(() -> new Exception()); // Todo throw a custom exception called NotFoundException
//
//        if (user.getBalance() > product.getPrice() && 
//                findById(product.getId()) != null &&
//                product.getQuantity() > 0) 
//        {
//
//            user.setBalance(user.getBalance() + balance);
//            repo.save(product);
//        }
//        
//    }
}
