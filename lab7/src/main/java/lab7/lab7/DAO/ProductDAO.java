package lab7.lab7.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lab7.lab7.entity.Product;
import lab7.lab7.entity.Report;

public interface ProductDAO extends JpaRepository<Product, Integer>{
    // Dùng cho bài 1
    // @Query("FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    // List<Product> findByPrice(Double minPrice, double maxPrice);

    // Dùng cho bài 4
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    
    // Dùng cho bài 2
    // @Query("FROM Product o WHERE o.name LIKE ?1")
    // Page<Product> findByKeywords(String keywords, Pageable pageable);

    // Dùng cho bài 4
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    @Query("SELECT o.category AS group, sum(o.price) AS sum, count(o) AS count"
                +" FROM Product o"
                +" GROUP BY o.category"
                +" ORDER BY sum(o.price) DESC")
    List<Report> getInventoryByCategory();
}

