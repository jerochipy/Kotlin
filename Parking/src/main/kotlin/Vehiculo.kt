class Vehiculo {
    val patente:String
    val marca:String
    val modelo:String
    var color:String

    constructor(
        patente: String,
        marca: String,
        modelo: String,
        color: String
    ) {
        this.patente = patente
        this.marca = marca
        this.modelo = modelo
        this.color = color
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vehiculo

        if (patente != other.patente) return false

        return true
    }

    override fun hashCode(): Int {
        return patente.hashCode()
    }

    override fun toString(): String {
        return "Vehiculo(patente='$patente', marca='$marca', modelo='$modelo', color='$color')"
    }


}