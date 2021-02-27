package br.com.tecnomotor.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

class PmList : Serializable {
    @JsonProperty("34")
    var pmList: List<Pm>? = null
}