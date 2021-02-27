package br.com.tecnomotor.model

import java.io.Serializable
import java.util.*

class Modulos : Serializable {
    var id = 0
    var nome: String? = null
    var atuador = false
    var programacao = false
    var ajuste = false
    var identificacao = false
    var defeitos = false
    var apagamemoria = false
    var leituras = false
    var analisegrafica = false
    var dhchange: Date? = null
}