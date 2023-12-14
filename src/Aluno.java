public class Aluno implements Comparable<Aluno> {

    String nome;
    int nivelDeHabilidade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNivelDeHabilidade() {
        return nivelDeHabilidade;
    }
    public void setNivelDeHabilidade(int nivelDeHabilidade) {
        this.nivelDeHabilidade = nivelDeHabilidade;
    }
    
    public Aluno(String nome, int nivelDeHabilidade) {
        this.nome = nome;
        this.nivelDeHabilidade = nivelDeHabilidade;
    }

    @Override
    public int compareTo(Aluno outroAluno) {
        return this.nome.compareTo(outroAluno.getNome());
    }
    
}
