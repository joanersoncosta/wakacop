package academy.wakanda.wakacop.sessaovotacao.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturarequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.repository.SessaoVotacaoRepsitory;
import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaovotacaService {
	private final SessaoVotacaoRepsitory sessaoVotacaoRepsitory;

	@Override
	public SessaoAberturaResponse abreSessao(SessaoAberturarequest sessaoRequest) {
		log.info("[inicia] SessaoVotacaoApplicationService - abreSessao");
		SessaoVotacao sessaoVotacao = sessaoVotacaoRepsitory.salva(new SessaoVotacao(sessaoRequest));
		log.info("[finaliza] SessaoVotacaoApplicationService - abreSessao");
		return new SessaoAberturaResponse(sessaoVotacao);
	}

}
