package br.iesb.meuprograma.dados;
import br.iesb.meuprograma.negocio.NegocioException;
import br.iesb.meuprograma.negocio.PlanoDeEnsinoBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "PlanoDeEnsinoBean")    // Using ManagedBean annotation  
@SessionScoped  // Using Scope annotation  
public class PlanoDeEnsinoBean implements Serializable{
    private int id;
    private String curso;
    private int ano;
    private int semestre;
    private String disciplinas;
    private int cargaHoraria;
    private String periodo;
    private String professor;
    private String ementa;
    private String competenciasHabilidades;
    private String metodologia;
    private String avaliacao;
    private List<PlanoDeEnsinoBean> carregarPlanoDeEnsino = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getCompetenciasHabilidades() {
        return competenciasHabilidades;
    }

    public void setCompetenciasHabilidades(String competenciasHabilidades) {
        this.competenciasHabilidades = competenciasHabilidades;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public List<PlanoDeEnsinoBean> carregarPlanoDeEnsino(){
    PlanoDeEnsinoBO bo = new PlanoDeEnsinoBO();
        try {
            List<PlanoDeEnsinoBean> lista = bo.listar();
            return lista;
        } catch (NegocioException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: " + ex.getMessage()));
            return null;
        }
    }
    
    
    public void cadastrarPlanoDeEnsino() {
        PlanoDeEnsinoBO bo = new PlanoDeEnsinoBO(); 
        
        try{
            bo.inserir(this);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucesso", "Dados inseridos com sucesso!")); 
        }catch(NegocioException ex){
            if(ex.getCause() != null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage())); 
            }
        }
    }       
}
