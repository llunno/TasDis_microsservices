package com.ln.microsservice.bff.Business.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientInstancesConfig {

	@Value("${tarefa.microsservice.url}")
	private String tarefaMicrosserviceUrl;
	@Value("${usuario.microsservice.url}")
	private String usuarioMicrosserviceUrl;
	@Value("${endereco.microsservice.url}")
	private String enderecoMicrosserviceUrl;
	@Value("${instituicao.microsservice.url}")
	private String instituicaoMicrosserviceUrl;
	@Value("${curso.microsservice.url}")
	private String cursoMicrosserviceUrl;

	@Bean
	public WebClient webClientTarefaDomain() {
		return WebClient.builder()
				.baseUrl(tarefaMicrosserviceUrl)
				.build();
	}

	@Bean
	public WebClient webClientUsuarioDomain() {
		return WebClient.builder()
				.baseUrl(usuarioMicrosserviceUrl)
				.build();
	}

	@Bean
	public WebClient webClientEnderecoDomain() {
		return WebClient.builder()
				.baseUrl(enderecoMicrosserviceUrl)
				.build();
	}

	@Bean
	public WebClient webClientInstituicaoDomain() {
		return WebClient.builder()
				.baseUrl(instituicaoMicrosserviceUrl)
				.build();
	}

	@Bean
	public WebClient webClientCursoDomain() {
		return WebClient.builder()
				.baseUrl(cursoMicrosserviceUrl)
				.build();
	}
}
