package academy.wakanda.wakacop.sessaovotacao.application.service;

import java.util.UUID;

import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturarequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.VotoRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.VotoResponse;

public interface SessaovotacaService {
	SessaoAberturaResponse abreSessao(SessaoAberturarequest sessaoRequest);
	VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest);
	ResultadoSessaoVotacao obtemResultado(UUID idSessao);
}
