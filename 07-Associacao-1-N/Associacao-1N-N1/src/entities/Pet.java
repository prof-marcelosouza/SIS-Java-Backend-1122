package entities;

public class Pet {

    private int id;
    private String raca;
    private Pessoa pessoa;

    public Pet() {
    }

    public Pet(int id, String raca, Pessoa pessoa) {
        this.id = id;
        this.raca = raca;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void cadastrar() {
        System.out.println("Cadastrando um pet...");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        return id == pet.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", raca='" + raca + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
