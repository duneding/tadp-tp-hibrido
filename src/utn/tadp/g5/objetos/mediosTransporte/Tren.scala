package utn.tadp.g5.objetos.mediosTransporte

import utn.tadp.g5.objetos.Direccion
import scala.collection.mutable.HashMap
import scala.collection.immutable.TreeMap

class Contains(r: Range) { 
  def unapply(i: Int): Boolean = r contains i 
}

class Tren(linea:String, compania: String, estaciones: List[Direccion]) extends MedioConEstaciones{

	val descripcion = "Tren"	
	val tiempoPorEstacion:Double = 3
	var tablaPrecios = new TreeMap[Int,Double]
	val C1 = new Contains(1 to 5)
	val C2 = new Contains(6 to 8)	
	
	def addPrecio(cantidadEstaciones:Int, precio:Double){
	  tablaPrecios += (cantidadEstaciones -> precio)
	}
	
	def getEstaciones() = estaciones
	
	def costoPara(direccionSalida:Direccion, direccionLlegada:Direccion):Double={
	  this.costoPara(this.estacionesEntre(direccionSalida, direccionLlegada))
	}
	
	def costoPara(estacionesRecorridas:Int):Double={
	  for(cantidadEstaciones <- tablaPrecios.keySet){
	    if(estacionesRecorridas <= estacionesRecorridas){
	      return tablaPrecios(cantidadEstaciones) 
	    }
	  }
	  return 0.0
	}
	
	 override def tiempoCombinacionSubte(direccionCombinacion : Direccion, direccionSalida:Direccion)={
	   5.0 
	 }
	 
	 override def tiempoCombinacionTren(direccionCombinacion : Direccion, direccionSalida:Direccion)={
	   6.0 
	 }
	 
	def costoCombinacion(medio:Medio, direccionSalida:Direccion, direccionLlegada:Direccion)={
	  medio.costoCombinacionTren(direccionSalida, direccionLlegada)
	}
	
	def tiempoCombinacion(direccionCombinacion:Direccion, medio:Medio, direccionSalida:Direccion)={
	  medio.tiempoCombinacionTren(direccionCombinacion, direccionSalida)
	}
	
	def calcularPrecio(estaciones:Int):Double ={
	  
	  estaciones match {
	    case C1() => 2
	    case C2() => 3.5
	    case _ => 4.75
	  }	  	 
	}
	
	override def getLinea(): String = {
	  linea
  }
	
	override def getDescripcion(): String = {
	  return descripcion
  }
	
	override def getCompania(): String = {
	  compania
	}
	
}