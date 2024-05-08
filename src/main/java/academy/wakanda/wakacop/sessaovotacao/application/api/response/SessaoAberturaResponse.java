package academy.wakanda.wakacop.sessaovotacao.application.api.response;

import java.util.UUID;

import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SessaoAberturaResponse {
	private UUID idSesao;
	
	public SessaoAberturaResponse(SessaoVotacao sessaoVotacao) {
		this.idSesao = sessaoVotacao.getIdSessao();
	}

}
