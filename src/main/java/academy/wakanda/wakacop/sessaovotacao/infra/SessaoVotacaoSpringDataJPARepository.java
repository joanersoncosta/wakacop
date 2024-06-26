package academy.wakanda.wakacop.sessaovotacao.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.domin.StatusSessaoVotacao;

public interface SessaoVotacaoSpringDataJPARepository extends JpaRepository<SessaoVotacao, UUID>{
	List<SessaoVotacao> findByStatus(StatusSessaoVotacao aberta);
}
