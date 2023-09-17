/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

/**
 *
 * @author llpad
 */

@RestController // Mostrar que essa e uma class controller
@RequestMapping("/hello") // Mostrar qual URL que vai responder 
public class HelloController {
    
    
     @GetMapping  
    public String olaMundo(){
        
   
    return "Ola Mundo Spring!";
}
    
}
