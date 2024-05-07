package academy.wakanda.wakacop.sessaovotacao.application.service;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturarequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;

public interface SessaovotacaService {
	SessaoAberturaResponse abreSessao(SessaoAberturarequest sessaoRequest);
}
