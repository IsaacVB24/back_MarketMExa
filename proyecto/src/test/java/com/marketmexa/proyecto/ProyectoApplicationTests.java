package com.marketmexa.proyecto;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketmexa.proyecto.model.Productos;

@AutoConfigureMockMvc
@SpringBootTest
class ProyectoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlc3RlZmFuaWFwZXJlekBleGFtcGxlLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzM5NDI3MDI2LCJleHAiOjE3Mzk0NzAyMjZ9.gqjxQ6t_iBAT6O9Le2yYhnjlKqs6sOq-QHEBWN0CvJk";
	
	@Test
	@DisplayName("Se prueba el endponit http://localhost:8080/api/productos/")
	void pruebaGet() throws Exception {
	this.mockMvc.perform(get("/api/productos/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString(""))
			);
	}
	@Test
	@Disabled("Probado la primera vez, deshabilitado para sussecuentes ocasiones")
	@DisplayName("Se prueba borrar el producto con el id 5 en el endpoint http://localhost:8080/api/productos/1")
	void pruebaDelete() throws Exception {
	this.mockMvc.perform(delete("/api/productos/5").header("Authorization", token))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Album Beatles Sergeant Pepper"))
			);
	}
	
	@Test
	@DisplayName("Se prueba actualizar el producto con el id 4 en el endponit http://localhost:8080/api/productos/4")
	void pruebaPut() throws Exception {
	this.mockMvc.perform(put("/api/productos/4?price=1700.55")
			.header("Authorization", token))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("1700.55"))
			);
	} 
	
	@Test
	@DisplayName("Se prueba crear un producto en el endponit http://localhost:8080/api/productos/")
	void pruebaPost() throws Exception {
		Productos p = new Productos("Laptop", "Laptop Dell inspiron 3535", "laptop.jpg", 17854.56, 3);
		this.mockMvc.perform(post("/api/productos/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
			.header("Authorization", token))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Laptop Dell inspiron 3535"))
			);
	} 
	
	private String asJsonString(final Object obj) {
		try {
		return new ObjectMapper().writeValueAsString(obj);
		}	catch (JsonProcessingException e){
				throw new RuntimeException(e);
			}			
}

}
