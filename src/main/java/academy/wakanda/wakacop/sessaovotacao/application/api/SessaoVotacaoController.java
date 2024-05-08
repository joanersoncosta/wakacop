package academy.wakanda.wakacop.sessaovotacao.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturarequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.VotoRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.VotoResponse;
import academy.wakanda.wakacop.sessaovotacao.application.service.SessaovotacaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoController implements SessaovotacaoAPI {
	private final SessaovotacaService sessaovotacaService;
	
	@Override
	public SessaoAberturaResponse abreSessao(SessaoAberturarequest sessaoRequest) {
		log.info("[start] SessaoVotacaoController - abreSessao");
		SessaoAberturaResponse sessaoAberturaResponse = sessaovotacaService.abreSessao(sessaoRequest);
		log.info("[finish] SessaoVotacaoController - abreSessao");
		return sessaoAberturaResponse;
	}

	@Override
	public VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest) {
		log.info("[start] SessaoVotacaoController - recebeVoto");
		log.info("[idSessao] {}", idSessao);
		VotoResponse votoResponse = sessaovotacaService.recebeVoto(idSessao, votoRequest);
		log.info("[finish] SessaoVotacaoController - recebeVoto");
		return votoResponse;
	}

	@Override
	public ResultadoSessaoVotacao obtemResultado(UUID idSessao) {
		log.info("[start] SessaoVotacaoController - obtemResultado");
		log.info("[idSessao] {}", idSessao);
		ResultadoSessaoVotacao resultadoSessaoVotacao = sessaovotacaService.obtemResultado(idSessao);
		log.info("[finish] SessaoVotacaoController - obtemResultado");
		return resultadoSessaoVotacao;
	}
}
