package br.com.tecnomotor.dao.impl

import android.content.Context
import br.com.tecnomotor.model.Montadora
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager

class MontadoraDaoImpl(context: Context?) : GenericDao<Montadora>(context, Montadora::class.java) {
    private var dao: Dao<Montadora, Int>? = null

    private fun setDao() {
        try {
            dao = DaoManager.createDao(getConnectionSource(), Montadora::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun findByNome(str: String): List<Montadora>? {
        return try {
            dao!!.queryBuilder()
                    .where()
                    .eq("NOME", str)
                    .query()
        } catch (e: Exception) {
            e.printStackTrace()
            ArrayList()
        }
    }

    init {
        setDao()
    }
}