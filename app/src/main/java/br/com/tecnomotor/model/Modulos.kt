package br.com.tecnomotor.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.j256.ormlite.field.DataType
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import lombok.*
import java.io.Serializable
import java.util.*

@AllArgsConstructor
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Setter
@SuppressWarnings("serial")
@ToString
@DatabaseTable(tableName = "TBL_MODULOS")
class Modulos : Serializable {
    @DatabaseField(id = true, columnName = "MODULO_ID")
    var id : Int? = 0
    @DatabaseField(columnName = "NOME")
    var nome: String? = null
    @DatabaseField(columnName = "ATUADOR")
    var atuador = false
    @DatabaseField(columnName = "PROGRAMACAO")
    var programacao = false
    @DatabaseField(columnName = "AJUSTE")
    var ajuste = false
    @DatabaseField(columnName = "IDENTIFICACAO")
    var identificacao = false
    @DatabaseField(columnName = "DEFEITOS")
    var defeitos = false
    @DatabaseField(columnName = "APAGA_MEMORIA")
    var apagamemoria = false
    @DatabaseField(columnName = "LEITURAS")
    var leituras = false
    @DatabaseField(columnName = "ANALISE_GRAFICA")
    var analisegrafica = false
    @DatabaseField(dataType = DataType.DATE_LONG, columnName = "DH_CHANGE")
    var dhchange: Date? = null
}