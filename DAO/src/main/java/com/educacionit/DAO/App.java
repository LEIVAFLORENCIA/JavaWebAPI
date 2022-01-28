package com.educacionit.DAO;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.mariadb.UsuarioImpl;

public class App 
{
    public static void main( String[] args ) {
     Usuario usuario = null;
     UsuarioImpl impl = new UsuarioImpl();
     
     usuario = impl.buscar("user2@gmail.com");
     System.out.println(usuario);
    }
}
