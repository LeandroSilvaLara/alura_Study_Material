package br.com.leandrolara.ioc_di;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MeuComponent {
    
    public String chamarComponent() {
    return "Chamando meu component";
    
    }
}
