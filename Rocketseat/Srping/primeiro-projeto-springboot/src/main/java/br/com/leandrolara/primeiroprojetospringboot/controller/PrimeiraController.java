package br.com.leandrolara.primeiroprojetospringboot.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {

    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id) {
        return "O paramétro é " + id;
    }

    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id) {
        return "O paramétro com metodoComQueryParams é " + id;
    }

    
    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams2(@RequestParam Map<String, String> allParams) {
        return "O paramétro com metodoComQueryParams é " + allParams.entrySet();
    }

    @PostMapping("metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario usuario) {
        return "metodoComBodyParams" + usuario.username();
    }

    @PostMapping("metodoComHeader")
    public String metodoComHeaders(@RequestHeader("name") String name) {
        return "metodoComHeader" + name;
    }

    
    @PostMapping("metodoComListHeader")
    public String metodoComListHeaders(@RequestHeader Map<String, String> headers) {
        return "metodoComListHeader" + headers.entrySet();
    }

    record Usuario(String username) {

    }

}
