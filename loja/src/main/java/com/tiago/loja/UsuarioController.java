package com.tiago.loja;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;


@RestController()
@RequestMapping("/usuario")
public class UsuarioController {

    //Cria uma lista
    public static List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
    
    @PostConstruct
    public void inciaList(){
        
        UsuarioDTO usuarioDTO1 = new UsuarioDTO();
        UsuarioDTO usuarioDTO2 = new UsuarioDTO();
        UsuarioDTO usuarioDTO3 = new UsuarioDTO();


        usuarioDTO1.setNome("Aline");
        usuarioDTO1.setCpf("1");
        usuarioDTO1.setEndereço("Rua A");
        usuarioDTO1.setEmail("aline@email.com");
        usuarioDTO1.setTelefone("1111-11111");
        usuarioDTO1.setDataCadastro(LocalDateTime.now());


        usuarioDTO2.setNome("Lucia");
        usuarioDTO2.setCpf("2");
        usuarioDTO2.setEndereço("Rua B");
        usuarioDTO2.setEmail("Lucia@email.com");
        usuarioDTO2.setTelefone("2222-2222");
        usuarioDTO2.setDataCadastro(LocalDateTime.now());


        usuarioDTO3.setNome("Oséias");
        usuarioDTO3.setCpf("3");
        usuarioDTO3.setEndereço("Rua C");
        usuarioDTO3.setEmail("Oséias@email.com");
        usuarioDTO3.setTelefone("3333-3333");
        usuarioDTO3.setDataCadastro(LocalDateTime.now());

        usuarios.add(usuarioDTO1);
        usuarios.add(usuarioDTO2);
        usuarios.add(usuarioDTO3);

    }


    @GetMapping()
    public List<UsuarioDTO> getMensagem(){
        return usuarios;
    }


    @GetMapping("/{cpf}")
    public UsuarioDTO getUsuarioFiltro(@PathVariable String cpf) {
        return usuarios.stream().filter(usuarioDTO -> usuarioDTO.getCpf().equals(cpf)).findFirst().orElseThrow(() -> new RuntimeException("Usuário não foi encontrado"));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO inserir( @RequestBody @Valid UsuarioDTO usuarioDTO ){
        usuarioDTO.setDataCadastro(LocalDateTime.now());
        usuarios.add(usuarioDTO);
        return usuarioDTO;
    }

    @DeleteMapping("/{cpf}")
    public boolean remover(@PathVariable String cpf){
        return usuarios.removeIf(userDTO -> userDTO.getCpf().equals(cpf));
    }
    

}
