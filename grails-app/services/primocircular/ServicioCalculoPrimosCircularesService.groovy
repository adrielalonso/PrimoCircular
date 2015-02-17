package primocircular
import java.util.concurrent.*
import java.lang.Math.*
import org.hibernate.ejb.criteria.expression.function.SqrtFunction;

import grails.transaction.Transactional

@Transactional
class ServicioCalculoPrimosCircularesService{

    def calcularPrimosCirculares() {
		
		List lista1 = new ArrayList<>()
		List lista2 = new ArrayList<>()
		List lista2Final = new ArrayList<>()
		List lista3 = new ArrayList<>()
		List lista3Inter = new ArrayList<>()
		List lista3Final = new ArrayList<>()
		
			//Hilo uno que calculo los primos circulares de los numeros con 1,2 y 3 dígitos			
	def primero = Thread.start {
		
		
//	println "entre al hilo 1"
		
//    List lista1 = new ArrayList<>()
//	List lista2 = new ArrayList<>()
//	List lista2Final = new ArrayList<>()
//	List lista3 = new ArrayList<>()
//	List lista3Inter = new ArrayList<>()
//	List lista3Final = new ArrayList<>()
    def i
	def j
	def k
	def n = 1
	def m = 10
	def p = 100
	
		//primos del 1 al 10 
		for(n;n<10;n++)	{
			def a = 0
			for(i=1;i<(n+1);i++){
				if(n%i==0){
					a++;
				   }
				}
				if(a==2){
					lista1.add(n) //si es primo lo agrego a la lista 1
					    }
				
		}//fin primos del 1  al 10
		
//		println"1 Final es"+lista1
		
	
		//primos del 10 al 100
		for(m;m<100;m++)	{
			
			def s = Integer.toString(m)
			if(s.contains("0") || s.contains("2") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("8")){
			}
			else{
			
			def a = 0
			for(j=1;j<(m+1);j++){
				if(m%j==0){
					a++;
				   }
				}
				if(a==2){
					lista2.add(m) //si es primo lo agrego a la lista 2
						}
			}
		}//fin primos del 10  al 100
		
		lista2.each{
			
			def x = Integer.toString(it)
			
			if(!lista2Final.contains(it)){ //se fija si el numero que estoy por dar vuelta, no lo tengo en la lista final ya, xq si ya lo tengo no hace falta evaluarlo
						
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,2) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
									
			//primos circulares del 10 al 100
	
				def a = 0
				for(j=1;j<(d+1);j++){
					if(d%j==0){
						a++;
					   }
					}
					if(a==2){
						lista2Final.add(d) //si es primo lo agrego a la lista 2
							}
	
			} // fin si, si la lista final ya tenia el numero
		}// fin each por cada elemento de dos digitos del vector Lista2
		
//		println"2 Final es"+lista2Final
	
		
		
		
		//primos del 100 al 1000
		for(p;p<1000;p++)	{
			
			def s = Integer.toString(p)
			
			//si el numero q estoy evaluando no contiene el 0,2,4,5,6,8 entonces puede llegar a ser primo
			if(s.contains("0") || s.contains("2") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("8")){
			}
			else{
			
			
			def a = 0
			for(k=1;k<(p+1);k++){
				if(p%k==0){
					a++;
				   }
				}
				if(a==2){
					lista3.add(p) //si es primo lo agrego a la lista 3
						}
			} //fin si y else
		}//fin primos del 100  al 1000
		
		
		
		lista3.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,3) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
			
			// si el numero me queda con un cero adelante, no me fijo si es primo circular. Por ejemplo, el 307 es primo, pero el 037 no lo tengo en cuenta ya que despues será par
			
			
			
			// me fijo si es primo la primer rotacion

