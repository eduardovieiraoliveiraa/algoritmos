package jogodavelha;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JogoDaVelha {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List<String> tabuleiro = Arrays.asList("1","2","3","4","5","6","7","8","9");
		printTabuleiro(tabuleiro);
		
		boolean nenhumGanahador = true;
		Scanner scanner = new Scanner(System.in);
		
		boolean vezJogadorX = true;
		boolean vezJogadorO = false;
		
		while(nenhumGanahador) {
			String mrcadorTabuleiro = "";
			
			if(vezJogadorX) {
				System.out.println("\nJogador escolha qual posicao deseja jogar (Jogador X): ");
				
				
				vezJogadorX = false;
				vezJogadorO = true;
				
				mrcadorTabuleiro = "X";
				
			}else if(vezJogadorO) {
				System.out.println("\nJogador escolha qual posicao deseja jogar (Jogador O): ");
				
				vezJogadorO = false;
				vezJogadorX = true;
				
				mrcadorTabuleiro = "O";
			}
			
			String posicao = scanner.nextLine();
			
			while(posicaoInvalida(posicao, tabuleiro)) {
				posicao = scanner.nextLine();
			}
			
			int index = Integer.valueOf(posicao)-1;
			tabuleiro.set(index, mrcadorTabuleiro);
			
			printTabuleiro(tabuleiro);
			
			if(ganhador(tabuleiro, mrcadorTabuleiro)) {
				nenhumGanahador = false;
				
				System.out.println("\n Parabens, voce ganhou! ganhador: " + mrcadorTabuleiro);
			}
		}
	}
	
	private static boolean posicaoInvalida(String posicao, List<String> tabuleiro) {
		if(posicao.isBlank() || posicao.isEmpty() || !posicao.matches("\\d+")) {
			System.out.println("Informe uma posição");
			
			return true;	
		}
		
		
		Integer index = Integer.valueOf(posicao)-1;
		if(index < 0 || index > 8) {
			System.out.println("Posição do tabuleiro invalida. Tente novamente em uma posição valida:");
			
			return true;
		}
		
		String posicaoTab = tabuleiro.get(index);
		
		if(posicaoTab.equals("X") || posicaoTab.equals("O")) {
			System.out.println("Posição do tabuleiro já preenchida por um jogador. Tente novamente em uma posição valida:");
			
			return true;
		}
		
		return false;
	}
	
	private static boolean ganhador(List<String> tabuleiro, String mrcadorTabuleiro) {
		boolean ganhadorLinha1 = tabuleiro.get(0).equals(mrcadorTabuleiro) && tabuleiro.get(1).equals(mrcadorTabuleiro)
				&& tabuleiro.get(2).equals(mrcadorTabuleiro);

		boolean ganhadorLinha2 = tabuleiro.get(3).equals(mrcadorTabuleiro) && tabuleiro.get(4).equals(mrcadorTabuleiro)
				&& tabuleiro.get(5).equals(mrcadorTabuleiro);

		boolean ganhadorLinha3 = tabuleiro.get(6).equals(mrcadorTabuleiro) && tabuleiro.get(7).equals(mrcadorTabuleiro)
				&& tabuleiro.get(8).equals(mrcadorTabuleiro);

		boolean ganhadorLinhaCruzada1 = tabuleiro.get(0).equals(mrcadorTabuleiro)
				&& tabuleiro.get(4).equals(mrcadorTabuleiro) && tabuleiro.get(8).equals(mrcadorTabuleiro);

		boolean ganhadorLinhaCruzada2 = tabuleiro.get(6).equals(mrcadorTabuleiro)
				&& tabuleiro.get(4).equals(mrcadorTabuleiro) && tabuleiro.get(2).equals(mrcadorTabuleiro);

		boolean ganhadorVertical1 = tabuleiro.get(0).equals(mrcadorTabuleiro)
				&& tabuleiro.get(3).equals(mrcadorTabuleiro) && tabuleiro.get(6).equals(mrcadorTabuleiro);
				
		boolean ganhadorVertical2 = tabuleiro.get(1).equals(mrcadorTabuleiro)
				&& tabuleiro.get(4).equals(mrcadorTabuleiro) && tabuleiro.get(7).equals(mrcadorTabuleiro);

		boolean ganhadorVertical3 = tabuleiro.get(2).equals(mrcadorTabuleiro)
				&& tabuleiro.get(5).equals(mrcadorTabuleiro) && tabuleiro.get(8).equals(mrcadorTabuleiro);
		
		return ganhadorLinha1 ||ganhadorVertical1 || ganhadorVertical3|| ganhadorVertical2 || ganhadorLinha2 || ganhadorLinha3 || ganhadorLinhaCruzada1 || ganhadorLinhaCruzada2;
	}
	
	private static void printTabuleiro(List<String> tabuleiro) {
		System.out.println(MessageFormat.format("{0} | {1} | {2}", tabuleiro.get(0), tabuleiro.get(1), tabuleiro.get(2)));
		System.out.println("----------");
		System.out.println(MessageFormat.format("{0} | {1} | {2}", tabuleiro.get(3), tabuleiro.get(4), tabuleiro.get(5)));
		System.out.println("----------");
		System.out.println(MessageFormat.format("{0} | {1} | {2}", tabuleiro.get(6), tabuleiro.get(7), tabuleiro.get(8)));
	}
}