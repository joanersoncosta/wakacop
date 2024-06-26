package academy.wakanda.wakacop.sessaovotacao.domin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class SessaoVotacaoTest {

	@Test
	void deveFecharSessaoQuandoChamarMetodoFecchaSessao() {
		SessaoVotacao sessao = buildeSessaoVotacao();
		PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
		
		sessao.fechaSessao(publicador);
		
		assertEquals(StatusSessaoVotacao.FECHADA, sessao.getStatus());
	}
	
	@Test
	void deveFecharSessaoQuandoStatusAbertaEMomentoEncerraementoEstiverNoPassado() {
		SessaoVotacao sessao = buildeSessaoVotacao();
		PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
		
		sessao.atualizaStatus(publicador);
		
		assertEquals(StatusSessaoVotacao.FECHADA, sessao.getStatus());
	}
	
	@Test
	void deveFicarAbertaSessaoQuandoStatusAbertaEMomentoEncerramentoEstiverNoFuturo() {
		SessaoVotacao sessao = buildeEncerramentoFuturoSessaoVotacao();
		PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
		
		sessao.atualizaStatus(publicador);
		
		assertEquals(StatusSessaoVotacao.ABERTA, sessao.getStatus());
	}

	private SessaoVotacao buildeSessaoVotacao() {
		return SessaoVotacao.builder()
			.idSessao(UUID.randomUUID())
			.idPauta(UUID.randomUUID())
			.status(StatusSessaoVotacao.ABERTA)
			.momentoAbertura(LocalDateTime.of(2023,1,1,1,1))
			.momentoEncerramento(LocalDateTime.of(2023,1,1,1,2))
			.votos(getVotos())
			.build();
	}
	
	private SessaoVotacao buildeEncerramentoFuturoSessaoVotacao() {
		return SessaoVotacao.builder()
			.idSessao(UUID.randomUUID())
			.idPauta(UUID.randomUUID())
			.status(StatusSessaoVotacao.ABERTA)
			.momentoAbertura(LocalDateTime.of(2023,1,1,1,3))
			.momentoEncerramento(LocalDateTime.MAX)
			.votos(getVotos())
			.build();
	}

	private Map<String, VotoPauta> getVotos() {
		return Map.of("08378945784", VotoPauta.builder()
				.cpfAssociado("08378945784")
				.opcaoVoto(OpcaoVoto.SIM)
				.build(),
				"08378945785", VotoPauta.builder()
				.cpfAssociado("08378945784")
				.opcaoVoto(OpcaoVoto.NAO)
				.build());
	}
}