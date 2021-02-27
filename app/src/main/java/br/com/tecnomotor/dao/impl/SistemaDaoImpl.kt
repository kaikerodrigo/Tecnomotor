package br.com.tecnomotor.dao.impl

import android.content.Context
import br.com.tecnomotor.model.Sistema

class SistemaDaoImpl(context: Context?) : GenericDao<Sistema>(context, Sistema::class.java)