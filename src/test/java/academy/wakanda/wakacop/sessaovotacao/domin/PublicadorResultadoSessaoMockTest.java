package academy.wakanda.wakacop.sessaovotacao.domin;

import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoVotacao;
import lombok.extern.log4j.Log4j2;

@Log4j2
class PublicadorResultadoSessaoMockTest implements PublicadorResultadoSessao {
	@Override
	public void publica(ResultadoSessaoVotacao resultadoSessaoVotacao) {
		log.info("[start] PublicadorResultadoSessaoMockTest - publica");
		log.info("[finish] PublicadorResultadoSessaoMockTest - publica");
	}
}
