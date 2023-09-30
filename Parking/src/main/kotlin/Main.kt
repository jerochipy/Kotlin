
import kotlin.NumberFormatException

fun main(args: Array<String>) {
    val estacionamiento=Estacionamiento()
    var exit=0
    do {
        opciones()
        var opcion= readln()
        when(opcion){
            "0"-> exit=1
            //println("Resultado: "+ cargarVehiculo()?.let { estacionamiento.estacionarVehiculo(it)})
            "1"->cargarVehiculo()?.let {
                val result=estacionamiento.estacionarVehiculo(it)
                if(result)
                    println("Vehiculo agregado correctamente.")
                else
                    println("No hay espacio en el estacionamiento.")
            }
            "2"-> println( estacionamiento.removerVehiculo(cargarDato("Patente"))?.let{
                println("""
                    El costo es de $${it.first}.
                    La estadia fue de ${it.second} segundos.
                """.trimIndent())

                "Vehiculo retirado correctamente"
            }?: "Datos incorrectos")
            "3"-> println(estacionamiento.mostrarVehiculos())
            "4"-> println(estacionamiento.buscarVehiculo(cargarDato("Patente")))
            "5"-> {estacionamiento.caja.abrirCaja(cargarDato("Dinero inicial: ").let {
                try {
                it.toLong()
            }catch (e: NumberFormatException){0}
            })
            }
            "6"-> {estacionamiento.caja.cerrarCaja();println("Las ganancias de la caja fueron de $${estacionamiento.caja.ganancia()}")}
            else-> println("Ingrese una opcion valida")
        }
    }while (exit==0)
}

fun opciones(){
    println("1-Estacionar vehiculo")
    println("2-Quitar vehiculo (por patente)")
    println("3-Ver vehiculos estacionados")
    println("4-Buscar vehiculos estacionados (por patente)")
    println("5-Abrir caja")
    println("6-Cerrar caja")
    println("0-Salir")

}

fun cargarVehiculo():Vehiculo? {


    val patente= cargarDato("Patente: ")
    val modelo= cargarDato("Modelo: ")
    val color= cargarDato("Color: ")
    val marca= cargarDato("Marca: ")



    val vehiculo: () -> Vehiculo? = {
        val tipo= cargarDato("""Inserte un tipo de vehiculo:
            |M= Moto
            |C= Camioneta
            |A= Auto
            |K= Camion 
        """)
        when(tipo.lowercase()) {
            "m" -> Moto(patente,marca,modelo,color,Estacionamiento.COSTO_MOTO)
            "c" -> Camioneta(patente,marca,modelo,color,Estacionamiento.COSTO_CAMIONETA)
            "a" -> Auto(patente,marca,modelo,color,Estacionamiento.COSTO_AUTO)
            "k" -> Camion(patente,marca,modelo,color,Estacionamiento.COSTO_CAMION)
            else -> {
                println("Opcion incorrecta!")
                null
            }
        }
    }
    return vehiculo.invoke()
}



fun cargarDato(mensaje:String): String {
    println(mensaje)
    return readln()
}