			def a = 0
			for(k=1;k<(d+1);k++){
				if(d%k==0){
					a++;
				   }
				}
				if(a==2){
					lista3Inter.add(d) //si es primo lo agrego a la lista 3
						}
			
				
			
		}// fin each por cada elemento de la lista3 digitos
			
			
		lista3Inter.each{
			
			if(!lista3Final.contains(it)){
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,3) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g = Integer.toString(d)
			

			
			
			// me fijo si la segunda rotacion tambien es primo --> es primo circular
			
			// si el numero me queda con un cero adelante, no me fijo si es primo circular. Por ejemplo, el 307 es primo, pero el 037 no lo tengo en cuenta en esta lista
			
				
				
				def y = Integer.toString(d)
				
				def q = y.substring(0,1) //para tomar el primer elemento de la cadena
				def w = y.substring(1,3) //para tomar el segundo elemento de la cadena
				def r = w+q
				def t = Integer.parseInt(r)
				
				// si ya existe el numero en alguna de sus proximas rotaciones, no hace falta evaluarlo,  asi no se me repite en la lista final
				if(!lista3Final.contains(t)){
			
			def a = 0
			for(k=1;k<(d+1);k++){
				if(d%k==0){
					a++;
				   }
				}
				if(a==2){
					lista3Final.add(d) //si es primo lo agrego a la lista 3 Final
						}
				} // fin if interno si ya evalue ese elemento
			
			} // fin si  ya existe ese elemento en esa lista
		}// fin each por cada elemento de la lista3Inter
		
//		 println "la lista 3Final es"+lista3Final
		 
    }//fin primer hilo
    
	
	List lista4 = new ArrayList<>()
	List lista4Inter1 = new ArrayList<>()
	List lista4Inter2 = new ArrayList<>()
	List lista4Final = new ArrayList<>()
	
		
	def segundo = Thread.start {
		
//		println "entre al hilo 2"
		
		// el segundo hilo, calcula los primos circulares de los numeros de 4 y 5 digitos
//		List lista4 = new ArrayList<>()
//		List lista4Inter1 = new ArrayList<>()
//		List lista4Inter2 = new ArrayList<>()
//		List lista4Final = new ArrayList<>()
		
		def i
		def n = 1000
		
		
		for(n;n<10000;n++)	{
			
			def x = Integer.toString(n)
			
			//si el numero tiene el 0,2,4,5,6,8 en alguna de sus rotaciones no va a ser primo, asi q ni lo calculo ahora
			if(x.contains("0") || x.contains("2") || x.contains("4") || x.contains("5") || x.contains("6") || x.contains("8")){
			}
			else{
			if(n%2!=0){
			def a = 0
			for(i=1;i<(n+1);i++){
				if(n%i==0){
					a++;
				   }
				}
				if(a==2){
					lista4.add(n) //si es primo lo agrego a la lista 4
						}
			}} // fin for de los primos de 4 digitos
		}
		
		lista4.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,4) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
			// si el numero me queda con un cero adelante, no me fijo si es primo circular. 
			
			if(g.length() == 4){
				
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista4Inter1.add(d) //si es primo lo agrego a la lista 4Inter1
							}
								
				} // fin if, si que con 3 elementos

			} //fin each, por cada elemento de la lista 4
		
		
		lista4Inter1.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,4) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
						
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista4Inter2.add(d) //si es primo lo agrego a la lista 4
							}


			} //fin each, por cada elemento de la lista 4Inter1
		
		lista4Inter2.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,4) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
				def f = g.substring(0,1) //para tomar el primer elemento de la cadena
				def h = g.substring(1,4) //para tomar el segundo elemento de la cadena
				def l = h+f
				def z = Integer.parseInt(l)
				def ll = h+f
				

				def q = ll.substring(0,1) //para tomar el primer elemento de la cadena
				def w = ll.substring(1,4) //para tomar el segundo elemento de la cadena
				def r = w+q
				def t = Integer.parseInt(r)
				
				// si ya existe el numero en alguna de sus proximas rotaciones, no hace falta evaluarlo,  asi no se me repite en la lista final
				
				if(!lista4Final.contains(t) && !lista4Final.contains(it) && !lista4Final.contains(r)  && !lista4Final.contains(z)){
				
					
					
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista4Final.add(d) //si es primo lo agrego a la lista 4
							
								
				}// fin si no existe en las proximas rotaciones
				} // fin if, si que con 3 elementos

			} //fin each, por cada elemento de la lista 4Inter2
		
//		println "lista 4 Final es"+lista4Final
		
