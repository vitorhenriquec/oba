package br.ufrn.imd.oba.domain;

enum class AccessType(
	val description: String
) {
	MOBILE("Smartphone/Tablet"),
	WEB("Web Browser"),
	EXECUTABLE("Download");
}
