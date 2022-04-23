package br.ufrn.imd.oba

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ObaApplication

fun main(args: Array<String>) {
	runApplication<ObaApplication>(*args)
}
