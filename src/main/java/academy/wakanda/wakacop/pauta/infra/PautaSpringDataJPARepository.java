package academy.wakanda.wakacop.pauta.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.wakanda.wakacop.pauta.domain.Pauta;

public interface PautaSpringDataJPARepository extends JpaRepository<Pauta, UUID>{

}
