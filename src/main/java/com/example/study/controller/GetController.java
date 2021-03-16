package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //localhost:8080/api/getMethod
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pwd){ //@RequestParam(name="password")으로 설정하면 http요청할때 파라미터 변수명은 password가 된다.
        String password = "bbbb";

        System.out.println("id : "+ id);
        System.out.println("pwd : "+ pwd);

        return id + pwd;
    }

    //localhost:8080/api/multiParameter?account=abcd&email=study@gmail.com&page=10
    /*public String getMultiParameter(@RequestParam String account,
                                    @RequestParam String email,
                                    @RequestParam int page){
        System.out.println(account);
        System.out.println(email);
        System.out.println(page);

        return "OK";
     }*/
    @GetMapping("getMultiParameter") //localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    public String getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";
    }

    @GetMapping("getMultiParameterJson") //localhost:8080/api/getMultiParameterJson?account=abcd&email=study@gmail.com&page=10
    public SearchParam getMultiParameterJson(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //{"account" : "abcd", "email" : "study@gmail.com", "page" : 0 }
        return searchParam;
    }



}
