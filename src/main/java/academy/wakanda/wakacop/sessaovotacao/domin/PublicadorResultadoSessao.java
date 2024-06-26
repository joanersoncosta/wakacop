package academy.wakanda.wakacop.sessaovotacao.domin;

import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoVotacao;

public interface PublicadorResultadoSessao {
	void publica(ResultadoSessaoVotacao resultadoSessaoVotacao);
}
