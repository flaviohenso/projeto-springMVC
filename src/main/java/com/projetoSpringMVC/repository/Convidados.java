/**
 * projeto-springMVC : 16 de ago de 2017
 */
package com.projetoSpringMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoSpringMVC.model.Convidado;

/**
 * @author flavio
 *
 */
public interface Convidados extends JpaRepository<Convidado, Long> {

}