//		println "la lista 1 es"+lista1
		
		} // fin segundo hilo
		
		
		
	
	List lista5 = new ArrayList<>()
	List lista5Inter1 = new ArrayList<>()
	List lista5Inter2 = new ArrayList<>()
	List lista5Inter3 = new ArrayList<>()
	List lista5Final = new ArrayList<>()
		
	def tercero = Thread.start {
		// este hilo calcula los primos circulares del 10000 al 100000
//		println "entre al hilo 3"
		
//		List lista5 = new ArrayList<>()
//		List lista5Inter1 = new ArrayList<>()
//		List lista5Inter2 = new ArrayList<>()
//		List lista5Inter3 = new ArrayList<>()
//		List lista5Final = new ArrayList<>()
		
		def i
		def n = 10000
		
		for(n;n<100000;n++)	{
			
			def x = Integer.toString(n)
			
			//si el numero tiene el 0,2,4,5,6,8 en alguna de sus rotaciones no va a ser primo, asi q ni lo calculo ahora
			if(x.contains("0") || x.contains("2") || x.contains("4") || x.contains("5") || x.contains("6") || x.contains("8")){
			}
			else{
			
			
			if(n%2!=0){
			def a = 0
			for(i=1;i<(n+1);i++){
				if(n%i==0){
					a++;
				   }
				}
				if(a==2){
					lista5.add(n) //si es primo lo agrego a la lista 4
						}
			}} // fin for de los primos de 5 digitos
		}
		
		lista5.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,5) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista5Inter1.add(d) //si es primo lo agrego a la lista 4Inter1
							}
								
			} //fin each, por cada elemento de la lista 5
		
		
		lista5Inter1.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,5) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista5Inter2.add(d) //si es primo lo agrego a la lista 4Inter1
							}

			} //fin each, por cada elemento de la lista 5Inter1
//		println"lista5inter2 es "+lista5Inter2
		lista5Inter2.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,5) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista5Inter3.add(d) //si es primo lo agrego a la lista 4Inter1
							}
								
			} //fin each, por cada elemento de la lista 5Inter2
//		println"lista5inter3 es "+lista5Inter3
		
		
		lista5Inter3.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,5) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			
			def ee = c.substring(0,1) //para tomar el primer elemento de la cadena
			def bb = c.substring(1,5) //para tomar el segundo elemento de la cadena
			def cc = bb+ee
			def dd = Integer.parseInt(cc)
			
			def eee = cc.substring(0,1) //para tomar el primer elemento de la cadena
			def bbb = cc.substring(1,5) //para tomar el segundo elemento de la cadena
			def ccc = bbb+eee
			def ddd = Integer.parseInt(ccc)
			
			def eeee = ccc.substring(0,1) //para tomar el primer elemento de la cadena
			def bbbb = ccc.substring(1,5) //para tomar el segundo elemento de la cadena
			def cccc = bbbb+eeee
			def dddd = Integer.parseInt(cccc)
				
				// si ya existe el numero en alguna de sus proximas rotaciones, no hace falta evaluarlo,  asi no se me repite en la lista final
			
			if(!lista5Final.contains(it)){
			if(!lista5Final.contains(d)){
			if(!lista5Final.contains(dd)){
			if(!lista5Final.contains(ddd)){
			if(!lista5Final.contains(dddd)){
				
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista5Final.add(d) //si es primo lo agrego a la lista 4Inter3
							}
				}}}}}
				 // fin if, si que con 3 elementos

			} //fin each, por cada elemento de la lista 4
		
//		println "5 Final"+lista5Final
		
		}//fin tercer hilo
	
		
	List lista6 = new ArrayList<>()
	List lista6Inter1 = new ArrayList<>()
	List lista6Inter2 = new ArrayList<>()
	List lista6Inter3 = new ArrayList<>()
	List lista6Inter4 = new ArrayList<>()
	List lista6Final = new ArrayList<>()
	
	def cuarto = Thread.start {
		// este hilo calcula los primos circulares del 10000 al 100000
//		println "entre al hilo 4"
	
//		List lista6 = new ArrayList<>()
//		List lista6Inter1 = new ArrayList<>()
//		List lista6Inter2 = new ArrayList<>()
//		List lista6Inter3 = new ArrayList<>()
//		List lista6Inter4 = new ArrayList<>()
//		List lista6Final = new ArrayList<>()
		
		
		// Las pruebas dieron que los primos circulares de 6 digitos,se pueden encontrar en el rango de 100.000 a 200.000, por lo cual solo se evalua en ese rango
		
		
		def i
		def n = 100000
		
		for(n;n<200000;n++)	{
			
			def x = Integer.toString(n)
			
			//si el numero tiene el 0,2,4,5,6,8 en alguna de sus rotaciones no va a ser primo, asi q ni lo calculo ahora
			if(x.contains("0") || x.contains("2") || x.contains("4") || x.contains("5") || x.contains("6") || x.contains("8")){
			}
			else{
			
			
			if(n%2!=0){
			def a = 0
			for(i=1;i<(n+1);i++){
				if(n%i==0){
					a++;
				   }
				}
				if(a==2){
					lista6.add(n) //si es primo lo agrego a la lista 6
						}
			}} // fin for de los primos de 6 digitos
		}
		
//		println "lista 6"+lista6
		
		lista6.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,6) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista6Inter1.add(d) //si es primo lo agrego a la lista 6Inter1
							}
								
			} //fin each, por cada elemento de la lista 6
		
