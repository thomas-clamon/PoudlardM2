package com.example.poudlarm10710.controler;

import com.example.poudlarm10710.services.ISorcierService;
import com.example.poudlarm10710.services.SorcierServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Sorcier")
public class SorcierController {

    // un endpoint qui accede à tout les elements.
    @Autowired
    private ISorcierService service;

    @GetMapping("/all")
    ResponseEntity getAll(){
        return new ResponseEntity(service.getAll(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("get/{id}")
    ResponseEntity get (@PathVariable Integer id){

        // on verifie si le sorcier existe sinon on s'arrete
        if (!service.exist(id))
            return new ResponseEntity("Le sorcier n'existe pas", HttpStatusCode.valueOf(201));
        return new ResponseEntity(service.get(id), HttpStatusCode.valueOf(200));
    }
}
