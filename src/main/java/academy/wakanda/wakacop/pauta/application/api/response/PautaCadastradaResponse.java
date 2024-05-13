package academy.wakanda.wakacop.pauta.application.api.response;

import java.util.UUID;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PautaCadastradaResponse {
	private UUID idPauta;
	
	public PautaCadastradaResponse(Pauta pauta) {
		this.idPauta = pauta.getIdPauta();
	}
	
}
