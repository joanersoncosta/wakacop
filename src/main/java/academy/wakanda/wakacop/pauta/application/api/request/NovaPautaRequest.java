package academy.wakanda.wakacop.pauta.application.api.request;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NovaPautaRequest {
	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	@NotNull
	private UUID idAssociadoAutor;
}
