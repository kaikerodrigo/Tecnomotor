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
@DatabaseTable(tableName = "TBL_TIPO_SISTEMA")
class TipoSistema : Serializable {
    @DatabaseField(id = true, columnName = "TIPO_SISTEMA_ID")
    var id : Int? = 0
    @DatabaseField(columnName = "NOME")
    var nome: String? = null
    @DatabaseField(columnName = "NOME_SPA")
    var nomeSpa: String? = null
    @DatabaseField(columnName = "NOME_ENG")
    var nomeEng: String? = null
}