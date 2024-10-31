package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack() && desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }


    public Double getTotalSalarios() {
        Double totalSalarios = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            totalSalarios += desenvolvedor.calcularSalario();
        }
        return totalSalarios;
    }


    public Integer qtdDesenvolvedoresMobile() {
        int quantidade = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> salarioMaiorIgual = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario) {
                salarioMaiorIgual.add(desenvolvedor);
            }
        }
        return salarioMaiorIgual;
    }


    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores == null) {
            return null;
        }
        Desenvolvedor menorSalario = desenvolvedores.get(0);
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() < menorSalario.calcularSalario()) {
                menorSalario = desenvolvedor;
            }
        }
        return menorSalario;
    }

    //DESAFIOS
    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        if (tecnologia == null){
            return null;
        }
        List<Desenvolvedor> devList = new ArrayList<>();
        for(Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.toString().contains(tecnologia)){
                devList.add(desenvolvedor);
            }
        }
        return devList;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        if (tecnologia == null){
            return null;
        }
        List<Desenvolvedor> devList = buscarPorTecnologia(tecnologia);
        Double totalSalarioPorTec = 0.0;
        for(Desenvolvedor desenvolvedor : desenvolvedores){
            totalSalarioPorTec += desenvolvedor.calcularSalario();
        }
        return totalSalarioPorTec;
    }

}