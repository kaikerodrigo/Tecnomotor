package br.com.tecnomotor.dao.impl

import android.content.Context
import android.util.Log
import br.com.tecnomotor.dao.DataBaseHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager

abstract class GenericDao<E>(context: Context?, private val type: Class<E>) : DataBaseHelper(context) {
    private var dao: Dao<E, Int>? = null

    private fun setDao() {
        try {
            dao = DaoManager.createDao(getConnectionSource(), type)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    val all: List<E>?
        get() = try {
            dao!!.queryForAll()
        } catch (e: Exception) {
            e.printStackTrace()
            ArrayList()
        }

    fun findById(id: Int): E? {
        return try {
            dao!!.queryForId(id)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    fun insert(obj: E) {
        try {
            dao!!.create(obj)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun delete(obj: E) {
        try {
            dao!!.delete(obj)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun deleteById(id: Int) {
        try {
            dao!!.deleteById(id)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun deleteAll() {
        try {
            val list = all
            if (list != null) {
                for (it in list){
                    dao!!.delete(it)
                    Log.i("Delete object", list.toString())
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun update(obj: E) {
        try {
            dao!!.update(obj)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    init {
        setDao()
    }
}