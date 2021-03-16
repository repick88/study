package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //메소드의 mapping주소는 겹치면 안된다. 단, 클래스 mapping주소는 겹쳐도 괜찮다.
public class PostController {

    //HTML <Form> 또는 ajax 검색에 사용
    //http post는 body에 담아오기 때문에 @RequestParam가 아닌 @RequastBody를 활용한다. public String postMethod(@RequestBody SearchParam searchParam){
    //json, xml, multipart-from / text-plain

    //@RequestMapping(method = RequestMethod.POST, path = "postMethod") == @PostMapping("/postMethod")
    //POSTMAN
    //1.Headers Content-Type / application/json
    //2.BODY raw / JSON(applcation/json) / { "account" :"aaaa","email": "pppp@gmail","page" : 55}
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }

    /*POST와 마찬가지로 BODY에 데이터가 들어 있으며, 주로 업데이트에 사용하지만 해당 메소드는 주로 사용하지 않는다*/
    /*@PutMapping("/putMethod")
    public void put(){}

    @PatchMapping("/patchMethod")
    public void patch(){}*/
}
