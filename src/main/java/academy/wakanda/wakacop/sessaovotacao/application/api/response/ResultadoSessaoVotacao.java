package academy.wakanda.wakacop.sessaovotacao.application.api.response;

import java.time.LocalDateTime;
import java.util.UUID;

import academy.wakanda.wakacop.sessaovotacao.domin.SessaoVotacao;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResultadoSessaoVotacao {
	private UUID idSessao;
	private UUID idPauta;
	private LocalDateTime momentoAbertura;
	private LocalDateTime momentoEncerramento;
	private Long totalVotos;
	private Long totalSim;
	private Long totalNao;
	
	public ResultadoSessaoVotacao(SessaoVotacao sessao) {
		this.idSessao = sessao.getIdSessao();
		this.idPauta = sessao.getIdPauta();
		this.momentoAbertura = sessao.getMomentoAbertura();
		this.momentoEncerramento = sessao.getMomentoEncerramento();
		this.totalVotos = sessao.getTotalVotos();
		this.totalSim = sessao.getTotalSim();
		this.totalNao = sessao.getTotalNao();
	}
}
