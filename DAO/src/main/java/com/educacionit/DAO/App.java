package com.educacionit.DAO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.mariadb.UsuarioImpl;
import com.educacionit.interfaces.UtilidadesFecha;

public class App {
	public static void main(String[] args) throws ParseException {
		UsuarioImpl impl = new UsuarioImpl();
		
		
		Usuario usuario1 = new Usuario("user2@gmail.com", "14234", new Date(), UtilidadesFecha.getStringAFecha("2022-01-27"));
		
		
		impl.guardar(new Usuario("user3@gmail.com", "124", new Date(), UtilidadesFecha.getStringAFecha("2022-01-31")));
		
		List<Usuario> lista = impl.listar();
		lista.forEach(System.out::println);
	}
}
