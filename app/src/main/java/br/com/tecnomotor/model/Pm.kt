package br.com.tecnomotor.model

import java.io.Serializable

class Pm : Serializable {
    var id = 0
    var modulos: Modulos? = null
    var montadora: Montadora? = null
    var sistema: Sistema? = null
    var tipoSistema: TipoSistema? = null
    var veiculo: Veiculo? = null
    var motorizacao: Motorizacao? = null
    var veiculoMotorizacao: String? = null
    var anoInicial = 0
    var anoFinal = 0
    var posConector: String? = null
    var moduloBusca = false
    var moduloVirtual = false
    var aplicacaoConectorList: List<AplicacaoConectorList>? = null
    var rastherPc = false
    var manualtec = false
    var versaoInicial = 0
}