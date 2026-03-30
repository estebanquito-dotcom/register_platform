package com.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.plataforma.exception.CursoLlenoException;
import com.plataforma.model.Curso;

public class CursoService {

    private static final Logger logger = LogManager.getLogger(CursoService.class);
    private List<Curso> cursos;

    public CursoService(){
        logger.info("CursoService inicializado");
        cursos = new ArrayList<>(); 
    }

    public void addCurso(Curso curso){
        cursos.add(curso);
        logger.info("curso añadido con exito");
    }

    public List<Curso> getCursos(){
        return cursos;
    }

    public Curso buscarCursoPorCodigo(String codigo){
        for(Curso curso: cursos){
            if(curso.getNombre().equals(codigo)){
                return curso;
            }
        }
        throw new CursoLlenoException("El Curso: "+codigo+" No se encuentra en el sistema");
    }


}
