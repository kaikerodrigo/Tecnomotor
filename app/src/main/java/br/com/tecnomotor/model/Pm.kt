package br.com.tecnomotor.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.j256.ormlite.dao.ForeignCollection
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.field.ForeignCollectionField
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
@DatabaseTable(tableName = "TBL_PM")
class Pm : Serializable {
    @DatabaseField(id = true, columnName = "ID")
    var id: Int? = 0

    @DatabaseField(
        columnName = "MODULOS_ID",
        foreign = true,
        foreignAutoRefresh = true,
        defaultValue = "INTEGER REFERENCES TBL_MODULOS(MODULO_ID) ON DELETE CASCADE"
    )
    var modulos: Modulos? = null

    @DatabaseField(
        columnName = "MONTADORA_ID",
        foreign = true,
        foreignAutoRefresh = true,
        defaultValue = "INTEGER REFERENCES TBL_MONTADORA(MONTADORA_ID) ON DELETE CASCADE"
    )
    var montadora: Montadora? = null

    @DatabaseField(
        columnName = "SISTEMA_ID",
        foreign = true,
        foreignAutoRefresh = true,
        defaultValue = "INTEGER REFERENCES TBL_SISTEMA(SISTEMA_ID) ON DELETE CASCADE"
    )
    var sistema: Sistema? = null

    @DatabaseField(
        columnName = "TIPO_SISTEMA_ID",
        foreign = true,
        foreignAutoRefresh = true,
        defaultValue = "INTEGER REFERENCES TBL_TIPO_SISTEMA(TIPO_SISTEMA_ID) ON DELETE CASCADE"
    )
    var tipoSistema: TipoSistema? = null

    @DatabaseField(
        columnName = "VEICULO_ID",
        foreign = true,
        foreignAutoRefresh = true,
        defaultValue = "INTEGER REFERENCES TBL_VEICULO(VEICULO_ID) ON DELETE CASCADE"
    )
    var veiculo: Veiculo? = null

    @DatabaseField(
        columnName = "MOTORIZACAO_ID",
        foreign = true,
        foreignAutoRefresh = true,
        defaultValue = "INTEGER REFERENCES TBL_MOTORIZACAO(MOTORIZACAO_ID) ON DELETE CASCADE"
    )
    var motorizacao: Motorizacao? = null

    @DatabaseField(columnName = "VEICULO_MOTORIZACAO")
    var veiculoMotorizacao: String? = null

    @DatabaseField(columnName = "ANO_INICIAL")
    var anoInicial: Int? = 0

    @DatabaseField(columnName = "ANO_FINAL")
    var anoFinal: Int? = 0

    @DatabaseField(columnName = "POS_CONECTOR")
    var posConector: String? = null

    @DatabaseField(columnName = "MODULO_BUSCA")
    var moduloBusca: Boolean? = false

    @DatabaseField(columnName = "MODULO_VIRTUAL")
    var moduloVirtual: Boolean? = false

    @DatabaseField(columnName = "RASTHER_PC")
    var rastherPc: Boolean? = false

    @DatabaseField(columnName = "MANUAL_TEC")
    var manualtec: Boolean? = false

    @DatabaseField(columnName = "VERSAO_INICIAL")
    var versaoInicial: Int? = 0
}