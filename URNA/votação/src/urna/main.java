package urna;

import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        String candidatos = JOptionPane.showInputDialog("Digite a quantidade de candidatos:");
        int numero = Integer.parseInt(candidatos);

        String[] eleitores = new String[numero];
        int[] votos = new int[numero];

        for (int i = 0; i < numero; i++) {
            eleitores[i] = JOptionPane.showInputDialog("Digite o nome do candidato " + (i + 1) + ":");
        }

        String input = JOptionPane.showInputDialog("Digite a quantidade de eleitores:");
        int number = Integer.parseInt(input);

        int atual = 1;
        while (atual <= number) {
            String menu = "Eleitor " + atual + ", escolha seu candidato:\n";
            for (int i = 0; i < numero; i++) {
                menu += (i + 1) + " - " + eleitores[i] + "\n";
            }

            String votar = JOptionPane.showInputDialog(menu);
            int voto = Integer.parseInt(votar);

            if (voto >= 1) {
                if (voto <= numero) {
                    votos[voto - 1]++;
                    atual++;
                } else if (voto > numero) {
                    JOptionPane.showMessageDialog(null, "CANDIDATO INEXISTENTE! Tente novamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "VALOR INVÁLIDO! Digite um número positivo.");
            }
        }

        String resultado = "--- APURAÇÃO DA VOTAÇÃO ---\n";
        int maior = -1;
        int vencedor = 0;

        for (int i = 0; i < numero; i++) {
            resultado += eleitores[i] + ": " + votos[i] + " voto(s)\n";

            if (votos[i] > maior) {
                maior = votos[i];
                vencedor = i;
            } else if (votos[i] == maior) {
            } else {
            }
        }

        resultado += "\nO vencedor da eleição é: " + eleitores[vencedor] + " com " + maior + " votos!";
        JOptionPane.showMessageDialog(null, resultado);
    }
}