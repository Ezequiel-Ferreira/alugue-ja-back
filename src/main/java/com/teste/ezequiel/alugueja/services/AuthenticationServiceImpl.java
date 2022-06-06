package com.teste.ezequiel.alugueja.services;

import com.teste.ezequiel.alugueja.configs.SecurityConfig;
import com.teste.ezequiel.alugueja.dto.inputs.CredenciaisDTO;
import com.teste.ezequiel.alugueja.exceptions.usuario.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private SecurityConfig securityConfig;

    @Value("url.application")
    private String urlApplication;

    @Value("server.por")
    private String serverPort;

    @Override
    public String login(CredenciaisDTO credenciaisDTO) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CredenciaisDTO> entity = new HttpEntity<>(credenciaisDTO);
        try{
            ResponseEntity<Void> res = restTemplate
                    .exchange(
                            new URI(String.format("%s%s", urlApplication, serverPort)),
                            HttpMethod.POST,
                            entity,
                            Void.class);
            return Objects.requireNonNull(res.getHeaders().get("Authorization")).get(0);
        } catch (HttpClientErrorException e){
            throw new ForbiddenException();
        }
    }
}
