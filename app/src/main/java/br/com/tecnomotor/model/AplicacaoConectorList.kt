package br.com.tecnomotor.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
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
@DatabaseTable(tableName = "TBL_APLICACAO_CONECTOR_LIST")
class AplicacaoConectorList : Serializable {
    @DatabaseField(id = true, columnName = "APLICACAO_CONECTOR_ID")
    var id : Int? = 0
    @DatabaseField(columnName = "CONECTOR_ID", foreign = true, foreignAutoRefresh = true, defaultValue = "INTEGER REFERENCES TBL_CONECTOR(CONECTOR_ID) ON DELETE CASCADE")
    var conector: Conector? = null
    @DatabaseField(columnName = "CONECTOR_PINO_X")
    var conectorPinoX: String? = null
    @DatabaseField(columnName = "CONECTOR_PINO_Y")
    var conectorPinoY: String? = null
}