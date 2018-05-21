package com.controller;

import com.dao.CustomerDao;
import com.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableJpaRepositories("com.dao.CustomerDao")
@RestController
@Controller    // This means that this class is a com.controller
@RequestMapping(path = "/customer") // This means URL's start with /customer (after com.Application path)
public class CustomerController {
    @Autowired // This means to get the bean called IUserDao
    // Which is auto-generated by Spring, we will use it to handle the data
    private CustomerDao customerDao;


    //get details of a user by email
    @GetMapping(path = "/email")

    @ResponseBody
    public Map<String, Object> getCustomerInfo(@RequestParam String email) {

        List<Customer> customerList = customerDao.getCustomerByEmailId(email);


        Map<String, Object> response = new HashMap();
        response.put("data",null);
        response.put("error",null);


        if (customerList.size() == 0) {
            Map<String,Object> errorMassage=new HashMap<>();
            errorMassage.put("message","customer details not found");
            response.put("error",errorMassage);
            return response;
        }
      Customer c=  customerList.get(0);
        response.put("data",c);



        return response;
    }

    @GetMapping(path = "/mobile")
    public
    @ResponseBody
    Map<String, Object> getCustomerName(@RequestParam("mobileNo") String mobile) {

        Map<String , Object> response = new HashMap<>();
        response.put("data",null);
        response.put("error",null);

        try{

            List<Customer> customerList = customerDao.getCustomerBymobileNo(mobile);

            Map<String, Object> map = new HashMap();

            if (customerList.size() == 0) {
                Map<String,String > tempMap = new HashMap<>();
                tempMap.put("message","not found");

                response.put("error",tempMap);

                return response;
            }

            //TODO
            map.put("name", customerList.get(0).getName());
            map.put("address", customerList.get(0).getAddress());
            map.put("mobileNo", customerList.get(0).getMobileNo());
            map.put("email", customerList.get(0).getEmail());
            map.put("PIN", customerList.get(0).getPIN());

            response.put("data",map);
        }
        catch(Exception e){

            Map<String,String > tempMap = new HashMap<>();
            tempMap.put("message","some thing went wrong");

            response.put("error",tempMap);

        }
        return response;



    }
    @GetMapping("/name")
    @ResponseBody
    public Map<String,Object> getCustomerInfoByName(@RequestParam String name){
        List<Customer> customerList=customerDao.getCustomerByName(name);
            Map<String,Object> response=new HashMap<>();
            response.put("data",null);
            response.put("error",null);

            if(customerList.size()==0){
                Map<String,Object> errorMassage=new HashMap<>();
                errorMassage.put("massage","something went wrong");

                response.put("error",errorMassage);


                return response;
            }
            Map<String,Object> data=new HashMap<>();
        data.put("address",customerList.get(0).getAddress());//returning 1st customer's address
            response.put("data",data);

            return response;


    }
    //write an api to fetch all customers from db
    @GetMapping("/all")
    @ResponseBody
    public Map<String,Object> getAllCustomer(){
        List<Customer> allCustomer=customerDao.getAllCustomer();

        Map<String,Object> map=new HashMap<>();
        map.put("data",null);
        map.put("error",null);

        if(allCustomer.size()==0){
            Map<String,Object> errorMassage=new HashMap<>();
            errorMassage.put("mesaage","no customet found");
            map.put("error",errorMassage);
            return map;

        }
        Map<String,Object> dataValue=new HashMap<>();

        map.put("data",allCustomer); //returning list of customers
        return map;


    }


    /*

      List all customers on a given pincode

     */
    @GetMapping(path = "/pin")
    @ResponseBody
    public Map<String,Object> getCustomersOnPin(@RequestParam Integer pin){
        Map<String,Object> response=new HashMap<>();
        response.put("data",null);
        response.put("error",null);

        List<Customer> customerByPin=customerDao.getCustomerByPin(pin);
        if (customerByPin.size()==0){
            Map<String ,Object> errorMassage=new HashMap<>();
            errorMassage.put("message","no customer found by this pin");
            response.put("error",errorMassage);
            return response;

        }

        response.put("data",customerByPin.get(0));//returning 1 customer.
        return response;



    }

}