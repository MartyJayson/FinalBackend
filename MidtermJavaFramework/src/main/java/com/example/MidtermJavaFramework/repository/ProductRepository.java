package com.example.MidtermJavaFramework.repository;

import com.example.MidtermJavaFramework.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>  {

    @Query(value = "SELECT s FROM Product s WHERE s.name LIKE %?1%",
            nativeQuery = false)
    public List<Product> searchProduct(String keyword);

}
