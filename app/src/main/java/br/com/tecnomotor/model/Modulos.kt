package br.com.tecnomotor.model

import com.fasterxml.jackson.annotation.*
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
@JsonPropertyOrder(
        "id",
        "nome",
        "atuador",
        "programacao",
        "ajuste",
        "identificacao",
        "defeitos",
        "apagamemoria",
        "leituras",
        "analisegrafica",
        "dhchange"
)
@DatabaseTable(tableName = "TBL_MODULO")
class Modulos : Serializable {
    @DatabaseField(id = true, columnName = "MODULO_ID")
    var id: Int? = 0

    @DatabaseField(columnName = "NOME")
    var nome: String? = ""

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
    var dhchange: Date? = Date()

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any>? {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}