package br.com.gabrielcaiodev.onetoone.controller;

import br.com.gabrielcaiodev.onetoone.model.cliente.Cliente;
import br.com.gabrielcaiodev.onetoone.model.cliente.ClienteService;
import br.com.gabrielcaiodev.onetoone.model.endereco.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @PutMapping("/{id}/endereco")
    public ResponseEntity<Cliente> atualizarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Cliente clienteAtualizado = clienteService.atualizarEndereco(id, endereco);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarCliente(id);
        return ResponseEntity.ok(cliente);
    }
}


