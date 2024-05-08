package academy.wakanda.wakacop.sessaovotacao.application.api.response;

import java.time.LocalDateTime;
import java.util.UUID;

import academy.wakanda.wakacop.sessaovotacao.domin.VotoPauta;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoResponse {
	private UUID idVotoPauta;
	private UUID idSessao;
	private String cpfAssociado;
	private LocalDateTime momentoVoto;
	
	public VotoResponse(VotoPauta voto) {
		this.idVotoPauta = voto.getIdVotoPauta();
		this.idSessao = voto.getIdSessao();
		this.cpfAssociado = voto.getCpfAssociado();
		this.momentoVoto = voto.getMomentoVoto();
	}
	
}
