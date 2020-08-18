package br.com.osapi.api.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.osapi.domain.model.Cliente;

@RestController
public class ClienteController {
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Erika");
		cliente1.setEmail("erikota@erikota.com");
		cliente1.setTelefone("11 99635-1158");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Gabs");
		cliente2.setEmail("gabs@gab.com.br");
		cliente2.setTelefone("21 96351-4785");
		
		Cliente cliente3 = new Cliente();
		cliente3.setId(3L);
		cliente3.setNome("João");
		cliente3.setEmail("joao@bike.com.br");
		cliente3.setTelefone("31 99965-8857");

		return Arrays.asList(cliente1, cliente2, cliente3);
	}

}
