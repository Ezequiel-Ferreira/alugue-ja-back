package com.teste.ezequiel.alugueja.entities;

import com.teste.ezequiel.alugueja.entities.vo.enuns.TipoUsuario;
import com.teste.ezequiel.alugueja.exceptions.InsufficientFunds;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Usuario implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;
    private String senha;
    private BigDecimal creditos;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="tipos_usuario")
    private Set<Integer> tipos = new HashSet<>();

    @Transient
    private TipoUsuario tipo;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Aluguel> alugueis = new ArrayList<>();


    public Usuario(Long id, String nome, String email, String senha, BigDecimal creditos, List<Aluguel> alugueis) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.creditos = creditos;
        this.tipos.add(2);
        this.alugueis = alugueis;
    }

    /*
        Criacao de usuarios com perfil de Adiministrador
     */
    public Usuario(Long id, String nome, String email, String senha, BigDecimal creditos, List<Aluguel> alugueis, String ADMIN) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.creditos = creditos;
        this.tipos.add(1);
        this.alugueis = alugueis;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }

    public Set<Integer> getTipos() {
        return tipos;
    }

    public void setTipos(Set<Integer> tipos) {
        this.tipos = tipos;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.tipos.stream()
                .map(us -> new SimpleGrantedAuthority(TipoUsuario.toEnum(us).getDescricao()))
                .collect(Collectors.toList());
    }
    @Override
    public String getPassword() {

        return this.senha;
    }
    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public void payFilme(BigDecimal valor) {
        if (getCreditos().compareTo(valor) < 0){
            throw new InsufficientFunds();
        }

        setCreditos(getCreditos().subtract(valor));
    }

    public TipoUsuario getTipo() {
        if (getTipos() != null && !getTipos().isEmpty()){
            tipo = getTipos().stream()
                    .map(TipoUsuario::toEnum).findFirst().orElse(TipoUsuario.CLIENTE);
        }

        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
