package br.com.tecnomotor.dao.impl

import android.content.Context
import br.com.tecnomotor.model.Veiculo

class VeiculoDaoImpl(context: Context?) : GenericDao<Veiculo>(context, Veiculo::class.java)