package cc.code;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import sun.invoke.empty.Empty;

/**
 * Relatório de pessoas
 * @author Deus
 */
public class report_de_pessoas {
	/**
	 * a string para somar todos os nomes na lista 
	 */
	static String _s;
	
	/**
	 * imprime a lista de pessoas
	 * @param paramL
	 */
	public static void print_e_vai(Vector paramL){
		
		String dados;
		_s = "";
		
		for (int i = 0; i < paramL.size(); i++) {
			
			Pessoa p = (Pessoa) paramL.get(i);
			Validation validador = new Validation();
			List<String> erro = validador.validaPessoa(p);
			
			dados = "\n" +
		    		"Nome: " + p.name + "\n" +
		    		"Fone: " + p.telefonesCelulares.get(0) + "\n" +
		    		"CPF : " + p.cpf + "\n"
		    		;
			
			if(!erro.isEmpty()) {
				System.out.print(erro.toString() + "\n");
				continue;
			}
			
			_s += dados;
		}
		
		if (!_s.isEmpty())
			System.out.print(_s);
	}
	
	/**
	 * codigo principal
	 * @param args
	 */
	public static void main(String[] args) {
		Vector v = new Vector();
		
		Pessoa p = new Pessoa();
		p.name = "Fulano";
		p.cpf = "34252203066";
		
		ArrayList<String> telefonesCelulares = new ArrayList<String>();
		telefonesCelulares.add("1234567890");
		p.telefonesCelulares = telefonesCelulares;
		
		v.add(p);
		
		Pessoa p2 = new Pessoa();
		p2.name = "Fulano 2";
		p2.cpf = "0033435457";
		
		ArrayList<String> telefonesCelulares2 = new ArrayList<String>();
		telefonesCelulares2.add("123456789");
		p2.telefonesCelulares = telefonesCelulares2;
		
		v.add(p2);
		
		print_e_vai(v);
	}
}

 class Pessoa{
	String name;
	String cpf;
	int idade;
	List<String> telefonesFixos;
	List<String> telefonesCelulares;
}