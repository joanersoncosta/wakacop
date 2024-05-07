package academy.wakanda.wakacop.sessaovotacao.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.wakacop.pauta.application.api.response.PautaCadastradaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturarequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
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
		log.info("[inicia] SessaoVotacaoController - abreSessao");
		SessaoAberturaResponse sessaoAberturaResponse = sessaovotacaService.abreSessao(sessaoRequest);
		log.info("[finaliza] SessaoVotacaoController - abreSessao");
		return sessaoAberturaResponse;
	}

}
