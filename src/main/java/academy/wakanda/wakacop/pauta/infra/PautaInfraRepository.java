package academy.wakanda.wakacop.pauta.infra;

import org.springframework.stereotype.Repository;

import academy.wakanda.wakacop.pauta.application.repository.PautaRepsitory;
import academy.wakanda.wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PautaInfraRepository implements PautaRepsitory {
	private final PautaSpringDataJPARepository pautaSpringDataJPARepository;

	@Override
	public Pauta salva(Pauta pauta) {
		log.info("[start] PautaInfraRepository - salva");
		pautaSpringDataJPARepository.save(pauta);
		log.info("[finish] PautaInfraRepository - salva");
		return pauta;
	}

}
