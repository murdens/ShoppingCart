package com.murdens.cmsshoppingcart;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.murdens.cmsshoppingcart.models.Cart;
import com.murdens.cmsshoppingcart.models.CategoryRepository;
import com.murdens.cmsshoppingcart.models.PageRepository;
import com.murdens.cmsshoppingcart.models.data.Category;
import com.murdens.cmsshoppingcart.models.data.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class Common {

    @Autowired
    private PageRepository pageRepo;

    @Autowired
    private CategoryRepository categoryRepo;


    @ModelAttribute
    @SuppressWarnings("unchecked")
    public void sharedData(Model model, HttpSession session, Principal principal){

        if (principal != null){
            model.addAttribute("principal", principal.getName());
        }

        List<Page> cPages = pageRepo.findAllByOrderBySortingAsc();

        List<Category> cCategories = categoryRepo.findAllByOrderBySortingAsc();

        boolean cartActive = false;

        if (session.getAttribute("cart") != null){
            HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>)session.getAttribute("cart");
            int size = 0;
            double total = 0;

            for(Cart value : cart.values()){
                size += value.getQuantity();
                total += value.getQuantity() * Double.parseDouble(value.getPrice());
            }

            model.addAttribute("csize", size);
            model.addAttribute("ctotal", total);

            cartActive = true;
        }

        model.addAttribute("cpages", cPages);
        model.addAttribute("ccategories", cCategories);
        model.addAttribute("cartActive", cartActive);
    }
    
}