package academy.wakanda.wakacop.pauta.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import academy.wakanda.wakacop.pauta.application.api.request.NovaPautaRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Pauta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idPauta;
	private String titulo;
	private String descricao;
	@Column(columnDefinition = "uuid", updatable = false, nullable = false)
	private UUID idAssociadoAutor;
	private LocalDateTime dataCriacao;
	
	public Pauta(NovaPautaRequest novaPauta) {
		this.titulo = novaPauta.getTitulo();
		this.descricao = novaPauta.getDescricao();
		this.idAssociadoAutor = novaPauta.getIdAssociadoAutor();
		this.dataCriacao = LocalDateTime.now();
	}
	
}
