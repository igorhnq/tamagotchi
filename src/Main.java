import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bichinho {
    private String nome;
    private int idade;
    private int fome;
    private int saude;

    public Bichinho(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.fome = 50;
        this.saude = 100;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void envelhecer() {
        idade++;
    }

    public int getFome() {
        return fome;
    }

    public void aumentarFome(int quantidade) {
        fome = Math.min(fome + quantidade, 100);
    }

    public void alimentar(int quantidade) {
        fome = Math.max(fome - quantidade, 0);
        envelhecer();
    }

    public int getSaude() {
        return saude;
    }

    public void brincar() {
        saude = Math.min(saude + 10, 100);
        envelhecer();
    }

    public void mostrarStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Fome: " + fome);
        System.out.println("Saude: " + saude);
        System.out.println();
    }
}
class BichinhoManager {
    private List<Bichinho> bichinhos;

    public BichinhoManager() {
        bichinhos = new ArrayList<>();
    }

    public void adicionarBichinho(Bichinho bichinho) {
        bichinhos.add(bichinho);
    }

    public Bichinho encontrarBichinhoPorNome(String nome) {
        for (Bichinho bichinho : bichinhos) {
            if (bichinho.getNome().equalsIgnoreCase(nome)) {
                return bichinho;
            }
        }
        return null;
    }

    public void mostrarTodosBichinhos() {
        for (Bichinho bichinho : bichinhos) {
            bichinho.mostrarStatus();
        }
    }

    public void envelhecerTodosBichinhos() {
        for (Bichinho bichinho : bichinhos) {
            bichinho.envelhecer();
        }
    }

    public void aumentarFomeTodosBichinhos() {
        for (Bichinho bichinho : bichinhos) {
            bichinho.aumentarFome(10);  // Aumenta a fome de cada bichinho em 10
        }
    }
}

public class Main {
    private static BichinhoManager manager = new BichinhoManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Adicionar Bichinho");
            System.out.println("2. Alimentar Bichinho");
            System.out.println("3. Brincar com Bichinho");
            System.out.println("4. Mostrar Status dos Bichinhos");
            System.out.println("5. Envelhecer Todos os Bichinhos");
            System.out.println("6. Aumentar Fome de Todos os Bichinhos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    adicionarBichinho();
                    break;
                case 2:
                    alimentarBichinho();
                    break;
                case 3:
                    brincarComBichinho();
                    break;
                case 4:
                    manager.mostrarTodosBichinhos();
                    break;
                case 5:
                    manager.envelhecerTodosBichinhos();
                    System.out.println("Todos os bichinhos envelheceram!");
                    break;
                case 6:
                    manager.aumentarFomeTodosBichinhos();
                    System.out.println("A fome de todos os bichinhos aumentou!");
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarBichinho() {
        System.out.print("Digite o nome do bichinho: ");
        String nome = scanner.nextLine();
        Bichinho bichinho = new Bichinho(nome);
        manager.adicionarBichinho(bichinho);
        System.out.println("Bichinho " + nome + " adicionado!");
    }

    private static void alimentarBichinho() {
        System.out.print("Digite o nome do bichinho: ");
        String nome = scanner.nextLine();
        Bichinho bichinho = manager.encontrarBichinhoPorNome(nome);
        if (bichinho != null) {
            System.out.print("Digite a quantidade de comida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            bichinho.alimentar(quantidade);
            System.out.println("Bichinho alimentado!");
        } else {
            System.out.println("Bichinho não encontrado!");
        }
    }

    private static void brincarComBichinho() {
        System.out.print("Digite o nome do bichinho: ");
        String nome = scanner.nextLine();
        Bichinho bichinho = manager.encontrarBichinhoPorNome(nome);
        if (bichinho != null) {
            bichinho.brincar();
            System.out.println("Você brincou com " + nome + "!");
        } else {
            System.out.println("Bichinho não encontrado!");
        }
    }
}
