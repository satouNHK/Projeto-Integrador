    package br.iesb.meuprograma.dados;

    import br.iesb.meuprograma.negocio.DisciplinaBO;
    import br.iesb.meuprograma.negocio.NegocioException;
    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
    import javax.faces.application.FacesMessage;
    import javax.faces.bean.ManagedBean;
    import javax.faces.bean.SessionScoped;
    import javax.faces.context.FacesContext;

    @ManagedBean(name = "DisciplinaBean")
    @SessionScoped
    public class DisciplinaBean implements Serializable {

        private int id;
        private String nome;
        private int cod;
        private String descricao;
        private int semestre;
        private int cargaHoraria;
        private List<DisciplinaBean> carregarDisciplina;
        private List<DisciplinaBean> listaTodasDisciplina;

    public List<DisciplinaBean> getCarregarDisciplina() {
        return carregarDisciplina;
    }

    public void setCarregarDisciplina(List<DisciplinaBean> carregarDisciplina) {
        this.carregarDisciplina = carregarDisciplina;
    }

    public List<DisciplinaBean> getListaTodasDisciplina() {
        DisciplinaBO bo = new DisciplinaBO();
                try {
                    listaTodasDisciplina = bo.listar();
                } catch (NegocioException ex) {
                    Logger.getLogger(AtasBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            return listaTodasDisciplina;
    }

    public void setListaTodasDisciplina(List<DisciplinaBean> listaTodasDisciplina) {
        this.listaTodasDisciplina = listaTodasDisciplina;
    }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getCod() {
            return cod;
        }

        public void setCod(int cod) {
            this.cod = cod;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public int getSemestre() {
            return semestre;
        }

        public void setSemestre(int semestre) {
            this.semestre = semestre;
        }

        public int getCargaHoraria() {
            return cargaHoraria;
        }

        public void setCargaHoraria(int cargaHoraria) {
            this.cargaHoraria = cargaHoraria;
        }

        @Override
        public String toString() {
            return nome + cargaHoraria;
        }

        public List<DisciplinaBean> carregarDisciplina() {
            DisciplinaBO bo = new DisciplinaBO();
            try {
                List<DisciplinaBean> lista = bo.listar();
                return lista;
            } catch (NegocioException ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro: " + ex.getMessage()));
                return null;
            }
        }

        public void cadastrarDisciplina() {
            DisciplinaBO bo = new DisciplinaBO();

            try {
                bo.inserir(this);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados inseridos com sucesso!"));
            } catch (NegocioException ex) {
                if (ex.getCause() != null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro", ex.getMessage()));
                }
            }
        }

    }
