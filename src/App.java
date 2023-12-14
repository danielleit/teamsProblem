import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    public static int verificador(Scanner scanner, int number) {

        while (number < 2 || number > 10000) {
            System.out.println();
            System.out.println("Error: número menor que 2 ou maior que 10.000!");
            System.out.println("Insira a quantidade correta.");
            System.out.print("N: ");
            number = scanner.nextInt();
        }

        return number;
    }

    public static int verificador(Scanner scanner, int number, int n) {

        while (number < 2 || number > 10000 || number > n) {
            System.out.println();
            System.out.println("Error: número menor que 2, maior que 10.000 ou maior que o número de alunos!");
            System.out.println("Insira a quantidade correta.");
            System.out.print("T: ");
            number = scanner.nextInt();
        }

        return number;
    }

    public static int verificador(Scanner scanner, int number, List<Aluno> listaDeAlunosSemTime) {

        for (Aluno aluno : listaDeAlunosSemTime) {
            if (aluno.getNivelDeHabilidade() == number) {
                while (aluno.getNivelDeHabilidade() == number) {

                    System.out.println();
                    System.out.println("Error: número de habilidade igual à de outro aluno!");
                    System.out.println("Insira o nível de habilidade correta.");
                    number = scanner.nextInt();

                    while (number < 0 || number > 1000000) {
                        System.out.println();
                        System.out.println("Error: número menor que 0 ou maior que 1.000.000!");
                        System.out.println("Insira a quantidade correta.");
                        number = scanner.nextInt();
                    }
                }
            }
        }
        return number;
    }

    public static void ordenacao(List<Aluno> alunos) {

        for (int i = 0; i < alunos.size(); i++) {
            Aluno chave = alunos.get(i);
            int j = i - 1;

            while (j >= 0 && alunos.get(j).getNivelDeHabilidade() < chave.getNivelDeHabilidade()) {
                alunos.set(j + 1, alunos.get(j));
                j--;
            }

            alunos.set(j + 1, chave);

        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<List<Aluno>> listaDeTimes = new ArrayList<>();
        List<Aluno> listaDeAlunosSemTime = new ArrayList<>();

        System.out.println(
                "Insira a quantidade de alunos N (entre 2 e 10.000) e a quantidade de times T (entre 2 e 1000): ");
        System.out.print("N: ");

        int n = verificador(scanner, scanner.nextInt());

        System.out.print("T: ");
        int t = verificador(scanner, scanner.nextInt(), n);

        for (int i = 0; i < t; i++) {
            listaDeTimes.add(new ArrayList<Aluno>());
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Insira o nome do aluno (em maiúsculo) e o nivel de habilidade H (entre 0 e 1.000.000)");
            System.out.print("Nome: ");
            String nome = scanner.next().toUpperCase().trim();

            System.out.print("H: ");
            int h = verificador(scanner, scanner.nextInt(), listaDeAlunosSemTime);

            listaDeAlunosSemTime.add(new Aluno(nome, h));
        }

        int count = 0;
        int tamanhoLista = listaDeAlunosSemTime.size() - 1;

        for (int i = 0; i <= tamanhoLista; i++) {
            listaDeTimes.get(count).add(listaDeAlunosSemTime.get(0));

            listaDeAlunosSemTime.remove(0);

            count++;

            if (count == listaDeTimes.size()) {
                count = 0;
            }
        }

        for (List<Aluno> lista : listaDeTimes) {
            Collections.sort(lista);
        }

        int aux = 1;
        for (List<Aluno> lista : listaDeTimes) {
            System.out.println("Time " + aux + ": ");
            for (Aluno aluno : lista) {
                System.out.println(aluno.getNome());
            }
            System.out.println();
            aux++;
        }
    }
}
