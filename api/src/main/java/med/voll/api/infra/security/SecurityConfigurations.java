/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author llpad
 */
@Configuration// anotação para o Spring encontrar a class 
@EnableWebSecurity//Indicar ao Spring que vamos perssonalizar as configuraçãoes de segurança
public class SecurityConfigurations {

    //A próxima alteração é configurar o Spring Security para ele não usar o processo de segurança tradicional, o stateful. 
    //Como estamos trabalhando com uma API Rest, o processo de autenticação precisa ser stateless.
    @Bean
    //Objeto utilizado pelo Spring para configurar processos de autenticação
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())//desabilitar a proteção aos ataques do tipo csrf pois o token ja faz isso
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();

    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
        
    }
    
    @Bean
     public PasswordEncoder passwordEncoder(){
         
         return new BCryptPasswordEncoder();
     }

}
