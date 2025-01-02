package br.com.gabrielcaiodev.onetoone.model.cliente;

import br.com.gabrielcaiodev.onetoone.controller.error.ResourceNotFoundException;
import br.com.gabrielcaiodev.onetoone.model.endereco.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    // Inserção de cliente e endereço
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Atualização de dados do endereço
    public Cliente atualizarEndereco(Long clienteId, Endereco novoEndereco) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setEndereco(novoEndereco);
            return clienteRepository.save(cliente);
        }
        throw new RuntimeException("Cliente não encontrado.");
    }

    // Remoção de cliente e endereço relacionado
    public void removerCliente(Long clienteId) {
        if(!clienteRepository.existsById(clienteId)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        clienteRepository.deleteById(clienteId);
    }

    // Busca de cliente por id
    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado"));
    }
}

