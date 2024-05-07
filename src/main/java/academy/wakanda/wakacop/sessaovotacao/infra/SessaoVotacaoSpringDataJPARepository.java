package academy.wakanda.wakacop.sessaovotacao.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;

public interface SessaoVotacaoSpringDataJPARepository extends JpaRepository<SessaoVotacao, UUID>{

}
