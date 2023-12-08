package com.example.pentakillpdm123.home.network

import com.example.pentakillpdm123.home.model.LeagueModel
import retrofit2.http.GET



interface LeagueService {



    @GET("ligas/")
    suspend fun getLeagues(): List<LeagueModel>
}
//conecta a redis
//checa si redis tiene la info de ligas, o si es mayor a un dia.


// SI REDIS ESTA VIEJO O NO TIENE INFO
// si no tiene en redis o es muy viejo,pegal e la ruta de ligas para traer la info de mongo
//ya teniendo la info actualiza redis

//S I REDIS TIENE LA INFO Y ES NUEVO

//println(imprime lo de redis)