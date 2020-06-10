package modelo;

import java.util.ArrayList;
import java.util.Collection;

public enum TipoCurso {
	GRADUACAO, APERFEICOAMENTO, LATU_SENSU, STRICTO_SENSU;
	
	/**
	 * M�todo para retornar todos os cursos na forma de uma Collection<TipoCurso>, j� que
	 * values() devolve TipoCurso[].
	 * @return
	 */
	public static Collection<TipoCurso> getAll() {
		Collection<TipoCurso> todos = new ArrayList<TipoCurso>();
		for(TipoCurso tipo : TipoCurso.values())
			todos.add(tipo);
		return todos;
	}
}
