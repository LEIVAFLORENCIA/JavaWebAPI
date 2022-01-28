package com.educacionit.interfaces;

import java.util.List;

public interface DAO <E, K> {
	E buscar(K k);
	
	Boolean insertar(E e);
	
	Boolean eliminar(E e);
	
	Boolean actualizar(E e);
	
	List<E> listar();
}
