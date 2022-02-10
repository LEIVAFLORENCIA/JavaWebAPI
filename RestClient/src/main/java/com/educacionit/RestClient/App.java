package com.educacionit.RestClient;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// URL
		URI URL_SERVICIOS = UriBuilder.fromUri("http://localhost:8080/Rest/servicios").build();

		Client clienteRest = ClientBuilder.newClient();// le podemos pasar el token de seguridad

		Usuario usuario = new Usuario();
		usuario.setCorreo("user12@gmail.com");
		usuario.setClave("1234");

		// Seria como un fetch de js
		WebTarget URL_USUARIOS = clienteRest.target(URL_SERVICIOS).path("usuarios");

		// agregar usuarios
		// request lo que voy a recibir
		// post: objeto que voy a enviar y qué voy a recibir
		Response respuestaAgregar = URL_USUARIOS.path("agregar").request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(usuario, MediaType.APPLICATION_JSON_TYPE));

		System.out.println(respuestaAgregar);

		System.out.println(respuestaAgregar.getStatus());

		//Nos devolverà un objeto
		Response respuestaUsuarioURN = URL_USUARIOS.path("buscar").path("user2@gmail.com")
				.request(MediaType.APPLICATION_JSON_TYPE).get();
		
		System.out.println(respuestaUsuarioURN);
		
		//Reflexion
		//.readentity => El objeto que recibis lo vas a tratar como una clase Usuario
		Usuario usuarioURN = respuestaUsuarioURN.readEntity(Usuario.class);
	}
}
