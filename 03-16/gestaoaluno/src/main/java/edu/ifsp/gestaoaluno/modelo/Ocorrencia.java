package edu.ifsp.gestaoaluno.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ocorrencias")
public class Ocorrencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 5, max = 255, message = "{ocorrencia.nome.size}")
	private String nome_aluno;
	
	@Column(name = "horario", columnDefinition = "DATETIME")
	private LocalDateTime horario;
	
	@NotEmpty(message = "{ocorrencia.justificativa.vazia")
	@Size(max = 500, message = "{ocorrencia.justificativa.size}")
	private String justificativa;
	
	@jakarta.persistence.PrePersist
    protected void aoSalvar() {
		if (this.horario == null) {
	        this.horario = LocalDateTime.now();
	    }
    }
	
	@jakarta.persistence.PreUpdate
	protected void aoAtualizar() {
	    if (this.horario == null) {
	        this.horario = LocalDateTime.now();
	    }
	}
		
	public Ocorrencia() {
	}

	public Ocorrencia(Integer id, @Size(min = 5, max = 255, message = "{aluno.nome.size}") String nome_aluno,
			@NotEmpty(message = "{aluno.justificativa.vazia") @Size(max = 500, message = "{justificativa.size}") String justificativa) {
		this.id = id;
		this.nome_aluno = nome_aluno;
		this.horario = LocalDateTime.now();
		this.justificativa = justificativa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
}
