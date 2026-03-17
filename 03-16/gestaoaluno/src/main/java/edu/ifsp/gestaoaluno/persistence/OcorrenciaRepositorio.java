package edu.ifsp.gestaoaluno.persistence;

import org.springframework.data.repository.CrudRepository;

import edu.ifsp.gestaoaluno.modelo.Ocorrencia;

public interface OcorrenciaRepositorio extends CrudRepository<Ocorrencia, Integer>{

}
