package com.FIneDine.FineDineOfficial.Controller;

import com.FIneDine.FineDineOfficial.Model.MenuList;
import com.FIneDine.FineDineOfficial.Services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
   private MenuService service;


    @GetMapping("/get")
    public ResponseEntity<List<MenuList>> getMenuList(){
        return new ResponseEntity<>(service.getMenuList(), HttpStatus.OK);
    }


     @PostMapping("/create")
        public  String createMenu(@RequestBody MenuList menu){
         service.createMenu(menu);
         return "Created";
     }


     @PostMapping("/createMenu")
     public ResponseEntity<?> addMenu(@RequestPart MenuList menu ,
                                      @RequestPart MultipartFile imageFile //For Taking the image as MultiFile
                                      ){

      try {
      MenuList menuList=  service.addMenuWithImage(menu,imageFile);
          return  new ResponseEntity<>(menuList,HttpStatus.OK);
      }
      catch (Exception e){
          return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }


     }

     @PostMapping("/update")
    public void updateMenu(@RequestBody MenuList menu){
        service.updateMenu(menu);
     }

     @GetMapping("/delete/{id}")
    public void deleteMenu(@PathVariable int id){
        service.deleteMenu(id);
     }



}
