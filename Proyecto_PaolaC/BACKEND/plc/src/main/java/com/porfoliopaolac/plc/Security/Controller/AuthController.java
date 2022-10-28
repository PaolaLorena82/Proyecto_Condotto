/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfoliopaolac.plc.Security.Controller;

import com.porfoliopaolac.plc.Security.Dto.JwtDto;
import com.porfoliopaolac.plc.Security.Dto.LoginUsuario;
import com.porfoliopaolac.plc.Security.Dto.NuevoUsuario;
import com.porfoliopaolac.plc.Security.Entity.Rol;
import com.porfoliopaolac.plc.Security.Entity.Usuario;


import com.porfoliopaolac.plc.Security.Enums.RolNombre;
import com.porfoliopaolac.plc.Security.Service.RolService;
import com.porfoliopaolac.plc.Security.Service.UsuarioService;
import com.porfoliopaolac.plc.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/auth")



public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping ("/nuevo")
    
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario , BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity (new Mensaje ("Campos erroneos y mal contraseña"), HttpStatus.BAD_REQUEST );
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity (new Mensaje ("Usuario ya existente"), HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity (new Mensaje("Email ya existente"),HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario (nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
        passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje ("usuario guardado"),HttpStatus.CREATED);
               
    } 
     @PostMapping ("/login")
    public ResponseEntity<JwtDto> login (@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity (new Mensaje ("Campos mal puesto"),HttpStatus.BAD_REQUEST );
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),
        loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto (jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity (jwtDto, HttpStatus.OK);
        
    }
    
}
