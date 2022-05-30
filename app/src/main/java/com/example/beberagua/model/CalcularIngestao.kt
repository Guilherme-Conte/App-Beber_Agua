package com.example.beberagua.model

class CalcularIngestao {

    private val ML_Jovem = 40.0
    private val ML_Adulto = 35.0
    private val ML_Idoso = 30.0
    private val ML_Mais66 = 25.0

    private var resultadoMl = 0.0
    private var totalMl = 0.0

    fun calcularTotalMl(peso: Double, idade: Int){
        if(idade <= 17){
            resultadoMl = peso * ML_Jovem
            totalMl = resultadoMl

        }else if(idade <= 55){
            resultadoMl = peso * ML_Adulto
            totalMl = resultadoMl

        }else if (idade <= 65){
            resultadoMl = peso * ML_Idoso
            totalMl = resultadoMl

        }else{
            resultadoMl = peso * ML_Mais66
            totalMl = resultadoMl
        }

    }
    fun resultadoML(): Double{
        return totalMl

    }
}