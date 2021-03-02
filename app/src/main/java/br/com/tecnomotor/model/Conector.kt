package br.com.tecnomotor.model

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonPropertyOrder
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
        "id",
        "nome"
)
@DatabaseTable(tableName = "TBL_CONECTOR")
class Conector : Serializable {
    @DatabaseField(id = true, columnName = "CONECTOR_ID")
    var id: Int? = 0

    @DatabaseField(columnName = "NOME")
    var nome: String? = ""
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