package br.com.tecnomotor.model

import com.fasterxml.jackson.annotation.*
import com.google.gson.JsonElement
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
        "pmList"
)
class PmList : Serializable {

    var pmList: List<JsonElement>? = null

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