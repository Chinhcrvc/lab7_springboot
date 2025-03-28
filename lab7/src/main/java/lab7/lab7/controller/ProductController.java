package lab7.lab7.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lab7.lab7.DAO.ProductDAO;
import lab7.lab7.entity.Product;
import lab7.lab7.service.SessionService;

@Controller
public class ProductController {
    @Autowired
    ProductDAO dao;

    @Autowired
    SessionService session;

    @RequestMapping("/product/search")
    public String search(Model model,
                @RequestParam("min") Optional<Double> min,
                @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        // List<Product> items = dao.findByPrice(minPrice, maxPrice);
        List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search";
    }

    @RequestMapping("/product/search-and-page")
    public String searchAndPage(Model model,
                @RequestParam("keywords") Optional<String> kw,
                @RequestParam("p") Optional<Integer> p) {
        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);
        System.out.println("Session Keywords: " + session.get("keywords", ""));
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        // Page<Product> page = dao.findByKeywords("%"+kwords+"%", pageable);
        Page<Product> page = dao.findAllByNameLike("%"+kwords+"%", pageable);
        model.addAttribute("keywords", kwords);
        model.addAttribute("page", page);
        return "product/search-and-page";
    }
      
}
