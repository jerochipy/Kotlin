

class Estacionamiento {
    private val vehiculos: MutableSet<Vehiculo> = mutableSetOf()

    companion object{
        const val COSTOXHORA=300

    }

    fun estacionarVehiculo(vehiculo: Vehiculo)=vehiculos.add(vehiculo)
    fun removerVehiculo(patente:String)=vehiculos.removeIf{ it.patente==patente}

    fun mostrarVehiculos(){vehiculos.forEach { println(it) }}
    fun buscarVehiculo(patente: String)=vehiculos.find { it.patente==patente }
    fun vehiculosEstacionados()=vehiculos.count()
    fun costoTarifa(horas: Int)= COSTOXHORA*horas


}