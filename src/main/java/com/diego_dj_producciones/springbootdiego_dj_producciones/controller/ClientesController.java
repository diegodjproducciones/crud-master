package com.diego_dj_producciones.springbootdiego_dj_producciones.controller;

import com.diego_dj_producciones.springbootdiego_dj_producciones.models.Cliente;
import com.diego_dj_producciones.springbootdiego_dj_producciones.services.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("clientes")
public class ClientesController {
    @Autowired
    private final ClientesRepository clientesRepository;


    public ClientesController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;

    }

    @GetMapping
    public String getClientes(Model model) {
        List<Cliente> clientes = clientesRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes/index";
    }

    @GetMapping("/crear")
    public String showCreatePage(Model model) {
        return "clientes/crearcliente";
    }


}
