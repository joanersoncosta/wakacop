package academy.wakanda.wakacop.pauta.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@ToString
public class Pauta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idPauta;
	private String titulo;
	private String descricao;
	private UUID idAssociadoAutor;
	private LocalDateTime dataCriacao;
}
