/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author llpad
 */
@Configuration// anotação para o Spring encontrar a class 
@EnableWebSecurity//Indicar ao Spring que vamos perssonalizar as configuraçãoes de segurança
public class SecurityConfigurations {
    
   @Autowired
    private SecurityFilter securityFilter;

    //A próxima alteração é configurar o Spring Security para ele não usar o processo de segurança tradicional, o stateful. 
    //Como estamos trabalhando com uma API Rest, o processo de autenticação precisa ser stateless.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req -> {req.requestMatchers(HttpMethod.POST,  "/login").permitAll();
                req.anyRequest().authenticated();
                }) 
                //chama primeiro o nosso filtro para depois chamar o do Spring
                .addFilterBefore(securityFilter,  UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean//Serve para esportar uma class para o Spring para que ele possa realiazar a injeção de dependencia em outras class 
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();

    }

    @Bean //Mostrar para o Spring que as senhas vam ser armazenadas em augoritmo BCrypt
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

}
