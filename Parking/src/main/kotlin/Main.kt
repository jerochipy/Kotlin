import java.lang.NumberFormatException

fun main(args: Array<String>) {
    val estacionamiento=Estacionamiento()

    var exit=0
    do {
        opciones()
        var opcion= readln()
        when(opcion){
            "0"-> exit=1
            "1"-> println("Resultado: "+estacionamiento.estacionarVehiculo(cargarVehiculo()))
            "2"-> println("Resultado: "+estacionamiento.removerVehiculo(cargarDato("Patente")))
            "3"-> println(estacionamiento.mostrarVehiculos())
            "4"-> println(estacionamiento.buscarVehiculo(cargarDato("Patente")))
            "5"-> {
                try {
                    println("Costo total (${Estacionamiento.COSTOXHORA}/hora)= "+estacionamiento.costoTarifa(cargarDato("Horas:").toInt()))
                }catch (e:NumberFormatException){
                    println("Ingrese una hora valida")
                }
            }
            else-> println("Ingrese una opcion valida")
        }
    }while (exit==0)
}

fun opciones(){
    println("1-Estacionar vehiculo")
    println("2-Quitar vehiculo (por patente)")
    println("3-Ver vehiculos estacionados")
    println("4-Buscar vehiculos estacionados (por patente)")
    println("5-Calcular tarifa (por hora)")
    println("0-Salir")

}

fun cargarVehiculo():Vehiculo {

    val patente= cargarDato("Patente: ")
    val modelo= cargarDato("Modelo: ")
    val color= cargarDato("Color: ")
    val marca= cargarDato("Marca: ")

    return Vehiculo(patente,marca,modelo, color)
}

fun cargarDato(mensaje:String): String {
    println(mensaje)
    return readln()
}