package com.brl.pdv;

import java.util.List;

import com.brl.pdv.model.Cliente;
import com.brl.pdv.model.dao.ClienteDAO;

public class ClassePrincipal {
	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente1 = new Cliente("Jão", 'M', 'A');
		Cliente cliente2 = new Cliente("Jow", 'F', 'A');
		Cliente cliente3 = new Cliente("Jew", 'M', 'I');
		Cliente cliente4 = new Cliente("Joca", 'M', 'A');
		Cliente cliente5 = new Cliente("Juana", 'F', 'I');
		clienteDAO.insert(cliente1);
		clienteDAO.insert(cliente2);
		clienteDAO.insert(cliente3);
		clienteDAO.insert(cliente4);
		clienteDAO.insert(cliente5);
		List<Cliente> clientes = clienteDAO.findAll();
		clientes.forEach(System.out::println);
	}
}