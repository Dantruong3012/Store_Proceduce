package com.dantruong.custommer_store_procedure.controller;

import com.dantruong.custommer_store_procedure.entity.Customer;
import com.dantruong.custommer_store_procedure.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService, View view) {
        this.customerService = customerService;
    }

    @GetMapping("/home-app")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @PostMapping("/create-customer")
    public String create(@ModelAttribute("customer") Customer customer){
        customerService.processing(customer.getName(), customer.getEmail());
        return "redirect:/view";
    }

    @GetMapping("/view")
    public String viewList(Model model){
        model.addAttribute("list", customerService.showList());
        return "view";
    }
}
