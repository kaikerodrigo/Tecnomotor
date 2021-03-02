package br.com.tecnomotor.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import br.com.tecnomotor.model.*
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import java.sql.SQLException

open class DataBaseHelper(context: Context?) :
        OrmLiteSqliteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val TAG = DataBaseHelper::class.java.simpleName
        private const val DATABASE_NAME = "tecnomotor.db"
        private const val DATABASE_VERSION = 1
    }

    private var aplicacaoConectorListDao: Dao<AplicacaoConectorList, Int>? = null
    private var conectorDao: Dao<Conector, Int>? = null
    private var modulosDao: Dao<Modulos, Int>? = null
    private var montadoraDao: Dao<Montadora, Int>? = null
    private var motorizacaoDao: Dao<Motorizacao, Int>? = null
    private var aPmDao: Dao<Pm, Int>? = null
    private var sistemaDao: Dao<Sistema, Int>? = null
    private var tipoSistemaDao: Dao<TipoSistema, Int>? = null
    private var veiculoDao: Dao<Veiculo, Int>? = null


    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTableIfNotExists(connectionSource, Conector::class.java)
        TableUtils.createTableIfNotExists(connectionSource, Modulos::class.java)
        TableUtils.createTableIfNotExists(connectionSource, Montadora::class.java)
        TableUtils.createTableIfNotExists(connectionSource, Motorizacao::class.java)
        TableUtils.createTableIfNotExists(connectionSource, Sistema::class.java)
        TableUtils.createTableIfNotExists(connectionSource, TipoSistema::class.java)
        TableUtils.createTableIfNotExists(connectionSource, Veiculo::class.java)
//        TableUtils.createTableIfNotExists(connectionSource, AplicacaoConectorList::class.java)
//        TableUtils.createTableIfNotExists(connectionSource, Pm::class.java)
    }

    override fun onUpgrade(
            database: SQLiteDatabase?,
            connectionSource: ConnectionSource?,
            oldVersion: Int,
            newVersion: Int
    ) {
        when (DATABASE_VERSION) {
            1 -> onCreate(database, connectionSource)
            else -> onCreate(database, connectionSource)
        }
    }

    override fun close() {
        aplicacaoConectorListDao = null
        conectorDao = null
        modulosDao = null
        montadoraDao = null
        motorizacaoDao = null
        aPmDao = null
        sistemaDao = null
        tipoSistemaDao = null
        veiculoDao = null
    }

    @Throws(SQLException::class)
    fun getAplicacaoConectorListDao(): Dao<AplicacaoConectorList, Int>? {
        if (aplicacaoConectorListDao == null) {
            aplicacaoConectorListDao = getDao(AplicacaoConectorList::class.java)
        }
        return aplicacaoConectorListDao
    }

    @Throws(SQLException::class)
    fun getConectorDao(): Dao<Conector, Int>? {
        if (conectorDao == null) {
            conectorDao = getDao(Conector::class.java)
        }
        return conectorDao
    }

    @Throws(SQLException::class)
    fun getModulosDao(): Dao<Modulos, Int>? {
        if (modulosDao == null) {
            modulosDao = getDao(Modulos::class.java)
        }
        return modulosDao
    }

    @Throws(SQLException::class)
    fun getMontadoraDao(): Dao<Montadora, Int>? {
        if (montadoraDao == null) {
            montadoraDao = getDao(Montadora::class.java)
        }
        return montadoraDao
    }

    @Throws(SQLException::class)
    fun getMotorizacaoDao(): Dao<Motorizacao, Int>? {
        if (motorizacaoDao == null) {
            motorizacaoDao = getDao(Motorizacao::class.java)
        }
        return motorizacaoDao
    }

    @Throws(SQLException::class)
    fun getPmDao(): Dao<Pm, Int>? {
        if (aPmDao == null) {
            aPmDao = getDao(Pm::class.java)
        }
        return aPmDao
    }

    @Throws(SQLException::class)
    fun getSistemaDao(): Dao<Sistema, Int>? {
        if (sistemaDao == null) {
            sistemaDao = getDao(Sistema::class.java)
        }
        return sistemaDao
    }

    @Throws(SQLException::class)
    fun getTipoSistemaDao(): Dao<TipoSistema, Int>? {
        if (tipoSistemaDao == null) {
            tipoSistemaDao = getDao(TipoSistema::class.java)
        }
        return tipoSistemaDao
    }

    @Throws(SQLException::class)
    fun getVeiculoDao(): Dao<Veiculo, Int>? {
        if (veiculoDao == null) {
            veiculoDao = getDao(Veiculo::class.java)
        }
        return veiculoDao
    }
}