package com.dantruong.custommer_store_procedure.connection;

import com.dantruong.custommer_store_procedure.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    // Cách 1: Map trực tiếp tên method với tên tham số (Dễ nhất)
    // Lưu ý: Tên tham số trong Java phải khớp thứ tự hoặc tên với tham số trong MySQL
    @Transactional
    @Procedure(value = "sp_add_customer")
    void addCustomer(String full_name, String email);
}
