package PrimoCircular



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)




class NumeroController {

	def servicioCalculoPrimosCircularesService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Numero.list(params), model:[numeroInstanceCount: Numero.count()]
    }

    def show(Numero numeroInstance) {
        respond numeroInstance
    }

    def create() {
        respond new Numero(params)
    }

    @Transactional
    def save(Numero numeroInstance) {
        if (numeroInstance == null) {
            notFound()
            return
        }

        if (numeroInstance.hasErrors()) {
            respond numeroInstance.errors, view:'create'
            return
        }

        numeroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'numeroInstance.label', default: 'Numero'), numeroInstance.id])
                redirect numeroInstance
            }
            '*' { respond numeroInstance, [status: CREATED] }
        }
    }

    def edit(Numero numeroInstance) {
        respond numeroInstance
    }

    @Transactional
    def update(Numero numeroInstance) {
        if (numeroInstance == null) {
            notFound()
            return
        }

        if (numeroInstance.hasErrors()) {
            respond numeroInstance.errors, view:'edit'
            return
        }

        numeroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Numero.label', default: 'Numero'), numeroInstance.id])
                redirect numeroInstance
            }
            '*'{ respond numeroInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Numero numeroInstance) {

        if (numeroInstance == null) {
            notFound()
            return
        }

        numeroInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Numero.label', default: 'Numero'), numeroInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'numeroInstance.label', default: 'Numero'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	
	
	
	
	def calcular(){ 
		
		def s = servicioCalculoPrimosCircularesService.calcularPrimosCirculares()
	
		
	}
}
