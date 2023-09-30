  open class Vehiculo(val patente:String, val marca:String, val modelo:String, var color:String, val costoPorSeg:Int) {
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
    data class Auto(val patente: String, val marca: String, val modelo: String, val color: String, val costoPorSeg: Int)

}

 class Auto(patente: String, marca: String, modelo: String, color: String, costoPorSeg: Int) :Vehiculo(patente, marca, modelo, color,
     costoPorSeg
 ){
     override fun equals(other: Any?): Boolean {
         if (this === other) return true
         if (javaClass != other?.javaClass) return false
         if (!super.equals(other)) return false
         return true
     }

 }
 class Moto(patente: String, marca: String, modelo: String, color: String, costoPorSeg: Int) :Vehiculo(patente, marca, modelo, color,
     costoPorSeg
 ){
     override fun equals(other: Any?): Boolean {
         if (this === other) return true
         if (javaClass != other?.javaClass) return false
         if (!super.equals(other)) return false
         return true
     }

 }
  class Camioneta(patente: String, marca: String, modelo: String, color: String, costoPorSeg: Int) :Vehiculo(patente, marca, modelo, color,
      costoPorSeg
  ){
      override fun equals(other: Any?): Boolean {
          if (this === other) return true
          if (javaClass != other?.javaClass) return false
          if (!super.equals(other)) return false
          return true
      }

  }
  class Camion(patente: String, marca: String, modelo: String, color: String, costoPorSeg: Int) :Vehiculo(patente, marca, modelo, color,
      costoPorSeg
  ){
      override fun equals(other: Any?): Boolean {
          if (this === other) return true
          if (javaClass != other?.javaClass) return false
          if (!super.equals(other)) return false
          return true
      }

  }
