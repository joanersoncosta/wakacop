package academy.wakanda.wakacop.sessaovotacao.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import academy.wakanda.wakacop.associado.application.service.AssociadoService;
import academy.wakanda.wakacop.pauta.application.service.PautaService;
import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.SessaoAberturarequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.request.VotoRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.ResultadoSessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.application.api.response.VotoResponse;
import academy.wakanda.wakacop.sessaovotacao.application.repository.SessaoVotacaoRepsitory;
import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.domin.VotoPauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaovotacaService {
	private final SessaoVotacaoRepsitory sessaoVotacaoRepsitory;
	private final PautaService PautaService;
	private final AssociadoService associadoService;

	@Override
	public SessaoAberturaResponse abreSessao(SessaoAberturarequest sessaoRequest) {
		log.info("[start] SessaoVotacaoApplicationService - abreSessao");
		Pauta pauta = PautaService.getPautaPorId(sessaoRequest.getIdPauta());
		SessaoVotacao sessaoVotacao = sessaoVotacaoRepsitory.salva(new SessaoVotacao(sessaoRequest, pauta));
		log.info("[finish] SessaoVotacaoApplicationService - abreSessao");
		return new SessaoAberturaResponse(sessaoVotacao);
	}

	@Override
	public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
		log.info("[start] SessaoVotacaoApplicationService - recebeVoto");
		SessaoVotacao sessao = sessaoVotacaoRepsitory.buscaSessaoPorId(idSessao);
		VotoPauta voto = sessao.recebeVoto(novoVoto, associadoService);
		sessaoVotacaoRepsitory.salva(sessao);
		log.info("[finish] SessaoVotacaoApplicationService - recebeVoto");
		return new VotoResponse(voto);
	}

	@Override
	public ResultadoSessaoVotacao obtemResultado(UUID idSessao) {
		log.info("[start] SessaoVotacaoApplicationService - obtemResultado");
		SessaoVotacao sessao = sessaoVotacaoRepsitory.buscaSessaoPorId(idSessao);
		sessao.obtemResultado();
		sessaoVotacaoRepsitory.salva(sessao);
		log.info("[finish] SessaoVotacaoApplicationService - obtemResultado");
		return new ResultadoSessaoVotacao(sessao);
	}
}
