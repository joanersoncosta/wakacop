package academy.wakanda.wakacop.sessaovotacao.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.wakacop.pauta.application.service.PautaService;
import academy.wakanda.wakacop.pauta.domain.Pauta;
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
	private final PautaService PautaService;

	@Override
	public SessaoAberturaResponse abreSessao(SessaoAberturarequest sessaoRequest) {
		log.info("[inicia] SessaoVotacaoApplicationService - abreSessao");
		Pauta pauta = PautaService.getPautaPorId(sessaoRequest.getIdPauta());
		SessaoVotacao sessaoVotacao = sessaoVotacaoRepsitory.salva(new SessaoVotacao(sessaoRequest, pauta));
		log.info("[finaliza] SessaoVotacaoApplicationService - abreSessao");
		return new SessaoAberturaResponse(sessaoVotacao);
	}

}
