package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Product;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT t from Product t order by price")
    Collection<Product> findProductByPriceAsc();

    @Query(value = "SELECT t from Product t order by price desc")
    Collection<Product> findProductByPriceDesc();

    @Query(value = "SELECT t from Product t where name like %?1% order by name ASC")
    Collection<Product> findProductByName(String productName);


//    @Query(value = "SELECT t from Product t left join productCategory p on t.productCategory = p.id where p.name like %?1%")
//    Collection<Product> findProductByCategory(String categoryName);








}
