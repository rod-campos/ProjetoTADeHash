package projeto;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o tamanho do vetor: ");
        int tamanho = scanner.nextInt();
        VetorTAD<Object> vetor = new VetorTAD<>(tamanho);

        System.out.println("Opções:");
        System.out.println("1 - Adicionar elemento");
        System.out.println("2 - Mostrar elementos");
        System.out.println("3 - Buscar elemento");
        System.out.println("4 - Remover elemento");
        System.out.println("0 - Sair");

        int opcao;
        do {
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Informe o elemento a ser adicionado: ");
                    if (scanner.hasNextInt()) {
                        vetor.inserir(scanner.nextInt());
                    } else if (scanner.hasNextFloat()) {
                        vetor.inserir(scanner.nextFloat());
                    } else {
                        vetor.inserir(scanner.next());
                    }
                    break;
                case 2:
                    System.out.println("Elementos no vetor:");
                    vetor.mostrar();
                    break;
                case 3:
                    System.out.print("Informe o elemento a ser buscado: ");
                    if (scanner.hasNextInt()) {
                        System.out.println("Encontrado: " + vetor.buscar(scanner.nextInt()));
                    } else if (scanner.hasNextFloat()) {
                        System.out.println("Encontrado: " + vetor.buscar(scanner.nextFloat()));
                    } else {
                        System.out.println("Encontrado: " + vetor.buscar(scanner.next()));
                    }
                    break;
                case 4:
                    System.out.print("Informe o elemento a ser removido: ");
                    if (scanner.hasNextInt()) {
                        vetor.remover(scanner.nextInt());
                    } else if (scanner.hasNextFloat()) {
                        vetor.remover(scanner.nextFloat());
                    } else {
                        vetor.remover(scanner.next());
                    }
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Esta opção não existe.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}