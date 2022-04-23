package br.ufrn.imd.oba.domain;

enum class ViewType(
	val id: Long,
	val description: String
) {
	MOBILE_DEVICE(1, "Smartphone/Tablet"),
	DESKTOP_WEB(2,"Online"),
	DESKTOP_EXECUTABLE(3,"Download");
}
