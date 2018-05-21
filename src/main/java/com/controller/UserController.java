package com.controller;

import org.springframework.stereotype.Controller;

//@RestController
@Controller    // This means that this class is a com.controller
//@RequestMapping(path = "/demo") // This means URL's start with /demo (after com.Application path)
public class UserController {
//    @Autowired // This means to get the bean called IUserDao
//    // Which is auto-generated by Spring, we will use it to handle the data
//    private UserDao userDao;
//
////    @GetMapping(path = "/add") // Map ONLY GET Requests
////    public
////    @ResponseBody
////    String addNewUser(@RequestParam String name
////            , @RequestParam String email) {
////        // @ResponseBody means the returned String is the response, not a view name
////        // @RequestParam means it is a parameter from the GET or POST request
////
//////        User n = new User();
//////        n.setName(name);
//////        n.setEmail(email);
//////        IUserDao.save(n);
//////        return "Saved";
////    }
//
////    @GetMapping(path = "/all")
////    public
////    @ResponseBody
////    Iterable<User> getAllUsers() {
////        // This returns a JSON or XML with the users
////        //return IUserDao.findAll();
////        return "1";
////    }
//
//    //get details of a user
//    @GetMapping(path = "/userInfo")
//    public
//    @ResponseBody
//    Map<String, Object> getUserInfo(@RequestParam String email) {
//
//        List<User> userList = userDao.getUserByEmailId(email);
//
//        Map<String, Object> map = new HashMap();
//        if (userList.size() <= 0) {
//            map.put("message", "not found");
//            return map;
//        }
//
//        map.put("email", userList.get(0).getEmail());
//        map.put("id", userList.get(0).getId());
//        map.put("name", userList.get(0).getName());
//
//        return map;
//
//    }
//
//
//
//    @GetMapping(path = "/username")
//    public
//    @ResponseBody
//    Map<String, Object> getUserName(@RequestParam("username") String name) {
//
//        List<User> userList = userDao.getUserByName(name);
//
//        Map<String, Object> map = new HashMap();
//        if (userList.size() <= 0) {
//            map.put("message", "not found");
//            return map;
//        }
//
//        map.put("email", userList.get(0).getEmail());
//        map.put("id", userList.get(0).getId());
//        map.put("name", userList.get(0).getName());
//
//        return map;
//
//    }
}