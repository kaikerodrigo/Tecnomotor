package br.com.tecnomotor.model

import com.fasterxml.jackson.annotation.*
import com.j256.ormlite.table.DatabaseTable
import lombok.*
import java.io.Serializable


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
        "modulos",
        "montadora",
        "sistema",
        "tipoSistema",
        "veiculo",
        "motorizacao",
        "veiculoMotorizacao",
        "anoInicial",
        "anoFinal",
        "posConector",
        "moduloBusca",
        "moduloVirtual",
        "aplicacaoConectorList",
        "rastherPc",
        "manualtec",
        "versaoInicial"
)
@DatabaseTable(tableName = "TBL_PM")
class Pm : Serializable {

    @JsonProperty("id")
    var id: Int? = null

    @JsonProperty("modulos")
    var modulos: Modulos? = null

    @JsonProperty("montadora")
    var montadora: Montadora? = null

    @JsonProperty("sistema")
    var sistema: Sistema? = null

    @JsonProperty("tipoSistema")
    var tipoSistema: TipoSistema? = null

    @JsonProperty("veiculo")
    var veiculo: Veiculo? = null

    @JsonProperty("motorizacao")
    var motorizacao: Motorizacao? = null

    @JsonProperty("veiculoMotorizacao")
    var veiculoMotorizacao: String? = null

    @JsonProperty("anoInicial")
    var anoInicial: Int? = null

    @JsonProperty("anoFinal")
    var anoFinal: Int? = null

    @JsonProperty("posConector")
    var posConector: String? = null

    @JsonProperty("moduloBusca")
    var moduloBusca: Boolean? = null

    @JsonProperty("moduloVirtual")
    var moduloVirtual: Boolean? = null

    @JsonProperty("aplicacaoConectorList")
    var aplicacaoConectorList: List<AplicacaoConectorList>? = null

    @JsonProperty("rastherPc")
    var rastherPc: Boolean? = null

    @JsonProperty("manualtec")
    var manualtec: Boolean? = null

    @JsonProperty("versaoInicial")
    var versaoInicial: Int? = null

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