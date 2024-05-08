package academy.wakanda.wakacop.sessaovotacao.application.repository;

import java.util.UUID;

import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;

public interface SessaoVotacaoRepsitory {
	SessaoVotacao salva(SessaoVotacao sessaoVotacao);
	SessaoVotacao buscaSessaoPorId(UUID idSessao);
}
