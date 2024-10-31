package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria() {}

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
        return desenvolvedores.stream().mapToDouble(Desenvolvedor::calcularSalario).sum();
    } //fazer um for

    public Integer qtdDesenvolvedoresMobile() {
        return (int) desenvolvedores.stream().filter(d -> d instanceof DesenvolvedorMobile).count();
    }



    // fazer o  buscarPorSalarioMaiorIgualQue()

    //fazer o public Desenvolvedor buscarMenorSalario()

    //fazer os dois desafios
































}