//		println"lista6inter1"+lista6Inter1
		
		lista6Inter1.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,6) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista6Inter2.add(d) //si es primo lo agrego a la lista 4Inter2
							}
								
			} //fin each, por cada elemento de la lista 5
		
//		println"lista6inter2"+lista6Inter2
		lista6Inter2.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,6) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista6Inter3.add(d) //si es primo lo agrego a la lista 4Inter1
							}
								
			} //fin each, por cada elemento de la lista 5
//		println"lista6inter3"+lista6Inter3
		lista6Inter3.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,6) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			def g =  Integer.toString(d) // esto es para ver el Siguiente if
			
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista6Inter4.add(d) //si es primo lo agrego a la lista 4Inter1
							}
								
			} //fin each, por cada elemento de la lista 5
//		println"lista6inter4"+lista6Inter4
				lista6Inter4.each{
			
			def x = Integer.toString(it)
			
			def e = x.substring(0,1) //para tomar el primer elemento de la cadena
			def b = x.substring(1,6) //para tomar el segundo elemento de la cadena
			def c = b+e
			def d = Integer.parseInt(c)
			
			def ee = c.substring(0,1) //para tomar el primer elemento de la cadena
			def bb = c.substring(1,6) //para tomar el segundo elemento de la cadena
			def cc = bb+ee
			def dd = Integer.parseInt(cc)
			
			def eee = cc.substring(0,1) //para tomar el primer elemento de la cadena
			def bbb = cc.substring(1,6) //para tomar el segundo elemento de la cadena
			def ccc = bbb+eee
			def ddd = Integer.parseInt(ccc)
			
			def eeee = ccc.substring(0,1) //para tomar el primer elemento de la cadena
			def bbbb = ccc.substring(1,6) //para tomar el segundo elemento de la cadena
			def cccc = bbbb+eeee
			def dddd = Integer.parseInt(cccc)
				
			def eeeee = cccc.substring(0,1) //para tomar el primer elemento de la cadena
			def bbbbb = cccc.substring(1,6) //para tomar el segundo elemento de la cadena
			def ccccc = bbbbb+eeeee
			def ddddd = Integer.parseInt(ccccc)
				// si ya existe el numero en alguna de sus proximas rotaciones, no hace falta evaluarlo,  asi no se me repite en la lista final
			
			if(!lista6Final.contains(it)){
			if(!lista6Final.contains(d)){
			if(!lista6Final.contains(dd)){
			if(!lista6Final.contains(ddd)){
			if(!lista6Final.contains(dddd)){
			if(!lista6Final.contains(ddddd)){
				
				//me fijo si la primer rotacion es primo
				def a = 0
				for(i=1;i<(d+1);i++){
					if(d%i==0){
						a++;
					   }
					}
					if(a==2){
						lista6Final.add(d) //si es primo lo agrego a la lista 4Inter3
							}
				}}}}}}
				 // fin if, si que con 3 elementos

			} //fin each, por cada elemento de la lista 4
		
//		println "6 Final"+lista6Final
//		
//		println "los numeros primos circulares que hay del 1 hasta el 1.000.000 son"
//		println "los números de 1 dígito son: "+lista1
//		println "los números de 2 dígitos son: "+lista2Final
//		println "los números de 3 dígitos son: "+lista3Final
//		println "los números de 4 dígitos son: "+lista4Final
//		println "los números de 5 dígitos son: "+lista5Final
//		println "los números de 6 dígitos son: "+lista6Final
		
		
		List listaDefinitiva = new ArrayList<>()
		
		lista2Final.each{
			listaDefinitiva.add(it)
					}		
		lista3Final.each{
			listaDefinitiva.add(it)
					}
		lista4Final.each{
			listaDefinitiva.add(it)
					}
		lista5Final.each{
			listaDefinitiva.add(it)
					}
		lista6Final.each{
			listaDefinitiva.add(it)
					}
		
		println "los numeros primos circulares que hay del 1 hasta el 1.000.000 son "+listaDefinitiva
		
		} // fin hilo 4
			
		
		
		
			
		}//fin metodo
	
    }//fin servicio
    

