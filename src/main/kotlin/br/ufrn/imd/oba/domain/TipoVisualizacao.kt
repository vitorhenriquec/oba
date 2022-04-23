package br.ufrn.imd.oba.domain;

enum class TipoVisualizacao(
	val id: Long,
	val nome: String
) {
	DISPOSITIVO_MOVEL(1, "Celular/Tablet"),
	DESKTOP_WEB(2,"Online"),
	DESKTOP_EXECUTAVEL(3,"Download");
}
