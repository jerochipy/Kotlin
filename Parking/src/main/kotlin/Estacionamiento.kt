import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import javax.swing.text.html.parser.Parser


class Estacionamiento {
    private val vehiculos: MutableMap<Vehiculo,LocalDateTime> = mutableMapOf()
    val capacidadMaxima=3
    val caja=Caja()
    companion object{
        const val COSTO_AUTO=2
        const val COSTO_MOTO=1
        const val COSTO_CAMION=6
        const val COSTO_CAMIONETA=4

    }

    fun estacionarVehiculo(vehiculo: Vehiculo): Boolean {
        if (vehiculosEstacionados() < capacidadMaxima){
            val hora = LocalDateTime.now()
            vehiculos[vehiculo] = hora
            return true
        }
        return false
    }
    fun removerVehiculo(patente:String):Pair<Long,Long>?{
        vehiculos.forEach {
            if(it.key.patente==patente){
                val tiempo=Duration.between(it.value,LocalDateTime.now())
                val costo=tiempo.toSeconds()*it.key.costoPorSeg
                vehiculos.remove(it.key)
                caja.ingresoDinero(costo)
                return Pair(costo,tiempo.toSeconds())
            }
        }
        return null
    }

    fun mostrarVehiculos(){vehiculos.forEach { println(it) }}
    fun buscarVehiculo(patente: String)=vehiculos.entries.find { it.key.patente==patente }
    fun vehiculosEstacionados()=vehiculos.count()
}

class Caja{
    var dineroInicio: Long = 0
    var dinero: Long = 0
    var estado=false

    fun abrirCaja(valor:Long){ dineroInicio=valor; dinero=valor;estado=true}
    fun ingresoDinero(valor:Long){if(estado)dinero+=valor}
    fun cerrarCaja(){estado=false}
    fun ganancia()=dinero-dineroInicio
}