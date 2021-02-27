package br.com.tecnomotor.dao.impl

import android.content.Context
import br.com.tecnomotor.model.TipoSistema

class TipoSistemaDaoImpl(context: Context?) : GenericDao<TipoSistema>(context, TipoSistema::class.java)