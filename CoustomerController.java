package com.example.hw122.Controller;

import com.example.hw122.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Coustomer")
public class CoustomerController {
    ArrayList<Customer> customers=new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    @PostMapping("/add")
    public String addCustomers(@RequestBody Customer customer){
        customers.add(customer);
        return "customers add";
    }
    @PutMapping("/updet/{index}")
    public String updetCustomer(@PathVariable int index, @RequestBody Customer task){
        customers.set(index,task);
        return ("Customers upset");
    }

    @DeleteMapping("/delete/{index}")
    public String deleteCustomer(@PathVariable int index ){
        customers.remove(index);
        return ("Customers Delete");
    }
    @PostMapping("/Deposit/{index}/{amount}")
    public String Deposit(@PathVariable int index  , @PathVariable double amount ) {
        customers.get(index).setBalance(customers.get(index).getBalance() + amount);

        return "Deposit money to customer";

    }
    @PutMapping("/WithdrawMoney/{index}/{withdraw}")
    public String WithdrawMoney(@PathVariable int index ,@PathVariable double withdraw){
        if (customers.get(index).getBalance()>withdraw){
        customers.get(index).setBalance(customers.get(index).getBalance() - withdraw);}
        else {
            return "The balance is not enough";
        }



     return "Withdraw money from customers";
    }

}

