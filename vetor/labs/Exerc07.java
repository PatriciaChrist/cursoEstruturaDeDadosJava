package com.loiane.estruturadados.vetor.labs;

import java.util.ArrayList;
import java.util.Scanner;

import com.loiane.estruturadados.vetor.Lista;
import com.loiane.estruturadados.vetor.teste.Contato;

public class Exerc07 {

	public static void main(String[] args) {

		//criação das variaveis
		Scanner scan = new Scanner(System.in);

		//criar vetor com 20capacidades
		ArrayList<Contato> lista = new ArrayList<Contato>(20);

		//criar e adicionar 30 contatos
		criarContatosDinamicamente(5, lista);

		//criar um menu para que o usuário escolha a opção
		int opcao = 1;

		while (opcao != 0) {

			opcao = obterOpcaoMenu(scan);

			switch (opcao) {
			case 1: 
				adicionarContatoFinal(scan, lista);
				break;
			case 2:
				adicionarContatoPosicao(scan, lista);
				break;	
			case 3:
				obtemContatoPosicao(scan, lista);
				break;
			case 4:
				obtemContato(scan, lista);
				break;
			case 5:
				pesquisarUltimoIndice(scan, lista);
				break;
			case 6:
				pesquisarContatoExiste(scan, lista);
				break;
			case 7:
				excluirPorPosicao(scan, lista);
				break;
			case 8:
				excluirContato(scan, lista);
				break;
			case 9:
				imprimeTamanhoVetor(lista);
				break;
			case 10:
				limparVetor(lista);
				break;
			case 11:
				imprimirVetor(lista);
				break;
			default:
				break;
			}
		}

		System.out.println("Usuário digitou 0, programa terminou");
	}	

	private static void imprimirVetor(ArrayList<Contato> lista) {

		System.out.println(lista);
	}

	private static void limparVetor(ArrayList<Contato> lista) {

		lista.clear();

		System.out.println("Todos os contatos do vetor foram excuídos");
	}

	private static void imprimeTamanhoVetor(ArrayList<Contato> lista) {

		System.out.println("Tamanho do vetor é de: " + lista.size());
	}


	private static void excluirPorPosicao(Scanner scan, ArrayList<Contato> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

		try {

			lista.remove(pos);

			System.out.println("Contato excluido");

		} catch (Exception e) {
			System.out.println("Posição invalida!");
		}
	}

	private static void excluirContato(Scanner scan, ArrayList<Contato> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

		try {

			Contato contato = lista.get(pos);

			lista.remove(contato);

			System.out.println("Contato excluido");

		} catch (Exception e) {
			System.out.println("Posição invalida!");
		}
	}

	private static void pesquisarContatoExiste(Scanner scan, ArrayList<Contato> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Contato contato = lista.get(pos);

			boolean existe = lista.contains(contato);

			if (existe) {
				System.out.println("Contato existe, seguem dados:");
				System.out.println(contato);
			} else {
				System.out.println("Contato não existe");
			}

		} catch (Exception e) {
			System.out.println("Posição invalida!");
		}
	}

	private static void pesquisarUltimoIndice(Scanner scan, ArrayList<Contato> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Contato contato = lista.get(pos);

			System.out.println("Contato existe, seguem dados:");
			System.out.println(contato);

			System.out.println("Fazendo pesquisa do último índice do contato encontrado");
			pos = lista.lastIndexOf(contato);

			System.out.println("Contato encontrado na posição " + pos);

		} catch (Exception e) {
			System.out.println("Posição invalida!");
		}
	}

	private static void obtemContato(Scanner scan, ArrayList<Contato> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Contato contato = lista.get(pos);

			System.out.println("Contato existe, seguem dados:");
			System.out.println(contato);

			System.out.println("Fazendo pesquisa do contato encontrado");
			pos = lista.indexOf(contato);

			System.out.println("Contato encontrado na posição " + pos);

		} catch (Exception e) {
			System.out.println("Posição invalida!");
		}
	}

	private static void obtemContatoPosicao(Scanner scan, ArrayList<Contato> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Contato contato = lista.get(pos);

			System.out.println("Contato existe, seguem dados:");
			System.out.println(contato);

		} catch (Exception e) {
			System.out.println("Posição invalida!");
		}
	}

	private static void adicionarContatoFinal(Scanner scan, ArrayList<Contato> lista) {
		System.out.println("Criando um contato, entre com as informações:");
		String nome = leInformacao("Entre com o nome", scan);
		String telefone = leInformacao("Entre com o telefone", scan);
		String email = leInformacao("Entre com o email", scan);

		Contato contato = new Contato(nome, telefone, email);

		lista.add(contato);

		System.out.println("Contato adicionado com sucesso!");
		System.out.println(contato);

	}

	private static void adicionarContatoPosicao(Scanner scan, ArrayList<Contato> lista) {
		System.out.println("Criando um contato, entre com as informações:");
		String nome = leInformacao("Entre com o nome", scan);
		String telefone = leInformacao("Entre com o telefone", scan);
		String email = leInformacao("Entre com o email", scan);

		Contato contato = new Contato(nome, telefone, email);




		int pos = leInformacaoInt("Entre com a posição a adicionar o contato", scan);

		try {
			lista.add(pos, contato);

			System.out.println("Contato adicionado com sucesso!");
			System.out.println(contato);

		}catch (Exception e) {
			System.out.println("Posição inválida, contato não adicionado");
		}
	}

	private static String leInformacao(String msg, Scanner scan) {

		System.out.println(msg);
		String entrada = scan.nextLine();

		return entrada;	
	}



	private static int leInformacaoInt(String msg, Scanner scan) {

		boolean entradaValida = false;
		int num = 0;

		while (!entradaValida) {	

			try {

				System.out.println(msg);
				String entrada = scan.nextLine();

				num = Integer.parseInt(entrada);

				entradaValida = true;

			} catch (Exception e) {
				System.out.println("Entrada inválida, digite novamente");
			}
		}

		return num;	
	}

	private static int obterOpcaoMenu(Scanner scan) {

		boolean entradaValida = false;
		int opcao = 0;
		String entrada;

		while (!entradaValida) {

			System.out.println("Digite a opção desejada");
			System.out.println("1: Adiciona contato no final do vetor");
			System.out.println("2: Adiciona contato em uma posição especifica");
			System.out.println("3: Obtem contato de uma posição especifica");
			System.out.println("4: Consulta contato");
			System.out.println("5: Consulta último índice do contato");
			System.out.println("6: Verifica se o contato existe");
			System.out.println("7: Excluir por posição");
			System.out.println("8: Excluir contato");
			System.out.println("9: Verifica tamanho do vetor");
			System.out.println("10: Excluir todos os contatos do vetor");
			System.out.println("11: Imprime vetor");
			System.out.println("0: Sair");

			try {

				entrada= scan.nextLine();
				opcao = Integer.parseInt(entrada);

				if (opcao>=0 && opcao<=11) {
					entradaValida = true;
				} else {
					throw new Exception();
				}

			} catch (Exception e) {

				System.out.println("Entrada invalida, digite novamente");
			}

		}
		return opcao;
	}
	private static void criarContatosDinamicamente(int quantidade, ArrayList<Contato> lista) {

		Contato contato;

		for (int i=0; i<=quantidade; i++) {
			contato = new Contato();
			contato.setNome("Contato" + i);
			contato.setTelefone("3351-3333" + i);
			contato.setEmail("contato" + i + "@email.com");

			lista.add(contato);
		}
	}


}

