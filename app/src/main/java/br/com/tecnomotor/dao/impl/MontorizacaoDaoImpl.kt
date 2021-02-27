package br.com.tecnomotor.dao.impl

import android.content.Context
import br.com.tecnomotor.model.Motorizacao

class MontorizacaoDaoImpl(context: Context?) : GenericDao<Motorizacao>(context, Motorizacao::class.java)