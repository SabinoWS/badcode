package cc.code;

import java.util.ArrayList;
import java.util.List;

public class Validation {

protected List<String> validaPessoa(Pessoa pessoa) {
		
		List<String> constraints = new ArrayList<String>();
		
		if (pessoa == null) {
			constraints.add("Erro - Pessoa inválida");
		} else {
			if (pessoa.cpf == null || pessoa.cpf.isEmpty())
				constraints.add("Erro - CPF inválido");
					
			if (pessoa.name == null || pessoa.name.isEmpty())
				constraints.add("Erro - Nome inválido");
			
			if (pessoa.telefonesFixos != null) {
				for (String telefone : pessoa.telefonesFixos) {
					if (telefone != null) {
						if (telefone.isEmpty()) {
							constraints.add("Erro - Telefone inválido");
							return constraints;
						} else {
							if(telefone.length() < 7){
								constraints.add("Erro - Telefone inválido");
								return constraints;
							}
						}
						
					} else {
						constraints.add("Erro - Telefone inválido");
						return constraints;
					}
				}
			}
			
			constraints.addAll(validarTelefonesCelulares(pessoa.telefonesCelulares));
		}

		return constraints;
	}

	private List<String> validarTelefonesCelulares(List<String> celulares) {
		
		List<String> constraints = new ArrayList<String>();
		
		if (celulares != null) {
			for (String telefone : celulares) {
				if (telefone != null) {
					if(telefone.length() != 10){
						constraints.add("Erro - Telefone celular inválido");
						return constraints;
					}
				} else {
					constraints.add("Erro - Telefone celular inválido");
					return constraints;
				}
			}
		} 
		
		return constraints;
	}
}