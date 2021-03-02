package br.com.tecnomotor.model

import com.fasterxml.jackson.annotation.*
import com.j256.ormlite.field.DatabaseField
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
        "conector",
        "conectorPinoX",
        "conectorPinoY"
)
@DatabaseTable(tableName = "TBL_APLICACAO_CONECTOR_LIST")
class AplicacaoConectorList : Serializable {
    @DatabaseField(
            columnName = "CONECTOR_ID",
            foreign = true,
            foreignAutoRefresh = true,
            defaultValue = "INTEGER REFERENCES TBL_CONECTOR(CONECTOR_ID) ON DELETE CASCADE"
    )
    var conector: Conector? = Conector()

    @DatabaseField(columnName = "CONECTOR_PINO_X")
    var conectorPinoX: String? = ""

    @DatabaseField(columnName = "CONECTOR_PINO_Y")
    var conectorPinoY: String? = ""

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