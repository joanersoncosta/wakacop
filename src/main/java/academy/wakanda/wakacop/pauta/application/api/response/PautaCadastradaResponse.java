package academy.wakanda.wakacop.pauta.application.api.response;

import java.util.UUID;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class PautaCadastradaResponse {
	private UUID idPauta;
}
