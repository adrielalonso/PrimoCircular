<%@ page import="PrimoCircular.Numero" %>



<div class="fieldcontain ${hasErrors(bean: numeroInstance, field: 'numero', 'error')} required">
	<label for="numero">
		<g:message code="numero.numero.label" default="Numero" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numero" type="number" value="${numeroInstance.numero}" required=""/>

</div>

